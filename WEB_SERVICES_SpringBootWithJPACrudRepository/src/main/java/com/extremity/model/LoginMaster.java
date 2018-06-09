package com.extremity.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoginMaster {
	@Id
private int loginid;
private String userType;
private String uname;
private String password;
public int getLoginid() {
	return loginid;
}
public void setLoginid(int loginid) {
	this.loginid = loginid;
}
public String getUserType() {
	return userType;
}
public void setUserType(String userType) {
	this.userType = userType;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
