package vo;

public class DeptEmp {
	// 필드 생성 (캡슐화)
	private Employees employees;
	private Departments departments;
	private String fromDate;
	private String toDate;
	// 생성자 생성
	public DeptEmp() {
		
	}
	// setter, getter메소드 생성
	public Employees getEmployees() {
		return employees;
	}
	public void setEmployees(Employees employees) {
		this.employees = employees;
	}
	public Departments getDepartments() {
		return departments;
	}
	public void setDepartments(Departments departments) {
		this.departments = departments;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
}
