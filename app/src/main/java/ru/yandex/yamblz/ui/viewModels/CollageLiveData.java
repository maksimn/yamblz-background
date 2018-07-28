package ru.yandex.yamblz.ui.viewModels;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import ru.yandex.yamblz.loader.CollageStrategy;
import ru.yandex.yamblz.loader.HorizontalCollageStrategy;

public class CollageLiveData extends LiveData<List<CollageInfo>> {
    private final Context context;
    private List<CollageInfo> collageInfoList;

    public CollageLiveData(Application context, List<CollageInfo> info) {
        this.context = context;
        collageInfoList = info;
        createData();
    }

    private void createData() {
        CollageInfo collageInfo = collageInfoList.get(0);

        new AsyncTask<Void, Void, CollageInfo>() {
            @Override
            protected CollageInfo doInBackground(Void[] _void) {
                ImageLoader imageLoader = ImageLoader.getInstance();
                List<Bitmap> bitmaps = new ArrayList<>();

                for (String url : collageInfo.artists_img_urls) {
                    Bitmap bitmap = imageLoader.loadImageSync(url);
                    bitmaps.add(bitmap);
                }

                CollageStrategy collageStrategy = new HorizontalCollageStrategy();
                Bitmap resultBitmap = collageStrategy.create(bitmaps);
                collageInfo.collage = resultBitmap;
                return collageInfo;
            }
            @Override
            protected void onPostExecute(CollageInfo data) {
                List<CollageInfo> list = new ArrayList<>();
                list.add(data);
                setValue(list);
            }
        }.execute();
    }
}
