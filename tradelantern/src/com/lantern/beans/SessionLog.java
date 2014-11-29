package com.lantern.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the session_log database table.
 * 
 */
@Entity
@Table(name="session_log")
@NamedQuery(name="SessionLog.findAll", query="SELECT s FROM SessionLog s")
public class SessionLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="ip_address")
	private String ipAddress;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="login_time")
	private Date loginTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="logout_time")
	private Date logoutTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="session_created")
	private Date sessionCreated;

	@Column(name="session_id")
	private String sessionId;

	@Column(name="user_agent")
	private String userAgent;

	@Column(name="user_name")
	private String userName;

	public SessionLog() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Date getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Date getLogoutTime() {
		return this.logoutTime;
	}

	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}

	public Date getSessionCreated() {
		return this.sessionCreated;
	}

	public void setSessionCreated(Date sessionCreated) {
		this.sessionCreated = sessionCreated;
	}

	public String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getUserAgent() {
		return this.userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}