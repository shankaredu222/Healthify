package com.angular.ojt.AngularBackend.daoIMPL;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.angular.ojt.AngularBackend.dao.AuthDao;
import com.angular.ojt.AngularBackend.entity.Employee;

@Repository
public class AuthDaoImpl implements AuthDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public Employee getUserByUsername(String username) {
		
		Employee emp =null;
		Session session =null;
		try {
		session=sf.openSession();
		Criteria criteria =session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("username", username));
		 emp = (Employee) criteria.uniqueResult();
		 
		 if(emp!=null) {
			 return emp;
		 }else {
			 return null;
		 }
		 
		} catch (Exception e) {
			e.printStackTrace();
			return emp;
		}finally {
			session.close();
			
		}
		
		
		
	}

	

}
