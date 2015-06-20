package oop.ex6.expressions;

import oop.ex6.sjava_objects.SJavaException;
import oop.ex6.sjava_objects.SJavaObject;
import oop.ex6.sjava_objects.blocks.BlockFactory;
import oop.ex6.sjava_objects.blocks.SuperBlock;
import oop.ex6.sjava_objects.variables.Type;
import oop.ex6.sjava_objects.variables.VarFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Defines String expressions, and return corresponding S-Java objects.
 * @author Omri Kaplan & Asaf Etzion
 */
public class ExpressionsDefiner {

    /* data members */
    private static SuperBlock currentBlock;

    /* Methods */

    /**
     * Define an S-Java expression, and do the appropriate task.
     * @param expression    The expression we want to define.
     * @return The object corresponding with the expression.
     */
    public static SJavaObject defineExpression(String expression, SuperBlock theCurrentBlock) throws SJavaException{

        final String METHOD_NAME = "[a-zA-Z]\\w*";
        final String VARIABLE_NAME = "[a-z_A-Z]\\w*";
        final String VARIABLE_TYPE = "(final\\s+)?\\s*(int|double|String|boolean|char)";
        final String PARAMETER = VARIABLE_TYPE + "\\s+" + VARIABLE_NAME;
        final String NUMBERS = "-?\\d+(\\.\\d+)?";
        final String VARIABLE_VALUE_OR_NAME = "(true|false|\".*\"|'.'|" + NUMBERS + "|" + VARIABLE_NAME + ")";
        final String VARIABLE_NAME_WITH_ASSIGNMENT_OPTION = "((" + VARIABLE_NAME + ")(\\s*=\\s*" + VARIABLE_VALUE_OR_NAME +
                "\\s*)?)";
        final String LOOP_AND_CONDITION = "(if|while)";
        final String BOOLEAN_VARIABLE = "(" + NUMBERS + "|true|false|" + VARIABLE_NAME + ")";
        final String BOOLEAN_OPERATOR = "((" + BOOLEAN_VARIABLE + "\\s*(&&|\\|\\|)\\s*)+" + BOOLEAN_VARIABLE + ")";
        final String IF_OR_WHILE_PARAMETER = "(" + BOOLEAN_VARIABLE + "|" + BOOLEAN_OPERATOR + ")";


        final String IF_WHILE_DECLARATION = "\\A\\s*" + LOOP_AND_CONDITION + "\\s*\\(\\s*" + IF_OR_WHILE_PARAMETER +
                "\\s*\\)\\s*\\{\\s*\\z";

        final String METHOD_DECLARATION = "\\A\\s*void\\s+(" + METHOD_NAME + ")\\s*\\(\\s*(((\\s*" + PARAMETER +
                "\\s*,\\s*)*(\\s*" + PARAMETER + "\\s*))|)\\s*\\)\\s*\\{\\s*\\z";

        final String VARIABLE_DECLARATION = "\\A\\s*" + VARIABLE_TYPE + "\\s+" + VARIABLE_NAME_WITH_ASSIGNMENT_OPTION +
                "(\\s*,\\s*" + VARIABLE_NAME_WITH_ASSIGNMENT_OPTION + ")*\\s*;\\s*\\z";

        final String CALL_METHOD = "\\A\\s*(" + METHOD_NAME + ")\\s*\\(\\s*((" + VARIABLE_VALUE_OR_NAME + "(\\s*,\\s*" +
                VARIABLE_VALUE_OR_NAME + "\\s*)*" + ")|)\\)\\s*;\\s*\\z";

        final String ASSIGN_VARIABLE = "\\A\\s*(" + VARIABLE_NAME + ")\\s*=\\s*" + VARIABLE_VALUE_OR_NAME + "\\s*;\\s*\\z";

        Matcher ifWhileDeclaration = Pattern.compile(IF_WHILE_DECLARATION).matcher(expression);
        Matcher methodDeclaration = Pattern.compile(METHOD_DECLARATION).matcher(expression);
        Matcher callMethod = Pattern.compile(CALL_METHOD).matcher(expression);
        Matcher variableDeclaration = Pattern.compile(VARIABLE_DECLARATION).matcher(expression);
        Matcher assignVariable = Pattern.compile(ASSIGN_VARIABLE).matcher(expression);

        currentBlock = theCurrentBlock;

        if (ifWhileDeclaration.matches()) {
            if (currentBlock.getParent()==null) { //meaning this is the main block
                throw new WrongProtocolDeclaration("can't declare a loop in the main block");
            } else {
                SuperBlock loopBlock = BlockFactory.produceBlock("ifWhile", ifWhileDeclaration.group(2));
                loopBlock.setParent(currentBlock); //todo check
                return loopBlock;
            }
        } else if (methodDeclaration.matches()) {
            isReservedWordErrorCheck(methodDeclaration.group(1)); //todo add final support
            if (currentBlock.getParent()==null) { //meaning this is the main block
                return Finder.declareMethod(methodDeclaration.group(1),methodDeclaration.group(2));
            } else {
                throw new WrongProtocolDeclaration("can't declare a method in an inner block");
            }
        } else if (callMethod.matches()){
            isReservedWordErrorCheck(callMethod.group(1));
            if (currentBlock.getParent()==null) { //meaning this is the main block
                throw new WrongProtocolDeclaration("can't call a method in the main block");
            } else {
                Finder.callMethod(callMethod.group(1),callMethod.group(2));
                return null;
            }
        } else if (variableDeclaration.matches()){

            //todo add a more complex code for multiple vars

            isReservedWordErrorCheck(variableDeclaration.group(/*todo*/));
            if (Finder.declareVar(variableDeclaration.group(/*todo*/), currentBlock)){
                return VarFactory.produceVariable(new String[]{variableDeclaration.group(/*todo final+type*/),variableDeclaration.group(/*todo name*/),
                        variableDeclaration.group(/*todo value or var*/)});
            } else {
                throw new ObjectExistException("a variable with the same name already exists in the relevant scope");
            }
        } else if (assignVariable.matches()){
            assignVariableMethod(assignVariable.group(1), assignVariable.group(2));
            return null;
        } else {
            throw new SyntaxErrorException("the syntax doesn't follow the sjava protocol");
        }
    }

    private static void assignVariableMethod(String varName, String value) throws SJavaException{
        Type valueType = Finder.assignVar(value, currentBlock);
        isReservedWordErrorCheck(varName);
        Type varType = Finder.assignVar(varName, currentBlock);
        if (varType.isValid(value) || varType.compareType(valueType) ||
                (varType.getType().equals("double")&&valueType.getType().equals("int"))){
            return;
        } else {
            throw new WrongParameterTypeException("a different type of value was expected as a parameter");
        }
    }

    private static void isReservedWordErrorCheck(String word) throws SyntaxErrorException {
        final String RESERVED_WORDS = "int|double|boolean|char|String|void|final|if|while|true|false|return";
        if (word.trim().matches(RESERVED_WORDS)){
            throw new SyntaxErrorException("using the reserved words of sjava as a method or variable name accounts " +
                    "as a syntax error");
        }
    }
}
