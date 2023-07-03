package test;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.CuocHop;
import model.NhanVien;
import util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction trans = session.beginTransaction();
			
			NhanVien n1 = new NhanVien("NV1", "KIM TIN", new Date(1998,11,10));
//			session.save(n1);
			
			CuocHop ch1 = new CuocHop();
			ch1.setTenCuocHop("Hop hoi dong quan tri");
			ch1.setThoiGian(new Date(2022,8,10));
			ch1.setDiaDiem("Phong hop 1");
			ch1.addNhanVien(n1);
			session.save(ch1);
			
			trans.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
