package com.partiel_android_boucher.classes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.partiel_android_boucher.R;
import com.partiel_android_boucher.classes.Track;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import android.content.Context;
import android.widget.TextView;

/**
 * Created by boucherclement on 28/04/16.
 */
public class TracksAdapter extends BaseAdapter {
    LayoutInflater layoutInflater;
    ArrayList<Track> tracks;
    Context context;

    public TracksAdapter(Context _context, ArrayList<Track> _tracks) {
        this.tracks = _tracks;
        this.context = _context;

        layoutInflater = LayoutInflater.from(_context);
    }

    @Override
    public int getCount() {
        return tracks.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return tracks.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.track_item, parent, false);
        }
        Track track = tracks.get(position);

        TextView trackName = (TextView) convertView.findViewById(R.id.trackName);
        TextView trackDuration = (TextView) convertView.findViewById(R.id.trackDuration);

        trackName.setText(track.getTid() + ". " + track.getTitle());
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        trackDuration.setText(sdf.format(track.getDuration()));

        return convertView;
    }
}
