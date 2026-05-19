package com.shoppingdistrict.microservices.model.dto;

import com.shoppingdistrict.microservices.model.PrivacySetting;
import com.shoppingdistrict.microservices.model.PrivacySettingKey;

public class UserPrivacySetting {

  private PrivacySetting settingValue;
  private PrivacySettingKey settingKey;
  
	public UserPrivacySetting() {
	}

	public UserPrivacySetting(PrivacySetting settingValue, PrivacySettingKey settingKey) {
		super();
		this.settingValue = settingValue;
		this.settingKey = settingKey;
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
	
}
