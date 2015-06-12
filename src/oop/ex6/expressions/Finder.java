package oop.ex6.expressions;

import oop.ex6.sjava_objects.SJavaObject;
import oop.ex6.sjava_objects.blocks.MethodBlock;

/**
 * @author Omri Kaplan and Asaf Etzion
 */
class Finder {

    /**
     * Searching for an object in the local scope. If it wasn't found, search up the abstract compile tree.
     * @param object    The object to find.
     * @return true if the object was found, false else.
     */
    boolean findObject(SJavaObject object) {

        return false;
    }

    /**
     * Search for a method in the root block of the abstract compile tree.
     * @param method    The method to find.
     * @return true if the object was found, false else.
     */
    boolean findMethod(MethodBlock method) {

        return false;
    }

    /**
     * Search for a variable in the current scope. If it wasn't found look up the abstract compile tree.
     * @param var    The method to find. // todo add a var parameter according to var package structure.
     * @return true if the object was found, false else.
     */
    boolean findVar() {

        return false;
    }
}
