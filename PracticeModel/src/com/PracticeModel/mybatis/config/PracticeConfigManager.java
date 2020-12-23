package com.PracticeModel.mybatis.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class PracticeConfigManager {
	 InputStream inputStream;
	 SqlSessionFactory sqlSessionFactory;
	 private static PracticeConfigManager instance;
	 
	 private PracticeConfigManager() {
		 String resource = "com/PracticeModel/mybatis/config/config.xml";
		 try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 
	 public static PracticeConfigManager getInstance() {
		 if(instance==null) {
			 instance=new PracticeConfigManager();
		 }
		return instance;
	}
	 
	 public SqlSession getSqlSession() {
		 SqlSession sqlSession=null;
		 sqlSession=sqlSessionFactory.openSession();
		 return sqlSession;
	 }
	 
	 public void close(SqlSession sqlSession) {
		 if(sqlSession!=null) {
			 sqlSession.close();
		 }
	 }
}
