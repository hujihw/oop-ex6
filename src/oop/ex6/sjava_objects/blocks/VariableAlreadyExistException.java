package oop.ex6.sjava_objects.blocks;

import oop.ex6.sjava_objects.SJavaException;

/**
 * thrown when the trying to declare a var with the same name in the same scope
 * @author Omri Kaplan and Asaf Etzion
 */
class VariableAlreadyExistException extends SJavaException {
    VariableAlreadyExistException(String message) {
        super(message);
    }
}
