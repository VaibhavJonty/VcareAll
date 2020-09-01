package com.tuteehub.vcareall.model;

import com.google.gson.annotations.SerializedName;

public class Count {
    @SerializedName("video_comment_count")
    private String videoCommentCount;
    @SerializedName("like_count")
    private String likeCount;

    public String getVideoCommentCount() {
        return videoCommentCount;
    }

    public void setVideoCommentCount(String videoCommentCount) {
        this.videoCommentCount = videoCommentCount;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }
}
