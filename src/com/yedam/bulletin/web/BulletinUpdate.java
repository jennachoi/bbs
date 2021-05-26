package com.yedam.bulletin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bulletin.serviceImpl.BulletinServiceImpl;
import com.yedam.bulletin.vo.BulletinVO;
import com.yedam.common.DBCommand;
import com.yedam.notice.serviceImpl.NoticeServiceImpl;
import com.yedam.notice.vo.NoticeVO;

public class BulletinUpdate implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		BulletinVO vo = new BulletinVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setId(Integer.parseInt(id));

		BulletinServiceImpl service = new BulletinServiceImpl();
		service.updateBulletin(vo);

		return "/bulletinListPaging.do";
	}
}
