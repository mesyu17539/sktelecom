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
			switch(JOptionPane.showInputDialog("[메뉴] [0] 종료 [1] 가입 [2] 목록 [3] 고객번호로 찾기"
					+ " [4] 이름으로 찾기 [5] 전화번호 변경 [6] 회원삭제")) {
			case "0":
				JOptionPane.showMessageDialog(null, "종료합니다");
				return;
			case "1":
				bean=new SkPhoneBean();
				memberBean=new MemberBean();
				bean.setBrand(JOptionPane.showInputDialog("브랜드를 고르세요 [1] GALAXY [2] IPhone"));
				memberBean.setName(JOptionPane.showInputDialog("이름을 입력하세요"));
				JOptionPane.showMessageDialog(null, service.openService(bean,memberBean));
				break;
			case "2":
				JOptionPane.showMessageDialog(null,
						service.list());
				break;
			case "3":
				JOptionPane.showMessageDialog(null, service.findByKey(JOptionPane.showInputDialog("고객의 번호를 입력하세요")));
				break;
			case "4":
				JOptionPane.showMessageDialog(null, service.findByName(JOptionPane.showInputDialog("이름을 입력하세요")));
				break;
			case "5":
				JOptionPane.showMessageDialog(null, service.updatePhoneNumber(JOptionPane.showInputDialog("고객넘버를 입력하세요")));
				break;
			case "6":
				service.deleteMember(JOptionPane.showInputDialog("고객넘버를 입력하세요"));
				break;
			}
		}
	}
}
