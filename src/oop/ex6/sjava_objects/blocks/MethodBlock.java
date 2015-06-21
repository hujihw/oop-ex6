package oop.ex6.sjava_objects.blocks;

import oop.ex6.main.Manager;
import oop.ex6.sjava_objects.variables.Type;

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

    public MethodBlock(String name, String parameters) { //todo check MainBlock is ok (was SuperBlock)
        super(name, Manager.getInstance().getMainBlock());
        System.out.println("Method created!");

    }

    public void parametersToArray(String parameters) {
        final String PARAMETER_SEPARATOR = "\\s*,\\s*";

//        parameters =
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
