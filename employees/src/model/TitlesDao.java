package model;

import java.sql.Connection;
import java.util.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBHelper;

public class TitlesDao {
	// 생성자 생성
	public TitlesDao() {
		
	}
	//중복을 제거한 titles의 리스트
	public List<String> selectTitlesListDistinct() {
		// 리턴값인 List<String>타입을 선언한다.
		List<String> list = new ArrayList<String>();
		// 마리아 DB로딩에 필요한 변수를 선언하고 초기화한다
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// 쿼리문을 String타입으로 변수 선언한다
		String sql = "select distinct title from titles";
		// getConnection메소드를 불러온후 마리아DB에값을 저장한다.
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("title"));
			}
		} catch(Exception e) {
			
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	
		// 테이블의 행의 수 구하는 메소드
		public int selectTitlesCount() {
			int count = 0;
			final String sql = "select count(*) from titles";
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			try {
				conn = DBHelper.getConnection();
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				if(rs.next()) {
					count = rs.getInt("count(*)");
					
				}
			// Exception 예외의 최상위 클래스
			}catch(Exception e) { // e라는 변수가  2개인 이유는 자바의 변수 생명주기는 {}
				e.printStackTrace();
			} finally {
				DBHelper.close(rs, stmt, conn);
			}
			return count;
		}
}
