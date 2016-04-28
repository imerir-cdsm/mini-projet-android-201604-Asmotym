package com.partiel_android_boucher.classes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import io.realm.Realm;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.partiel_android_boucher.R;
import com.partiel_android_boucher.classes.Artist;
import com.partiel_android_boucher.classes.realm_classes.RealmAlbum;
import com.partiel_android_boucher.tools.RealmConfig;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Asmotym on 27/04/2016.
 */
public class ArtistsAdapter extends BaseAdapter {
    ArrayList<Artist> artists;
    LayoutInflater layoutInflater;
    Context context;

    public ArtistsAdapter(Context _context, ArrayList<Artist> _artists){
        this.artists = _artists;
        this.context = _context;

        this.layoutInflater = LayoutInflater.from(_context);
    }

    @Override
    public int getCount() {
        return artists.size();
    }

    @Override
    public Object getItem(int position) {
        return artists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.tab_artists_item, parent, false);
        }
        Artist artist = artists.get(position);

        ImageView artistImage = (ImageView) convertView.findViewById(R.id.artistImage);
        TextView artistName = (TextView) convertView.findViewById(R.id.artistName);
        TextView artistNbAlbums = (TextView) convertView.findViewById(R.id.artistNbAlbums);

        Picasso.with(this.context).load(artist.getPhotoUrl()).resize(40, 40).centerCrop().into(artistImage);
        artistName.setText(artist.toString());
        int nbAlbums = RealmAlbum.getNbAlbumsByArtist(RealmConfig.realm, artist.getPid());
        if (nbAlbums < 2) {
            artistNbAlbums.setText(nbAlbums + " Album");
        } else {
            artistNbAlbums.setText(nbAlbums + " Albums");
        }


        return convertView;
    }
}
