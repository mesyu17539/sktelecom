package com.sktelecom.jse.serviceImpl;

import java.util.Random;

import com.sktelecom.jse.domain.MemberBean;
import com.sktelecom.jse.domain.SkPhoneBean;

import com.sktelecom.jse.service.Service;

public class ServiceImpl implements Service{
	private static String GR="galaxy", IPH="iphone";
	private int memberCount, skcount; 
	SkPhoneBean bean=null;
	MemberBean mbean=null;
	Random ra=null;
	MemberBean[] mbeans;
	SkPhoneBean[] sbeans;
	public ServiceImpl() {
		mbeans=new MemberBean[2];
		sbeans=new SkPhoneBean[2];
	}
	public void addmem(MemberBean mBean, SkPhoneBean sBean) {
		this.mbeans[memberCount++]=mBean;
		this.sbeans[skcount++]=sBean;
	}
	public String openService(SkPhoneBean nbean, MemberBean memberBean) {
		mbean=new MemberBean();
		bean=new SkPhoneBean();
		ra=new Random();
		mbean.setName(memberBean.getName());
		String brand=nbean.getBrand();
		bean.setBrand(brand.equals("1")?GR:brand.equals("2")?IPH:"없음");
		Random ra=new Random();
		String num="";
		for(int i=0;i<8;i++) {
			num+=ra.nextInt(9);
			if(i==3) {
				num+="-";
			}
		}
		bean.setNumber(String.format("010-%s",num));
		addmem(mbean,bean);
		return String.format("[%s]님 이름으로 [%S] [%s]폰이 개통되었습니다", mbean.getName(), bean.getNumber(),bean.getBrand());
	}

}
