package com.partiel_android_boucher.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.partiel_android_boucher.R;
import com.partiel_android_boucher.classes.Album;
import com.partiel_android_boucher.classes.Artist;
import com.partiel_android_boucher.classes.Track;
import com.partiel_android_boucher.classes.realm_classes.RealmAlbum;
import com.partiel_android_boucher.classes.realm_classes.RealmArtist;
import com.partiel_android_boucher.tools.RealmConfig;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlbumDetailsActivity extends AppCompatActivity {
    ImageView albumImage;
    TextView albumName, artistName, nbTracks, duration;
    Album album;
    Artist artist;
    ArrayList<Track> tracks;
    int aid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_details);
        aid = getIntent().getExtras().getInt("aid");
        getAlbumDetails();

    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpAlbumDetails();
    }

    private void getAlbumDetails(){
        album = RealmAlbum.getAlbumByPid(RealmConfig.realm, aid);
        artist = RealmArtist.getArtistByPid(RealmConfig.realm, album.getArtist());
    }

    private void setUpAlbumDetails() {
        albumImage = (ImageView) findViewById(R.id.albumDetailsImage);
        albumName = (TextView) findViewById(R.id.albumDetailsName);
        artistName = (TextView) findViewById(R.id.albumDetailsArtist);
        nbTracks = (TextView) findViewById(R.id.albumDetailsNbTracks);
        duration = (TextView) findViewById(R.id.albumDetailsDuration);

        Picasso.with(this).load(album.getPhotoUrl()).resize(100, 100).centerCrop().into(albumImage);
        albumName.setText(album.getTitle());
        artistName.setText(artist.toString());
    }
}
