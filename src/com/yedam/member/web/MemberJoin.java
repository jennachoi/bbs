package com.yedam.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.DBCommand;
import com.yedam.member.service.MemberService;
import com.yedam.member.serviceImpl.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class MemberJoin implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 새 회원 DB에 저장, 완료 후에는 main.do 호출

		HttpSession session = request.getSession(); 	// 세션 객체 생성
		
		String id = request.getParameter("memberId");
		String pwd = request.getParameter("memberPwd");
		String name = request.getParameter("memberName");
		String addr = request.getParameter("memberAddr");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setName(name);
		vo.setAddr(addr);
		
		MemberService service = new MemberServiceImpl();
		service.insertMember(vo);
		
		session.setAttribute("id", id);				// 세션에 할당하기
		session.setAttribute("member", vo);

		return "main/main.tiles";
	}

}
