package com.yedam.notice.service;

import java.util.List;

import com.yedam.notice.vo.NoticeVO;

public interface NoticeService {
	// 전체리스트, 한건조회, 입력, 수정, 삭제
	
	List<NoticeVO> selectNoticeList();
	List<NoticeVO> selectNewNoticeList();
	NoticeVO selectNotice(NoticeVO vo);
	int insertNotice(NoticeVO vo);
	int updateNotice(NoticeVO vo);
	int deleteNotice(NoticeVO vo);
	
}
