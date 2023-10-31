package com.angular.ojt.AngularBackend.daoIMPL;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.angular.ojt.AngularBackend.dao.RegistrationDao;
import com.angular.ojt.AngularBackend.entity.Employee;

@Repository
public class RegistrationDaoImpl implements RegistrationDao {

	@Autowired
	private SessionFactory sf;
	
//	@Override
//	public Employee loginUser(Employee employee) {
////		Employee user=null;
////		String username =employee.getUsername();
////		Session session=null;
////		try {
////			session= sf.openSession();
////			Criteria criteria = session.createCriteria(Employee.class);
////			criteria.add(Restrictions.eq("username",username));
////			 user=(Employee) criteria.uniqueResult();
////			System.out.println(user);
////			return user;
////		} catch (Exception e) {
////			e.printStackTrace();
////			return null;
////		}finally {
////			session.close();
////		}
	

}
