package com.yedam.product.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DBCommand;
import com.yedam.product.service.ProductService;
import com.yedam.product.serviceImpl.ProductServiceImpl;
import com.yedam.product.vo.CartVO;

public class CartList implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("uid");
		
		ProductService service = new ProductServiceImpl();
		List<CartVO> list = service.getListCart(id);

		request.setAttribute("cartList", list);
		
		return "product/cartList.tiles";
	}

}
