package oop.ex6.sjava_objects.blocks;

import oop.ex6.expressions.Finder;
import oop.ex6.sjava_objects.SJavaException;

/**
 * @author Omri Kaplan
 */
public class IfWhileBlock extends SuperBlock {
    public IfWhileBlock(String parameters) throws SJavaException {
        super(null);
        checkParameters(parameters);
    }

    private void checkParameters(String parameters) throws SJavaException { //todo
        final String PARAMETERS_SEPARATOR = "\\s*(&&|\\|\\|)\\s*";
        final String VARIABLE_NAME = "";
        final String TRUE_FALSE = "";
        final String NUMBERS = "";

        String[] parametersArray = parameters.trim().split(PARAMETERS_SEPARATOR);
        for (String parameter : parametersArray) {
            if (parameter.matches(NUMBERS)) {

            } else if (parameter.matches(TRUE_FALSE)) {

            } else if (parameter.matches(VARIABLE_NAME)) {
                Finder.assignVar(parameter, this);

            }
        }
//        throw new WrongParametersException("Trying to initialize an If/While block with the wrong " +
//                "parameters");
    }
}
