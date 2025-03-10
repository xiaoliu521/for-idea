//package org.example.media;
//
//import org.bytedeco.ffmpeg.global.avcodec;
//import org.bytedeco.ffmpeg.global.avutil;
//import org.bytedeco.javacv.Frame;
//import org.bytedeco.javacv.*;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Base64;
//import java.util.Queue;
//import java.util.concurrent.ConcurrentLinkedDeque;
//
///**
// * @author NiKo
// * @date 2022-08-01
// */
//@Service
//public class StreamTest {
//
//    static final Java2DFrameConverter java2DFrameConverter = new Java2DFrameConverter();
//
//    private final static Base64.Encoder encoder = Base64.getEncoder();
//
//
//    static {
//        FFmpegLogCallback.set();
//        avutil.av_log_set_level(avutil.AV_LOG_ERROR);
//    }
//
//    final static Queue<LocalBufferedImage> temp_frame_cache = new ConcurrentLinkedDeque<>();
//
//    final static Queue<Frame> final_frame_cache = new ConcurrentLinkedDeque<>();
//
//
//    public static void main(String[] args) {
//        new StreamTest().test("rtsp://x.x.x.x");
//    }
//
//    private String videoRtmpUrl = "rtmp://x.x.x.x/live/livestream";
//
//    public String test(String url) {
//        try {
//            final String input_stream = url;
//            final String output_stream = videoRtmpUrl;
//            final int width = 1280;
//            final int height = 720;
//            // 取帧任务
//            Thread thread1 = new Thread(() -> {
//                Thread current_thread = Thread.currentThread();
//                FFmpegFrameGrabber grabber = null;
//                try {
//                    grabber = FFmpegFrameGrabber.createDefault(input_stream);
//                    if (input_stream.contains("rtsp://")) {
//                        // 如果是RTSP协议的直播流，UDP转换TCP
//                        grabber.setOption("rtsp_transport", "tcp");
//                        grabber.setOption("rtsp_flags", "prefer_tcp");
//                    }
//                    grabber.setTimeout(5000);
//                    // 5秒超时 单位微秒
//                    grabber.setOption("stimeout", "5000000");
//                    grabber.setOption("threads", "1");
//                    // 5秒超时 单位微秒
//                    grabber.setOption("rw_timeout", "5000000");
//                    // 设置缓存大小，提高画质、减少卡顿花屏
//                    grabber.setOption("buffer_size", "1024000");
//                    grabber.start();
//                    long last_frame_time = 0;
//                    while (grabber.hasVideo()) {
//                        if (current_thread.isInterrupted()) {
//                            break;
//                        }
//                        Frame frame = grabber.grab();
//                        final long current_frame_time = System.currentTimeMillis();
//                        if (null != frame) {
//                            BufferedImage image = java2DFrameConverter.getBufferedImage(frame);
////                            log.info("帧时间:{}", current_frame_time);
//                            if (last_frame_time == 0 || current_frame_time - last_frame_time > 1 * 1000)
////                            if (frame.keyFrame)
//                            {
//                                temp_frame_cache.add(new LocalBufferedImage(true, image));
//                                last_frame_time = current_frame_time;
//                            } else {
//                                temp_frame_cache.add(new LocalBufferedImage(false, image));
//                            }
//                        } else {
//                            System.out.println("frame is null");
//                        }
//                    }
//                } catch (Exception e) {
//                    System.out.println(e.getMessage(), e);
//                } finally {
//                    try {
//                        grabber.stop();
//                    } catch (FrameGrabber.Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//            thread1.start();
//
//
//            // 计算任务
//            new Thread(() -> {
//                ArrayList<AiResult> box_cahce = new ArrayList();
//                // 100K 通常RTSP的720P 80K
//                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//                while (true) {
//                    try {
//                        if (temp_frame_cache.size() > 0) {
//                            LocalBufferedImage localBufferedImage = temp_frame_cache.poll();
//
//                            if (null == localBufferedImage) {
//                                log.error("frame is null continue");
//                                continue;
//                            }
//                            BufferedImage image = localBufferedImage.getBufferedImage();
//                            Frame frame;
//                            if (localBufferedImage.isCompute()) {
//                                box_cahce.clear();
//                                //关键帧 调用算法
//                                JSONObject param = new JSONObject();
//                                param.put("test_image", encoder.encodeToString(imageToBytes(byteArrayOutputStream, image)));
//                                param.put("test_ID", 0);
//                                param.put("test_roi","[[732,1024],[1624,985],[1635,583],[728,779]]");
//                                long start_time = System.currentTimeMillis();
//                                String result =
//                                        HttpClientPerformance.postJson("http://10.1.68.151:8002/IntrusionReg",
//                                                param.toJSONString());
//                                log.info("AI请求实际耗时:{} ms", (System.currentTimeMillis() - start_time));
//                                if (StringUtils.hasText(result)) {
//                                    JSONObject jsonObject = JSON.parseObject(result);
//                                    com.alibaba.fastjson.JSONArray jsonArray = jsonObject.getJSONArray("test_result");
//                                    if (null != jsonArray) {
//                                        for (Object val : jsonArray) {
//                                            //{"prob":1,"box":[600,157,757,315],"value":0}
//                                            AiResult aiResult = JSON.parseObject(val.toString(), AiResult.class);
//                                            box_cahce.add(aiResult);
//                                        }
//                                    }
//                                    Graphics g = image.getGraphics();
//                                    draw_box(g, box_cahce);
//                                    log.info("box is :{} ", JSON.toJSONString(box_cahce));
//                                } else {
//                                    // 没结果 清理坐标
//                                    box_cahce.clear();
//                                }
//                                frame = java2DFrameConverter.convert(image);
//                            } else {
//                                // 非关键帧
//                                if (null != box_cahce && !box_cahce.isEmpty()) {
//                                    Graphics g = image.getGraphics();
//                                    draw_box(g, box_cahce);
//                                }
//                                frame = java2DFrameConverter.convert(image);
//                            }
//                            // 重写绘制的图片帧 放到最终缓存队列中 ,用于新的推流
//                            if (null != frame) {
//                                final_frame_cache.add(frame);
//                            }
//                        }
//                    } catch (Exception e) {
//                        log.error(e.getMessage(), e);
//                    }
//                }
//            }).start();
//
//            // 推流任务
//            new Thread(() -> {
//                FFmpegFrameRecorder recorder = null;
//                try {
//                    recorder = FFmpegFrameRecorder.
//                            createDefault(output_stream, width, height);
////                    recorder.setAudioChannels(0);
//                    recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264); // avcodec.AV_CODEC_ID_H264，编码
//                    recorder.setVideoCodecName("libx264");
////                    recorder.setVideoQuality(0);
//                    recorder.setFormat("flv");//封装格式，如果是推送到rtmp就必须是flv封装格式
//                    recorder.setInterleaved(false);
//
//                    /**
//                     *film： 电影、真人类型；
//                     *animation： 动画；
//                     *grain： 需要保留大量的grain时用；
//                     *stillimage： 静态图像编码时使用；
//                     *psnr： 为提高psnr做了优化的参数；
//                     *ssim： 为提高ssim做了优化的参数；
//                     *fastdecode： 可以快速解码的参数；
//                     *zerolatency：零延迟，用在需要非常低的延迟的情况下，比如电视电话会议的编码。
//                     */
//                    recorder.setVideoOption("tune", "stillimage");
//                    /**
//                     * ultrafast、superfast、veryfast、faster、fast、medium、slow、slower、veryslow、placebo
//                     * 这10个选项，从快到慢。
//                     */
//                    recorder.setVideoOption("preset", "medium");
//                    /**
//                     *
//                     */
//                    recorder.setVideoOption("crf", "26");
//                    recorder.setVideoOption("threads", "1");
//                    recorder.setFrameRate(25);// 设置帧率
//                    recorder.setGopSize(25);// 设置gop,与帧率相同，相当于间隔1秒chan's一个关键帧
//                    recorder.setTrellis(1);//启用RDOQ算法，优化视频质量 1：在视频码率和视频质量之间取得平衡 2：最大程度优化视频质量（会降低编码速度和提高码率）
//                    recorder.setMaxDelay(2 * 1000 * 1000);
//                    recorder.start();
//                    while (true) {
//                        if (final_frame_cache.size() > 25 * 2) {
//                            Thread.sleep(1000 / 25);
//                            recorder.record(final_frame_cache.poll());
//                        } else {
//                            log.warn("----------当前没有可以推流的帧了----------");
//                        }
//                    }
//                } catch (Exception e) {
//                    log.error(e.getMessage(), e);
//                } finally {
//                    if (recorder != null) {
//                        try {
//                            recorder.stop();
//                        } catch (FFmpegFrameRecorder.Exception e) {
//                            log.error(e.getMessage(), e);
//                        }
//                    }
//                }
//
//            }).start();
//
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//        }
//        return "http://x.x.x.x/live/livestream.flv";
//    }
//
//    private static void draw_box(Graphics g, ArrayList<AiResult> boxList) {
//        for (AiResult aiResult : boxList) {
//            final int value = aiResult.getValue() != null ? aiResult.getValue() : -1;
//            final int[] box = aiResult.getBox();
//            if (null != box && box.length > 0 && value >= 0) {
//                if (value == 0) { // 未佩戴口罩
//                    Graphics2D g2d = (Graphics2D) g;
//                    g2d.setColor(Color.RED);//画笔颜色
//                    g2d.setStroke(new BasicStroke(2));
//                    g2d.drawRect(box[0], box[1], box[2] - box[0], box[3] - box[1]);
//                } else if (value == 1) {// 已佩戴口罩
////                    g2d.setColor(Color.GREEN);
//                } else if (value == 2) {// 不确定,一半是背面
////                    g2d.setColor(Color.YELLOW);
//                }
//
//            }
//        }
//    }
//
//    /**
//     * BufferedImage转byte[]
//     *
//     * @param bImage BufferedImage对象
//     */
//    private static byte[] imageToBytes(ByteArrayOutputStream out, BufferedImage bImage) {
//        try {
//            ImageIO.write(bImage, "jpg", out);
//            return out.toByteArray();
//        } catch (IOException e) {
//            log.error(e.getMessage(), e);
//        } finally {
//            try {
////                out.close();
//                out.flush();
//                out.reset();
//            } catch (IOException e) {
//                log.error(e.getMessage(), e);
//            }
//        }
//        return null;
//    }
//
//}