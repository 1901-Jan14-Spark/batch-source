package com.revature.models;

//Inheritance is the process wherein characteristics are inherited from ancestors. 
//Inheritance in java can be defined as a mechanism where a new class is derived from an existing class.
// Lion derived from mammals
public class Lion extends Mamals{
	public Lion() {
	}


	private boolean groupHunter;
	private Object isGroupHunter;

	//polymorphism. allows you to implement multiple methods within the same class that use the same name
	// but a different set of parameters. 
	//That is called method overloading and represents a static form of polymorphism.

	@Override
	public void huntingSkill(){
	System.out.println("chase is on. A period of time during which the tiger relentlessly pursues its terrified prey with an astonishing speed of around 65");}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getGenus() {
		
		return genus;
}
	
	public void setGenus(String genus) {
		this.genus = genus;
	}
	
	public boolean getCanHunt() {
		if (canHunt == true) {
		System.out.println("This Animal can hunt");
	} else {
		System.out.println("This animal cannot hunt");
	}
		return groupHunter;}

	public boolean setCanHunt(boolean canHunt) {
		return this.canHunt = canHunt;
	}
	
	public boolean isGroupHunter() {
		return groupHunter;
	}

	public void setGroupHunter(boolean groupHunter) {
		this.groupHunter = groupHunter;
	}


	@Override
	protected void groupHunter() {
		System.out.println("Lion are group hunters");
	}
	
	//Equals method
	@Override
	public boolean equals(Object o) {
		if(o.getClass()!=this.getClass()) {
			return false;
		}
		Lion v = (Lion) o;
		if(v.isGroupHunter!=this.isGroupHunter) {
			return false;
		}
		if(v.genus!=this.genus) {
			return false;
		}
		return true;
	}

	
}
