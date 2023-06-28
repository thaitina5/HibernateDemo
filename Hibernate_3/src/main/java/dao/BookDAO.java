package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Author;
import model.Book;
import util.HibernateUtil;

public class BookDAO implements DAOInterface<Book>{

	@Override
	public List<Book> selectAll() {
		List<Book> result = new ArrayList<Book>();
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction trans = session.beginTransaction();
			
			String hql = "from Book";
			Query query = session.createQuery(hql);
			result = query.getResultList();
			
			trans.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Book selectById(Book t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Book t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Book t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Book t) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
