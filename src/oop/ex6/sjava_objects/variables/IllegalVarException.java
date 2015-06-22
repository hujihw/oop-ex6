package oop.ex6.sjava_objects.variables;

import oop.ex6.sjava_objects.SJavaException;

/**
 * Raised when factory asked for an unsupported variable.
 * @author Omri Kaplan and Asaf Etzion
 */
class IllegalVarException extends SJavaException {
    IllegalVarException(String message) {
        super(message);
    }
}
