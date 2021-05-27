package com.yedam.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.product.serviceImpl.ProductServiceImpl;

public class IndexPage implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		request.setAttribute("id", id);
		return "main/main.tiles";
	}

}
