package ru.ifmo.enf.kogan.t14;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by arsenykogan on 19/04/14.
 */
public class ImageData implements ImageDataReader.ImageData {

    int[] pixels;
    final int width;
    final int height;

    public ImageData(final int[] pixels, final int width, final int height) {
        this.pixels = pixels;
        this.width = width;
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getPixelColor(final int x, final int y) {
        final int value = pixels[y * width + x];
        return new Color(value, value, value).getRGB();
    }

    @Override
    public void persist(final String fileName) {
        final BufferedImage image = getImageFromArray(getWidth(), getHeight());
        try {
            ImageIO.write(image, "png", new FileOutputStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BufferedImage getImageFromArray(int width, int height) {
        final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                image.setRGB(i, j, getPixelColor(i, j));
            }
        }
        return image;
    }
}
