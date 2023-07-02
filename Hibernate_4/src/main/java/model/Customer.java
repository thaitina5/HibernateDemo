package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	private String id;
	private String name;
	private String email;
	@OneToMany(mappedBy = "customer")
	private List<Orders> oders;
	
	public Customer() {
	}
	
	public Customer(String id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public Customer(String id, String name, String email, List<Orders> oders) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.oders = oders;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Orders> getOders() {
		return oders;
	}

	public void setOders(List<Orders> oders) {
		this.oders = oders;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", oders=" + oders.size() + "]";
	}
	
	
}
