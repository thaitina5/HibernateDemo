package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class DonHang {
	@Id
	@GeneratedValue
	private int id;
	private String tenKhachHang;
	private Date thoiGian;
	@OneToMany(mappedBy = "donHang", cascade = CascadeType.ALL)
//	@OneToMany(mappedBy = "donHang", cascade = CascadeType.PERSIST)
//	@OneToMany(mappedBy = "donHang", cascade = CascadeType.REMOVE)
//	@OneToMany(mappedBy = "donHang", cascade = CascadeType.MERGE)
	private List<ChiTietDonHang> danhSachCTDonHang = new ArrayList<ChiTietDonHang>();

	public DonHang() {
	}

	public DonHang(int id, String tenKhachHang, Date thoiGian, List<ChiTietDonHang> danhSachCTDonHang) {
		this.id = id;
		this.tenKhachHang = tenKhachHang;
		this.thoiGian = thoiGian;
		this.danhSachCTDonHang = danhSachCTDonHang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public Date getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}

	public List<ChiTietDonHang> getDanhSachCTDonHang() {
		return danhSachCTDonHang;
	}

	public void setDanhSachCTDonHang(List<ChiTietDonHang> danhSachCTDonHang) {
		this.danhSachCTDonHang = danhSachCTDonHang;
	}
	
	public void addCTDH(ChiTietDonHang ct) {
		this.danhSachCTDonHang.add(ct);
	}
}
