package com.hyol.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBHelper;

public class EmployeesDao {
	// 생성자생성
	public EmployeesDao(){	
	
	}
	// 총 행의 수를 구하는 메소드
	public int getEmployeesCount() {
		int count = 0;
		final String SQL = "select count(*) from employees";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(SQL);
			rs = stmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count(*)");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return count;
	}
}
