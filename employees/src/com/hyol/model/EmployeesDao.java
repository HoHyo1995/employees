package com.hyol.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hyol.vo.Departments;
import com.hyol.vo.Employees;
import com.hyol.vo.Titles;

import db.DBHelper;

public class EmployeesDao {
	
	// 현재 근무중인 사원 수 조회 메소드
	public int getEmployeesCountWhere(int rowPerPage) {
		System.out.println("--getEmployeesCountWhere--");
		int count = 0;
		int lastPage = 0;
		final String SQL = "select count(*)\r\n" + 
				"from employees e inner join (select * from dept_emp where to_date = '9999-01-01') de\r\n" + 
				"on e.emp_no = de.emp_no\r\n" + 
				"inner join departments d\r\n" + 
				"on de.dept_no = d.dept_no\r\n" + 
				"inner join (select emp_no, title from titles where to_date = '9999-01-01') t\r\n" + 
				"on e.emp_no = t.emp_no";
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
			if(count%rowPerPage == 0 ) {
				lastPage = count/rowPerPage;
			}else {
				lastPage = (count/rowPerPage)+1;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return lastPage;
	}
	
	// 현재 근무중인 사원 조회 메소드
	public List<Employees> getEmployees(int currentPage, int rowPerPage) {
		System.out.println("현재페이지 = "+currentPage +"페이지당 행의 수 = "+rowPerPage);
		List<Employees> list = new ArrayList<Employees>();
		final String SQL = "select e.emp_no, concat(e.first_name,\" \",e.last_name) name, d.dept_name, t.title, e.gender, e.hire_date\r\n" + 
				"from employees e inner join (select * from dept_emp where to_date = '9999-01-01') de\r\n" + 
				"on e.emp_no = de.emp_no\r\n" + 
				"inner join departments d\r\n" + 
				"on de.dept_no = d.dept_no\r\n" + 
				"inner join (select emp_no, title from titles where to_date = '9999-01-01') t\r\n" + 
				"on e.emp_no = t.emp_no\r\n" + 
				"order by e.emp_no asc\r\n" + 
				"limit ?, ?";
		int beginRow = (currentPage-1)*rowPerPage;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, beginRow);
			stmt.setInt(2, rowPerPage);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Employees employees = new Employees();
				employees.setEmpNo(rs.getInt("e.emp_no"));
				employees.setFirstName(rs.getString("name"));
				employees.setDepartments(new Departments());
				employees.getDepartments().setDeptName(rs.getString("d.dept_name"));
				employees.setTitles(new Titles());
				employees.getTitles().setTitle(rs.getString("t.title"));
				employees.setGender(rs.getString("e.gender"));
				employees.setHireDate(rs.getString("e.hire_date"));
				list.add(employees);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
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
	// 로그인 정보가 맞는지 확인하는 메소드
	public int compareEmployees(Employees employees) {
		int empNo = 0;
		final String SQL = "SELECT emp_no FROM employees where emp_no = ? and last_name = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, employees.getEmpNo());
			stmt.setString(2, employees.getLastName());
			rs = stmt.executeQuery();
			if(rs.next()) {
				empNo = rs.getInt("emp_no");
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		return empNo;
	}
}
