package main;

import java.util.List;

import com.revature.beans.Cat;
import com.revature.dao.CatDaoImpl;

public class Driver {

	public static void main(String[] args) {
		Cat c = new Cat("Fluffy", "White");
		CatDaoImpl cd = new CatDaoImpl();
//		cd.insertCat(c);

		c = new Cat(1, "Jankins the cat", "Tuxedo");
		cd.updateCat(c);
		
		
		List<Cat> cats = cd.selectAllCats();
		System.out.println(">>>>>>>>>>>>>>>>>LIST O CATS");
		for (Cat cc : cats) {
			System.out.println(cc);
		}
		
		
	}
}
