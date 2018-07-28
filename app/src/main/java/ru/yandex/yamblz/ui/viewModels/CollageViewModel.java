package ru.yandex.yamblz.ui.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class CollageViewModel extends AndroidViewModel {
    private CollageLiveData data;

    public CollageViewModel(Application application, List<CollageInfo> info) {
        super(application);

        data = new CollageLiveData(application, info);
    }

    public LiveData<List<CollageInfo>> getData() {
        return data;
    }
}