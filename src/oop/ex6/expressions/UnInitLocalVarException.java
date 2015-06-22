package oop.ex6.expressions;

import oop.ex6.sjava_objects.SJavaException;

/**
 * Called when a local variable is referred without initialization.
 * @author Omri Kaplan and Asaf Etzion
 */
class UnInitLocalVarException extends SJavaException {
    UnInitLocalVarException(String message) {
        super(message);
    }
}
