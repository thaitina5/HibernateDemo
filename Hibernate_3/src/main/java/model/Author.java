package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Author {
	@Id
	private String authorId;
	private String name;
	private Date dateOfBirth;
	
	public Author() {
	}
	
	public Author(String authorId, String name, Date dateOfBirth) {
		this.authorId = authorId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
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
	
	
}
