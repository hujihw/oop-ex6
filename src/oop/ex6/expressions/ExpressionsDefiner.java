package oop.ex6.expressions;

import oop.ex6.sjava_objects.SJavaException;
import oop.ex6.sjava_objects.SJavaObject;
import oop.ex6.sjava_objects.blocks.BlockFactory;
import oop.ex6.sjava_objects.blocks.IfBlock;
import oop.ex6.sjava_objects.blocks.SuperBlock;
import oop.ex6.sjava_objects.variables.IntVar;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Defines String expressions, and return corresponding S-Java objects.
 * @author Omri Kaplan & Asaf Etzion
 */
public class ExpressionsDefiner {


    /* Data Members */



    /* Methods */

    /**
     * Define an S-Java expression, and do the appropriate task.
     * @param expression    The expression we want to define.
     * @return The object corresponding with the expression.
     */
    public static SJavaObject defineExpression(String expression, SuperBlock currentBlock) throws SJavaException{

        final String METHOD_NAME = "[a-zA-Z]\\w*";
        final String VARIABLE_NAME = "[a-z_A-Z]\\w*";
        final String VARIABLE_TYPE = "(final\\s+)?\\s*(int|double|String|boolean|char)";
        final String PARAMETER = VARIABLE_TYPE + "\\s+" + VARIABLE_NAME;
        final String NUMBERS = "-?\\d+(\\.\\d+)?";
        final String VARIABLE_VALUE = "(true|false|\".*\"|'.'|" + NUMBERS + "|" + VARIABLE_NAME + ")";
        final String VARIABLE_NAME_WITH_ASSIGNMENT_OPTION = "(" + VARIABLE_NAME + "(\\s*=\\s*" + VARIABLE_VALUE +
                "\\s*)?)";
        final String LOOP_AND_CONDITION = "(if|while)";
        final String BOOLEAN_VARIABLE = "(" + NUMBERS + "|true|false|" + VARIABLE_NAME + ")";
        final String BOOLEAN_OPERATOR = "((" + BOOLEAN_VARIABLE + "\\s*(&&|\\|\\|)\\s*)+" + BOOLEAN_VARIABLE + ")";
        final String IF_OR_WHILE_PARAMETER = "(" + BOOLEAN_VARIABLE + "|" + BOOLEAN_OPERATOR + ")";


        final String IF_WHILE_DECLARATION = "\\s*" + LOOP_AND_CONDITION + "\\s*\\(\\s*" + IF_OR_WHILE_PARAMETER +
                "\\s*\\)\\s*\\{\\s*";

        final String METHOD_DECLARATION = "\\s*void\\s+" + METHOD_NAME + "\\s*\\(\\s*(((\\s*" + PARAMETER +
                "\\s*,\\s*)*(\\s*" + PARAMETER + "\\s*))|)\\s*\\)\\s*\\{\\s*";

        final String VARIABLE_DECLARATION = "\\s*" + VARIABLE_TYPE + "\\s+" + VARIABLE_NAME_WITH_ASSIGNMENT_OPTION +
                "(\\s*,\\s*" + VARIABLE_NAME_WITH_ASSIGNMENT_OPTION + ")*\\s*;\\s*";

        final String CALL_METHOD = "\\s*" + METHOD_NAME + "\\s*\\(\\s*((" + VARIABLE_VALUE + "(\\s*,\\s*" +
                VARIABLE_VALUE + "\\s*)*" + ")|)\\)\\s*;\\s*";

        final String ASSIGN_VARIABLE = "\\s*" + VARIABLE_NAME + "\\s*=\\s*" + VARIABLE_VALUE + "\\s*;\\s*";

        Matcher ifWhileDeclaration = Pattern.compile(IF_WHILE_DECLARATION).matcher(expression);
        Matcher methodDeclaration = Pattern.compile(METHOD_DECLARATION).matcher(expression);
        Matcher callMethod = Pattern.compile(CALL_METHOD).matcher(expression);
        Matcher variableDeclaration = Pattern.compile(VARIABLE_DECLARATION).matcher(expression);
        Matcher assignVariable = Pattern.compile(ASSIGN_VARIABLE).matcher(expression);

        // todo return null if object was found and no exception raised (calling a method, var assignment...).
        // todo subtract reserved words with regex!

        if (ifWhileDeclaration.matches()) {
            if (currentBlock.getParent()==null) { //meaning this is the main block
                throw new WrongProtocolDeclaration("can't declare a loop in the main lock");
            } else {
                return BlockFactory.produceBlock(new String[]{"ifWhile",ifWhileDeclaration.group(2)});
            }
        } else if (methodDeclaration.matches()) {
            if (currentBlock.getParent()==null) { //meaning this is the main block

            } else {
                throw new WrongProtocolDeclaration("can't declare a method in an inner block");
            }
        } else if (callMethod.matches()){
            if (currentBlock.getParent()==null) { //meaning this is the main block

            } else {

            }
        } else if (variableDeclaration.matches()){

        } else if (assignVariable.matches()){

        }

        return null;//todo change
    }

    /**
     * Defines a block creation expression.
     * @return The corresponding object to the expression received.
     */
    private static SJavaObject createBlock() { // todo add parameter.

        return null;
    }
}
