package ru.yandex.yamblz.loader;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class StubCollageLoader implements CollageLoader {
    @Override
    public void loadCollage(List<String> urls, ImageView imageView) {
        ImageLoader imageLoader = ImageLoader.getInstance();
        List<Bitmap> bitmaps = new ArrayList<>();

        for (String url : urls) {
            Bitmap bitmap = imageLoader.loadImageSync(url);
            bitmaps.add(bitmap);
        }

        CollageStrategy collageStrategy = new HorizontalCollageStrategy();
        Bitmap resultBitmap = collageStrategy.create(bitmaps);

        imageView.setImageBitmap(resultBitmap);
    }

    @Override
    public void loadCollage(List<String> urls, ImageTarget imageTarget) {

    }

    @Override
    public void loadCollage(List<String> urls, ImageView imageView,
                            CollageStrategy collageStrategy) {

    }

    @Override
    public void loadCollage(List<String> urls, ImageTarget imageTarget,
                            CollageStrategy collageStrategy) {

    }

}
