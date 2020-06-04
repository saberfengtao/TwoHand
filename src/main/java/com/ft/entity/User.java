package com.ft.entity;

public class User {
	private Integer userId;
	private String userName;
	private int userSex;
	private String userLoginName;
	private String userLoginPwd;
	private String userTel;
	private String userMail;
	private String userPhoto;
	private int userState;
	
	public Integer getUserId() {

		return userId;
	}
	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserSex() {

		return userSex;
	}
	public void setUserSex(int userSex) {

		this.userSex = userSex;
	}
	public String getUserLoginName() {

		return userLoginName;
	}
	public void setUserLoginName(String userLoginName)
	{
		this.userLoginName = userLoginName;
	}
	public String getUserLoginPwd() {
		return userLoginPwd;
	}
	public void setUserLoginPwd(String userLoginPwd) {
		this.userLoginPwd = userLoginPwd;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	public int getUserState() {
		return userState;
	}
	public void setUserState(int userState) {
		this.userState = userState;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userSex=" + userSex + ", userLoginName="
				+ userLoginName + ", userLoginPwd=" + userLoginPwd + ", userTel=" + userTel + ", userMail=" + userMail
				+ ", userPhoto=" + userPhoto + ", userState=" + userState + "]";
	}

}
