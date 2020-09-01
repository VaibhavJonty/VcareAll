package com.tuteehub.vcareall.model;

import com.google.gson.annotations.SerializedName;

public class Sound {
    @SerializedName("created")
    private String created;
    @SerializedName("section")
    private String section;
    @SerializedName("thum")
    private String thum;
    @SerializedName("description")
    private String description;
    @SerializedName("sound_name")
    private String soundName;
    @SerializedName("audio_path")
    private AudioPath audioPath;
    @SerializedName("id")
    private int id;

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getThum() {
        return thum;
    }

    public void setThum(String thum) {
        this.thum = thum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSoundName() {
        return soundName;
    }

    public void setSoundName(String soundName) {
        this.soundName = soundName;
    }

    public AudioPath getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(AudioPath audioPath) {
        this.audioPath = audioPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
