package com.partiel_android_boucher.classes.realm_classes;

import com.partiel_android_boucher.classes.Album;
import com.partiel_android_boucher.classes.Artist;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by boucherclement on 27/04/16.
 */
public class RealmAlbum {

    public static void copyToRealm(Realm _realm, Album _album){
        _realm.beginTransaction();
        _realm.copyToRealm(_album);
        _realm.commitTransaction();
    }

    public static void creatObjectFromJson(Realm _realm, String _json){
        _realm.beginTransaction();
        _realm.createObjectFromJson(Album.class, _json);
        _realm.commitTransaction();
    }

    public static String getAlbumArtist(Realm _realm, int _pid){
        String artistName;
        _realm.beginTransaction();
        artistName = _realm.where(Artist.class).equalTo("pid", _pid).findFirst().toString();
        _realm.commitTransaction();
        return artistName;
    }

    public static ArrayList<Album> getAllAlbum(Realm _realm){
        _realm.beginTransaction();
        ArrayList<Album> albums = new ArrayList<>();
        RealmResults<Album> results = _realm.where(Album.class).findAll();
        if (results.size() == 0) {
            _realm.commitTransaction();
            return albums;
        } else {
            for (Album album : results) {
                albums.add(album);
            }
            _realm.commitTransaction();
            return albums;
        }
    }

    public static Album getAlbumByPid(Realm _realm, int _aid){
        _realm.beginTransaction();
        Album album = _realm.where(Album.class).equalTo("aid", _aid).findFirst();
        _realm.commitTransaction();
        return album;
    }

    public static int getNbAlbumsByArtist(Realm _realm, int _pid) {
        _realm.beginTransaction();
        RealmResults<Album> results = _realm.where(Album.class).equalTo("artist", _pid).findAll();
        _realm.commitTransaction();
        return results.size();
    }

    public static void clearAlbums(Realm _realm) {
        _realm.beginTransaction();
        _realm.delete(Album.class);
        _realm.commitTransaction();
    }

}
