package com.hyol.model;

import java.sql.*;

import db.DBHelper;

public class DepartmentsDao {
	//생성자 생성
	public DepartmentsDao() {
	 
 }
	// 총 행의 수를 구하는 메소드
	public int getDepartmentsCount() {
		int count = 0;
		final String SQL = "select count(*) from departments";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs =null;
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(SQL);
			rs = stmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count(*)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		return count;
	}

}
