package oop.ex6.expressions;

import oop.ex6.sjava_objects.SJavaObject;
import oop.ex6.sjava_objects.blocks.MethodBlock;
import oop.ex6.sjava_objects.variables.SuperVar;

/**
 * In charge of finding objects up the abstract syntax tree.
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
    private boolean findMethod(MethodBlock method) {

        return false;
    }

    /**
     * Search for a variable in the current scope. If it wasn't found look up the abstract compile tree.
     * @param var    The method to find. // todo add a var parameter according to var package structure.
     * @return true if the object was found, false else.
     */
    private boolean findVar(SuperVar var) {
        // todo if var was found in a parent (or a parent of a parent...) deep copy to local hash and return t
        return false;
    }
}
