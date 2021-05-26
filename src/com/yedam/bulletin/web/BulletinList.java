package com.yedam.bulletin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bulletin.service.BulletinService;
import com.yedam.bulletin.serviceImpl.BulletinServiceImpl;
import com.yedam.bulletin.vo.BulletinVO;
import com.yedam.common.DBCommand;

public class BulletinList implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BulletinService service = new BulletinServiceImpl();
		List<BulletinVO> list = service.selectBulletinList();

		request.setAttribute("BulletinList", list);
		return "bulletin/bulletinList.tiles";
	}
}
