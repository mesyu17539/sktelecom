package com.sktelecom.jse.serviceImpl;


import com.sktelecom.jse.domain.MemberBean;
import com.sktelecom.jse.domain.SkPhoneBean;

import com.sktelecom.jse.service.Service;

public class ServiceImpl implements Service{
	private static String GR="galaxy", IPH="iphone";
	private int mCount, skcount, customNum; 
	MemberBean[] mbeans;
	SkPhoneBean[] sbeans;
	public ServiceImpl() {
		mCount=skcount=0;
		customNum=1000;
		mbeans=new MemberBean[2];
		sbeans=new SkPhoneBean[2];
	}
	public void addmem(MemberBean mBean, SkPhoneBean sBean) {
		String customNum=createCustomNum();
		System.out.println("생성된 커스텀넘버"+customNum);
		mBean.setMcount(customNum);
		sBean.setMcount(customNum);
		this.mbeans[mCount++]=mBean;
		this.sbeans[skcount++]=sBean;
	}
	public String openService(SkPhoneBean skbean, MemberBean mBean) {
		String brand=skbean.getBrand();
		skbean.setBrand(brand.equals("1")?GR:brand.equals("2")?IPH:"없음");
		String num="";
		for(int i=0;i<8;i++) {
			num+=(int)(Math.random()*10);
			if(i==3) {
				num+="-";
			}
		}
		skbean.setNumber(String.format("010-%s",num));
		addmem(mBean,skbean);
		return String.format("[%s]님 이름으로 [%S] [%s]폰이 개통되었습니다", mBean.getName(), skbean.getNumber(),skbean.getBrand());
	}
	public String createCustomNum() {
		return String.valueOf(customNum++);
	}
	public String list() {
		String res="";
		for(int i=0;i<mCount;i++) {
			for(int j=0;j<skcount;j++) {
				if(sbeans[j].getMcount().equals(mbeans[i].getMcount())) {
					res = res.concat(mbeans[i].getMcount().
								concat(mbeans[i].getName().
								concat(sbeans[i].getBrand().
								concat(sbeans[i].getNumber()+"\n"))));
				}
			}
		}
		return res;
	}
}
