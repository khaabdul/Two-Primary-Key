package com.DualDataBaseWithDualPrimaryKey.Entity;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Embeddable
public class UserBeanPrimaryKey {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserBeanPrimaryKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserBeanPrimaryKey(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserBeanPrimaryKey [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserBeanPrimaryKey other = (UserBeanPrimaryKey) obj;
		return id == other.id && Objects.equals(name, other.name);
	}

}
