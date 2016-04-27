package com.partiel_android_boucher.classes;

/**
 * Created by boucherclement on 27/04/16.
 */
public class Track {
    private int tid;
    private int album;
    private String title;
    private int duration;

    public Track(){

    }

    public Track(int _tid, int _album, String _title, int _duration){
        setTid(_tid);
        setAlbum(_album);
        setTitle(_title);
        setDuration(_duration);
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getAlbum() {
        return album;
    }

    public void setAlbum(int album) {
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
