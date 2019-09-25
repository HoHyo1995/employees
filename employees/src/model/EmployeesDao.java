package model;
import java.util.*;

import db.DBHelper;
import vo.*;
import java.sql.*;

public class EmployeesDao {
	// 생성자생성
	public EmployeesDao(){
		
	}
	// 마지막페이지를 구하는 메소드
	public int selectLastPage(int rowPerPage) {
		// rowPerPage가 넘어오는지 확인한다.
		System.out.println("rowPerPage = "+ rowPerPage);
		// 마지막페이지를 담을 변수 생성 및 초기화 (if안에서 생성하면 지역변수가 되기때문에 if 밖에서 생성해서 리턴해준다)
		int lastPage = 0;
		// this.selectEmployeesCount()메소드가 총행을 구하는 메소드이므로 이용해서 마지막페이지를 구한다.
		int totalRow = this.selectEmployeesCount();
		// if문을 사용해서 행의 수에 따라 달라지는 마지막페이지를 구한다
		if(totalRow % rowPerPage != 0) {
			lastPage = (totalRow / rowPerPage)+1;
		} else {
			lastPage = totalRow / rowPerPage;
		}
		
		return lastPage;
	}
	// 10개씩 페이징하여 출력한 메소드
	public List<Employees> getEmployeesListByPage(int currentPage, int rowPerPage) {
		// 인수로 넘어온값이 맞게 넘어왔는지 확인한다
		System.out.println("currentPage = "+currentPage+"rowPerPage = "+rowPerPage);
		// 리턴값에 맞는 변수 생성
		List<Employees> list = new ArrayList<Employees>();
		// 마리아DB로딩에 필요한 변수들을 선언하고 초기화한다.
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// 쿼리문을 String타입에 복사한다
		// limit은 0부터시작한다
		final String sql = "select emp_no, birth_date, first_name, last_name, gender, hire_date from employees limit ?, ?";
		
		try {
			// 마리아 DB 로딩 및 연결
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			// 시작값을 currentPage로 하면 계속 시작페이지가 똑같아서 같은값이 나오게 되어서 startRow라는 변수를 생성했다.
			int startRow = (currentPage-1)*rowPerPage;
			stmt.setInt(1, startRow);
			stmt.setInt(2, rowPerPage);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Employees employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setBirthDate(rs.getString("birth_date"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setGender(rs.getString("gender"));
				employees.setHireDate(rs.getString("hire_date"));
				list.add(employees);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	// begin이랑 end값을 받은 후 그 사이값을 출력하는 메소드
	public List<Employees> selectEmployeesListBetween(int begin, int end){
		// 동적배열 사용을위해 생성
		List<Employees> list = new ArrayList<Employees>();
		// 마리아DB로딩에 사용할 변수 선언 및 초기화
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// 쿼리문 between사용하여서 사이값을 구하기 때문에 스트링타입으로 선언
		final String sql = "select emp_no, birth_date, first_name, last_name, gender, hire_date from employees where emp_no between ? and ?";
		// try{}catch{}를 사용하여 rs에서 값을 가져와서 list에추가한다
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, begin);
			stmt.setInt(2, end);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Employees employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setBirthDate(rs.getString("birth_date"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setGender(rs.getString("gender"));
				employees.setHireDate(rs.getString("hire_date"));
				list.add(employees);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	// 성별별로 사원수를 나타내는 메소드
	public List<Map<String, Object>> selectEmployeesCountGroupByGender() {
		// 동적배열 생성
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// 마리아 DB로딩 변수 선언 및 초기화
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// STring타입의 쿼리문 생성
		String sql = "select gender, count(gender) from employees group by gender";
		// 마리아DB에서 데이터를 불러와 변수에 저장
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("gen", rs.getString("gender"));
				map.put("genCnt", rs.getString("count(gender)"));
				list.add(map);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	// 전체 리스트를 출력하는 메소드인데 오름차순 내림차순이 있음 50개씩 보여주는 메소드
	public List<Employees> selectEmployeesOrderBy(String order) {
		System.out.println("EmployeesDao.java에 selectEMployeesList에 인수로 사용된 order의 값은"+order);
		//Employees타입의 변수를 여러개 받기 위해  배열 생성
		List<Employees> list = new ArrayList<Employees>();
		// 메소드 로딩에 쓸 변수 생성 및 초기화
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// 쿼리문이 오름차순이냐 내림차순이냐에 따라 바뀌므로 동적쿼리를 사용하엿따.
		String sql = null;
		if(order.equals("asc")) {
			sql = "select emp_no, birth_date, first_name, last_name, gender, hire_date from employees order by first_name asc limit 50";
		} else if(order.equals("desc")) {
			sql = "select emp_no, birth_date, first_name, last_name, gender, hire_date from employees order by first_name desc limit 50";
		}
		
		// 예외구문을 사용하여 DB에 값을 set메소드를 사용하여 복사
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Employees employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setBirthDate(rs.getString("birth_date"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setGender(rs.getString("gender"));
				employees.setHireDate(rs.getString("hire_date"));
				list.add(employees);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	
	// 전체 리스트를 출력하는 메소드
	public List<Employees> selectEmployeesList(int limit) {
		System.out.println("EmployeesDao.java에 selectEMployeesList에 인수로 사용된 limit의 값은"+limit);
		//Employees타입의 변수를 여러개 받기 위해  배열 생성
		List<Employees> list = new ArrayList<Employees>();
		// 메소드 로딩에 쓸 변수 생성 및 초기화
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// employees타입들을 전원 출력할 쿼리문 사용 + 너무많아서 몇개씩 출력할껀지 제한하기위해 limit사용
		final String sql = "select emp_no, birth_date, first_name, last_name, gender, hire_date from employees limit ?";
		// 예외구문을 사용하여 DB에 값을 set메소드를 사용하여 복사
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, limit);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Employees employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setBirthDate(rs.getString("birth_date"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setGender(rs.getString("gender"));
				employees.setHireDate(rs.getString("hire_date"));
				list.add(employees);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	// index에 사용할 employeesDB의 사원 수를 구하는 메소드
	public int selectEmployeesCount() {
		int count = 0;
		final String sql = "select count(*) from employees";
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
