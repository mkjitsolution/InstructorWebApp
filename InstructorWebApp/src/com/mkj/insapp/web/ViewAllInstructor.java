package com.mkj.insapp.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mkj.insapp.dao.InstructorDAO;
import com.mkj.insapp.dao.InstructorDAOImpl;
import com.mkj.insapp.dto.Instructor;

/**
 * Servlet implementation class ViewAllInstructor
 */
public class ViewAllInstructor extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			System.out.println("  --->> Servlet 1");
			InstructorDAO dao = new InstructorDAOImpl();
			Map<Integer, Instructor> map = dao.getAllInstructor();
			System.out.println("  --->> Servlet 2 "+map);
			
			Iterator<Integer> itr = map.keySet().iterator();
			
			while(itr.hasNext())
			{
				int code = itr.next();
				System.out.println(" Servlet 2 inside while "+code);
				
				Instructor instructor = map.get(code);
				
				out.print(instructor+"<br/>");
			}
			
			
		} catch (Exception e) {
			out.print(e);
		}
	
	}

	
}
