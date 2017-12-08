package com.sktelecom.jse.service;

import com.sktelecom.jse.domain.MemberBean;
import com.sktelecom.jse.domain.SkPhoneBean;

public interface Service {
	public String openService(SkPhoneBean bean, MemberBean memberBean);
	public String list();
	public String findByKey(String key);
	public String findByName(String name);
	public String updatePhoneNumber(String key);
	public void deleteMember(String key);
}
