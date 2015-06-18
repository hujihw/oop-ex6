package oop.ex6.sjava_objects.blocks;

import java.util.Scanner;

/**
 * @author Omri Kaplan
 */
public class MethodBlock extends SuperBlock {
    /* Data Members */
    // data member to hold the signature of the method (parameters by order)
    private Scanner scanner;

    public MethodBlock(MainBlock parent) { //todo check MainBlock is ok (was SuperBlock)
        super(parent);
    }

    /**
     * Called to check validity of parameters on method call.
     * @param parameters    A string of the parameters
     * @return true if the parameters are valid, false if not.
     */
    public boolean checkParameters(String parameters) {
        // todo split the parameters. check validity.
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
}
