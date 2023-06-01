package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cat {
	private Integer id;
	private String name;
	private Date dateOfBirth;
	private boolean sex;
	
	public Cat() {}
	
	public Cat(String name, Date dateOfBirth, boolean sex) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
	}
	
	@Id //khóa chính
	@GeneratedValue //tự động tăng, auto number
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Cat [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", sex=" + sex + "]";
	}
	
	
}
