package com.yedam.bulletin.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yedam.bulletin.service.BulletinService;
import com.yedam.bulletin.vo.BulletinVO;
import com.yedam.common.DAO;

public class BulletinServiceImpl extends DAO implements BulletinService{
	
	PreparedStatement psmt;
	ResultSet rs;
	
	@Override
	public List<BulletinVO> selectBulletinList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BulletinVO selectBulletin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertBulletin(BulletinVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBulletin(BulletinVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBulletin(BulletinVO vo) {
		// TODO Auto-generated method stub
		return 0;
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
