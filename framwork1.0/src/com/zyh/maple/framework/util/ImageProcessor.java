/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.framework.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageProcessor {
    private static float quality = 0.9f;

    public Image copyRectImage(Image original, Rectangle2D rect, ImageObserver observer) {
        int x = (int)rect.getX();
        int y = (int)rect.getY();
        int width = (int)rect.getWidth();
        int height = (int)rect.getHeight();
        return this.mirror(original, 0, 0, width, height, x, y, x + width, y + height, observer);
    }

    public Image resize(Image original, double percentage, ImageObserver observer) {
        int width = (int)((double)original.getWidth(observer) * percentage);
        int height = (int)((double)original.getHeight(observer) * percentage);
        return ImageProcessor.resize(original, width, height, observer);
    }

    public static Image resize(Image original, int width, int height, ImageObserver observer) {
        BufferedImage bufferedImage = new BufferedImage(width, height, 1);
        Graphics2D g2 = bufferedImage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(original, 0, 0, width, height, observer);
        return bufferedImage;
    }

    public Image horizontalMirror(Image original, ImageObserver observer) {
        int width = original.getWidth(observer);
        int height = original.getHeight(observer);
        return this.mirror(original, width, 0, 0, height, 0, 0, width, height, observer);
    }

    public Image verticalMirror(Image original, ImageObserver observer) {
        int width = original.getWidth(observer);
        int height = original.getHeight(observer);
        return this.mirror(original, 0, height, width, 0, 0, 0, width, height, observer);
    }

    public Image clockwise(Image original, ImageObserver observer) {
        return this.rotate90(original, true, observer);
    }

    public Image counterClockwise(Image original, ImageObserver observer) {
        return this.rotate90(original, false, observer);
    }

    private Image mirror(Image original, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
        int width = Math.abs(sx1 - sx2);
        int height = Math.abs(sy1 - sy2);
        BufferedImage bufferedImage = new BufferedImage(width, height, 1);
        Graphics g = bufferedImage.getGraphics();
        g.drawImage(original, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer);
        return bufferedImage;
    }

    private Image rotate90(Image original, boolean clockwise, ImageObserver observer) {
        int width = original.getWidth(observer);
        int height = original.getHeight(observer);
        BufferedImage bufferedImage = new BufferedImage(height, width, 1);
        Graphics2D g2 = bufferedImage.createGraphics();
        if (clockwise) {
            AffineTransform aff = AffineTransform.getRotateInstance(Math.toRadians(90.0), 0.0, 0.0);
            g2.setTransform(aff);
            g2.drawImage(original, 0, - height, observer);
        } else {
            AffineTransform aff = AffineTransform.getRotateInstance(Math.toRadians(-90.0), 0.0, 0.0);
            g2.setTransform(aff);
            g2.drawImage(original, - width, 0, observer);
        }
        return bufferedImage;
    }

    private Image rotate(Image original, boolean clockwise, ImageObserver observer) {
        int width = original.getWidth(observer);
        int height = original.getHeight(observer);
        BufferedImage bufferedImage = new BufferedImage(height, width, 1);
        Graphics2D g2 = bufferedImage.createGraphics();
        if (clockwise) {
            AffineTransform aff = AffineTransform.getRotateInstance(Math.toRadians(90.0), 0.0, 0.0);
            g2.setTransform(aff);
            g2.drawImage(original, 0, - height, observer);
        } else {
            AffineTransform aff = AffineTransform.getRotateInstance(Math.toRadians(-90.0), 0.0, 0.0);
            g2.setTransform(aff);
            g2.drawImage(original, - width, 0, observer);
        }
        return bufferedImage;
    }

    public static void cutImage(String imgOriginalPath, String imgDestPath, String suffix, int x, int y, int width, int height) throws IOException {
        BufferedImage sourceImage = ImageIO.read(new File(imgOriginalPath));
        CropImageFilter cropFilter = new CropImageFilter(x, y, width, height);
        Image croppedImage = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(sourceImage.getSource(), cropFilter));
        int h1 = croppedImage.getHeight(null);
        int w1 = croppedImage.getWidth(null);
        BufferedImage bi = new BufferedImage(w1, h1, 1);
        Graphics graphics = bi.getGraphics();
        graphics.drawImage(croppedImage, 0, 0, Color.white, null);
        File file = new File(imgDestPath);
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(new File(imgDestPath));
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fileOutputStream);
        JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(bi);
        jep.setQuality(quality, true);
        encoder.encode(bi, jep);
        ImageIO.write((RenderedImage)bi, suffix, fileOutputStream);
        fileOutputStream.close();
    }

    public static void scaledImage(String imgOriginalPath, String imgDestPath, int newWidth, int newHeight, String suffix) throws Exception {
        BufferedImage bi = ImageIO.read(new File(imgOriginalPath));
        Image image2 = bi.getScaledInstance(newWidth, newHeight, 16);
        int height = image2.getHeight(null);
        int width = image2.getWidth(null);
        BufferedImage bi3 = new BufferedImage(width, height, 1);
        Graphics g = bi3.getGraphics();
        g.drawImage(image2, 0, 0, Color.white, null);
        FileOutputStream fos = new FileOutputStream(new File(imgDestPath));
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fos);
        JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(bi3);
        jep.setQuality(quality, true);
        encoder.encode(bi3, jep);
        ImageIO.write((RenderedImage)bi3, suffix, fos);
        fos.close();
    }

    public static void initImage(String imgOriginalPath) throws Exception {
        int newWidth = 0;
        int newHeight = 0;
        BufferedImage bi = ImageIO.read(new File(imgOriginalPath));
        if (bi.getHeight() > 240 && bi.getHeight() >= bi.getWidth()) {
            newWidth = bi.getWidth() * 240 / bi.getHeight();
            newHeight = 240;
            ImageProcessor.scaledImage(imgOriginalPath, imgOriginalPath, newWidth, newHeight, "jpg");
        } else if (bi.getWidth() > 240 && bi.getWidth() > bi.getHeight()) {
            newWidth = 240;
            newHeight = bi.getHeight() * 240 / bi.getWidth();
            ImageProcessor.scaledImage(imgOriginalPath, imgOriginalPath, newWidth, newHeight, "jpg");
        }
    }

    public static void copyImage(String imgOriginalPath, String imgDestPath) {
        File tempfile = new File(imgOriginalPath);
        String fileName = tempfile.getName();
        String imgDestPathTemp = String.valueOf(imgDestPath) + "/80X80/";
        File dicfile = new File(imgDestPathTemp);
        if (!dicfile.exists()) {
            dicfile.mkdirs();
        }
        byte[] fileByte = new byte[(int)tempfile.length()];
        imgDestPathTemp = String.valueOf(imgDestPathTemp) + fileName;
        DataInputStream sin = null;
        FileOutputStream fos = null;
        try {
            try {
                sin = new DataInputStream(new FileInputStream(tempfile));
                sin.readFully(fileByte);
                fos = new FileOutputStream(new File(imgDestPathTemp));
                fos.write(fileByte);
                fos.close();
                sin.close();
            }
            catch (Exception e) {
                e.printStackTrace();
                try {
                    fos.close();
                    sin.close();
                }
                catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
        finally {
            try {
                fos.close();
                sin.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

