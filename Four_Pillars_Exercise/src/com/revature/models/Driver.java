package com.revature.models;

public class Driver {
	public Driver() {
	}
	public static void main(String[] args) {
		Lion l = new Lion();
		l.setName("Lion");
		l.setGenus("Pantera");
		l.setCanHunt(true);
		System.out.println(l.getName());
		System.out.println(l.getGenus());

		Mamals Li = new Lion();
		Li.groupHunter();
	}

}
