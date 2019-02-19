package com.revature.models;

//Inheritance is the process wherein characteristics are inherited from ancestors. 
//Inheritance in java can be defined as a mechanism where a new class is derived from an existing class.
// Lion derived from mammals
public class Lion extends Mamals implements Predator{
	private boolean groupHunter;
	private String hasFur;
	public Lion() {
		super();
	}
	// here we overload our constructor, providing constructors with different sets of parameters
		// this is polymorphism -- overloading
		public Lion(boolean groupHunter, String name, String genus,boolean canHunt,String hasFur) {
			super(name, genus, canHunt);
			this.groupHunter = groupHunter;
			this.hasFur = hasFur;
		}
		
		public Lion(String hasFur) {
			if(hasFur.equals("Furry")) {
				System.out.println("Yes,Mostly Lions are furry");
			} else {
				try {
					throw  new FurValidityException("lions are furry");
				} catch (FurValidityException e) {
					e.printStackTrace();
					this.setGroupHunter(true);
				}
			}
		}
		
    //polymorphism. allows you to implement multiple methods within the same class that use the same name
	// but a different set of parameters. 
	//That is called method overloading and represents a static form of polymorphism.

	@Override
	public void huntingSkill(){
	System.out.println("chase is on. A period of time during which the lion relentlessly pursues its terrified prey");}

	
	public boolean isGroupHunter() {
		return groupHunter;
	}

	public void setGroupHunter(boolean groupHunter) {
		this.groupHunter = groupHunter;
	}
	public String getHasFur() {
		return hasFur;
	}
	public void setHasFur(String hasFur) {
		this.hasFur = hasFur;
	}
	
	@Override
	public String toString() {
		return "Lion [groupHunter=" + groupHunter + ", hasFur=" + hasFur + ", isGroupHunter()=" + isGroupHunter()
				+ ", getHasFur()=" + getHasFur() + ", getName()=" + getName() + ", getGenus()=" + getGenus()
				+ ", isCanHunt()=" + isCanHunt() + "]";
	}
	//Equals method
	@Override
	public boolean equals(Object o) {
		if(o.getClass()!=this.getClass()) {
			return false;
		}
		Lion v = (Lion) o;
		if(v.groupHunter!=this.groupHunter) {
			return false;
		}
		if(v.getGenus()!=this.getGenus()) {
			return false;
		}
		return true;
	}

	
}
