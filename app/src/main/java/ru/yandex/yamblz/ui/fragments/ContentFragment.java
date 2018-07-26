package ru.yandex.yamblz.ui.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Arrays;

import ru.yandex.yamblz.R;
import ru.yandex.yamblz.loader.CollageLoader;
import ru.yandex.yamblz.loader.CollageLoaderManager;
import ru.yandex.yamblz.ui.viewModels.CollageViewModel;

public class ContentFragment extends BaseFragment {

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_content, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        ImageView collageImageView = (ImageView)getView().findViewById(R.id.collageImageView);
        CollageViewModel model = ViewModelProviders.of(this).get(CollageViewModel.class);
        model.getData().observe(this, bitmap -> {
            collageImageView.setImageBitmap(bitmap);
        });
    }
}
