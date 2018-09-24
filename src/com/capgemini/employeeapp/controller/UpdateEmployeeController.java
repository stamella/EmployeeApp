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
import com.capgemini.employeeapp.model.Employee;

@WebServlet("/updateEmployee.do")
public class UpdateEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
	private EmployeeDao employeeDao;

	public UpdateEmployeeController() {
		super();

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		RequestDispatcher dispatcher = null;
		String id = request.getParameter("Id");
		employeeDao = (EmployeeDao) context.getAttribute("employeeDao");
		Employee employee = employeeDao.findEmployeeById(Integer.parseInt(id));
		context.setAttribute("employee", employee);

		dispatcher = request.getRequestDispatcher("updateEmployee.jsp");
		dispatcher.forward(request, response);

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
		
		if(employeeDao.updateEmployee(employee) != null)
		{
			response.sendRedirect("getAllEmployees.do");
		}
		else
		{
			dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}	
	}

}