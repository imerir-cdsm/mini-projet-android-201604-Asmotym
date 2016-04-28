package com.partiel_android_boucher.activities.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.partiel_android_boucher.R;
import com.partiel_android_boucher.classes.Artist;
import com.partiel_android_boucher.classes.adapters.ArtistsAdapter;
import com.partiel_android_boucher.classes.realm_classes.RealmArtist;
import com.partiel_android_boucher.controllers.ArtistController;
import com.partiel_android_boucher.tools.RealmConfig;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class ArtistsFragment extends Fragment {
    private ListView artistsList;
    ArrayList<Artist> artists;

    public ArtistsFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_artists, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        if (RealmArtist.getAllArtist(RealmConfig.realm).size() == 0) {
            RealmArtist.clearArtist(RealmConfig.realm);
            ArtistController.downloadAllArtists(getContext());
        }
        artists = RealmArtist.getAllArtist(RealmConfig.realm);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                artistsList = (ListView) getView().findViewById(R.id.artistsList);
                ArtistsAdapter artistsAdapter = new ArtistsAdapter(getContext(), artists);
                artistsList.setAdapter(artistsAdapter);
            }
        }, 2000);
    }
}
