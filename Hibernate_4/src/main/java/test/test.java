package test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Customer;
import model.Orders;
import util.HibernateUtil;

public class test {

	public static void main(String[] args) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction trans = session.beginTransaction();
			
//			Customer c1 = new Customer("c1","THAI KIM TIN","thaitina5@gmail.com");
//			Orders o1 = new Orders("O1","ABC1234",c1);
//			Orders o2 = new Orders("O2","ABC1234",c1);
//			Orders o3 = new Orders("O3","ABC1234",c1);
//			Orders o4 = new Orders("O4","ABC1234",c1);
//			
//			List<Orders> list = new ArrayList<>();
//			list.add(o1);
//			list.add(o2);
//			list.add(o3);
//			list.add(o4);
//			
//			c1.setOders(list);
//			session.saveOrUpdate(c1);
//			session.saveOrUpdate(o1);
//			session.saveOrUpdate(o2);
//			session.saveOrUpdate(o3);
//			session.saveOrUpdate(o4);
//			
//			Customer c2 = new Customer("c2","My Thu","mythu@gmail.com");
//			session.saveOrUpdate(c2);
			
			String hql = "from Customer c where size(c.oders) > 0";
			List<Customer> results = session.createQuery(hql).list();
			
			for(Customer rs: results) {
				System.out.println(rs);
			}
			
			trans.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
