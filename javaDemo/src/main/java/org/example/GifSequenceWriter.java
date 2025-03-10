package org.example;

import javax.imageio.*;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import java.awt.image.BufferedImage;
import java.io.IOException;

class GifSequenceWriter {
    private static final int LOOP_COUNT = 0;

    static void setDelay(BufferedImage image, int delay) {
        try {
            ImageWriter writer = ImageIO.getImageWritersByFormatName("gif").next();
            ImageWriteParam writeParam = writer.getDefaultWriteParam();
            ImageTypeSpecifier typeSpecifier = ImageTypeSpecifier.createFromBufferedImageType(BufferedImage.TYPE_INT_ARGB);
            IIOMetadata metadata = writer.getDefaultImageMetadata(typeSpecifier, writeParam);
            IIOMetadataNode root = (IIOMetadataNode) metadata.getAsTree(metadata.getNativeMetadataFormatName());
            IIOMetadataNode graphicsControlExtensionNode = getNode(root, "GraphicControlExtension");
            graphicsControlExtensionNode.setAttribute("delayTime", Integer.toString(delay / 10));
            writer.setOutput(ImageIO.createImageOutputStream(image));
            writer.prepareWriteSequence(null);
            writer.writeToSequence(new IIOImage(image, null, metadata), null);
            writer.endWriteSequence();
            writer.dispose();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static IIOMetadataNode getNode(IIOMetadataNode rootNode, String nodeName) {
        int nNodes = rootNode.getLength();
        for (int i = 0; i < nNodes; i++) {
            if (rootNode.item(i).getNodeName().equalsIgnoreCase(nodeName)) {
                return (IIOMetadataNode) rootNode.item(i);
            }
        }
        IIOMetadataNode node = new IIOMetadataNode(nodeName);
        rootNode.appendChild(node);
        return node;
    }
}