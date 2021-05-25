package com.yedam.notice.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DBCommand;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.serviceImpl.NoticeServiceImpl;
import com.yedam.notice.vo.NoticeVO;

public class NoticeList implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 공지사항 조회결과 -> noticeList.jsp
		NoticeService service = new NoticeServiceImpl();
		List<NoticeVO> list = service.selectNoticeList();

		request.setAttribute("noticeList", list);
		
		return "notice/noticeList.tiles";
	}

}
