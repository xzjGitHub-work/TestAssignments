package com.xuzhaoju.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.xuzhaoju.model.EmployeeModel;
import com.xuzhaoju.model.Student;

public class DateUtil {
	
	public static final Properties errors =new Properties();
	static {
		try {
			InputStream is=new FileInputStream("errors.config");
			errors.load(is);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//将日期转换为字符串
	public static LocalDate dateToLocalDate(Date date) {
		return LocalDate.ofEpochDay(date.getTime()/86400000).plusDays(1);
	}
	
//	public static Object[][] listToArray(List<Student> stus){
//		Object[][] data=new Object[stus.size()][];
//		int size=stus.size();
//		for(int i=0;i<size;i++) {
//			Student s = stus.get(i);
//			Object[] info =new Object[] {s.getId(),s.getName(),s.getScore(),s.getBirth(),s.getCity()};
//			data[i]=info;
//		}
//		return data;
//	}
	//stdent
	public static Object[][] listToArrayByStud(List<Student> stus){
		Object[][] data=new Object[stus.size()][];
		int size=stus.size();
		for(int i=0;i<size;i++) {
			Student s = stus.get(i);
			Object[] info =new Object[] {s.getId(),s.getName(),s.getScore(),s.getCity()};
			data[i]=info;
		}
		return data;
	}
	//部门
	public static Object[][] listToArrayByEmployee(List<EmployeeModel> stus){
		Object[][] data=new Object[stus.size()][];
		int size=stus.size();
		for(int i=0;i<size;i++) {
			EmployeeModel s = stus.get(i);
			Object[] info =new Object[] {s.getId(),s.getName(),s.getAge(),s.getGender(),s.getPostion(),s.getDepartment()};
			data[i]=info;
		}
		return data;
	}
}
