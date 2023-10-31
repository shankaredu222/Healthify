package com.angular.ojt.AngularBackend.daoIMPL;

import java.util.List;

import javax.transaction.Transaction;
import javax.validation.Valid;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.angular.ojt.AngularBackend.dao.EmpDao;
import com.angular.ojt.AngularBackend.entity.Employee;

@Repository
public class EmpDaoImpl implements EmpDao {

	@Autowired
	private SessionFactory sf;

	

	@Override
	public String updateEmp(Employee e) {
		String msg = null;
		Session session = null;

		try {
			session = sf.openSession();
			session.update(e);
			session.beginTransaction().commit();
			msg = "Employee Updated Successfully";
		} catch (Exception e2) {
			msg = "EMPLOYEE  NOT UPDATED ";
			e2.printStackTrace();
		} finally {
			session.close();
		}
		return msg;
	}

	@Override
	public String deleteEmpById(Long id) {
		String msg = null;
		Session session = null;
		try {
			session = sf.openSession();
			Employee e = session.get(Employee.class, id);
			session.delete(e);
			session.beginTransaction().commit();
			msg = "EMPLOYEE DELETED SUCCESSFULLY WITH " + id;
		} catch (Exception e) {
			msg = "EMPLOYEE NOT FOUND";
			e.printStackTrace();
		}

		return msg;
	}

	@Override
	public String deleteEmpByName(String name) {

		String msg = null;
		Session session = null;
		try {
			session = sf.openSession();
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.add(Restrictions.eq("firstName", name));
			Employee e = (Employee) criteria.uniqueResult();
			session.delete(e);
			msg = "EMPLOYEE DELETED SUCCESSFULLY WITH NAME " + name;
		} catch (Exception e) {
			msg = "EMPLOYEE NOT FOUND WITH NAME " + name;
			e.printStackTrace();
		}

		return msg;
	}

	@Override
	public List<Employee> getAllEmp() {
		List<Employee> list = null;
		Session session = null;

		try {
			session = sf.openSession();
			Criteria criteria = session.createCriteria(Employee.class);
			list = criteria.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return list = null;
		} finally {
			session.close();
		}
	}

	@Override
	public Employee getEmpById(Long id) {
		Employee employee = null;
		Session session = null;

		try {
			session = sf.openSession();
			employee = session.get(Employee.class, id);
			return employee;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Boolean addemp(@Valid Employee e) {
		System.out.println(e);
		boolean isAdded = false; 
		Session session =null;
		
		try {
			session=sf.openSession();
			session.save(e);
			session.beginTransaction().commit();
			isAdded=true;
		} catch (Exception e2) {
			e2.printStackTrace();
			isAdded=false;
		}
		return isAdded;
	}

	@Override
	public String uploadSheet(List<Employee> readExcelFile) {
		System.out.println("IN DAO IMPL " +readExcelFile);
		String msg = null;
		Session session = null;
		
		try {
			session= sf.openSession();
			for (Employee employee : readExcelFile) {
				session.save(employee);
			}
			session.beginTransaction().commit();
			msg = "Employee Added Successfully";
		} catch (Exception e) {
			e.printStackTrace();
			msg="Employee not Added Successfully";
		}
		return msg;
	}

}
