package ru.ifmo.enf.kogan.t14;

import java.io.InputStream;
import java.util.Collection;

/**
 * Created by arsenykogan on 19/04/14.
 */
public interface ImageDataReader {

    /**
     * Читает данные из InputStream и строит по прочитанным данным объектную модель
     */
    Collection<ImageData> readImageData(InputStream in);

    public interface ImageData {

        /**
         * @return ширина изображения в пикселях
         */
        int getWidth();

        /**
         * @return высота изображения в пикселях
         */
        int getHeight();

        /**
         * @return цвет пикселя — 3 байта (rgb)
         */
        int getPixelColor(int x, int y);

        /**
         * Сохраняет объектную модель в файл, который может быть открыт в программе просмотра изображений
         *
         * @param fileName имя выходного файла
         */
        void persist(String fileName);
    }

}
