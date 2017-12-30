package cn.et.food.service;

import cn.et.food.Tools.PageTools;
import cn.et.food.entity.Student;


public interface StudentService {

	public abstract PageTools queryStudent(String sname,Integer page,Integer rows);
	public void deleteStudent(Integer sid);
	public void updateStudent(Student stu);
	public void saveStudent(Student stu);
}