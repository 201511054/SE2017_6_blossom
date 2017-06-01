/**
 * @title : ModifyList.java
 * @author : Ȳ���� (201511077@sangmyung.kr)
 * @version : 1.0.0.
 * @since : 2017 - 05 - 31
 * @brief : ����Ʈ ���� �ڵ�
 * ------------------------------
 * @history
    author      version      date      brief
        Ȳ����      		1.0.0.      2017-05-30   �ʾ� �ۼ�
 * ------------------------------
 */

package se.smu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import se.smu.ListDB;

public class ModifyList {
	// �⺻ ���� ����
	Scanner in = new Scanner(System.in);
	static String ModiListName;
	static String ModiDeadLine;
	static String ModiFinishDay;
	static String ModiFinish;
	static String ModiImportance;
	static String ListName;
	static String DeadLine;
	static String FinishDay;
	static String Finish;
	static String Importance;

	// ������ List���� �Է�
	public ModifyList() {
		ModiListName = in.next();
		ModiDeadLine = in.next();
		ModiFinishDay = in.next();
		ModiFinish = in.next();
		ModiImportance = in.next();

	}

	public static void main(String[] args) {

		new ModifyList();

		try {
			// �⺻ ���� ����
			Connection conn = null;
			String sql;
			Statement st = null;
			PreparedStatement pst = null;
			ResultSet rs = null;

			// DB����
			Class.forName("com.mysql.jdbc.Driver"); // 1.0.3. �������� DB���� �õ�
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?=UTC&useSSL=false", "root", "0000");

			// ����� DB����, ����Ʈ���� �ҷ�����
			st = conn.createStatement();
			sql = "USE ListDB";
			st.execute(sql);
			rs = st.executeQuery("Select * from Listinfo");

			// �Է¹��� ListName�� ListDB�� ������ ��ġ�ϴ� ���� ������ ����
			while (rs.next()) {
				ListName = rs.getString("ListName");
				DeadLine = rs.getString("DeadLine");
				FinishDay = rs.getString("FinishDay");
				Finish = rs.getString("Finish");
				Importance = rs.getString("Importance");

				if ((ModiListName.equals(ListName)) || (ModiDeadLine.equals(DeadLine))
						|| (ModiFinishDay.equals(FinishDay)) || (ModiFinish.equals(Finish))
						|| (ModiImportance.equals(Importance))) {
					sql = "UPDATE Listinfo SET ListName=" + "\'"+ModiListName+"\'" + "where ListName=" + "\'" +ListName+ "\'";
					st.execute(sql);
					sql = "UPDATE Listinfo SET DeadLine=" + "\'"+ModiDeadLine+"\'" + "where DeadLine=" + "\'" +DeadLine+ "\'";
					st.execute(sql);
					sql = "UPDATE Listinfo SET FinishDay=" + "\'"+ModiFinishDay+"\'" + "where FinishDay=" + "\'" +FinishDay+ "\'";
					st.execute(sql);
					sql = "UPDATE Listinfo SET Finish=" + "\'"+ModiFinish+"\'" + "where Finish=" + "\'" +Finish+ "\'";
					st.execute(sql);
					sql = "UPDATE Listinfo SET Importance=" + "\'"+ModiImportance+"\'" + "where Importance=" + "\'" +Importance+ "\'";
					st.execute(sql);
				}
			}

			// ����â �ݱ�
			rs.close();
			st.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}