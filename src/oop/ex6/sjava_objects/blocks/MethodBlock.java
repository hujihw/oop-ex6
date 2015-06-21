package oop.ex6.sjava_objects.blocks;

import oop.ex6.expressions.Finder;
import oop.ex6.main.Manager;
import oop.ex6.sjava_objects.variables.Type;
import oop.ex6.sjava_objects.variables.VarFactory;

import java.lang.reflect.Field;
import java.util.Scanner;

/**
 * @author Omri Kaplan
 */
public class MethodBlock extends SuperBlock {
    /* Data Members */
    // data member to hold the signature of the method (parameters by order)
    private Type[] parameters;
    private Scanner scanner;
    // todo array of parameter types ordered as the method declaration order.

    public MethodBlock(String name, String parameters) throws VariableAlreadyExistException { //todo check MainBlock is ok (was SuperBlock)
        super(name, Manager.getInstance().getMainBlock());
        System.out.println("Method created!");
        if (!parameters.equals("")){
            parametersToVariables(parameters);
        }
    }

    /**
     * Makes local variables out of the parameters given on declaration.
     * @param parameters    The parameters given on declaration.
     */
    private void parametersToVariables(String parameters) throws VariableAlreadyExistException {
        final String PARAMETER_SEPARATOR = "\\s*,\\s*";

        String[] parametersArray = parameters.split(PARAMETER_SEPARATOR);
//        Type[] signatureTypesArray = new Type[parametersArray.length];

        for (String parameter : parametersArray) {
            String[] typeAndName = parameter.split("\\s*");
            if (Finder.declareVar(typeAndName[1], this)){
                addVariable(typeAndName[0], VarFactory.produceVariable(typeAndName));
            } else {
                throw new VariableAlreadyExistException("Trying to declare an existing local variable.");
            }
        }
    }

    /**
     * Called to check validity of parameters on method call.
     * @param parameters    A string of the parameters
     * @return true if the parameters are valid, false if not.
     */
    public boolean checkParameters(String parameters) {
        final String PARAMETER_SEPARATOR = "\\s*,\\s*";


        return false;
    }

    /**
     * A getter to the scanner of the current method.
     * @return the scanner object of the method.
     */
    public Scanner getScanner() {
        return scanner;
    }

    /**
     * setter for the scanner data member
     * @param scanner the scanner to be set
     */
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    // todo method to compare parameters given, with parameters field.
}
