package oop.ex6.expressions;

import oop.ex6.sjava_objects.SJavaException;

/**
 * Called when a final variable is assigned a new value.
 * @author Omri Kaplan and Asaf Etzion
 */
class VariableIsFinalException extends SJavaException {

    VariableIsFinalException(String message) {
        super(message);
    }
}
