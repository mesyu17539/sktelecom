package com.sktelecom.jse.controller;

import javax.swing.JOptionPane;

import com.sktelecom.jse.domain.MemberBean;
import com.sktelecom.jse.domain.SkPhoneBean;
import com.sktelecom.jse.service.Service;
import com.sktelecom.jse.serviceImpl.ServiceImpl;

public class Servicecontroller {
	public static void main(String[] args) {
		Service service=new ServiceImpl();
		SkPhoneBean bean=null;
		MemberBean memberBean=null;
		while(true) {
			switch(JOptionPane.showInputDialog("[메뉴] [0] 종료 [1]가입")) {
			case "0":
				JOptionPane.showMessageDialog(null, "종료합니다");
				return;
			case "1":
				bean=new SkPhoneBean();
				memberBean=new MemberBean();
				bean.setBrand(JOptionPane.showInputDialog("브랜드를 고르세요 [1] GALAXY [2] IPhone"));
				memberBean.setName(JOptionPane.showInputDialog("이름을 입력하세요"));
				JOptionPane.showMessageDialog(null, service.openService(bean,memberBean));
			}
		}
	}
}
