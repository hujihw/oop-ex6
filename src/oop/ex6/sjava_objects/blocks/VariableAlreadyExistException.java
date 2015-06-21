package oop.ex6.sjava_objects.blocks;

import oop.ex6.sjava_objects.SJavaException;

/**
 * @author Omri Kaplan
 */
public class VariableAlreadyExistException extends SJavaException {
    public VariableAlreadyExistException(String message) {
        super(message);
    }
}
