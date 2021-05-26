package com.yedam.bulletin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bulletin.serviceImpl.BulletinServiceImpl;
import com.yedam.bulletin.vo.BulletinVO;
import com.yedam.common.DBCommand;
import com.yedam.notice.serviceImpl.NoticeServiceImpl;
import com.yedam.notice.vo.NoticeVO;

public class BulletinInsert implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 입력값을 DB insert 후 -> bulletinList보여주기
		String title = request.getParameter("title");
		String writer = request.getParameter("id");
		String content = request.getParameter("content");
		
		BulletinVO vo = new BulletinVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);

		BulletinServiceImpl service = new BulletinServiceImpl();
		service.insertBulletin(vo);
		
		return "/bulletinListPaging.do";		
	}

}
