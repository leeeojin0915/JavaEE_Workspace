/*게시판 목록 페이지*/
package board.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BoardList extends Page {
	JTable table;
	JScrollPane scroll;
	JButton bt;//글쓰기 폼 이동버튼
	public BoardList(BoardMain boardMain) {
		super(boardMain);
		//생성
		table =new JTable(20,5);
		scroll=new JScrollPane(table);
		bt=new JButton("글등록");
		
		//스타일
		scroll.setPreferredSize(new Dimension((int)this.getPreferredSize().getWidth(), 600));
		//this.setBackground(Color.YELLOW);
		//조립
		add(scroll);
		add(bt);
		
		bt.addActionListener((e)->{
			boardMain.showPage(Pages.valueOf("BoardWrite").ordinal());
		});
	}

}
