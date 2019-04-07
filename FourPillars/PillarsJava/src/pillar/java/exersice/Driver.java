package pillar.java.exersice;

public class Driver {
public int spots;
public static void main(String[] args) {
	
	
	Leopardus l3= new Leopardus(-45,"Big"); 
		
	System.out.println(l3);
	
	
	Leopardus l = new Leopardus(15, "Medium");
	l.communicate();
	l.reproduce();
	System.out.println("nosie: "+l.getSpots());
	
	Ocelot o = new Ocelot(12,"small");
	o.communicate();
	o.reproduce();
	//o.numberOfDrinks();
			
	Leopardus l1 = new Leopardus(17, "small");
	l1.communicate();
	Leopardus l2 = new Leopardus(17, "small");
	l2.communicate(); 
	//my example of an implementation of the .equals object method
	if (l1.equals(l2)) {
		System.out.println("equal");
	}else {System.out.println("not");
	}
	
	///my example of method hiding where the method Loesound is not overridden
	Leopardus.leoSound();
	Ocelot.leoSound();
	
	//my example of Virtual method Invocation
	Leopardus l5 = new Ocelot(15, "Large");
	System.out.println(l5.getTaxonomy());
	
	
}
///my example of the .equals object method being properl initailized
public boolean equals(Object o) {
//	if(o == this){
//		return true;
//	}
	 if(o.getClass().getSimpleName()!= this.getClass().getSimpleName()){
		 return false;
		}
	 Leopardus l2= (Leopardus)o; 
	 if (this.spots != l2.getSpots()) {
		 return false;
	 }else {
		 return true;
	 }
	
	}
	


}
