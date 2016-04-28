package com.partiel_android_boucher.classes.realm_classes;

import android.util.Log;

import com.partiel_android_boucher.classes.Artist;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by boucherclement on 27/04/16.
 */
public class RealmArtist {

    /**
     * Copy an Artist into Realm
     * @param _realm
     * @param _artist
     */
    public static void copyToRealm(Realm _realm, Artist _artist){
        _realm.beginTransaction();
        _realm.copyToRealm(_artist);
        _realm.commitTransaction();
    }

    /**
     * Create a realm Artist with a json string
     * @param _realm
     * @param _json
     */
    public static void creatObjectFromJson(Realm _realm, String _json){
        _realm.beginTransaction();
        _realm.createObjectFromJson(Artist.class, _json);
        _realm.commitTransaction();
    }

    /**
     * Get all artists from realm
     * @param _realm
     * @return
     */
    public static ArrayList<Artist> getAllArtist(Realm _realm) {
        _realm.beginTransaction();
        ArrayList<Artist> artists = new ArrayList<>();
        RealmResults<Artist> results = _realm.where(Artist.class).findAll();
        if (results.size() == 0){
            _realm.commitTransaction();
            return artists;
        } else {
            for (Artist artist : results) {
                artists.add(artist);
            }
            _realm.commitTransaction();
            return artists;
        }
    }

    /**
     * Get an artist with pid
     * @param _realm
     * @param _pid
     * @return
     */
    public static Artist getArtistByPid(Realm _realm, int _pid) {
        _realm.beginTransaction();
        Artist artist = _realm.where(Artist.class).equalTo("pid", _pid).findFirst();
        _realm.commitTransaction();
        return artist;
    }

    /**
     * Clear all artist from realm
     * @param _realm
     */
    public static void clearArtist(Realm _realm) {
        _realm.beginTransaction();
        _realm.delete(Artist.class);
        _realm.commitTransaction();
    }

}
