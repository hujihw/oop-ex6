package oop.ex6.expressions;

import oop.ex6.sjava_objects.SJavaException;
import oop.ex6.sjava_objects.SJavaObject;
import oop.ex6.sjava_objects.blocks.BlockFactory;
import oop.ex6.sjava_objects.blocks.SuperBlock;
import oop.ex6.sjava_objects.variables.SuperVar;
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
    private static ExpressionsDefiner instance = new ExpressionsDefiner();
    private SuperBlock currentBlock;

    final String METHOD_NAME = "[a-zA-Z]\\w*";
    final String VARIABLE_NAME = "(([a-z_A-Z]\\w+)|[a-zA-Z])";
    final String VARIABLE_TYPE = "((final)\\s+)?\\s*(int|double|String|boolean|char)";
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

    final String VARIABLE_DECLARATION = "\\A\\s*" + VARIABLE_TYPE + "\\s+(" + VARIABLE_NAME_WITH_ASSIGNMENT_OPTION +
            "(\\s*,\\s*" + VARIABLE_NAME_WITH_ASSIGNMENT_OPTION + ")*)\\s*;\\s*\\z";

    final String CALL_METHOD = "\\A\\s*(" + METHOD_NAME + ")\\s*\\(\\s*((" + VARIABLE_VALUE_OR_NAME + "(\\s*,\\s*" +
            VARIABLE_VALUE_OR_NAME + "\\s*)*" + ")|)\\)\\s*;\\s*\\z";

    final String ASSIGN_VARIABLE = "\\A\\s*(" + VARIABLE_NAME + ")\\s*=\\s*" + VARIABLE_VALUE_OR_NAME + "\\s*;\\s*\\z";

    /* Methods */

    /**
     * The ExpressionsDefiner instance getter.
     * @return The only manager instance.
     */
    public static ExpressionsDefiner getInstance() {
        return instance;
    }

    /**
     * Define an S-Java expression, and do the appropriate task.
     * @param expression    The expression we want to define.
     * @param theCurrentBlock the block in which the expression was given
     * @return The object corresponding with the expression.
     * @throws SJavaException throws any SJavaException onwards.
     */
    public SJavaObject[] defineExpression(String expression, SuperBlock theCurrentBlock) throws SJavaException{

        Matcher ifWhileDeclaration = Pattern.compile(IF_WHILE_DECLARATION).matcher(expression);
        Matcher methodDeclaration = Pattern.compile(METHOD_DECLARATION).matcher(expression);
        Matcher callMethod = Pattern.compile(CALL_METHOD).matcher(expression);
        Matcher variableDeclaration = Pattern.compile(VARIABLE_DECLARATION).matcher(expression);
        Matcher assignVariable = Pattern.compile(ASSIGN_VARIABLE).matcher(expression);

        currentBlock = theCurrentBlock;
        //todo check no white spaces in groups!


        if (ifWhileDeclaration.matches()) {
            if (currentBlock.getParent()==null) { //meaning this is the main block
                throw new WrongProtocolDeclaration("can't declare a loop in the main block");
            } else {
                SuperBlock loopBlock = BlockFactory.produceBlock("ifWhile", ifWhileDeclaration.group(2));
                if (loopBlock != null) {
                    loopBlock.setParent(currentBlock);
                }
                return new SJavaObject[]{loopBlock};
            }
        } else if (methodDeclaration.matches()) {
            isReservedWordErrorCheck(methodDeclaration.group(1));
            if (currentBlock.getParent()==null) { //meaning this is the main block
                return new SJavaObject[]{Finder.declareMethod(methodDeclaration.group(1),methodDeclaration.group(2))};
            } else {
                throw new WrongProtocolDeclaration("can't declare a method in an inner block");
            }
        } else if (callMethod.matches()){
            if (currentBlock.getParent()==null) { //meaning this is the main block
                throw new WrongProtocolDeclaration("can't call a method in the main block");
            } else {
                Finder.callMethod(callMethod.group(1),callMethod.group(2));
                return null;
            }
        } else if (variableDeclaration.matches()){
            String varType = variableDeclaration.group(3);
            String finalFlag = variableDeclaration.group(2);
            final String commaWithSpaces = "\\s*,\\s*";
            String[] variablesAndAssignment = variableDeclaration.group(4).trim().split(commaWithSpaces);
            return variablesDeclarationMethod(finalFlag, varType, variablesAndAssignment);

        } else if (assignVariable.matches()){
            assignVariableMethod(assignVariable.group(1), assignVariable.group(2));
            return null;
        } else {
            throw new SyntaxErrorException("the syntax doesn't follow the sjava protocol");
        }
    }

    /**
     * declares all of the variables in the current expression, assigns the variable if needed.
     * @param varType the type of all of the declared variables. can have final prefix.
     * @param variablesAndAssignment the string that includes all of the variable names and assignments.
     * @return an array of the variables created.
     * @throws SJavaException throws any SJavaException onwards.
     */
    private SJavaObject[] variablesDeclarationMethod(String finalFlag, String varType, String[] variablesAndAssignment)
            throws SJavaException{
        SJavaObject[] variablesToReturn = new SJavaObject[variablesAndAssignment.length];
        final String variableAndAssignmentRegEx = "\\A(" + VARIABLE_NAME + ")\\s*=\\s*" + VARIABLE_VALUE_OR_NAME +
                "\\z";
        Pattern variableAndAssignmentPattern = Pattern.compile(variableAndAssignmentRegEx);
        int i = 0;
        for (String varAndAssignment: variablesAndAssignment){
            String varName, assignValue = null;
            Matcher varAndAssignmentMatcher = variableAndAssignmentPattern.matcher(varAndAssignment);
            if (varAndAssignmentMatcher.matches()){
                varName = varAndAssignmentMatcher.group(1);
                assignValue = varAndAssignmentMatcher.group(2);
            } else {
                varName = varAndAssignment.trim();
            }
            isReservedWordErrorCheck(varName);
            if (Finder.declareVar(varName, currentBlock)) {
                SuperVar variable;
                if (finalFlag != null) {
                    if (assignValue == null) { // todo tested, remove this message after submission
                        throw new WrongParameterTypeException("Declaring a final var without assignment");
                    }
                    variable = VarFactory.produceVariable(new String[]{finalFlag, varType, varName});
                } else {
                    variable = VarFactory.produceVariable(new String[]{varType, varName});
                }
                if (assignValue != null){
                    assignVariableMethod(variable, assignValue);
                }
                variablesToReturn[i] = variable;
            } else {
                throw new ObjectExistException("a variable with the same name already exists in the relevant " +
                        "scope");
            }
            i++;
        }
        return variablesToReturn;
    }

    /**
     * assigns a single variable.
     * @param varName the name of the variable
     * @param value the value to assign
     * @throws SJavaException throws any SJavaException onwards
     */
    private void assignVariableMethod(String varName, String value) throws SJavaException{
        Type varType = Finder.assignVar(varName, currentBlock);
        assignVariableMethodHelper(varType, value);
    }

    /**
     * assigns a single variable.
     * @param variable the variable
     * @param value the value to assign
     * @throws SJavaException throws any SJavaException onwards
     */
    private void assignVariableMethod(SuperVar variable, String value) throws SJavaException{
        variable.setWasInitialized();
        Type varType = variable.getType();
        assignVariableMethodHelper(varType, value);
    }

    /**
     * completes the variable assigning procedure.
     * @param varType the type of the var
     * @param value the value to assign
     * @throws SJavaException throws any SJavaException onwards
     */
    private void assignVariableMethodHelper(Type varType, String value) throws SJavaException {
        if (varType.isValid(value)){
            return;
        }
        if (value.matches(VARIABLE_NAME)) {
            Type valueType = Finder.wasVarInitialized(value, currentBlock);
            if (varType.compareType(valueType) ||
                    (varType.getType().equals("double") && valueType.getType().equals("int"))) {
                return; // for readability
            }
        }
        throw new WrongParameterTypeException("a different type of value was expected as a parameter");
    }

    /**
     * checks if the method or variable name is a reserved sjava word
     * @param word the word to check
     * @throws SyntaxErrorException throws any SJavaException onwards.
     */
    private void isReservedWordErrorCheck(String word) throws SyntaxErrorException {
        final String RESERVED_WORDS = "int|double|boolean|char|String|void|final|if|while|true|false|return";
        if (word.trim().matches(RESERVED_WORDS)){
            throw new SyntaxErrorException("using the reserved words of sjava as a method or variable name accounts " +
                    "as a syntax error");
        }
    }
}
