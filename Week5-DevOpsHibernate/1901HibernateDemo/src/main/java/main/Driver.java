package main;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import com.revature.beans.Bee;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
//		>>>>>>>>>>>>>>>>>>>>CATS<<<<<<<<<<<<<<<<
//		Cat c = new Cat("Fluffy", "white");
//		CatDaoImpl cd = new CatDaoImpl();
////		cd.insertCat(c);
//
//		
//		c = new Cat(24,"Janky-ins the cat", "Tuxe");
//		cd.updateCat(c);
//
//		//the following code is used to display contents
//		//of db
//		List<Cat> cats = cd.selectAllCats();
//		System.out.println(">>>>>LIST O CATS");
//		for(Cat cc: cats) {
//			System.out.println(cc);
//		}
//		>>>>>>>>>BEES,BEEHIVES,FLOWERS<<<<<<<<<<<<<<<<<<
//		Flower f1 = new Flower(6);
//		Flower f2 = new Flower(0);
//		FlowerDaoImpl fd = new FlowerDaoImpl();
//		fd.insertFlower(f1); //inserts flower to database
//		fd.insertFlower(f2); //inserts flower to database
//		List<Flower> flowers = new ArrayList<Flower>();
//		flowers.add(f1);
//		flowers.add(f2);
//		//the code above inserts two flowers into the array list
//		//and the database
//		
//		Beehive bh = new Beehive(9001);
//		BeehiveDaoImpl bhd = new BeehiveDaoImpl();
//		bhd.insertBeehive(bh);
//		//inserts a beehive into the database
//		
//		
//		
//		Bee bee = new Bee(100,bh);
//		bee.setFlower(flowers);
//		BeeDaoImpl beed = new BeeDaoImpl();
//		beed.insertBee(bee);// yo watch this
//		>>>>>>>>>>Query and Criteria<<<<<<
		
//		criteria and query are both interfaces. objects of these
//		types can be made using the session
//		they both serve similar purpose; they are both used
//		to grab data from the database, just in different ways
//		query uses HQL or SQL
		
//		Query query;
//		Session session = HibernateUtil.getSession();
//		String hql;
//		System.out.println("=========GET ALL Bees======");
//		hql = "FROM Bee";
//		query = session.createQuery(hql);
//		System.out.println(query.list()); //GET ALL THE BEES

//		System.out.println("======Parameterized HQL======");
//		hql = "FROM Bee WHERE id = :id";// the colon parameterizes
//		//the HQL
//		query = session.createQuery(hql);
//		query.setParameter("id", 400);
//		System.out.println(query.uniqueResult());
		
// criteria is an object based approach to grabbing a value from
//the database
		
//		instead of using one of the query languages, the criteria
//		interface can grab values from the database using what
//		is called "criteria"
		System.out.println("=====Criteria GET ALL====");
		Session session = HibernateUtil.getSession();
		List<Bee> bees;
		
		bees = session.createCriteria(Bee.class).list();
		//grab all the records from the database that are from
//		the Bee class
		System.out.println(bees);
		
		System.out.println("=========Conditional Criteria====");
		Criteria crit = session.createCriteria(Bee.class);
		crit.add(Restrictions.idEq(400));
		
		System.out.println(crit.uniqueResult());
		
		
		
		
	}

}
