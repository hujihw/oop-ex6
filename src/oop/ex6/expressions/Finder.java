package oop.ex6.expressions;

import oop.ex6.main.Manager;
import oop.ex6.sjava_objects.SJavaObject;
import oop.ex6.sjava_objects.blocks.MethodBlock;
import oop.ex6.sjava_objects.blocks.SuperBlock;
import oop.ex6.sjava_objects.variables.SuperVar;

/**
 * In charge of finding objects up the abstract syntax tree.
 * @author Omri Kaplan and Asaf Etzion
 */
class Finder {

    /* Methods */

    /**
     * Search for a method in the root block of the abstract compile tree.
     * @param methodName    The name of the method to find.
     * @return true if the object was found, false else.
     */
    private static boolean findMethod(String methodName) {
        return (Manager.getInstance().getMainBlock().getMethod(methodName) != null);
    }

    /**
     * Search for a variable in the current scope. If it wasn't found look up the abstract compile tree.
     * @param varName    The name of the variable to find.
     * @return true if the object was found, false else.
     */
    private static boolean findVar(String varName, SuperBlock currentBlock) {
        // todo if var was found in a parent (or a parent of a parent...) deep copy to local hash and return t
        SuperVar result = currentBlock.getVariable(varName);
        if (result == null) {
            while (currentBlock.getParent() != null) {
                currentBlock = currentBlock.getParent();
                result = currentBlock.getVariable(varName);
                if (result != null) {
//                    return result.getType();
                }
            }
        }

        return false;
    }
}
