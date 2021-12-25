package com.example.jmm.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jmm.R;
import com.example.jmm.databinding.FragmentMovieDteailsBinding;
import com.example.jmm.model.DetailsMoviesList;

public class MovieDteailsFragment extends Fragment {

    public MovieDteailsFragment() {
        // Required empty public constructor
    }

    FragmentMovieDteailsBinding binding;

    Bundle bundle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_dteails, container, false);
        binding.setDetailMovie(new DetailsMoviesList(
                getArguments().getString("name"), getArguments().getString("link_img"), getArguments().getString("dec"), getArguments().getString("gnere")
        ));
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}