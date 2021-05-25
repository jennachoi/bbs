package com.yedam.bulletin.service;

import java.util.List;

import com.yedam.bulletin.vo.BulletinVO;

public interface BulletinService {
	// 전체조회, 한건조회, 입력, 수정, 삭제

	List<BulletinVO> selectBulletinList();
	BulletinVO selectBulletin();
	public int insertBulletin(BulletinVO vo);
	public int updateBulletin(BulletinVO vo);
	public int deleteBulletin(BulletinVO vo);
	
}
