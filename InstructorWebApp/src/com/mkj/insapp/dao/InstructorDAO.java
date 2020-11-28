package com.mkj.insapp.dao;

import java.util.List;
import java.util.Map;

import com.mkj.insapp.dto.Instructor;

// created by System Arch. or Project Manager 
public interface InstructorDAO {

	public boolean insertInstructor(Instructor instructor)throws Exception;
	
	public Map<Integer,Instructor> getAllInstructor()throws Exception;
	
	public List<Instructor> getInstructorByLocation(String location);
	
	
	
}
