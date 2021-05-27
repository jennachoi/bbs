package com.yedam.product.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.DBCommand;
import com.yedam.product.service.ProductService;
import com.yedam.product.serviceImpl.ProductServiceImpl;
import com.yedam.product.vo.ProductVO;

public class ProductList implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String id = request.getParameter("memberId");
		
		ProductService service = new ProductServiceImpl();
		List<ProductVO> list = service.selectProductList();

		request.setAttribute("id", id);
		request.setAttribute("ProductList", list);
		
		return "product/productList.tiles";
	}

}
