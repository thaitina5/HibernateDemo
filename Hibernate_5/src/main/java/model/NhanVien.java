package model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class NhanVien {
	@Id
	private String id;
	private String hoTen;
	private Date ngaySinh;
	@ManyToMany(mappedBy = "danhSachNhanVien")
	private Set<CuocHop> danhSachCuocHop = new HashSet<CuocHop>();
	
	public NhanVien() {
	}
	
	public NhanVien(String id, String hoTen, Date ngaySinh) {
		this.id = id;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	
	
}
