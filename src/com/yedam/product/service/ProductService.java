package com.yedam.product.service;

import java.util.List;

import com.yedam.product.vo.CartVO;
import com.yedam.product.vo.ProductVO;

public interface ProductService {
	// 리스트, 한건조회, 입력, 수정, 삭제
	List<ProductVO> selectProductList();
	ProductVO selectProduct(ProductVO vo);
	int insertProduct(ProductVO vo);
	int updateProduct(ProductVO vo);
	int deleteProduct(ProductVO vo);
	public void addCart(String id, String itemCode, int qty);
	public int getCountCart(String id);
	public List<CartVO> getListCart(String id);
}
