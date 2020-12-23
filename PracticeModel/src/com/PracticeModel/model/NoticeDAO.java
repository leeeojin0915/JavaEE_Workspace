package com.PracticeModel.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.PracticeModel.domain.Notice;
import com.PracticeModel.mybatis.config.PracticeConfigManager;

public class NoticeDAO {
	PracticeConfigManager manager=PracticeConfigManager.getInstance();
	public int insert(Notice notice) {
		int result=0;
		SqlSession session=manager.getSqlSession();
		result=session.insert("Notice.insert", notice);
		session.commit();
		manager.close(session);
		return result;
	}
	public List selectAll() {
		List list=null;
		SqlSession session=manager.getSqlSession();
		list=session.selectList("Notice.selectAll");
		manager.close(session);
		return list;
	}
	
	public Notice select(int notice_id) {
		Notice notice=null;
		SqlSession session=manager.getSqlSession();
		notice=session.selectOne("Notice.select", notice_id);
		manager.close(session);
		return notice;
	}
	
	public int update(Notice notice) {
		int result=0;
		SqlSession session=manager.getSqlSession();
		result=session.update("Notice.update", notice);
		session.commit();
		manager.close(session);
		return result;
	}
	
	public int delete(int notice_id) {
		int result=0;
		SqlSession session=manager.getSqlSession();
		result=session.delete("Notice.delete",notice_id);
		session.commit();
		manager.close(session);
		return result;
	}
}
