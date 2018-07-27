package ru.yandex.yamblz.ui.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.graphics.Bitmap;

public class CollageViewModel extends AndroidViewModel {
    private CollageLiveData data;

    public CollageViewModel(Application application, CollageInfo info) {
        super(application);

        data = new CollageLiveData(application, info);
    }

    public LiveData<Bitmap> getData() {
        return data;
    }
}