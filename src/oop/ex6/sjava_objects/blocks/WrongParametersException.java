package oop.ex6.sjava_objects.blocks;

import oop.ex6.sjava_objects.SJavaException;

/**
 * Raised by a SuperBlock object when it gets inappropriate parameters when called.
 * @author Omri Kaplan and Asaf Etzion
 */
class WrongParametersException extends SJavaException {
    WrongParametersException(String message) {
        super(message);
    }
}
