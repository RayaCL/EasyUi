package cn.et.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.et.food.Tools.EPageTools;
import cn.et.food.entity.Emp;
import cn.et.food.entity.Result;
import cn.et.food.entity.TreeNode;
import cn.et.food.service.DeptService;

@Controller
public class DeptController {
	@Autowired
	DeptService service;
	@ResponseBody
	@RequestMapping("/queryDate")
	public List<TreeNode> queryDept(Integer id){
		if(id==null){
			id=0;
		}
		return service.queryTreeNode(id);
	}
	
	@ResponseBody
	@RequestMapping("/queryEmp")
	public EPageTools queryEmp(Integer id,String name,Integer page,Integer rows){
		return service.queryEmp(id,name,page,rows);
	}
	@ResponseBody
	@RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)
	public Result deleteEmp(@PathVariable String id){
		String[] sbs=id.split(",");
		Result r=new Result();
		r.setCode(1);
		try {
			for(String s:sbs){
				service.deleteemp(Integer.parseInt(s));
			}
			
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e);
		}
		return r;
	}
	@ResponseBody
	@RequestMapping(value="/emp/{id}",method=RequestMethod.PUT)
	public Result updateStudent(@PathVariable Integer id,Emp emp){
		emp.setId(id);
		Result r=new Result();
		r.setCode(1);
		try {
			service.updateEmp(emp);
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e);
		}
		return r;
	}
	
	@ResponseBody
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public Result insertStudent(Emp emp){
		Result r=new Result();
		r.setCode(1);
		try {
			service.saveEmp(emp);
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e);
		}
		return r;
	}
}
