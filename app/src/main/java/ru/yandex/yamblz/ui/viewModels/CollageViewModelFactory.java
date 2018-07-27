package ru.yandex.yamblz.ui.viewModels;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

public class CollageViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private Application application;
    private CollageInfo collageInfo;

    public CollageViewModelFactory(Application application, CollageInfo collageInfo) {
        this.application = application;
        this.collageInfo = collageInfo;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new CollageViewModel(application, collageInfo);
    }
}
