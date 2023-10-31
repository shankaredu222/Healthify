package com.angular.ojt.AngularBackend.daoIMPL;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.angular.ojt.AngularBackend.dao.CountryDao;
import com.angular.ojt.AngularBackend.entity.Country;

@Repository
public class CountryDaoImpl implements CountryDao {

	@Autowired
	private SessionFactory sf;

	public String createCountry(Country country) {
		Session session =null;
		String msg = null;
		
		try {
			session= sf.openSession();
			session.save(country);
			session.beginTransaction().commit();
			msg="Country saved Successfully..!!!";
		} catch (Exception e) {
			e.printStackTrace();
			msg="Something went wrong";
		}finally {
			session.close();
		}
		return msg;
		
	}

	@Override
	public Country getCountryById(long id) {
		Session session =null;
		Country country = null;
		try {
			session = sf.openSession();
			 country = session.get(Country.class, id);
			 
		} catch (Exception e) {
			e.printStackTrace();
			country= null;
		}finally {
			session.close();
		}
		return country;
	}

	@Override
	public List<Country> getAllCountry() {
		Session session =null;
		List<Country> list=null;
		
		try {
			session=sf.openSession();
			Criteria criteria = session.createCriteria(Country.class);
			 list =criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public Country getCountryByName(String cName) {
		Session session = null;
		Country country = null;
		
		try {
			session= sf.openSession();
			Criteria criteria = session.createCriteria(Country.class);
			criteria.add(Restrictions.eq("countryName", cName));
			country=(Country) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return country;
	}

	@Override
	public String updateCountry(Country country) {
		String msg = null;
		Session session= null;
		
		try {
			session=sf.openSession();
			session.update(country);
			session.beginTransaction().commit();
			msg="country updated successfully";
		} catch (Exception e) {
			e.printStackTrace();
			msg="country  not updated ";
		}finally {
			session.close();
		}
		return msg;
	}

	@Override
	public String deleteCountry(Long id) {
		String deleted=null;
		Session session= null;
		
		try {
			session=sf.openSession();
			Country country = session.get(Country.class, id);
			session.delete(country);
			session.beginTransaction().commit();
			deleted="country deleted successfully WITH "+id;
		} catch (Exception e) {
			e.printStackTrace();
			deleted="country not FOUND WITH "+id;
		}finally {
			session.close();
		}
		
		return deleted;
	}

	@Override
	public String deleteCountryByName(String name) {
		String deleted=null;
		Session session= null;
		try {
			session= sf.openSession();
			Criteria criteria = session.createCriteria(Country.class);
			criteria.add(Restrictions.eq("countryName", name));
			Country country = (Country) criteria.uniqueResult();
			session.delete(country);
			session.beginTransaction().commit();
			deleted="country deleted successfully with "+name;
		} catch (Exception e) {
			e.printStackTrace();
			deleted="country not found with "+name;
		}finally {
			session.close();
		}
		return deleted;
	}
	
	

}
