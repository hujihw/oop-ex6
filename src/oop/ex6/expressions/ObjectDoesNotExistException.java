package oop.ex6.expressions;

import oop.ex6.sjava_objects.SJavaException;

/**
 * Raised if Finder can not find an S-Java object.
 * @author Omri Kaplan & Asaf Etzion
 */
class ObjectDoesNotExistException extends SJavaException {
    public ObjectDoesNotExistException(String message) {
        super(message);
    }
}
