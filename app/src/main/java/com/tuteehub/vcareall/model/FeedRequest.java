package com.tuteehub.vcareall.model;

public class FeedRequest {
    private String fb_id;
    private String token;

    public FeedRequest(String fb_id, String token) {
        this.fb_id = fb_id;
        this.token = token;
    }
}
