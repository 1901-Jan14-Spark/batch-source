package animals;

public abstract class AnimalTypes implements Huntable{
	
	private int numOfLegs;
	public String animalName;
	private boolean eatsMeat;
	private boolean hunted;
	
	public static void printNotice() {
		System.out.println("This is an Animal");
	}
	
	@Override
    public boolean equals(Object o) {
        if(o.getClass() != this.getClass()) {
            return false;
        }
        AnimalTypes grr = (AnimalTypes) o;
        if(grr.hunted != this.hunted) {
            return false;
        }
        if(grr.eatsMeat != this.eatsMeat) {
            return false;
        }
        return true;
    } 
	
	public boolean getEatsMeat() {
		return EatsMeat();
	}


	public void setEatsMeat(boolean eatsMeat) {
		this.eatsMeat = eatsMeat;
	}


	public AnimalTypes() {
		super ();
	}


	public int getNumOfLegs() {
		return numOfLegs;
	}


	public void setNumOfLegs(int numOfLegs) {
		if(numOfLegs < 0 || numOfLegs > 4) {
			throw new ValidNumberOfLegsExeption("Animal Must Have Ideally 4 legs but no Less than 0");
		}
		this.numOfLegs = numOfLegs;
	}


	public String getAnimalName() {
		return animalName;
	}


	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}


	public void hunted(boolean hunted) {	
		this.setHunted(hunted);
	}
	

	public boolean EatsMeat() {
		return eatsMeat;
	}


	@Override
	public String toString() {
		return "AnimalTypes [numOfLegs=" + numOfLegs + ", animalName=" + animalName + ", eatsMeat=" + eatsMeat
				+ ", EatsMeat()=" + EatsMeat() + "]";
	}


	public boolean isHunted() {
		return hunted;
	}


	public void setHunted(boolean hunted) {
		this.hunted = hunted;
	}


	
}
