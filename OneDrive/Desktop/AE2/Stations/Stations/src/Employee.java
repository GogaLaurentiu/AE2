
public class Employee {
	private int id;
	private String empname;
	private String password;
	private String role;
	
	public Employee(){}
	
	
	public Employee(int id, String empname, String password, String role) {
		super();
		this.id = id;
		this.empname = empname;
		this.password = password;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", empname=" + empname + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
