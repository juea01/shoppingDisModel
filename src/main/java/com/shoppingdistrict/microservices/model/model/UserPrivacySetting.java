package com.shoppingdistrict.microservices.model.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name="user_privacy_settings")
public class UserPrivacySetting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // note this approach doesn't allow batch processing
	@Column(name = "id")
	private int id;

	@Enumerated(EnumType.STRING) // Maps enum values to their string representations in the database
    @Column(name = "setting_value", nullable = false)
    private PrivacySetting settingValue;

	@Enumerated(EnumType.STRING)
    @Column(name = "setting_key", nullable = false)
    private PrivacySettingKey settingKey;
	

	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling user and article indefinitely
	@JoinColumn(name = "user_id")
	private Users users;

	public UserPrivacySetting() {

	}

	public UserPrivacySetting(int id, PrivacySetting settingValue, PrivacySettingKey settingKey, Users user) {
		super();
		this.id = id;
		this.settingValue = settingValue;
		this.settingKey = settingKey;
		this.users = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PrivacySetting getSettingValue() {
		return settingValue;
	}

	public void setSettingValue(PrivacySetting settingValue) {
		this.settingValue = settingValue;
	}

	public PrivacySettingKey getSettingKey() {
		return settingKey;
	}

	public void setSettingKey(PrivacySettingKey settingKey) {
		this.settingKey = settingKey;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	

	

}
