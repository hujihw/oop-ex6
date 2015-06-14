package oop.ex6.sjava_objects;

/**
 * Raised by an S-Java object when created with inappropriate parameters.
 * @author Omri Kaplan
 */
public class IllegalParameterException extends SJavaException {
    public IllegalParameterException(String message) {
        super(message);
    }
}
