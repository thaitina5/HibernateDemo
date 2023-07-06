package test;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.ChiTietDonHang;
import model.DonHang;
import util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction trans = session.beginTransaction();
			
//			DonHang dh = new DonHang();
//			dh.setTenKhachHang("Thai Kim Tin");
//			dh.setThoiGian(new Date(123,1,30));
//			
//			ChiTietDonHang ctdh = new ChiTietDonHang();
//			ctdh.setTenSanPham("Red Bull");
//			ctdh.setGiaBan(10000);
//			ctdh.setSoLuong(2);
//			ctdh.setThanhTien(20000);
//			ctdh.setDonHang(dh);
//			
//			ChiTietDonHang ctdh2 = new ChiTietDonHang();
//			ctdh.setTenSanPham("Soda");
//			ctdh.setGiaBan(5000);
//			ctdh.setSoLuong(2);
//			ctdh.setThanhTien(10000);
//			ctdh.setDonHang(dh);
//			
//			dh.addCTDH(ctdh);
//			dh.addCTDH(ctdh2);
//			
//			session.save(dh);
			
			DonHang dh = session.load(DonHang.class, 1);
			session.remove(dh);
			
			trans.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
