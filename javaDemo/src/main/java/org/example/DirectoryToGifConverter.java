package org.example;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class DirectoryToGifConverter {
    public static void main(String[] args) {
        String directoryPath = "D:\\workSpace\\临时\\images\\";
        int gifWidth = 400;  // GIF宽度
        int gifHeight = 300; // GIF高度
        int delay = 500;     // 帧之间的延迟时间（以毫秒为单位）

        List<BufferedImage> images = loadImagesFromDirectory(directoryPath);
        BufferedImage gifImage = createGifImage(images, gifWidth, gifHeight, delay);

        // 将GIF图像写入文件
        try {
            ImageIO.write(gifImage, "gif", new File("D:\\workSpace\\临时\\1.gif"));
            System.out.println("GIF生成成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<BufferedImage> loadImagesFromDirectory(String directoryPath) {
        List<BufferedImage> images = new ArrayList<>();

        File directory = new File(directoryPath);
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    try {
                        BufferedImage image = ImageIO.read(file);
                        if (image != null) {
                            images.add(image);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return images;
    }

    private static BufferedImage createGifImage(List<BufferedImage> images, int width, int height, int delay) {
        BufferedImage gifImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = gifImage.createGraphics();

        // 设置背景色为透明
        graphics.setComposite(AlphaComposite.Clear);
        graphics.fillRect(0, 0, width, height);
        graphics.setComposite(AlphaComposite.SrcOver);

        // 计算居中位置
        int x = (width - images.get(0).getWidth()) / 2;
        int y = (height - images.get(0).getHeight()) / 2;

        // 将图片居中绘制到GIF图像上
        for (BufferedImage image : images) {
            graphics.drawImage(image, x, y, null);
        }

        graphics.dispose();

        // 设置GIF帧之间的延迟时间
        GifSequenceWriter.setDelay(gifImage, delay);

        return gifImage;
    }

}