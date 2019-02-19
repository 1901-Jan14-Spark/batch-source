package com.revature.models;

public class Driver {
	public Driver() {
	}
	public static void main(String[] args) {
		Lion l = new Lion();
		l.setName("Atlas");
		l.setGenus("Pantera");
		l.setCanHunt(true);
		l.setGroupHunter(true);
		l.isGroupHunter();
		System.out.println(l.getName());
		System.out.println(l.getGenus());

		//Mamals Mm = new Mamals();
		Lion alex = new Lion(true,"Alex","Pantera",false,"Furry");
		System.out.println(alex);

		
	}

}
