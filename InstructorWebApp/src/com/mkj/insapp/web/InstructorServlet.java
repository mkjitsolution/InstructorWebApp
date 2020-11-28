package com.mkj.insapp.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mkj.insapp.dao.InstructorDAO;
import com.mkj.insapp.dao.InstructorDAOImpl;
import com.mkj.insapp.dto.Instructor;

public class InstructorServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" By Mistake Direct Servlet Call");
		resp.sendRedirect("InstructorInputPage.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int instructorCode = Integer.parseInt(request.getParameter("instructorCode"));
		int instructorSalary = Integer.parseInt(request.getParameter("salary"));
		String name = request.getParameter("InstructorName");
		String year = request.getParameter("year"); // 2020-11-04
		String email = request.getParameter("email");
		String location = request.getParameter("location");

		boolean isValidEmail = email.endsWith("@gmail.com");
		if (isValidEmail) {
			// 1. create Instructor Object
			int jobyear = Integer.parseInt(year.substring(0, 4));
			System.out.println(" ===>> inside servlet if true job year "+jobyear);
			Instructor ins = new Instructor(instructorCode, name, instructorSalary, jobyear, email, location);
			System.out.println("--->> inside servlet if true instructor created " + ins);

			try {
				// Insert that object into Database
				InstructorDAO dao = new InstructorDAOImpl(); // Animal a = new Dog();
				boolean flag = dao.insertInstructor(ins);
				
				if(flag) response.getWriter().append(" Instructor "+name+" Inserted ");
				else response.getWriter().append(" Instructor Not Added Contact to Customer Care");
				
			} catch (Exception e) {
				response.getWriter().append(e.getMessage());
			}

		} else {
			// error msg throw
			System.out.println("--->> Validation Fail "+email);
			response.getWriter().append("Wrong Email Id");

			PrintWriter out = response.getWriter();
			out.print(" Wrong Email Id , Should ends with @gmail.com");

		}

		/*
		 * System.out.println(instructorCode); System.out.println(instructorSalary);
		 * System.out.println(year); System.out.println(name);
		 * System.out.println(email); System.out.println(location);
		 */

	}

}
