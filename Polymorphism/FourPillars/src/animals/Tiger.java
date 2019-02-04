package animals;

public class Tiger extends AnimalTypes{

	private String species;
	private boolean endangered;
	private boolean huntable;
	
	
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

	
	
	

}
