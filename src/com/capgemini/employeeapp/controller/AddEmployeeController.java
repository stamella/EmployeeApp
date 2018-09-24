package com.capgemini.employeeapp.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.capgemini.employeeapp.dao.EmployeeDao;
import com.capgemini.employeeapp.dao.impl.EmployeeDaoImpl;
import com.capgemini.employeeapp.model.Employee;

@WebServlet("/addEmployee.do")
public class AddEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao employeeDao;
	private ServletContext context;

	public AddEmployeeController() {
		super();
		employeeDao = new EmployeeDaoImpl();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		int empId = Integer.parseInt(request.getParameter("empId"));
		String empName = request.getParameter("empName");
		int empSalary = Integer.parseInt(request.getParameter("empSalary"));
		String empDept = request.getParameter("empDept");

		Employee employee = new Employee(empId, empName, empSalary, empDept);
		context.setAttribute("employeeDao", employeeDao);

		RequestDispatcher dispatcher = null;

		if (employeeDao.addEmployee(employee)) {
			/*
			 * if you want success and error pages - create two jsp pages (write messages in
			 * h1 tag in the body) dispatcher=request.getRequestDispatcher("success.jsp");
			 * dispatcher.forward(request,response);
			 */
			response.sendRedirect("getAllEmployees.do");
		} else {
			dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}
	}

}