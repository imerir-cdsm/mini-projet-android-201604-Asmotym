package com.partiel_android_boucher.classes.realm_classes;

import com.partiel_android_boucher.classes.Track;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by boucherclement on 27/04/16.
 */
public class RealmTrack {

    public static void copyToRealm(Realm _realm, Track _track){
        _realm.beginTransaction();
        _realm.copyToRealm(_track);
        _realm.commitTransaction();
    }

    public static void creatObjectFromJson(Realm _realm, String _json){
        _realm.beginTransaction();
        _realm.createObjectFromJson(Track.class, _json);
        _realm.commitTransaction();
    }

    public static ArrayList<Track> getAllTracks(Realm _realm) {
        _realm.beginTransaction();
        ArrayList<Track> tracks = new ArrayList<>();
        RealmResults<Track> results = _realm.where(Track.class).findAll();
        for (Track track : results){
            tracks.add(track);
        }
        _realm.commitTransaction();
        return tracks;
    }

    public static int getNbTracks(Realm _realm) {
        _realm.beginTransaction();
        int nbTrack = _realm.where(Track.class).findAll().size();
        _realm.commitTransaction();
        return nbTrack;
    }

    public static void clearTracks(Realm _realm) {
        _realm.beginTransaction();
        _realm.delete(Track.class);
        _realm.commitTransaction();
    }

}
