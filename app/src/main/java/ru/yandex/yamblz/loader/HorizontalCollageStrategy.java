package ru.yandex.yamblz.loader;

import android.graphics.Bitmap;

import java.util.List;

public class HorizontalCollageStrategy implements CollageStrategy {
    @Override
    public Bitmap create(List<Bitmap> bitmaps) {
        int resultWidth = 0;
        int resultHeight = 0;

        for (Bitmap b: bitmaps) {
            if (b != null) {
                resultWidth += b.getWidth();
                resultHeight = b.getHeight() > resultHeight ? b.getHeight() : resultHeight;
            }
        }

        Bitmap resultBitmap = Bitmap.createBitmap(resultWidth, resultHeight,
                Bitmap.Config.ARGB_8888);

        for (int i = 0, start = 0; i < bitmaps.size(); i++) {
            Bitmap bmp = bitmaps.get(i);

            if (bmp != null) {
                int w = bmp.getWidth();
                int h = bmp.getHeight();

                for (int j = 0; j < w; j++) {
                    for (int k = 0; k < h; k++) {
                        int pixel = bmp.getPixel(j, k);

                        resultBitmap.setPixel(start + j, k, pixel);
                    }
                }
                start += w;
            }
        }

        return resultBitmap;
    }
}
