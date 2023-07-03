package model;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class GiaoVien extends ConNguoi {
	private String monHocPhuTrach;

	public GiaoVien() {
	}

	public GiaoVien(String id, String name, Date ngaySinh, String monHocPhuTrach) {
		super(id, name, ngaySinh);
		this.monHocPhuTrach = monHocPhuTrach;
	}

	public String getMonHocPhuTrach() {
		return monHocPhuTrach;
	}

	public void setMonHocPhuTrach(String monHocPhuTrach) {
		this.monHocPhuTrach = monHocPhuTrach;
	}
	
	
}
