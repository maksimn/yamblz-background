package ru.yandex.yamblz.ui.viewModels;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.yandex.yamblz.loader.CollageStrategy;
import ru.yandex.yamblz.loader.HorizontalCollageStrategy;

public class CollageLiveData extends LiveData<Bitmap> {
    private final Context context;

    public CollageLiveData(Application context) {
        this.context = context;

        String[] urls = new String[] {
                "http://via.placeholder.com/150x150/ff0000/ffffff",
                "http://via.placeholder.com/150x150/0000ff/ffffff",
                "http://via.placeholder.com/150x150/cc0099/ffffff",
                "http://via.placeholder.com/150x150/33cc33/ffffff"
        };

        createData(Arrays.asList(urls));
    }

    private void createData(List<String> urls) {
        new AsyncTask<Void, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(Void[] _void) {
                ImageLoader imageLoader = ImageLoader.getInstance();
                List<Bitmap> bitmaps = new ArrayList<>();

                for (String url : urls) {
                    Bitmap bitmap = imageLoader.loadImageSync(url);
                    bitmaps.add(bitmap);
                }

                CollageStrategy collageStrategy = new HorizontalCollageStrategy();
                Bitmap resultBitmap = collageStrategy.create(bitmaps);
                return resultBitmap;
            }
            @Override
            protected void onPostExecute(Bitmap data) {
                setValue(data);
            }
        }.execute();
    }
}
