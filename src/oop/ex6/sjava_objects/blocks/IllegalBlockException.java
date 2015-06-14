package oop.ex6.sjava_objects.blocks;

import oop.ex6.sjava_objects.SJavaException;

/**
 * Raised when factory asked for an unsupported block.
 * @author Omri Kaplan
 */
public class IllegalBlockException extends SJavaException {
    public IllegalBlockException(String message) {
        super(message);
    }
}
