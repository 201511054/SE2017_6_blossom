/**
 * @title : ȸ���α���.java
 * @author : ���� (201511054@sangmyung.kr)
 * @version : 1.0.0.
 * @since : 2017 - 04 - 27
 * @brief : ȸ���α��� �������̽� ����
 * ------------------------------
 * @history : 
 	author		version		date
 	����			1.0.0.		2017-04-27
 * ------------------------------
 */

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ȸ���α��� extends JFrame {
	JButton jb1, jb2, jb3, jb4;
	JTextField jt;
	JPasswordField jpw;
	JTextArea jta;

	ȸ���α���() {
		setTitle("ȸ�� �α���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();

		jp1.setLocation(10, 120);
		jp1.setSize(300, 100);
		jp1.setLayout(new GridLayout(2,2));
		JButton jb1 = new JButton("�α���");
		JButton jb2 = new JButton("ȸ������");
		JButton jb3 = new JButton("�α��� ���� �ذ�");
		JButton jb4 = new JButton("Ż���� ���� ����");
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		jp1.add(jb4);
		add(jp1);

		jp2.setLocation(10, 10);
		jp2.setSize(90, 80);
		jp2.setLayout(new GridLayout(2, 1));
		jp2.add(new JLabel("���̵�"));
		jp2.add(new JLabel("��й�ȣ"));
		add(jp2);

		jp3.setLocation(70, 10);
		jp3.setSize(200, 90);
		jp3.setLayout(new GridLayout(2, 1));
		JTextField jt = new JTextField();
		JPasswordField jpw = new JPasswordField();
		jp3.add(jt);
		jp3.add(jpw);
		add(jp3);

		setSize(350, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ȸ���α���();
	}
}
