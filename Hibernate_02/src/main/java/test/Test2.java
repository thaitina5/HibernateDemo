package test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class Test2 {

	public static void main(String[] args) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {		
			Transaction tr = session.beginTransaction();
			
			String hql = "select id, name, spouse.id, spouse.name from Person ";
			List<Object[]> result = session.createQuery(hql).list();
			
			for(Object[] rs : result) {
				String id = rs[0]+"";
				String name = rs[1]+"";
				String spouse_id = rs[2]+"";
				String spouse_name = rs[3]+"";

				System.out.println(name+"("+id+")"+" married to "+spouse_name+"("+spouse_id+")");
			}
			
			tr.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
