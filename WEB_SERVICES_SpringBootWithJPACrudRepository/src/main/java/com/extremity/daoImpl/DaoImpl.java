package com.extremity.daoImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.extremity.dao.DaoInterface;
import com.extremity.model.User;


@Transactional
@Repository
public class DaoImpl implements DaoInterface{

	
	
	@PersistenceContext
	private EntityManager entityManager;
		
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("in dao..");
		System.out.println(user.getUid()+"  "+user.getName()+"   "+user.getAddress()+"   "+user.getPassword()+"   "+user.getUname());
		
		entityManager.persist(user);	
		return user;
	}


public List logincheck(String username,String password){
		System.out.println(username+"uuuuuuuu");
	Query query=entityManager.createQuery("from LoginMaster where uname='"+username+"' and password='"+password+"'");
	List li=query.getResultList();
System.out.println("list==="+li);
		return li;
	}


	@Override
	public int loginCheck(User user) {
		
		int id=0;
		System.out.println("in dao........");
		System.out.println(user.getUname());
		System.out.println(user.getPassword());
		Query query=entityManager.createQuery("from User where uname='"+user.getUname()+"' and password='"+user.getPassword()+"'");
		System.out.println(query);
		
		List li=query.getResultList();
		Iterator itr=li.iterator();
		while(itr.hasNext())
		{
			id=1;
			User s1=(User)itr.next();
			System.out.println(s1.getName());
			System.out.println(s1.getPassword());
		}
			
		return id;
	}
	
	public int deleteUser(int id) {
		
		System.out.println("in delete dao...");
		Query query=entityManager.createQuery("delete from User user where user.uid="+id+"");
		int id1=query.executeUpdate();
		return id1;
	}

	@Override
	public List<User> displayAll(User user) {
		System.out.println("display-----------All");
		TypedQuery<User> query=entityManager.createQuery("select u from User u",User.class);
		List<User> userList=query.getResultList();
		return userList;
	}

	@Override
	public User editUser(User user) {
		System.out.println("in edit dao....");
		Query query=entityManager.createQuery("from User user where user.uid="+user.getUid()+"");
		List<User> list=query.getResultList();
		Iterator< User> itr=list.iterator();
		User u=null;
		while(itr.hasNext())
		{
			u=itr.next();
			System.out.println(u.getName());
			System.out.println(u.getUid());
		}
		return u;
	}
	@Override
	public int updateUser(User user) {
		System.out.println("in update dao...");
		Query query=entityManager.createQuery("Update User user set user.name='"+user.getName()+"',user.uname='"+user.getUname()+"',user.password='"+user.getPassword()+"',user.address='"+user.getAddress()+"' where user.uid="+user.getUid()+"");
		int id=query.executeUpdate();
		return id;
	}





	@Override
	public User findAllByUnameAndPassword(String uname, String password) {
		System.out.println("in find by username and password....");
		Query query=entityManager.createQuery("from User user where user.password="+password+" and user.uname='"+uname+"'");
		List<User> list=query.getResultList();
		Iterator< User> itr=list.iterator();
		User u=null;
		while(itr.hasNext())
		{
			u=itr.next();
			System.out.println(u.getName());
			System.out.println(u.getUid());
		}
		return u;

	}





	@Override
	public User findAllByUid(int uid) {
		System.out.println("in find all by id....");
		Query query=entityManager.createQuery("from User user where user.uid="+uid+"");
		List<User> list=query.getResultList();
		Iterator< User> itr=list.iterator();
		User u=null;
		while(itr.hasNext())
		{
			u=itr.next();
			System.out.println(u.getName());
			System.out.println(u.getUid());
		}
		return u;
	}





	@Override
	public User findAllByPassword(String pwd) {
		System.out.println("in find all by pass...");
		Query query=entityManager.createQuery("from User user where user.password="+pwd+"");
		List<User> list=query.getResultList();
		Iterator< User> itr=list.iterator();
		User u=null;
		while(itr.hasNext())
		{
			u=itr.next();
			System.out.println(u.getName());
			System.out.println(u.getUid());
		}
		return u;
	}





	@Override
	public User findOne(int uid) {
		System.out.println("in find all by id....");
		Query query=entityManager.createQuery("from User user where user.uid="+uid+"");
		List<User> list=query.getResultList();
		Iterator< User> itr=list.iterator();
		User u=null;
		while(itr.hasNext())
		{
			u=itr.next();
			System.out.println(u.getName());
			System.out.println(u.getUid());
		}
		return u;

	}





	@Override
	public ArrayList<User> findAll() {
		System.out.println("in find all by id....");
		Query query=entityManager.createQuery("from User user");
		ArrayList<User> list=(ArrayList<User>) query.getResultList();
		System.out.println("list-----"+list);
		return list;

	}





	
}
