package oop.ex6.expressions;

import oop.ex6.sjava_objects.SJavaException;

/**
 * Called when a final variable is assigned a new value.
 * @author Omri Kaplan & Asaf Etzion
 */
public class VariableIsFinalException extends SJavaException {

    public VariableIsFinalException(String message) {
        super(message);
    }
}
