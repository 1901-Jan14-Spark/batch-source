package animals;

public class ValidNumberOfLegsExeption extends RuntimeException {
	public ValidNumberOfLegsExeption() {
		super();
	}
	
	public ValidNumberOfLegsExeption(String Message) {
		super(Message);
	}

}
