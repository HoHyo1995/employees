package com.hyol.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hyol.vo.Titles;

import db.DBHelper;

public class TitlesDao {
	
	// 직급별 직원 수
	public List<Titles> gettitlesCountList(){
		List<Titles> list = new ArrayList<Titles>();
		final String SQL = "SELECT title, count(title) peoples FROM titles where to_date = '9999-01-01' group by title order by title asc";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(SQL);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Titles titles = new Titles();
				titles.setTitle(rs.getString("title"));
				titles.setEmpCount(rs.getInt("peoples"));
				list.add(titles);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	// 총 행의 수를 구하는 메소드
	public int getTitlesCount() {
		int count = 0;
		final String SQL = "select count(*) from titles";
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
