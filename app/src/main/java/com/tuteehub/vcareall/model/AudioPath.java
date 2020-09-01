package com.tuteehub.vcareall.model;

import com.google.gson.annotations.SerializedName;

public class AudioPath {
    @SerializedName("acc")
    private String acc;
    @SerializedName("mp3")
    private String mp3;

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getMp3() {
        return mp3;
    }

    public void setMp3(String mp3) {
        this.mp3 = mp3;
    }
}
