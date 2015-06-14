package oop.ex6.sjava_objects.variables;

import oop.ex6.sjava_objects.SJavaException;

/**
 * Raised when factory asked for an unsupported variable.
 * @author Omri Kaplan
 */
public class IllegalVarException extends SJavaException {
    public IllegalVarException(String message) {
        super(message);
    }
}
