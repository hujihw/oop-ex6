package oop.ex6.main;

import oop.ex6.sjava_objects.SJavaException;

/**
 * Called when a local variable is referred without initialization.
 * @author Omri Kaplan
 */
public class UnInitLocalVarException extends SJavaException {
    public UnInitLocalVarException(String message) {
        super(message);
    }
}
