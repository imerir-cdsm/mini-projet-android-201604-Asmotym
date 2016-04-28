package com.partiel_android_boucher.classes.realm_classes;

import com.partiel_android_boucher.classes.Track;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;


public class RealmTrack {

    /**
     * Copy a Track into Realm with a Track object
     * @param _realm
     * @param _track
     */
    public static void copyToRealm(Realm _realm, Track _track){
        _realm.beginTransaction();
        _realm.copyToRealm(_track);
        _realm.commitTransaction();
    }

    /**
     * Copy a Track into Realm with a json string
     * @param _realm
     * @param _json
     */
    public static void createObjectFromJson(Realm _realm, String _json){
        _realm.beginTransaction();
        _realm.createObjectFromJson(Track.class, _json);
        _realm.commitTransaction();
    }

    /**
     * Get all tracks from Realm
     * @param _realm
     * @return
     */
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

    /**
     * Get the number of tracks
     * @param _realm
     * @return
     */
    public static int getNbTracks(Realm _realm) {
        _realm.beginTransaction();
        int nbTrack = _realm.where(Track.class).findAll().size();
        _realm.commitTransaction();
        return nbTrack;
    }

    /**
     * Clear all tracks from Realm
     * @param _realm
     */
    public static void clearTracks(Realm _realm) {
        _realm.beginTransaction();
        _realm.delete(Track.class);
        _realm.commitTransaction();
    }

}
