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

    /*
    Copy an object into realm
     */
    public static void copyToRealm(Realm _realm, Album _album){
        _realm.beginTransaction();
        _realm.copyToRealm(_album);
        _realm.commitTransaction();
    }

    /*
    Create a realm object with a json
     */
    public static void createObjectFromJson(Realm _realm, String _json){
        _realm.beginTransaction();
        _realm.createObjectFromJson(Album.class, _json);
        _realm.commitTransaction();
    }

    /*
    Get the name of the artist for an album
     */
    public static String getAlbumArtist(Realm _realm, int _pid){
        String artistName;
        _realm.beginTransaction();
        artistName = _realm.where(Artist.class).equalTo("pid", _pid).findFirst().toString();
        _realm.commitTransaction();
        return artistName;
    }

    /*
    Get all albums
     */
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

    /*
    Get an album with the id
     */
    public static Album getAlbumByPid(Realm _realm, int _aid){
        _realm.beginTransaction();
        Album album = _realm.where(Album.class).equalTo("aid", _aid).findFirst();
        _realm.commitTransaction();
        return album;
    }

    /*
    Get the number of album of an artist
     */
    public static int getNbAlbumsByArtist(Realm _realm, int _pid) {
        _realm.beginTransaction();
        RealmResults<Album> results = _realm.where(Album.class).equalTo("artist", _pid).findAll();
        _realm.commitTransaction();
        return results.size();
    }

    /*
    Clear realm of Album class
     */
    public static void clearAlbums(Realm _realm) {
        _realm.beginTransaction();
        _realm.delete(Album.class);
        _realm.commitTransaction();
    }

}
