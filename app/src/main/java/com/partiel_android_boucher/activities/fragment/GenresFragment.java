package com.partiel_android_boucher.activities.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.partiel_android_boucher.R;
import com.partiel_android_boucher.classes.Genre;
import com.partiel_android_boucher.classes.adapters.GenresAdapter;
import com.partiel_android_boucher.classes.realm_classes.RealmGenre;
import com.partiel_android_boucher.controllers.GenreController;
import com.partiel_android_boucher.tools.RealmConfig;

import java.util.ArrayList;
import android.os.Handler;
import android.widget.Toast;

import io.realm.Realm;

/**
 * Created by boucherclement on 27/04/16.
 */
public class GenresFragment extends Fragment {
    private static ListView genresList;
    private ArrayList<Genre> genres;
    private static View view;

    public GenresFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_genres, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        view = getView();
        GenreController.downloadAllGenres(getContext());
    }

    public static void setUpAdapter(ArrayList<Genre> _genres) {
        genresList = (ListView) view.findViewById(R.id.genresList);
        GenresAdapter genresAdapter = new GenresAdapter(view.getContext(), _genres);
        genresList.setAdapter(genresAdapter);
        genresList.setOnItemClickListener(new OnGenreItemClickListener(genresAdapter));
    }
}

class OnGenreItemClickListener implements ListView.OnItemClickListener {
    private GenresAdapter genresAdapter;

    public OnGenreItemClickListener(GenresAdapter _genresAdapter) {
        this.genresAdapter = _genresAdapter;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Genre genre = (Genre) genresAdapter.getItem(position);
        Toast.makeText(view.getContext(), genre.getName(), Toast.LENGTH_SHORT).show();
    }
}
