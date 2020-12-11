package board.gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BoardContent extends Page {
	JTextField t_title, t_author;
	JTextArea area;
	JScrollPane scroll;
	JButton bt_list, bt_edit, bt_del;

	public BoardContent(BoardMain boardMain) {
		super(boardMain);
		// ����
		t_author = new JTextField();
		t_title = new JTextField();
		area = new JTextArea();
		scroll = new JScrollPane(area);
		bt_list = new JButton("���");
		bt_edit = new JButton("����");
		bt_del = new JButton("����");
		// ��Ÿ��
		t_author.setPreferredSize(new Dimension((int)this.getPreferredSize().getWidth() - 10, 25));
		t_title.setPreferredSize(new Dimension((int)this.getPreferredSize().getWidth() - 10, 25));
		scroll.setPreferredSize(new Dimension((int)this.getPreferredSize().getWidth() - 10, 550));
		// ����
		add(t_author);
		add(t_title);
		add(scroll);
		add(bt_list);
		add(bt_edit);
		add(bt_del);
	}

}
