package com.ft.entity;

import java.sql.Timestamp;

public class FeedBack {
    private int fbId;
    private String fbType;
    private String fbText;
    private Timestamp fbTime;
    private int fbState;
    private User user;

    public int getFbId() {
        return fbId;
    }

    public void setFbId(int fbId) {
        this.fbId = fbId;
    }

    public String getFbType() {
        return fbType;
    }

    public void setFbType(String fbType) {
        this.fbType = fbType;
    }

    public String getFbText() {
        return fbText;
    }

    public void setFbText(String fbText) {
        this.fbText = fbText;
    }

    public Timestamp getFbTime() {
        return fbTime;
    }

    public void setFbTime(Timestamp fbTime) {
        this.fbTime = fbTime;
    }

    public int getFbState() {
        return fbState;
    }

    public void setFbState(int fbState) {
        this.fbState = fbState;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "FeedBack{" +
                "fbId=" + fbId +
                ", fbType='" + fbType + '\'' +
                ", fbText='" + fbText + '\'' +
                ", fbTime=" + fbTime +
                ", fbState=" + fbState +
                ", user=" + user +
                '}';
    }
}
