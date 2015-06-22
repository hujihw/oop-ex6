package oop.ex6.main;

import oop.ex6.sjava_objects.SJavaException;

import java.io.IOException;

/**
 * More than one argument is given by the user when calling "Sjavac" from the command line.
 * @author Omri Kaplan & Asaf Etzion
 */
public class WrongArgumentsNumberException extends IOException {
    public WrongArgumentsNumberException(String message) {
        super(message);
    }
}
