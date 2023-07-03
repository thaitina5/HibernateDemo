package test;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.GiaoVien;
import model.SinhVien;
import util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction trans = session.beginTransaction();
			
			GiaoVien gv = new GiaoVien("GV01", "Nguyen Van A",new Date(100, 1, 30), "hibernate");
			SinhVien sv = new SinhVien("07123", "Sinh viên 1", new Date(105, 2, 15), 9.8);
			
			session.save(gv);
			session.save(sv);
			
			trans.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
