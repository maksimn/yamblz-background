package ru.yandex.yamblz.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ru.yandex.yamblz.R;

public class CollagesAdapter extends RecyclerView.Adapter<CollagesAdapter.ViewHolder> {
    private Context context;
    private LayoutInflater mInflater;

    public CollagesAdapter(Context context) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
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
        holder.genreNameTextView.setText("Some text");
        holder.collageImageView.setImageBitmap(null);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return 0;
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