package com.extremity.bootcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.extremity.model.LoginMaster;
import com.extremity.model.User;
import com.extremity.service.Iservice;

@CrossOrigin
@RestController
public class SpringBootController {

	@Autowired
	private Iservice iservice;
	
	
	
	@RequestMapping("/")
	public String welcome()
	{
		System.out.println("index page...SERVER started");
		return "index";
	}
	
	
	@RequestMapping(value="/add" ,method=RequestMethod.POST,produces="application/json")
	public ResponseEntity<User> add( @RequestBody User user, BindingResult br)
	{	System.out.println("in add user...");
		System.out.println(user.getName());
		System.out.println(user.getAddress());
		System.out.println(user.getUid());
		System.out.println(user.getUname());
		iservice.saveUser(user);
		System.out.println("user is added....");
		
		return new ResponseEntity(HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value="/logincheck",method=RequestMethod.POST,produces="application/json")
	public ResponseEntity logincheck(@RequestBody LoginMaster login,HttpServletRequest request){
		
		
		System.out.println("sssssss");
		
		List list=iservice.logincheck(login.getUname(),login.getPassword());
		System.out.println(login.getUname()+"  "+login.getPassword());
		LoginMaster login1=(LoginMaster) list.get(0);
		System.out.println(login1.getUname());
		System.out.println(login1.getPassword());
		
		if(!list.isEmpty()){
			return new ResponseEntity(login1,HttpStatus.OK);
		}
		else{
			LoginMaster login2=new LoginMaster();
			login2.setUname("wrong");
			login2.setPassword("wrong");
			return new ResponseEntity(login2,HttpStatus.OK);
		}
		
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ResponseEntity loginUser()
	{
		
		System.out.println("in controller value of ");
		User user=new User();
			System.out.println("in if.................");
			List<User> listUser=iservice.displayAll(user);
			
			
			
			System.out.println("DATA====="+listUser);
			return new ResponseEntity(listUser,HttpStatus.CREATED);
		}
	
	
	
	
	@RequestMapping(value="/delete/{id}")
	public ResponseEntity deleteUser(@PathVariable("id") int id )
	{
		System.out.println("in delete......");
	
		int id1=iservice.deleteUser(id);
		User user=new User();
		List<User> listUser=iservice.displayAll(user);
		if(id1>0)
		{
			return new ResponseEntity(listUser,HttpStatus.OK);
		}
		return new ResponseEntity(listUser,HttpStatus.OK);
	}
		
	@RequestMapping(value="/update" , method=RequestMethod.PUT)
	public ResponseEntity updateUser(@RequestBody User user)
	{
		int id=iservice.updateUser(user);
		List<User> listUser=iservice.displayAll(user);
		if(id>0)
		{
			return new ResponseEntity(listUser,HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}
