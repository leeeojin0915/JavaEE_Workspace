/*
 * DAO��?
 * -Data Access Object�� �ǹ��ϴ� ���ø����̼��� ���� �о� ���
 * -Data Access�� �����ͺ��̽����� Create(=insert)Read(=select)UpdateDelete�۾��� �����Ѵٴ� �ǹ�
 * 
 * */
package board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DBManager;

public class NoticeDAO {
	DBManager dbManager=new DBManager();
	//���뼺 ������� ���� swing ���� ���� �ۼ�
	//insert�� �� �� �� �ϳ��� VO
	public int regist(Notice notice) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0;//�� ��� �� �� ����� ����
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
