package com.partiel_android_boucher.activities.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.partiel_android_boucher.R;
import com.partiel_android_boucher.classes.Artist;
import com.partiel_android_boucher.classes.adapters.ArtistsAdapter;
import com.partiel_android_boucher.classes.realm_classes.RealmArtist;
import com.partiel_android_boucher.controllers.ArtistController;
import com.partiel_android_boucher.tools.RealmConfig;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class ArtistsFragment extends Fragment {
    private static ListView artistsList;
    ArrayList<Artist> artists;
    private static View view;

    public ArtistsFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArtistController.downloadAllArtists(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_artists, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        view = getView();
        setUpAdapter(RealmArtist.getAllArtist(RealmConfig.realm));
    }

    public static void setUpAdapter(ArrayList<Artist> _artists) {
        artistsList = (ListView) view.findViewById(R.id.artistsList);
        ArtistsAdapter artistsAdapter = new ArtistsAdapter(view.getContext(), _artists);
        artistsList.setAdapter(artistsAdapter);
        artistsList.setOnItemClickListener(new OnArtistItemClickListener(artistsAdapter));
    }
}

class OnArtistItemClickListener implements ListView.OnItemClickListener {
    private ArtistsAdapter artistsAdapter;

    public OnArtistItemClickListener(ArtistsAdapter _artistsAdapter) {
        this.artistsAdapter = _artistsAdapter;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Artist artist = (Artist) artistsAdapter.getItem(position);
        Toast.makeText(view.getContext(), artist.toString(), Toast.LENGTH_SHORT).show();
    }
}
