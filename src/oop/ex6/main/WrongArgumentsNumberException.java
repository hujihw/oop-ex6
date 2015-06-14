package oop.ex6.main;

import oop.ex6.sjava_objects.SJavaException;

/**
 * More than one argument is given by the user when calling "Sjavac" from the command line.
 * @author Omri Kaplan
 */
public class WrongArgumentsNumberException extends SJavaException {
    public WrongArgumentsNumberException(String message) {
        super(message);
    }
}
