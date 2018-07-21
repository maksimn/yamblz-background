package ru.yandex.yamblz.loader;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.List;

public class StubCollageLoader implements CollageLoader {
    @Override
    public void loadCollage(List<String> urls, ImageView imageView) {
        String firstUrl = urls.get(0);

        ImageLoader imageLoader = ImageLoader.getInstance();

        imageLoader.loadImage(firstUrl, new SimpleImageLoadingListener() {
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                // loaded bitmap is here (loadedImage)
                imageView.setImageBitmap(loadedImage);
            }
        });
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
