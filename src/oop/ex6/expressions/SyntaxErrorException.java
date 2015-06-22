package oop.ex6.expressions;

import oop.ex6.sjava_objects.SJavaException;

/**
 * Raised when reaching a line with wrong syntax.
 * @author Omri Kaplan & Asaf Etzion
 */
class SyntaxErrorException extends SJavaException {
    public SyntaxErrorException(String message) {
        super(message);
    }
}
