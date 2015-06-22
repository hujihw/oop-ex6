package oop.ex6.expressions;

import oop.ex6.sjava_objects.SJavaException;

/**
 * thrown when deviating from the Sjava protocol.
 * @author Omri Kaplan and Asaf Etzion
 */
class WrongProtocolDeclaration extends SJavaException{
    public WrongProtocolDeclaration(String message) {
        super(message);
    }
}
