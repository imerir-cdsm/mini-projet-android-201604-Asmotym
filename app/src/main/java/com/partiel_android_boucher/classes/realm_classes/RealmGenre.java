package com.partiel_android_boucher.classes.realm_classes;

import com.partiel_android_boucher.classes.Album;
import com.partiel_android_boucher.classes.Genre;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by boucherclement on 27/04/16.
 */
public class RealmGenre {

    public static void copyToRealm(Realm _realm, Genre _genre){
        _realm.beginTransaction();
        _realm.copyToRealm(_genre);
        _realm.commitTransaction();
    }

    public static void creatObjectFromJson(Realm _realm, String _json){
        _realm.beginTransaction();
        _realm.createObjectFromJson(Genre.class, _json);
        _realm.commitTransaction();
    }

    public static ArrayList<Genre> getAllGenre(Realm _realm) {
        _realm.beginTransaction();
        ArrayList<Genre> genres = new ArrayList<>();
        RealmResults<Genre> results = _realm.where(Genre.class).findAll();
        if (results.size() == 0){
            _realm.commitTransaction();
            return genres;
        } else {
            for (Genre genre : results) {
                genres.add(genre);
            }
            _realm.commitTransaction();
            return genres;
        }
    }

    public static int getNbAlbumsByGenre(Realm _realm, int _gid) {
        _realm.beginTransaction();
        RealmResults<Album> results = _realm.where(Album.class).equalTo("genre", _gid).findAll();
        _realm.commitTransaction();
        return results.size();
    }

    public static void clearGenre(Realm _realm) {
        _realm.beginTransaction();
        _realm.delete(Genre.class);
        _realm.commitTransaction();
    }

}
