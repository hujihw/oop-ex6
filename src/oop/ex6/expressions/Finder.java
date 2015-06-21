package oop.ex6.expressions;

import oop.ex6.main.Manager;
import oop.ex6.sjava_objects.blocks.BlockFactory;
import oop.ex6.sjava_objects.blocks.IllegalBlockException;
import oop.ex6.sjava_objects.blocks.MethodBlock;
import oop.ex6.sjava_objects.blocks.SuperBlock;
import oop.ex6.sjava_objects.variables.SuperVar;
import oop.ex6.sjava_objects.variables.Type;

/**
 * In charge of finding objects up the abstract syntax tree.
 * @author Omri Kaplan and Asaf Etzion
 */
public class Finder {

    /* Methods */

    /**
     * Search for a method in the root block of the abstract compile tree.
     * @param methodName    The name of the method to find.
     * @return true if the object was found, false else.
     */
    static boolean callMethod(String methodName, String parameters) {
        MethodBlock found = Manager.getInstance().getMainBlock().getMethod(methodName);
        //noinspection SimplifiableIfStatement
        if (found != null) {
            return found.checkParameters(parameters);
        } else {
            return false;
        }
    }

    /**
     * Look for the method in the methods hash table. If it does not exist, create it.
     * @param methodName    The method we want to declare.
     * @param parameters    The parameters of the method.
     * @return The new method block object if it was not exist, or null if it was.
     */
    static SuperBlock declareMethod(String methodName, String parameters) throws ObjectExistException, IllegalBlockException {
        MethodBlock found = Manager.getInstance().getMainBlock().getMethod(methodName);
        if (found == null) {
            return BlockFactory.produceBlock(methodName, parameters);
        } else {
            throw new ObjectExistException("Trying to create a method that already exist");
        }
    }

    /**
     * Search for a variable in the current scope. If it wasn't found look up the abstract compile tree.
     * @param varName    The name of the variable to find.
     * @return the Type of the variable if it was found, or null if it was not found.
     */
    public static Type assignVar(String varName, SuperBlock currentBlock) throws ObjectDoesNotExistException{
        SuperVar found = currentBlock.getVariable(varName);
        if (found == null) {
            SuperBlock currentParent = currentBlock;
            while (currentBlock.getParent() != null) {
                currentParent = currentParent.getParent();
                found = currentParent.getVariable(varName);
                if (found != null) {
                    break;
                }
            }
        }
        if (found != null) {
            SuperVar copiedVar = new SuperVar(found);
            currentBlock.addVariable(varName, copiedVar);
            return found.getType();
        } else {
            throw new ObjectDoesNotExistException("The variable does not exist");
        }
    }

    /**
     * Search for variable name when declaring a variable.
     * This method looks for the variable name, that was given as a parameter, in the current block's hash
     * table (the block is also given as a parameter). If the variable was found, declaration can not take
     * place.
     * @param varName         The name of the variable we want to declare.
     * @param currentBlock    The current block object we want to declare the variable in.
     * @return The variable Type (if it was found) or null else.
     */
    static boolean declareVar(String varName, SuperBlock currentBlock) {
        return currentBlock.getVariable(varName) == null;
    }
}
