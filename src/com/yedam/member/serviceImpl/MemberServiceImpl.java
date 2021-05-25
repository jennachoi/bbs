package com.yedam.member.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.member.service.MemberService;
import com.yedam.member.vo.MemberVO;

public class MemberServiceImpl extends DAO implements MemberService {

	PreparedStatement psmt;
	ResultSet rs;

	// LOGIN시 ID, PWD 체크해주는 메소드
	public MemberVO loginCheck(MemberVO vo) {
		String SQL = "select * from member where id = ? and passwd = ?";
		MemberVO rvo = null;
		// boolean exist = false;
		try {
			psmt = conn.prepareStatement(SQL);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPwd());
			rs = psmt.executeQuery();
			if (rs.next()) {
//				exist = true;
				rvo = new MemberVO();
				rvo.setId(rs.getString("id"));
				rvo.setPwd(rs.getString("passwd"));
				rvo.setName(rs.getString("name"));
				rvo.setAddr(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return rvo;
	}

	// ID 중복체크 메소드 - 중복:true/사용가능:false
	public boolean idCheck(String id) {
		boolean exist = false;
		String SQL = "select id from member where id=?";
		try {
			psmt = conn.prepareStatement(SQL);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				exist = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return exist;
	}

	@Override
	public List<MemberVO> selectMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO selectMember() {
		// TODO Auto-generated method stub
		return null;
	}

	// 회원가입 
	@Override
	public int insertMember(MemberVO vo) {
		String sql = "insert into member(id, name, passwd, address) values(?,?,?,?)";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getPwd());
			psmt.setString(4, vo.getAddr());
			r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}

	@Override
	public int updateMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(MemberVO vo) {
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
