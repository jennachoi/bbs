package com.yedam.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bulletin.service.BulletinService;
import com.yedam.bulletin.serviceImpl.BulletinServiceImpl;
import com.yedam.bulletin.vo.BulletinVO;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.serviceImpl.NoticeServiceImpl;
import com.yedam.notice.vo.NoticeVO;

public class MainPage implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		BulletinService service = new BulletinServiceImpl();
		List<BulletinVO> list = service.selectNewBulletinList();

		request.setAttribute("BulletinNewList", list);
		
		NoticeService service2 = new NoticeServiceImpl();
		List<NoticeVO> list2 = service2.selectNewNoticeList();
		
		request.setAttribute("NoticeNewList", list2);
		
		return "main/main.tiles";
	}

}
