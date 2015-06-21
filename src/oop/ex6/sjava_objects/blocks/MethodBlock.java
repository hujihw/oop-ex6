package oop.ex6.sjava_objects.blocks;

import oop.ex6.expressions.Finder;
import oop.ex6.main.Manager;
import oop.ex6.sjava_objects.SJavaException;
import oop.ex6.sjava_objects.variables.Type;
import oop.ex6.sjava_objects.variables.VarFactory;
import java.util.Scanner;

/**
 * @author Omri Kaplan
 */
public class MethodBlock extends SuperBlock {
    /* Data Members */
    // data member to hold the signature of the method (parameters by order)
    private Type[] parameterTypes;
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
        this.parameterTypes = new Type[parametersArray.length];

        for (int i = 0; i < parametersArray.length; i++) {
            String parameter = parametersArray[i];
            String[] typeAndName = parameter.split("\\s*");
            if (Finder.declareVar(typeAndName[1], this)) {
                addVariable(typeAndName[0], VarFactory.produceVariable(typeAndName));
                this.parameterTypes[i] = getVariable(typeAndName[1]).getType();
            } else {
                throw new VariableAlreadyExistException("Trying to declare an existing local variable.");
            }
        }
    }

    /**
     * Called to check validity of parameters on method call.
     * @param parameters    A string of the parameters
     */
    public boolean checkParameters(String parameters) throws SJavaException {
        final String PARAMETER_SEPARATOR = "\\s*,\\s*";
        final String VAR_NAME = "";

        String[] givenParameters = parameters.trim().split(PARAMETER_SEPARATOR);
        if (givenParameters.length == this.parameterTypes.length){
            for (int i = 0; i < givenParameters.length; i++) {
                if (givenParameters[i].matches(VAR_NAME)){
                    this.parameterTypes[i].compareType(Finder.assignVar(givenParameters[i], this));
                } else {
                    this.parameterTypes[i].isValid(givenParameters[i]);
                }
            }
        }
        return true;
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
