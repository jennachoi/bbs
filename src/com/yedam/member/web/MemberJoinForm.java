package com.yedam.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DBCommand;

public class MemberJoinForm implements DBCommand {
	// 별다른 기능은 없음. 호출-리턴만 한다. 
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "member/memberJoinForm.tiles";
	}

}
