package exceptions;

//Custom made exception for when 'canFly' is set to boolean value false
public class CantFlyException extends RuntimeException {
	public CantFlyException(String msg) {
		super(msg);
	}
}
