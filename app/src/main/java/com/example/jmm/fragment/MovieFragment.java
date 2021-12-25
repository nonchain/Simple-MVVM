package com.example.jmm.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jmm.R;
import com.example.jmm.adapter.AdapterMoviesRec;
import com.example.jmm.databinding.FragmentMovieBinding;
import com.example.jmm.inter_face.OnClickListener;
import com.example.jmm.model.MoviesList;
import com.example.jmm.viewmodel.ViewModelMovies;

import java.util.List;

public class MovieFragment extends Fragment implements OnClickListener {

    public MovieFragment() {
        // Required empty public constructor
    }
    FragmentMovieBinding binding;

    RecyclerView rec_movies;
    AdapterMoviesRec adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie, container, false);

        rec_movies = binding.recMovies;
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewModelMovies viewModelMovies = new ViewModelProvider(getActivity()).get(ViewModelMovies.class);
        MutableLiveData<List<MoviesList>> mutableLiveData_Movie = viewModelMovies.GET_MOVIES();

        mutableLiveData_Movie.observe(getActivity(), new Observer<List<MoviesList>>() {
            @Override
            public void onChanged(List<MoviesList> moviesLists) {
                adapter = new AdapterMoviesRec(getActivity(), moviesLists, MovieFragment.this::onClick);
                rec_movies.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
                rec_movies.setAdapter(adapter);
            }
        });
    }

    @Override
    public void onClick(MoviesList movies) {
        Bundle bundle = new Bundle();
        bundle.putString("id", movies.getId());
        bundle.putString("name", movies.getName());
        bundle.putString("link_img", movies.getLink_img());
        bundle.putString("gnere", movies.getGnere());
        bundle.putString("dec", movies.getDescription());
        Navigation.findNavController(rec_movies).navigate(R.id.action_movieFragment_to_movieDteailsFragment, bundle);
    }
}