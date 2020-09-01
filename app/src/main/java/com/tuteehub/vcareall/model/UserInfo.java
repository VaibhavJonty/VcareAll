package com.tuteehub.vcareall.model;

import com.google.gson.annotations.SerializedName;

public class UserInfo {
    @SerializedName("verified")
    private String verified;
    @SerializedName("username")
    private String username;
    @SerializedName("profile_pic")
    private String profilePic;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("first_name")
    private String firstName;

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
