package com.ft.entity;

public class Authority {
    private int authoId;
    private String authoName;
    private String authoPerms;
    private int authoLevel;
    private int authoFatherId;
    private boolean isSelected;

    public int getAuthoId() {
        return authoId;
    }

    public void setAuthoId(int authoId) {
        this.authoId = authoId;
    }

    public String getAuthoName() {
        return authoName;
    }

    public void setAuthoName(String authoName) {
        this.authoName = authoName;
    }

    public String getAuthoPerms() {
        return authoPerms;
    }

    public void setAuthoPerms(String authoPerms) {
        this.authoPerms = authoPerms;
    }

    public int getAuthoLevel() {
        return authoLevel;
    }

    public void setAuthoLevel(int authoLevel) {
        this.authoLevel = authoLevel;
    }

    public int getAuthoFatherId() {
        return authoFatherId;
    }

    public void setAuthoFatherId(int authoFatherId) {
        this.authoFatherId = authoFatherId;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "authoId=" + authoId +
                ", authoName='" + authoName + '\'' +
                ", authoPerms='" + authoPerms + '\'' +
                ", authoLevel=" + authoLevel +
                ", authoFatherId=" + authoFatherId +
                ", isSelected=" + isSelected +
                '}';
    }
}

