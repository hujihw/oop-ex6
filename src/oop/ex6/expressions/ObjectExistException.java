package oop.ex6.expressions;

import oop.ex6.sjava_objects.SJavaException;

/**
 * the object already exists in the same scope
 * @author Omri Kaplan and Asaf Etzion
 */
class ObjectExistException extends SJavaException {
    ObjectExistException(String message) {
        super(message);
    }
}
