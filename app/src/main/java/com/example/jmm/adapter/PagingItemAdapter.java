package com.example.jmm.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jmm.R;
import com.example.jmm.model.ItemsList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PagingItemAdapter extends PagedListAdapter<ItemsList, PagingItemAdapter.PagedViewHolder> {

    Context cxt;

    public PagingItemAdapter(Context context) {
        super(DIFF_CALLBACK);

        cxt = context;
    }

    // load the items
    private static DiffUtil.ItemCallback<ItemsList> DIFF_CALLBACK = new DiffUtil.ItemCallback<ItemsList>() {
        @Override
        public boolean areItemsTheSame(@NonNull ItemsList oldItem, @NonNull ItemsList newItem) {
            return oldItem.answer_id == newItem.answer_id;
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull ItemsList oldItem, @NonNull ItemsList newItem) {
            return oldItem.equals(newItem);
        }
    };

    @NonNull
    @Override
    public PagedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vv = LayoutInflater.from(cxt).inflate(R.layout.item_paging, parent, false);

        return new PagedViewHolder(vv);
    }

    @Override
    public void onBindViewHolder(@NonNull PagedViewHolder holder, int position) {
        ItemsList items = getItem(position);

        holder.profile_name.setText(items.owner.display_name);
        Picasso.get().load(items.owner.profile_image).into(holder.profile_image);
    }

    public class PagedViewHolder extends RecyclerView.ViewHolder{

        TextView profile_name;
        CircleImageView profile_image;

        public PagedViewHolder(@NonNull View itemView) {
            super(itemView);

            profile_name = itemView.findViewById(R.id.tv_profile_name);
            profile_image = itemView.findViewById(R.id.img_profile);
        }
    }
}
