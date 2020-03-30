package com.hyol.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hyol.vo.Departments;
import com.hyol.vo.Employees;
import com.hyol.vo.Salaries;

import db.DBHelper;

public class SalariesDao {
	
	// 현재 재직중인 사원의 평균 임금 상위 20명
	public List<Salaries> getSalariesEmp(){
		List<Salaries> list = new ArrayList<Salaries>();
		final String SQL = "select dme.emp_no, d.dept_name, avg(s.salary) average, e.hire_date\r\n" + 
				"from\r\n" + 
				"(select * from dept_manager\r\n" + 
				"	union all\r\n" + 
				"    select * from dept_emp) dme inner join departments d\r\n" + 
				"on dme.dept_no = d.dept_no\r\n" + 
				"inner join salaries s\r\n" + 
				"on dme.emp_no = s.emp_no\r\n" + 
				"inner join employees e\r\n" + 
				"on dme.emp_no = e.emp_no\r\n" + 
				"where dme.to_date = \"9999-01-01\"\r\n" + 
				"group by dme.emp_no\r\n" + 
				"order by average desc\r\n" + 
				"limit 20";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(SQL);
			rs = stmt.executeQuery();
			while(rs.next()){
				Salaries salaries = new Salaries();
				salaries.setEmpNo(rs.getInt("dme.emp_no"));
				salaries.setSalary(rs.getInt("average"));
				salaries.setDepartments(new Departments());
				salaries.getDepartments().setDeptName(rs.getString("d.dept_name"));
				salaries.setEmployees(new Employees());
				salaries.getEmployees().setHireDate(rs.getString("e.hire_date"));
				list.add(salaries);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	// 총 행의 수를 구하는 메소드
	public int getSalariesCount() {
		int count = 0;
		final String SQL = "select count(*) from salaries";
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
