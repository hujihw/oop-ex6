package oop.ex6.sjava_objects.blocks;

/**
 * @author Omri Kaplan
 */
public class MethodBlock extends SuperBlock {
    /* Data Members */
    // data member to hold the signature of the method (parameters by order)

    public MethodBlock(SuperBlock parent) {
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
}
