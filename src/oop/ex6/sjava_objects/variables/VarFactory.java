package oop.ex6.sjava_objects.variables;

import java.util.Arrays;

/**
 * @author Omri Kaplan
 */
public class VarFactory {
    public static SuperVar produceVariable(String[] typeAndName) throws IllegalVarException {
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
