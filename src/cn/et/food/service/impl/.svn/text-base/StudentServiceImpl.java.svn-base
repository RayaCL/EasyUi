package cn.et.food.service.impl;


import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.food.Tools.PageTools;
import cn.et.food.dao.StudentMapper;
import cn.et.food.entity.Student;
import cn.et.food.entity.StudentExample;
import cn.et.food.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentMapper sm;
	/* (non-Javadoc)
	 * @see cn.et.food.service.impl.StudentService#queryStudent(java.lang.String)
	 */
	public PageTools queryStudent(String sname,Integer page,Integer rows){
		if(sname==null){
			sname="";
		}
		StudentExample se=new StudentExample();
		se.createCriteria().andSnameLike("%"+sname+"%");
		int total=queryStudentCount(se);
		//发起sql语句查询总记录数
		
		PageTools p=new PageTools(page, rows, total);
		RowBounds rb=new RowBounds(p.getStartIndex()-1, rows);
		List<Student> studentList=sm.selectByExampleWithRowbounds(se, rb);
		p.setRows(studentList);
		return p;
	}
	public int queryStudentCount(StudentExample se){
		int total=(int)sm.countByExample(se);
		return total;
	}
	
	public void deleteStudent(Integer sid){
		sm.deleteByPrimaryKey(sid);
	}
	public void updateStudent(Student stu){
		sm.updateByPrimaryKey(stu);
	}
	public void saveStudent(Student stu){
		sm.insertSelective(stu);
	}
}
