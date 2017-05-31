/**
 * @title : CourDB.java
 * @author : 황은선 (201511077@sangmyung.kr)
 * @version : 1.0.3.
 * @since : 2017 - 05 - 29
 * @brief : 과목정보 DB
 * ------------------------------
 * @history
 	author		version		date		brief
 	황은선		1.0.0.		2017-05-29	초안 작성
 	황은선	    1.0.1.		2017-05-29	주석 수정 및 코드 공백 정리
 	임현			1.0.2.		2017-05-30	history 주석 수정
 	임현			1.0.3.		2017-05-31	DB 연동
 * ------------------------------
 */

package se.smu;

import java.sql.*;
import java.util.Scanner;
import se.smu.InsertCourInfo;

public class CourDB {
	void CourTable(String CourName, String CourProf, String CourDay, String CourTime, String CourYear,
			String CourSeme) {
		try {
			// 기본 변수 선언
			Scanner in = new Scanner(System.in);
			Connection conn = null;
			String sql;
			Statement st = null;
			PreparedStatement pst = null;

			// DB연동
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?serverTimezone=UTC&useSSL=false", "root", "0000"); // JDBC
																													// 연결

			// DB생성, TABLE생성
			st = conn.createStatement();
			sql = "CREATE DATABASE CourDB";
			st.execute(sql);
			sql = "USE CourDB";
			st.execute(sql);
			sql = "CREATE TABLE CourInfo (CourName char(25), CourProf char(20), CourDay char(10), CourTime char(20), CourYear char(20), CourSeme char(10))";
			st.execute(sql);

			// 입력받은 과목정보를 DB에 삽입
			sql = "INSERT INTO CourInfo(CourName,CourProf,CourDay,CourTime,CourYear,CourSeme) values(?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst
					.executeQuery("select CourName, CourProf, CourDay, CourTime, CourYear, CourSeme from CourInfo");

			pst.setString(1, CourName);
			pst.setString(2, CourProf);
			pst.setString(3, CourDay);
			pst.setString(4, CourTime);
			pst.setString(5, CourYear);
			pst.setString(6, CourSeme);
			pst.executeUpdate();

			// 실행창 닫기
			rs.close();
			pst.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new CourDB();

	}
}