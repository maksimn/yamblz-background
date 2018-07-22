package ru.yandex.yamblz.ui.fragments;

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

public class ContentFragment extends BaseFragment {

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_content, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        ImageView collageImageView = (ImageView) getView().findViewById(R.id.collageImageView);

        CollageLoader collageLoader = CollageLoaderManager.getLoader();

        String[] urls = new String[] {
                "http://via.placeholder.com/150x150/ff0000/ffffff",
                "http://via.placeholder.com/150x150/0000ff/ffffff",
                "http://via.placeholder.com/150x150/cc0099/ffffff",
                "http://via.placeholder.com/150x150/33cc33/ffffff"
        };

        collageLoader.loadCollage(Arrays.asList(urls), collageImageView);
    }
}
