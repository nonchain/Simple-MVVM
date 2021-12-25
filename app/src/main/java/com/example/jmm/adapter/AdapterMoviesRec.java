package com.example.jmm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jmm.R;
import com.example.jmm.databinding.ItemMoviesBinding;
import com.example.jmm.inter_face.OnClickListener;
import com.example.jmm.model.MoviesList;

import java.util.List;

public class AdapterMoviesRec extends RecyclerView.Adapter<AdapterMoviesRec.MovieHolder> {

    Context cxt;
    List<MoviesList> data;
    OnClickListener onClickListener;

    public AdapterMoviesRec(Context cxt, List<MoviesList> data, OnClickListener listener) {
        this.cxt = cxt;
        this.data = data;
        onClickListener = listener;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(cxt);
        ItemMoviesBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_movies, parent, false);
        return new MovieHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        holder.binding.setResponse(data.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClick(data.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder{

        ItemMoviesBinding binding;

        public MovieHolder(ItemMoviesBinding b) {
            super(b.getRoot());

            binding = b;
        }
    }
}
