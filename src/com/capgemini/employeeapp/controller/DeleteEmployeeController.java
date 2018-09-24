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

@WebServlet("/deleteEmployee.do")
public class DeleteEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
	private EmployeeDao employeeDao;
	
    public DeleteEmployeeController() {
        super();
       
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	context = config.getServletContext();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		RequestDispatcher dispatcher = null;
		 
		String id=request.getParameter("Id");
		
		employeeDao = (EmployeeDao) context.getAttribute("employeeDao");
		System.out.println(id);
		 
		if (employeeDao.deleteEmployee(Integer.parseInt(id))){
			response.sendRedirect("getAllEmployees.do");			
		} else {
			dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}
		
	}
}