package com.tuteehub.vcareall.model;

import com.google.gson.annotations.SerializedName;

public class Msg {
    @SerializedName("created")
    private String created;
    @SerializedName("sound")
    private Sound sound;
    @SerializedName("description")
    private String description;
    @SerializedName("gif")
    private String gif;
    @SerializedName("thum")
    private String thum;
    @SerializedName("video")
    private String video;
    @SerializedName("liked")
    private String liked;
    @SerializedName("count")
    private Count count;
    @SerializedName("user_info")
    private UserInfo userInfo;
    @SerializedName("fb_id")
    private String fbId;
    @SerializedName("id")
    private String id;

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Sound getSound() {
        return sound;
    }

    public void setSound(Sound sound) {
        this.sound = sound;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGif() {
        return gif;
    }

    public void setGif(String gif) {
        this.gif = gif;
    }

    public String getThum() {
        return thum;
    }

    public void setThum(String thum) {
        this.thum = thum;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getLiked() {
        return liked;
    }

    public void setLiked(String liked) {
        this.liked = liked;
    }

    public Count getCount() {
        return count;
    }

    public void setCount(Count count) {
        this.count = count;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getFbId() {
        return fbId;
    }

    public void setFbId(String fbId) {
        this.fbId = fbId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
