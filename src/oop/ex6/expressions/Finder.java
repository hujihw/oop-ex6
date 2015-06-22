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
     * @throws SJavaException throws any SJavaException onwards
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
     * @throws SJavaException throws any SJavaException onwards
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
     * @param varName The name of the variable to find.
     * @param currentBlock the current block
     * @return the variable if it was found.
     * @throws SJavaException throws any SJavaException onwards
     */
    public static Type assignVar(String varName, SuperBlock currentBlock) throws SJavaException{
        SuperVar found = currentBlock.getVariable(varName);
        if (found != null) {
            found.setWasInitialized();
            return found.getType();
        } else {
            found = findVarInOuterBlocks(varName, currentBlock);
            SuperVar copiedVar = new SuperVar(found);
            currentBlock.addVariable(varName, copiedVar);
            copiedVar.setWasInitialized();
            return copiedVar.getType();
        }
    }

    /**
     * determines if a variable exists and if it is local checks if it was initialized.
     * @param varName the name of the variable
     * @param currentBlock the current block
     * @return the type of the variable
     * @throws SJavaException throws any SJavaException onwards
     */
    public static Type wasVarInitialized(String varName, SuperBlock currentBlock) throws SJavaException {
        SuperVar found = currentBlock.getVariable(varName);
        if (found != null) {
            if (checkInitialization(found, currentBlock)){
                return found.getType();
            }
        } else {
            found = findVarInOuterBlocks(varName, currentBlock);
            if (checkInitialization(found, currentBlock)){
                return found.getType();
            }
        }
        throw new UnInitLocalVarException("A local variable wasn't initialized before he was used");
    }

    /**
     * searches for a variable in all of the outer blocks that it lives in.
     * @param varName the name of the variable
     * @param currentBlock the current block
     * @return the variable that he found
     * @throws ObjectDoesNotExistException
     */
    private static SuperVar findVarInOuterBlocks(String varName, SuperBlock currentBlock)
            throws ObjectDoesNotExistException {
        SuperBlock currentParent = currentBlock;
        while (currentParent.getParent() != null) {
            currentParent = currentParent.getParent();
            SuperVar variable = currentParent.getVariable(varName);
            if (variable != null) {
                    return variable;
            }
        }
        throw new ObjectDoesNotExistException("The variable doesn't exist");
    }

    /**
     * checks if the variable was initialized if it is local.
     * @param variable the variable that we are checking
     * @param currentBlock the relevant block
     * @return true if it was initialized, false otherwise
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
