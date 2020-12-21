package com.xuzhaoju.service;

import java.sql.SQLException;
import java.util.List;

import com.xuzhaoju.dao.StudentDao;
import com.xuzhaoju.model.Student;

public class StudentService {
	
	public List<Student> queryAll(){
		try {
			return new StudentDao().queryAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int update(Student s) {
		StudentDao sDao =new StudentDao();
		try {
			sDao.update(s);
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 1001;
		}
	}
	
	public int delete(int id) {
		StudentDao sDao =new StudentDao();
		try {
			sDao.detele(id);
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 1001;
		}
	}
	
	public int insert(Student s) {
		StudentDao sDao =new StudentDao();
		try {
			sDao.add(s);
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 1001;
		}
	}
	
}
