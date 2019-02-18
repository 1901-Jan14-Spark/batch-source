package animals;

import java.io.FileNotFoundException;

public class Tiger extends AnimalTypes{

	private String species;
	private boolean endangered;
	private boolean huntable;
	
	
	public boolean equals(Object o) {  //equal
        if(o.getClass() != this.getClass()) {
            return false;
        }
        AnimalTypes grr = (AnimalTypes) o;
        if(grr.huntable() != this.huntable()){
            return false;
        }
        if(grr.getEatsMeat() != this.getEatsMeat()) {
            return false;
        }
        return true;
    } 
	
	public void setAnimalName(String animalName) {
		this.animalName=animalName;
	}
	
	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public boolean getEndangered() {
		return endangered;
	}

	public void setEndangered(boolean endangered) {
		this.endangered = endangered;
	}

	public void hunted(boolean hunted) {
		this.setHunted(hunted);
	}


	@Override
	public boolean huntable(boolean huntable) {
		return huntable;
	}

	public boolean isHuntable() {
		return huntable;
	}
	public static void printNotice() {
		System.out.println("This is a Tiger");
	}

	public void setHuntable(boolean huntable) {
		this.huntable = huntable;
	}


	@Override
	public boolean huntable() {
		// TODO Auto-generated method stub
		return huntable;
	}

	@Override
	public String toString() {
		return "Tiger [species=" + species + ", endangered=" + endangered + ", huntable=" + huntable + ", animalName="
				+ animalName + ", isHunted()=" + isHunted() + "]";
	}
//Attempt to generate CompareTo
	public static int compareTo(Tiger white, Giraffe bob) {
		return white.getNumOfLegs() - bob.getNumOfLegs();
		
	}

	public Tiger(String tigeFile) {
		if(tigeFile.equals("tigerFile.txt")) {
			System.out.println("Successfully Accessed Giraffe File");
		} else {
			try {
				throw new FileNotFoundException("Cannot Find GiraffeFile.txt");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				animalName="boby";
				System.out.println(e.toString());
			}
		}
	}
	//This generates a checked exception, code will not compile
public static void main(String[] args) {
	Tiger bobby = new Tiger(tigerFile);
	System.out.println(bobby);

}
	

}
