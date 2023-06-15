package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Cat;
import util.HibernateUtil;

public class CatDAO implements DAOInterface<Cat>{

	@Override
	public List<Cat> selectAll() {
		List<Cat> result = new ArrayList();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				
				String hql = "from Cat";//phải viết hoa chữ cái đầu table
				Query query = session.createQuery(hql);
				result = query.getResultList();
				
				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Cat selectById(Cat t) {
		List<Cat> result = new ArrayList();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				
				String hql = "from Cat c where c.id=:id";//phải viết hoa chữ cái đầu table
				Query query = session.createQuery(hql);
				query.setParameter("id", t.getId());
				result = query.getResultList();
				
				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result.size()>0) {
			return result.get(0); //lay phan tu dau tien
		}else {
			return null;
		}
	}
	
	public boolean saveOrUpdate(Cat t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				
				//save chi them neu chu ton tai
				//session.save(t);
				
				//Them moi neu chua ton tai, cap nhat neu da ton tai
				session.saveOrUpdate(t);
				
				tr.commit();
				session.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insert(Cat t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean update(Cat t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean delete(Cat t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				
				session.delete(t);
				
				tr.commit();
				session.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
