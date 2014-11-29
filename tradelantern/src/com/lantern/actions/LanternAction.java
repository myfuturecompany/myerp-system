package com.lantern.actions;


public class LanternAction {
	
	String userName;
	String passWord;
		
	public String execute(){
		return "login";
	}

	
	public String login(){
		return "dashboard";
	}

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


}
