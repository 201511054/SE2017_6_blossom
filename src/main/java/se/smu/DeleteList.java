/**
 * @title : DeleteList.java
 * @author : Ȳ���� (201511077@sangmyung.kr)
 * @version : 1.0.0.
 * @since : 2017 - 05 - 30
 * @brief : ����Ʈ ���� �ڵ�
 * ------------------------------
 * @history
    author      version      date      brief
        Ȳ����  	    1.0.0.      2017-05-30   �ʾ� �ۼ�
        Ȳ����       		1.1.0.      2017-05-31   ��� �ϼ� 
 * ------------------------------
 */

package se.smu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import se.smu.ListDB;

public class DeleteList {
   // �⺻ ���� ����
      Scanner in = new Scanner(System.in);
      static String DeleteListName;
      static String ListName;

      //
      public DeleteList() {
         DeleteListName = in.next();
      }

      public static void main(String[] args) {
         
         new DeleteList();
         
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
            rs = st.executeQuery("Select ListName from Listinfo");
            
            // �Է¹��� ListName�� ListDB�� ������ ��ġ�ϴ� ���� ������ ����
            while (rs.next()) {
               ListName=rs.getString("ListName");
               if (ListName.equals(DeleteListName))
               {
                  sql="DELETE FROM Listinfo where ListName="+"\'"+DeleteListName+"\'";
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