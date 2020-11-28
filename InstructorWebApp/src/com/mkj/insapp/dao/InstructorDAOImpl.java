package com.mkj.insapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mkj.insapp.dto.Instructor;


// Developer code 
public class InstructorDAOImpl implements InstructorDAO{

	Connection con = DatabaseUtil.con;
	
	@Override
	public boolean insertInstructor(Instructor instructor)throws Exception {
	
		System.out.println(" ----Inside DAOImpl Data Inserted ... Starting ");
		
		PreparedStatement ps = con.prepareStatement("insert into Instructor values(?,?,?,?,?,?)");
		ps.setInt(1,instructor.getInstructorCode());
		ps.setString(2,instructor.getName());
		ps.setInt(3,instructor.getSalary());
		ps.setInt(4, instructor.getJobStartYear());
		ps.setString(5,instructor.getEmail());
		ps.setString(6,instructor.getLocation());
		
		int i = ps.executeUpdate(); // for DML Queries like Insert,Delete and Update Query
		System.out.println(" ----Inside DAOImpl Data Inserted ..."+i);
		if(i>0) return true;
		return false;
	}
	
	
	
	@Override
	public Map<Integer, Instructor> getAllInstructor()throws Exception {
		
		Map<Integer, Instructor> map = new HashMap<>();
		System.out.println("A ");
		PreparedStatement ps = con.prepareStatement("select * from Instructor");
		System.out.println("B");
		ResultSet rs = ps.executeQuery();
		System.out.println(" ---->> DAO Imp 1 "+rs);
		while(rs.next())
		{
			Instructor temp = new Instructor();
			
			temp.setInstructorCode(rs.getInt("instructorcode"));
			temp.setName(rs.getString("name"));
			temp.setSalary(rs.getInt("salary"));
			temp.setJobStartYear(rs.getInt("Jobstartyear"));
			temp.setEmail(rs.getString("email"));
			temp.setLocation(rs.getString("trainerlocation"));
			
			System.out.println(" ---->> DAO Imp 2 "+temp);
			map.put(temp.getInstructorCode(), temp);
		}
		return map;
	}

	@Override
	public List<Instructor> getInstructorByLocation(String location) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
