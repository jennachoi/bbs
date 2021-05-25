package com.yedam.notice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DBCommand;
import com.yedam.notice.serviceImpl.NoticeServiceImpl;
import com.yedam.notice.vo.NoticeVO;

public class NoticeDelete implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		NoticeVO vo = new NoticeVO();
		vo.setId(Integer.parseInt(id));
		
		NoticeServiceImpl service = new NoticeServiceImpl();
		service.deleteNotice(vo);
		
//		request.setAttribute("notice", vo);		
		return "/noticeListPaging.do";		
	}
}
