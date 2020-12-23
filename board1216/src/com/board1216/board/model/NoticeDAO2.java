package com.board1216.board.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.board1216.mybatis.config.MybatisConfigManager;

public class NoticeDAO2 {
	MybatisConfigManager manager=MybatisConfigManager.getInstance();
	
	public int insert(Notice2 notice) {
		int result=0;
		SqlSession session=manager.getSqlSession();
		result=session.insert("Notice2.insert",notice);
		session.commit();
		manager.close(session);
		return result;	
	}
	public List selectAll() {
		List list=null;
		SqlSession session=manager.getSqlSession();
		list=session.selectList("Notice2.selectAll");
		manager.close(session);
		return list;
	}
	public Notice2 select(int notice_id) {
		Notice2 notice=null;
		return notice;
	}
	public int update(Notice2 notice) {
		int result=0;
		return result;
	}
	public int delete(int notice_id) {
		int result=0;
		return result;
	}
}
