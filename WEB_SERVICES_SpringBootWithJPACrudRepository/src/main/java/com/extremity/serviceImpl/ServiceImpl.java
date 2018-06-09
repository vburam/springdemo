package com.extremity.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.extremity.dao.DaoInterface;
import com.extremity.model.User;
import com.extremity.service.Iservice;

@Service
public class ServiceImpl implements Iservice{

	@Autowired
	private DaoInterface dao;

	@Override
	public void saveUser(User user) {
		
		dao.saveUser(user);
	}

	public List logincheck(String username,String password){
		List list=dao.logincheck(username,password);
		return list;
	}
	
	@Override
	public int loginCheck(User user) {
		
		/*String uname=user.getUname();
		String pass=user.getPassword();
		User u1=dao.findAllByPassword(pass);
		
		User u=dao.findAllByUnameAndPassword(uname,pass);
		if(u!=null)
		{
			System.out.println("in u not null ");
			return 1;
		}
		return 0;*/
		return dao.loginCheck(user);
		
	}

	@Override
	public int deleteUser(int id) {
		try{
		dao.deleteUser(id);
		return 1;
		}catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public ArrayList<User> displayAll(User user) {
		ArrayList<User> li=(ArrayList<User>)dao.findAll();
		return li;
	}

	@Override
	public User editUser(User user) {
		User u1=dao.findOne(user.getUid());
		//User u=dao.findAllByUid(user.getUid());
		return u1;
	}

	@Override
	public int updateUser(User user) {
		User u=dao.saveUser(user);
		return u.getUid();
	}
	
	
}
