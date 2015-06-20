package oop.ex6.expressions;

import oop.ex6.sjava_objects.SJavaException;

/**
 * Created by Asaf on 20/06/2015.
 */
class WrongProtocolDeclaration extends SJavaException{
    public WrongProtocolDeclaration(String message) {
        super(message);
    }
}
