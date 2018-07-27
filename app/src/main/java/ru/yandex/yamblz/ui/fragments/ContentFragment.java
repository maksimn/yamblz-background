package ru.yandex.yamblz.ui.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import ru.yandex.yamblz.R;
import ru.yandex.yamblz.ui.viewModels.CollageInfo;
import ru.yandex.yamblz.ui.viewModels.CollageViewModel;
import ru.yandex.yamblz.ui.viewModels.CollageViewModelFactory;

public class ContentFragment extends BaseFragment {

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_content, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        List<CollageInfo> collageInfos = populateCollageInfo();

        for (CollageInfo info : collageInfos) {
            CollageViewModel model = ViewModelProviders
                    .of(this, new CollageViewModelFactory(this.getActivity().getApplication(), info))
                    .get(CollageViewModel.class);

            model.getData().observe(this, bmp -> {

            });
        }
    }

    private List<CollageInfo> populateCollageInfo() {
        String collagesJson = readCollagesJsonFromRaw();
        Type listType = new TypeToken<ArrayList<CollageInfo>>(){}.getType();
        return new Gson().fromJson(collagesJson, listType);
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

        return writer.toString();
    }
}
