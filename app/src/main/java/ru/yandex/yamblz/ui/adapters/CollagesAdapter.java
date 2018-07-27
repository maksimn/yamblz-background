package ru.yandex.yamblz.ui.adapters;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ru.yandex.yamblz.R;
import ru.yandex.yamblz.ui.viewModels.CollageInfo;

public class CollagesAdapter extends RecyclerView.Adapter<CollagesAdapter.ViewHolder> {
    private List<CollageInfo> mCollageInfoList;
    private Context context;
    private LayoutInflater mInflater;

    public CollagesAdapter(Context context, List<CollageInfo> collageInfoList) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        mCollageInfoList = collageInfoList;
    }
    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.collage_item, parent, false);
        return new ViewHolder(view);
    }
    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CollageInfo collageInfo = mCollageInfoList.get(position);
        holder.genreNameTextView.setText(collageInfo.genre_name);
        holder.collageImageView.setImageBitmap(collageInfo.collage);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mCollageInfoList.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView genreNameTextView;
        private ImageView collageImageView;

        ViewHolder(View itemView) {
            super(itemView);
            genreNameTextView = itemView.findViewById(R.id.genreName);
            collageImageView = itemView.findViewById(R.id.collage);
        }
    }
}