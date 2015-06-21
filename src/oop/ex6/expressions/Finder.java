package oop.ex6.expressions;

import oop.ex6.main.Manager;
import oop.ex6.sjava_objects.SJavaException;
import oop.ex6.sjava_objects.blocks.BlockFactory;
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
    static boolean callMethod(String methodName, String parameters) throws SJavaException {
        MethodBlock found = Manager.getInstance().getMainBlock().getMethod(methodName);
        return (found != null) && found.checkParameters(parameters);
    }

    /**
     * Look for the method in the methods hash table. If it does not exist, create it.
     * @param methodName    The method we want to declare.
     * @param parameters    The parameters of the method.
     * @return The new method block object if it was not exist, or null if it was.
     */
    static SuperBlock declareMethod(String methodName, String parameters) throws SJavaException {
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
    public static SuperVar assignVar(String varName, SuperBlock currentBlock) throws ObjectDoesNotExistException{
        SuperVar found = currentBlock.getVariable(varName);
        if (found != null) {
            return found;
        } else {
            SuperBlock currentParent = currentBlock;
            while (currentParent.getParent() != null) {
                currentParent = currentParent.getParent();
                found = currentParent.getVariable(varName);
                if (found != null) {
                    SuperVar copiedVar = new SuperVar(found);
                    currentBlock.addVariable(varName, copiedVar);
                    return copiedVar;
                }
            }
        }

        throw new ObjectDoesNotExistException("The variable does not exist");
    }

    public static Type wasVarInitialized(String varName, SuperBlock currentBlock) throws ObjectDoesNotExistException {
        SuperVar found = currentBlock.getVariable(varName);
        if (found != null) {
            if (checkInitialization(found, currentBlock)){
                return found.getType();
            }
        } else {
            SuperBlock currentParent = currentBlock;
            while (currentBlock.getParent() != null) {
                currentParent = currentParent.getParent();
                found = currentParent.getVariable(varName);
                if (found != null) {

                }

            }
        }
        return null; //todo remove
    }

    /**
     *
     * @param variable
     * @param currentBlock
     * @return
     */
    private static boolean checkInitialization(SuperVar variable, SuperBlock currentBlock){
        if (currentBlock.getParent() != null){ // this is a local variable
            if (variable.wasInitialized()){
                return true;
            }
        }
        return false;
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
    public static boolean declareVar(String varName, SuperBlock currentBlock) {
        return currentBlock.getVariable(varName) == null;
    }
}
