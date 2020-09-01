package com.tuteehub.vcareall.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FeedResponse {

    @SerializedName("msg")
    private List<Msg> msg;
    @SerializedName("code")
    private String code;

    public List<Msg> getMsg() {
        return msg;
    }

    public void setMsg(List<Msg> msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
