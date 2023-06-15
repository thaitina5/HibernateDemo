package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Person;
import util.HibernateUtil;

public class PersonDAO implements DAOInterface<Person>{

	@Override
	public List<Person> selectAll() {
		List<Person> result = new ArrayList<>();
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction trans = session.beginTransaction();
			
			String hql = "from Person";
			Query query = session.createQuery(hql);
			result = query.getResultList();
			
			trans.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Person selectById(Person t) {
		List<Person> result = new ArrayList<>();
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			Transaction trans = session.beginTransaction();
			
			String hql = "from Person p where p.id=id";
			Query query = session.createQuery(hql);
			result = query.getResultList();
			
			trans.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
		}
		
		if(result.size()>0) {
			return result.get(0); //lay phan tu dau tien
		}else {
			return null;
		}
	}
	
	public boolean saveOrUpdate(Person p) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {		
			Transaction tr = session.beginTransaction();
			
			session.saveOrUpdate(p);
			
			tr.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insert(Person p) {
		return saveOrUpdate(p);
	}

	@Override
	public boolean update(Person p) {
		return saveOrUpdate(p);
	}

	@Override
	public boolean delete(Person p) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {		
			Transaction tr = session.beginTransaction();
			
			session.delete(p);
			
			tr.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

}
