package com.yedam.bulletin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bulletin.serviceImpl.BulletinServiceImpl;
import com.yedam.bulletin.vo.BulletinVO;
import com.yedam.common.DBCommand;
import com.yedam.common.Paging;

public class BulletinListPaging implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");	// 페이지 번호
		if (page == null) 
			page = "1";
		int pageCnt = Integer.parseInt(page);
		BulletinServiceImpl service = new BulletinServiceImpl();
		List<BulletinVO> total = service.selectBulletinList(); // 전체카운트
		
		// 전체 건수를 위해 실행
		service = new BulletinServiceImpl();
		List<BulletinVO> list = service.bulletinListPaging(pageCnt);
		
		//현재 페이지 리스트를 위해 실행
        Paging paging = new Paging();
        paging.setPageNo(pageCnt);	
        paging.setPageSize(10);		//페이지 크기
        paging.setTotalCount(total.size());
		
        request.setAttribute("BulletinList", list);
        request.setAttribute("paging", paging);
        return "bulletin/bulletinListPaging.tiles";
	}
}
