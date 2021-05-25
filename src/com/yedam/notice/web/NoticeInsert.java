package com.yedam.notice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DBCommand;
import com.yedam.notice.serviceImpl.NoticeServiceImpl;
import com.yedam.notice.vo.NoticeVO;

public class NoticeInsert implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 제목과 내용만 입력
		// submit → noticeInsert.do → 리스트 페이지
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		NoticeVO vo = new NoticeVO();
		vo.setTitle(title);
		vo.setContent(content);
		
		NoticeServiceImpl service = new NoticeServiceImpl();
		service.insertNotice(vo);
		
//		request.setAttribute("notice", vo);		
		return "/noticeListPaging.do";		
	}

}
