package com.partiel_android_boucher.classes.adapters;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.partiel_android_boucher.R;
import com.partiel_android_boucher.classes.Album;
import com.partiel_android_boucher.classes.Artist;
import com.partiel_android_boucher.classes.realm_classes.RealmAlbum;
import com.partiel_android_boucher.classes.realm_classes.RealmArtist;
import com.partiel_android_boucher.controllers.AlbumController;
import com.partiel_android_boucher.tools.RealmConfig;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.ArrayList;

import io.realm.Realm;


public class AlbumsAdapter extends BaseAdapter {
    LayoutInflater layoutInflater;
    ArrayList<Album> albums;
    Context context;
    ImageView albumImage;
    TextView albumTitle;
    TextView albumArtist;

    public AlbumsAdapter(Context _context, ArrayList<Album> _albums){
        this.context = _context;
        this.albums = _albums;

        layoutInflater = LayoutInflater.from(_context);
    }

    @Override
    public int getCount() {
        return albums.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return albums.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.tab_albums_item, parent, false);
        }
        Album album = albums.get(position);

        albumImage = (ImageView) convertView.findViewById(R.id.albumImage);
        albumTitle = (TextView) convertView.findViewById(R.id.albumTitle);
        albumArtist = (TextView) convertView.findViewById(R.id.albumArtist);

        Picasso.with(this.context).load(album.getPhotoUrl()).resize(50, 50).centerCrop().into(albumImage);
        albumTitle.setText(album.getTitle());

        if (RealmArtist.getArtistByPid(RealmConfig.realm, album.getArtist()) == null) {
            AlbumController.downloadArtistByPid(this.context, album.getArtist());
        }
        Artist artist = RealmArtist.getArtistByPid(RealmConfig.realm, album.getArtist());
        albumArtist.setText(artist.toString());

        return convertView;
    }
}

class AlbumsRunnable implements Runnable {
    private Context context;
    private int pid;
    private TextView textView;
    private Artist artist;

    public AlbumsRunnable(Context _context, int _pid, TextView _textView){
        this.context = _context;
        this.pid = _pid;
        this.textView = _textView;
    }

    @Override
    public void run() {
        //artist = AlbumController.getArtistByPid(this.context, this.pid);
        textView.setText(artist.toString());
    }
}