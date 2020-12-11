/*
 * DAO란?
 * -Data Access Object를 의미하는 어플리케이션의 설계 분야 용어
 * -Data Access란 데이터베이스와의 Create(=insert)Read(=select)UpdateDelete작업을 전담한다는 의미
 * 
 * */
package board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DBManager;

public class NoticeDAO {
	DBManager dbManager=new DBManager();
	//재사용성 고려하지 않은 swing 만의 로직 작성
	//insert는 글 한 건 하나의 VO
	public int regist(Notice notice) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0;//글 등록 후 그 결과값 보관
		con=dbManager.getConnection();
		String sql="insert into notice(author,title,content) values(?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, notice.getAuthor());
			pstmt.setString(2, notice.getTitle());
			pstmt.setString(3, notice.getContent());
			
			result=pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbManager.release(con, pstmt);
		}
		return result;
	}
}
