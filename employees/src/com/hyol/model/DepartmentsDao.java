package com.hyol.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.hyol.vo.Counting;

import db.DBHelper;

public class DepartmentsDao {
	
	// 일반 직원과 간부급 직원의 전체 수를 나타내는 메소드
	public List<Counting> getTotalEmloyees(){
		List<Counting> list = new ArrayList<Counting>();
		final String SQL = "select d.dept_name, count(d.dept_name) AS peoples\r\n" + 
				"From\r\n" + 
				"(SELECT *\r\n" + 
				"FROM dept_manager\r\n" + 
				"union all\r\n" + 
				"select *\r\n" + 
				"from dept_emp) dem inner join departments d\r\n" + 
				"on dem.dept_no = d.dept_no\r\n" + 
				"where dem.to_date = \"9999-01-01\"\r\n" + 
				"group by d.dept_name";
		Connection conn= null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(SQL);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Counting counting = new Counting();
				counting.setSort(rs.getString("d.dept_name"));
				counting.setPeoples(rs.getInt("peoples"));
				list.add(counting);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
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
