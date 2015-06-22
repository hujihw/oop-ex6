package oop.ex6.sjava_objects.variables;

import oop.ex6.sjava_objects.SJavaException;

import java.util.Arrays;

/**
 * creates the different variables
 * @author Omri Kaplan and Asaf Etzion
 */
public class VarFactory {

    /**
     *
     * @param typeAndName the wanted type and name of the var
     * @return the variable object created
     * @throws SJavaException throws any SJavaException onwards
     */
    public static SuperVar produceVariable(String[] typeAndName) throws SJavaException {
        switch (typeAndName[0]){
            case "boolean":
                return new BooleanVar(typeAndName[1]);
            case "char":
                return new CharVar(typeAndName[1]);
            case "double":
                return new DoubleVar(typeAndName[1]);
            case "int":
                return new IntVar(typeAndName[1]);
            case "String":
                return new StringVar(typeAndName[1]);
            case "final":
                return new FinalDecorator(Arrays.copyOfRange(typeAndName, 1, typeAndName.length));
            default:
                throw new IllegalVarException("Trying to create a variable of an unrecognized type");
        }
    }
}
