package com.yedam.bulletin.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.bulletin.service.BulletinService;
import com.yedam.bulletin.vo.BulletinVO;
import com.yedam.common.DAO;

public class BulletinServiceImpl extends DAO implements BulletinService{
	
	PreparedStatement psmt;
	ResultSet rs;
	
	// 페이징 기능
	public List<BulletinVO> bulletinListPaging(int page){
		String SQL = "select b.*\r\n"
				+ "from (select rownum rn,a.*\r\n"
				+ "      from(select * from bulletin order by id)a\r\n"
				+ "      )b\r\n"
				+ "where b.rn between ? and ?";
		List<BulletinVO> list = new ArrayList<>();
		int firstCnt = 0, lastCnt = 0;		
		firstCnt = (page - 1) * 10 + 1;		// 1 , 11
		lastCnt = (page * 10);			    // 10, 20
		
		try {
			psmt = conn.prepareStatement(SQL);
			psmt.setInt(1, firstCnt);
			psmt.setInt(2, lastCnt);
			rs = psmt.executeQuery();
			while(rs.next()) {
				BulletinVO vo = new BulletinVO();
				vo.setId(rs.getInt("id"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setRegDate(rs.getDate("reg_date"));
				vo.setHit(rs.getInt("hit"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	//전체조회
	@Override
	public List<BulletinVO> selectBulletinList() {
		List<BulletinVO> list = new ArrayList<>();
		String SQL = "select * from bulletin order by 1";
		try {
			psmt = conn.prepareStatement(SQL);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BulletinVO vo = new BulletinVO();
				vo.setId(rs.getInt("id"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setRegDate(rs.getDate("reg_date"));
				vo.setHit(rs.getInt("hit"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	
	// 최신글 조회
	@Override
	public List<BulletinVO> selectNewBulletinList() {
		List<BulletinVO> list = new ArrayList<>();
		String SQL = "select id, title, reg_date from ( SELECT * from bulletin order by id desc) where rownum <= 5";
		try {
			psmt = conn.prepareStatement(SQL);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BulletinVO vo = new BulletinVO();
				vo.setId(rs.getInt("id"));
				vo.setTitle(rs.getString("title"));
				vo.setRegDate(rs.getDate("reg_date"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	
	@Override
	public BulletinVO selectBulletin(BulletinVO vo) {
		String SQL = "select * from Bulletin where id=?";
		try {
			psmt = conn.prepareStatement(SQL);
			psmt.setInt(1, vo.getId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				hitCount(vo.getId());		// 1건 조회할 때 마다 조회수 업데이트

				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setContent(rs.getString("content"));
				vo.setRegDate(rs.getDate("reg_date"));
				vo.setHit(rs.getInt("hit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int insertBulletin(BulletinVO vo) {
		String sql = "insert into bulletin(id, title, writer, content, reg_date, hit) values(bulletin_seq.nextval,?,?,?,sysdate,0)";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getWriter());
			psmt.setString(3, vo.getContent());
			r = psmt.executeUpdate();
			System.out.println(r + "건 등록됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}

	@Override
	public int updateBulletin(BulletinVO vo) {
		String SQL = "update Bulletin set title=?, content=? where id=?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(SQL);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setInt(3, vo.getId());
			r = psmt.executeUpdate();
			System.out.println(r + "건 수정됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}

	@Override
	public int deleteBulletin(BulletinVO vo) {
		String SQL = "delete from Bulletin where id=?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(SQL);
			psmt.setInt(1, vo.getId());
			r = psmt.executeUpdate();
			System.out.println(r + "건 삭제됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}

	
	public void hitCount(int id) {
		String SQL = "update bulletin set hit = hit+1 where id=?";
		try {
			psmt = conn.prepareCall(SQL);
			psmt.setInt(1, id);
			psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
