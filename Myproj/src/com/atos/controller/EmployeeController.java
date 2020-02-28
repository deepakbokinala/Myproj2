package com.atos.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.atos.model.Employee;
import com.atos.service.EmpService;

@Controller
public class EmployeeController {

@Autowired
EmpService employeeServRef;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@RequestParam("name") String name,@RequestParam("pass") String pass) {
		Employee emp=new Employee();
		emp.setName(name);
		emp.setPass(pass);
		employeeServRef.storeEmp(emp);
		return new ModelAndView("redirect:/add.jsp");
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ModelAndView listEmployees() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees", employeeServRef.listEmployeess());
		return new ModelAndView("emplist", model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addEmployee() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees", employeeServRef.listEmployeess());
		return new ModelAndView("add", model);
	}

	/*@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}*/
}

/*	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editEmployee(@ModelAttribute("command") EmployeeBean employeeBean, BindingResult result) {
		employeeServRef.deleteEmployee(employeeBean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", null);
		model.put("employees", employeeDaoRef.listEmployeess());
		return new ModelAndView("addEmployee", model);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@ModelAttribute("command") EmployeeBean employeeBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", employeeDaoRef.getEmployee(employeeBean.getId()));
		model.put("employees", employeeDaoRef.listEmployeess());
		return new ModelAndView("addEmployee", model);
	}
}*/