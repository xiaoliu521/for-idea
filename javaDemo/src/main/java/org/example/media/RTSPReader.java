package org.example.media;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bytedeco.javacv.*;
public class RTSPReader {
    private static final Log log = LogFactory.getLog(RTSPReader.class);

    public static void main(String[] args) {
        String rtspUrl = "rtsp://admin:1234qwer@192.168.16.91:554";
        try {
            CanvasFrame canvasFrame = new CanvasFrame("RTSP Stream");
            canvasFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

//            FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(rtspUrl);
            YsczFrameGrabber grabber = YsczFrameGrabber.createDefault(rtspUrl);

            // 缓存大小,太小丢包严重,会直接出现1的情况
            grabber.setOption("buffer_size", "10000000"); // 设置缓冲区大小为1

            grabber.start();
//            grabber.start(false);

            while (true) {

                long a = System.currentTimeMillis();
                grabber.flushAllBuffer();

//                grabber.setImageScalingFlags(0);
                Frame frame = grabber.grabImage();
                if (frame == null) {
                    continue;
                }

                canvasFrame.showImage(frame);

                Thread.sleep(1000);

                long b = System.currentTimeMillis();

                System.out.println(b -a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}