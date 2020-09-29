package be.abis.courseadmin.model;

public class AgeCannotBeNegativeException extends Exception {
	public AgeCannotBeNegativeException () {
        super();
    }
	public AgeCannotBeNegativeException (String message) {
        super(message);
    }
}
