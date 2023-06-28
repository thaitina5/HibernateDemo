package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Author;
import util.HibernateUtil;

public class AuthorDAO implements DAOInterface<Author>{

	@Override
	public List<Author> selectAll() {
		List<Author> result = new ArrayList<Author>();
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction trans = session.beginTransaction();
			
			String hql = "from Author";
			Query query = session.createQuery(hql);
			result = query.getResultList();
			
			trans.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Author selectById(Author t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Author t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Author t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Author t) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
