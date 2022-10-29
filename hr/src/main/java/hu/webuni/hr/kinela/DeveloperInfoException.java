package hu.webuni.hr.kinela;

public class DeveloperInfoException extends Exception{

	public DeveloperInfoException(String message) {
		super("[ DEVELOPER INFO ] - " + message);
	}

}
