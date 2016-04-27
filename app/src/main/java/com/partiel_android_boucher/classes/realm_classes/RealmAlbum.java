package com.partiel_android_boucher.classes.realm_classes;

import com.partiel_android_boucher.classes.Album;
import com.partiel_android_boucher.classes.Artist;

import io.realm.Realm;

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
        artistName = _realm.where(Artist.class).equalTo("aid", _pid).findFirst().toString();
        _realm.commitTransaction();
        return artistName;
    }

}
