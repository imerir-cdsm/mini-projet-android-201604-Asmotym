package com.partiel_android_boucher.classes;

import io.realm.RealmObject;

/**
 * Created by boucherclement on 27/04/16.
 */
public class Album extends RealmObject {
    private int aid;
    private String title;
    private int artist;
    private int genre;
    private String photoUrl;

    public Album(){

    }

    public Album(int _aid, String _title, int _artist, int _genre, String _photoUrl){
        setAid(_aid);
        setTitle(_title);
        setArtist(_artist);
        setGenre(_genre);
        setPhotoUrl(_photoUrl);
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getArtist() {
        return artist;
    }

    public void setArtist(int artist) {
        this.artist = artist;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
