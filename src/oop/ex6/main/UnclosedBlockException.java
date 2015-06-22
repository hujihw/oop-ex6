package oop.ex6.main;

import oop.ex6.sjava_objects.SJavaException;

/**
 * When closing bracket is missing after opening a new block.
 * @author Omri Kaplan and Asaf Etzion
 */
class UnclosedBlockException extends SJavaException {
    UnclosedBlockException(String message) {
        super(message);
    }
}
