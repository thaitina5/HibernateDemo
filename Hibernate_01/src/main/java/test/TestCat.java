package test;

import java.sql.Date;
import java.util.List;

import dao.CatDAO;
import model.Cat;

public class TestCat {

	public static void main(String[] args) {
		CatDAO cd = new CatDAO();
		//Test selectAll
//		List<Cat> list = cd.selectAll();
//		for (Cat cat : list) {
//			System.out.println(cat);
//		}
		
		//Test selectById
//		Cat c = new Cat();
//		c.setId(1);
//		
//		Cat c2 = cd.selectById(c);
//		System.out.println(c2);
		
		//Test insert va update
		Cat c3 = new Cat("Issac 2",new Date(System.currentTimeMillis()),true);
		c3.setId(3);
		cd.insert(c3);
	}

}
