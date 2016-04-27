package com.partiel_android_boucher.activities.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.partiel_android_boucher.R;

import io.realm.Realm;

/**
 * Created by boucherclement on 27/04/16.
 */
public class GenresFragment extends Fragment {
    private ListView genresList;
    private Realm realm;
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

}
