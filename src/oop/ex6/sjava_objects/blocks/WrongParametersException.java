package oop.ex6.sjava_objects.blocks;

import oop.ex6.sjava_objects.SJavaException;

/**
 * Raised by a SuperBlock object when it gets inappropriate parameters when called.
 * @author Omri Kaplan
 */
public class WrongParametersException extends SJavaException {
    public WrongParametersException(String message) {
        super(message);
    }
}
