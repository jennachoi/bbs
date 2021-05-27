package com.yedam.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.DBCommand;
import com.yedam.product.service.ProductService;
import com.yedam.product.serviceImpl.ProductServiceImpl;

public class AddCart implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// cart 테이블에 1건 추가 (회원아이디, 상품코드, 수량(=1))
		String id = request.getParameter("id");
		String itemCode = request.getParameter("itemCode");
		int qty = 1;

		ProductService service = new ProductServiceImpl();
		service.addCart(id, itemCode, qty);
		
		ProductService service2 = new ProductServiceImpl();
		int rCnt = service2.getCountCart(id);
		
		HttpSession session = request.getSession();
		session.setAttribute("cartCnt", rCnt);
		return "/productList.do";
	}

}
