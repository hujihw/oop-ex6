package oop.ex6.expressions;

import oop.ex6.sjava_objects.SJavaObject;
import oop.ex6.sjava_objects.blocks.IfBlock;
import oop.ex6.sjava_objects.blocks.SuperBlock;
import oop.ex6.sjava_objects.variables.IntVar;

import java.util.Random;
import java.util.regex.Pattern;

/**
 * Defines String expressions, and return corresponding S-Java objects.
 * @author Omri Kaplan
 */
public class ExpressionsDefiner {


    /* Data Members */

    /* Methods */

    /**
     * Define an S-Java expression, and do the appropriate task.
     * @param expression    The expression we want to define.
     * @return The object corresponding with the expression.
     */
    public static SJavaObject defineExpression(String expression, SuperBlock currentBlock) {
        final String METHOD_NAME = "[a-zA-Z]\\w*";
        final String VARIABLE_NAME = "[a-z_A-Z]\\w*";
        final String VARIABLE_TYPES = "int|double|String|boolean|char";
        final String VARIABLE_VALUE = ".+";

        // todo return null if object was found and no exception raised (calling a method, var assignment...).
        // method declaration block
        if (expression.matches("\\s*void\\s+\\w+\\s*\\(\\s*(((\\s*\\w+\\s+\\w+\\s*,\\s*)*(\\s*\\w+\\s+\\w+))|)\\s*\\)\\s*\\{\\s*")) {
// todo mail to jetbrains. regex auto width adjustment
        } else if (expression.matches("\\s*(if|while)\\s*\\(\\w\\)")) { // if/while block

        } else if (expression.matches("\\s*(if|while)\\s*\\(\\w\\)")) { // var type

        }
        return null;
    }

    /**
     * Defines a block creation expression.
     * @return The corresponding object to the expression received.
     */
    private static SJavaObject createBlock() { // todo add parameter.

        return null;
    }
}
