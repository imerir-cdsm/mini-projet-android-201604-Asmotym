package com.partiel_android_boucher.activities.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.partiel_android_boucher.R;
import com.partiel_android_boucher.classes.Genre;
import com.partiel_android_boucher.classes.adapters.GenresAdapter;
import com.partiel_android_boucher.classes.realm_classes.RealmGenre;
import com.partiel_android_boucher.controllers.GenreController;
import com.partiel_android_boucher.tools.RealmConfig;

import java.util.ArrayList;
import android.os.Handler;

import io.realm.Realm;

/**
 * Created by boucherclement on 27/04/16.
 */
public class GenresFragment extends Fragment {
    private ListView genresList;
    private ArrayList<Genre> genres;

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

        if (RealmGenre.getAllGenre(RealmConfig.realm).size() == 0) {
            RealmGenre.clearGenre(RealmConfig.realm);
            GenreController.downloadAllGenres(getContext());
        }
        genres = RealmGenre.getAllGenre(RealmConfig.realm);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                genresList = (ListView) getView().findViewById(R.id.genresList);
                GenresAdapter genresAdapter = new GenresAdapter(getContext(), genres);
                genresList.setAdapter(genresAdapter);
            }
        }, 2000);
    }
}
