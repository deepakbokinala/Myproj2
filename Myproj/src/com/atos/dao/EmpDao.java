package com.atos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.atos.model.Employee;

@Repository
public class EmpDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplateObject;

	public int addEmployee(Employee employee) {
		String SQL = "INSERT INTO `Employee` VALUES (?,?,?)";
		return jdbcTemplateObject.update(SQL, (Math.random()*1000), employee.getName(),	employee.getPass());
	}

	public List<Employee> listEmployeess() {
		String sql = "select * from Employee";
		List<Employee> list = jdbcTemplateObject.query(sql, new EmployeeMapper());
		return list;
	}

	public Employee getEmployee(int empid) {

		String sql = "SELECT * FROM `Employee` WHERE `empid` = ?";
		Employee employee = jdbcTemplateObject.queryForObject(sql, new Object[] { empid },new EmployeeMapper());
		return employee;
	}
}
 class EmployeeMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int rows) throws SQLException {
		Employee emp = new Employee();
		emp.setName(rs.getString("empid"));
		emp.setName(rs.getString("empname"));
		emp.setPass(rs.getString("pass"));
		
		return emp;
	}

}