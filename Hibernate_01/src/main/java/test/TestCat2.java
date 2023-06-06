package test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Cat;
import util.HibernateUtil;

public class TestCat2 {

	public static void main(String[] args) {
		//Transient
		Cat cat = new Cat("HuanSung",new Date(System.currentTimeMillis()), true);
		
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				
				//Persistent
				session.save(cat);
				tr.commit();
				
				//Detached => Persistent
				session.refresh(cat);
				
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(cat);
	}

}
