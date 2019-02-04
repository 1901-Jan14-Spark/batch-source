package pillar.java.exersice;

public class Driver {
public static void main(String[] args) {
	
	Leopardus l = new Leopardus(15, "Medium");
	l.communicate();
	l.reproduce();
	System.out.println("nosie: "+l.getSpots());
	
	Ocelot o = new Ocelot(12,"small");
	o.communicate();
	o.reproduce();
	//o.numberOfDrinks();
			
	
}
}
