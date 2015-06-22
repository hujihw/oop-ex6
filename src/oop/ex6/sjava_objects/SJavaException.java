package oop.ex6.sjava_objects;

/**
 * the super exception of all of the exceptions (except of badFileException)
 * @author Omri Kaplan and Asaf Etzion
 */
public class SJavaException extends Exception {

    /**
     * sends the imformative exception message up the exception call
     * @param message describes what is wrong with the sjava code
     */
    /* Constructor */
    public SJavaException(String message) {
        super(message);
    }
}
