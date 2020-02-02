package com.ibm.touchlessFG.demo.Model;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection = "Users")
public class Users implements ConfigurationModel {

	@Id
	@Field("UserID")
	private UUID userId;

	@Field("UserName")
	@NotNull
	private String userName;

	@Field("Password")
	@NotNull
	private String password;

	@Field("Permissions")
	private String permissions;

	@Field("Description")
	private String description;

	@Field("IsActive")
	private Boolean active;

	public Users() {}

	@PersistenceConstructor
	public Users(final UUID userId, final String userName, final String password, final String permissions,
			final String description, final Boolean active) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.permissions = permissions;
		this.description = description;
		this.active = active;
	}

	public Boolean getActive() {
		return active;
	}

	public String getDescription() {
		return description;
	}

	@Override
	@JsonIgnore
	public UUID getId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public String getPermissions() {
		return permissions;
	}

	public UUID getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(final boolean active) {
		this.active = active;
	}

	public void setActive(final Boolean active) {
		this.active = active;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public void setPermissions(final String permissions) {
		this.permissions = permissions;
	}

	public void setUserId(final UUID userId) {
		this.userId = userId;
	}

	public void setUserName(final String userName) {
		this.userName = userName;
	}

}
