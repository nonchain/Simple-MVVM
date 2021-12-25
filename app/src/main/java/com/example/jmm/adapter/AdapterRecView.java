package com.example.jmm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jmm.R;
import com.example.jmm.databinding.ItemPart02RecViewBinding;
import com.example.jmm.model.UsersInfo;

import java.util.List;

public class AdapterRecView extends RecyclerView.Adapter<AdapterRecView.MyHolder> {

    Context cxt;
    List<UsersInfo> data;

    public AdapterRecView(Context cxt, List<UsersInfo> data) {
        this.cxt = cxt;
        this.data = data;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(cxt);
        ItemPart02RecViewBinding viewBinding = DataBindingUtil.inflate(inflater, R.layout.item_part02_rec_view, parent, false);

        return new MyHolder(viewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position)
    {
        holder.binding.setUserInfo(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder
    {
        ItemPart02RecViewBinding binding;

        public MyHolder(@NonNull ItemPart02RecViewBinding b) {
            super(b.getRoot());

            binding = b;
        }
    }
}
