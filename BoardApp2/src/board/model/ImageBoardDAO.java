package board.model;
/*
 * ImageBoard 테이블에 대한 CRUD만을 전담하는 DAO저의
 * */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBManager;

public class ImageBoardDAO {
	DBManager dbManager = new DBManager();// ImagesBoardDAO 인스턴스가 생성될때
											// DBManager의 인스턴스도 같이 생성
	// create(insert)

	public int insert(ImageBoard board) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result=0;
		String sql = "insert into imageboard(author,title,content,filename)";
		sql += " values(?,?,?,?)";

		con = dbManager.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getAuthor());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContent());
			pstmt.setString(4, board.getFilename());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.release(con, pstmt);
		}
		return result;
	}

	// selectAll()
	public ArrayList selectAll() {
		Connection con=null;
		con=dbManager.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql = "select * from imageboard";
		ArrayList<ImageBoard> boardList=new ArrayList<ImageBoard>();
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ImageBoard board=new ImageBoard();
				board.setBoard_id(rs.getInt("board_id"));
				board.setAuthor(rs.getString("author"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getString("regdate"));
				board.setHit(rs.getInt("hit"));
				board.setFilename(rs.getString("filename"));
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbManager.release(con, pstmt, rs);
		}
		return boardList;
	}

	// select
	public ImageBoard select(int board_id) {
		Connection con=null;
		con=dbManager.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ImageBoard board=null;
		String sql = "select * from imageboard where board_id=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, board_id);
			rs=pstmt.executeQuery();
			if(rs.next()) { //레코드가 있다면
				board=new ImageBoard();
				board.setBoard_id(rs.getInt("board_id"));
				board.setAuthor(rs.getString("author"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getString("regdate"));
				board.setHit(rs.getInt("hit"));
				board.setFilename(rs.getString("filename"));
			}
			pstmt=con.prepareStatement("update imageboard set hit=hit+1 where board_id=?");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbManager.release(con, pstmt, rs);
		}
		return board;
	}

	// update
	public int update(ImageBoard board) {
		Connection con=null;
		PreparedStatement pstmt=null;
		con=dbManager.getConnection();
		int result=0;
		String sql = "update imageboard set author=?,title=?,content=?,filename=? where board_id=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, board.getAuthor());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContent());
			pstmt.setString(4, board.getFilename());
			pstmt.setInt(5, board.getBoard_id());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbManager.release(con, pstmt);
		}
		return result;
	}

	// delete
	public int delete(int board_id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0;
		String sql = "delete from imageboard where board_id=?";
		con=dbManager.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, board_id);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbManager.release(con, pstmt);
		}
		return result;
	}
}
