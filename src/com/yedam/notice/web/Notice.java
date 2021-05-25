package com.yedam.notice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DBCommand;
import com.yedam.notice.serviceImpl.NoticeServiceImpl;
import com.yedam.notice.vo.NoticeVO;

public class Notice implements DBCommand {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 공지사항 한건의 상세내용 조회
		// serviceImpl 구현
		
		String id = request.getParameter("id");
		
		NoticeVO vo = new NoticeVO();
		vo.setId(Integer.parseInt(id));
		
		NoticeServiceImpl service = new NoticeServiceImpl();
		service.selectNotice(vo);
		
		request.setAttribute("notice", vo);
		return "notice/notice.tiles";
	}

}
