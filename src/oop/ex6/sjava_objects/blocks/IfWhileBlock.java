package oop.ex6.sjava_objects.blocks;

import oop.ex6.expressions.Finder;
import oop.ex6.sjava_objects.SJavaException;
import oop.ex6.sjava_objects.variables.Type;

/**
 * represents an if or while block.
 * @author Omri Kaplan & Asaf Etzion
 */
public class IfWhileBlock extends SuperBlock {

    /* Data Members */
    private String parameters;

    /**
     * constructor that sets the name of the block (ifWhile) its parent block and its parameters.
     * @param parameters the boolean parameters
     * @throws SJavaException throws any SJavaException onwards
     */
    public IfWhileBlock(String parameters) throws SJavaException {
        super("ifWhile", null);
        this.parameters = parameters;
    }

    @Override
    public void setParent(SuperBlock parent) throws SJavaException {
        super.setParent(parent);
        checkParameters(parameters);
    }

    /**
     * checks that the parameters are boolean and follow the sjava protocol.
     * @param parameters the boolean parameters
     * @throws SJavaException throws any SJavaException onwards
     */
    private void checkParameters(String parameters) throws SJavaException {
        final String PARAMETERS_SEPARATOR = "\\s*(&&|\\|\\|)\\s*";
        final String VARIABLE_NAME = "[a-z_A-Z]\\w*";
        final String TRUE_FALSE = "(true|false)";

        String[] parametersArray = parameters.trim().split(PARAMETERS_SEPARATOR);
        for (String parameter : parametersArray) {
            if (parameter.matches(TRUE_FALSE)) {
                continue;
            } else if (parameter.matches(VARIABLE_NAME)) {
                Type parameterType = Finder.wasVarInitialized(parameter, this);
                if (!(parameterType.compareType(Type.BOOLEAN))) {
                    throw new WrongParametersException("Trying to initialize an If/While block with the wrong " +
                            "parameters");
                }
            } else if (!(Type.BOOLEAN.isValid(parameter))) {
                throw new WrongParametersException("Trying to initialize an If/While block with the wrong " +
                        "parameters");
            }
        }
    }
}
