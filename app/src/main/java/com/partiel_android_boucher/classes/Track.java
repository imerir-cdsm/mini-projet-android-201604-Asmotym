package com.partiel_android_boucher.classes;

import io.realm.RealmObject;

/**
 * Created by boucherclement on 27/04/16.
 */
public class Track extends RealmObject {
    private int tid;
    private String title;
    private int duration;

    public Track(){

    }

    public Track(int _tid, String _title, int _duration){
        setTid(_tid);
        setTitle(_title);
        setDuration(_duration);
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
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
