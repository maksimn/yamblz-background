package ru.yandex.yamblz.ui.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import ru.yandex.yamblz.R;
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

        String collagesJson = readCollagesJsonFromRaw();

        model.getData().observe(this, bitmap -> {
            collageImageView.setImageBitmap(bitmap);
        });
    }

    private String readCollagesJsonFromRaw() {
        InputStream is = getResources().openRawResource(R.raw.collages_data);
        Writer writer = new StringWriter();
        char[] buffer = new char[10000];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (Exception e) {
            return null;
        } finally {
            try {
                is.close();
            } catch (Exception e) {
                return null;
            }
        }

        String jsonString = writer.toString();

        return jsonString;
    }
}
