package com.yedam.product.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.product.service.ProductService;
import com.yedam.product.vo.CartVO;
import com.yedam.product.vo.ProductVO;

public class ProductServiceImpl extends DAO implements ProductService {

	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	// cart에 상품정보 추가하는 메소드
	public void addCart(String id, String itemCode, int qty) {
		sql = "insert into cart values(?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, itemCode);
			psmt.setInt(3, qty);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 추가.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	// 회원별 장바구니 상품 개수 표시
	public int getCountCart(String id) {
		sql = "select count(*) cnt from cart where user_id = ?";
		int rCnt = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				rCnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return rCnt;
	}
	
	// 회원별 장바구니 리스트
	@Override
	public List<CartVO> getListCart(String id) {
		sql = "select cart.user_id, cart.qty, p.*"
			+" from (select user_id, item_code, sum(item_qty) qty from cart group by user_id, item_code) cart, product p"
			+" where cart.item_code = p.item_code"
			+" and cart.user_id=?";
		List<CartVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				CartVO vo = new CartVO();
				vo.setItemCode(rs.getString("item_code"));
				vo.setItemName(rs.getString("item_name"));
				vo.setItemImage(rs.getString("item_image"));
				vo.setPrice(rs.getInt("price"));
				vo.setItemDesc(rs.getString("item_desc"));
				vo.setLikeIt(rs.getInt("like_it"));
				vo.setSale(rs.getString("sale"));
				vo.setSalePrice(rs.getInt("sale_price"));
				vo.setItemQty(rs.getInt("qty"));
				vo.setUserId(rs.getString("user_id"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	// 상품 전체조회
	@Override
	public List<ProductVO> selectProductList() {
		sql = "select * from product order by 1";
		List<ProductVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setItemCode(rs.getString("item_code"));
				vo.setItemName(rs.getString("item_name"));
				vo.setItemImage(rs.getString("item_image"));
				vo.setPrice(rs.getInt("price"));
				vo.setItemDesc(rs.getString("item_desc"));
				vo.setLikeIt(rs.getInt("like_it"));
				vo.setSale(rs.getString("sale"));
				vo.setSalePrice(rs.getInt("sale_price"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	// 한건 조회
	@Override
	public ProductVO selectProduct(ProductVO vo) {
		sql = "select * from product where item_code=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getItemCode());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setItemName(rs.getString("item_name"));
				vo.setItemImage(rs.getString("item_image"));
				vo.setPrice(rs.getInt("price"));
				vo.setItemDesc(rs.getString("item_desc"));
				vo.setLikeIt(rs.getInt("like_it"));
				vo.setSale(rs.getString("sale"));
				vo.setSalePrice(rs.getInt("sale_price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	// 한건 입력
	@Override
	public int insertProduct(ProductVO vo) {
		sql = "insert into product values(?,?,?,?,?,?,?,?)";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getItemCode());
			psmt.setString(2, vo.getItemName());
			psmt.setString(3, vo.getItemImage());
			psmt.setInt(4, vo.getPrice());
			psmt.setString(5, vo.getItemDesc());
			psmt.setInt(6, vo.getLikeIt());
			psmt.setString(7, vo.getSale());
			psmt.setInt(8, vo.getSalePrice());
			r = psmt.executeUpdate();
			System.out.println(r + "건 등록됨. ");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}

	// 한건 수정
	@Override
	public int updateProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 한건 삭제
	@Override
	public int deleteProduct(ProductVO vo) {
		String SQL = "delete from product where item_code=?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(SQL);
			psmt.setString(1, vo.getItemCode());
			r = psmt.executeUpdate();
			System.out.println(r + "건 삭제됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}

	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
