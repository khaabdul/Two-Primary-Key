package com.DualDataBaseWithDualPrimaryKey.Entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "UserDetails")
public class UserBean {
	@EmbeddedId
	private UserBeanPrimaryKey userBeanPrimaryKey;
	private String address;
	private long number;

	public UserBeanPrimaryKey getUserBeanPrimaryKey() {
		return userBeanPrimaryKey;
	}

	public void setUserBeanPrimaryKey(UserBeanPrimaryKey userBeanPrimaryKey) {
		this.userBeanPrimaryKey = userBeanPrimaryKey;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public UserBean(UserBeanPrimaryKey userBeanPrimaryKey, String address, long number) {
		super();
		this.userBeanPrimaryKey = userBeanPrimaryKey;
		this.address = address;
		this.number = number;
	}

	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserBean [userBeanPrimaryKey=" + userBeanPrimaryKey + ", address=" + address + ", number=" + number
				+ "]";
	}

}
