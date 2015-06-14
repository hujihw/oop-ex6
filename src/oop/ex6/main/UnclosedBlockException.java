package oop.ex6.main;

import oop.ex6.sjava_objects.SJavaException;

/**
 * When closing bracket is missing after opening a new block.
 * @author Omri Kaplan
 */
public class UnclosedBlockException extends SJavaException {
    public UnclosedBlockException(String message) {
        super(message);
    }
}
