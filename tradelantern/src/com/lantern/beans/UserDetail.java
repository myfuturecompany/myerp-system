package com.lantern.beans;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * The persistent class for the user_details database table.
 * 
 */
public class UserDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String address;

	private String contactNo;

	private String createdBy;

	private Timestamp createdDate;

	private String email;

	private byte isFirstLogin;

	private byte isLoggedIn;

	private String locationCd;

	private String name;

	private int role;

	private String sessionId;

	private int status;

	private String userName;

	private String userPassword;

	public UserDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return this.contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getIsFirstLogin() {
		return this.isFirstLogin;
	}

	public void setIsFirstLogin(byte isFirstLogin) {
		this.isFirstLogin = isFirstLogin;
	}

	public byte getIsLoggedIn() {
		return this.isLoggedIn;
	}

	public void setIsLoggedIn(byte isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public String getLocationCd() {
		return this.locationCd;
	}

	public void setLocationCd(String locationCd) {
		this.locationCd = locationCd;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRole() {
		return this.role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}