package oop.ex6.expressions;

import oop.ex6.sjava_objects.SJavaException;

/**
 * thrown when inputting a parameter with a wrong type.
 * @author Omri Kaplan and Asaf Etzion
 */
class WrongParameterTypeException extends SJavaException{

    public WrongParameterTypeException(String message) {
        super(message);
    }
}
