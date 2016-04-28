package com.partiel_android_boucher.classes.realm_classes;

import com.partiel_android_boucher.classes.Artist;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by boucherclement on 27/04/16.
 */
public class RealmArtist {

    public static void copyToRealm(Realm _realm, Artist _artist){
        _realm.beginTransaction();
        _realm.copyToRealm(_artist);
        _realm.commitTransaction();
    }

    public static void creatObjectFromJson(Realm _realm, String _json){
        _realm.beginTransaction();
        _realm.createObjectFromJson(Artist.class, _json);
        _realm.commitTransaction();
    }

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

    public static Artist getArtistByPid(Realm _realm, int _pid) {
        _realm.beginTransaction();
        Artist artist = _realm.where(Artist.class).equalTo("pid", _pid).findFirst();
        _realm.commitTransaction();
        return artist;
    }

}
