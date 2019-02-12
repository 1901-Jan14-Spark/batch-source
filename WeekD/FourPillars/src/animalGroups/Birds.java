package animalGroups;

public class Birds extends Animal implements CanFly {

	
	//why cant I use acceess modifiers?
		 String beaktype = "blunt";
		
	
	
	
	public Birds() {
		
		
	
	 System.out.println("Birds init");

		
		// TODO Auto-generated constructor stub
	}
	
	
	public void birdTalk() {
		
		System.out.println("Chirp Chirp");
		
	}

	@Override
	public String breathsWith() {
		
		// TODO Auto-generated method stub
		return "lungs";
	}


	@Override
	public void fly() {
		System.out.println("flap flap flap");
		// TODO Auto-generated method stub
		
	}

	public void diet( String x) {
		System.out.println(x);
		// TODO Auto-generated method stub
		
	}
	public void diet() {
		System.out.println("insects");
		// TODO Auto-generated method stub
		
	}

	@Override
	public String wingType() {
		// TODO Auto-generated method stub
		return  "wings with feather";
	}

	
	@Override
	public boolean equals(Object o) {
		if(o.getClass()!=this.getClass()) {
			return false;
		}
		Birds b = (Birds) o;
		if(b.beaktype!=this.beaktype) {
			return false;
		}

		
		return true;

	}

	
	





}
