package oop.ex6.expressions;


/**
 * @author Asaf Etzion
 */
public class AsafExpDef {

    final String METHOD_NAME = "[a-zA-Z]\\w*";
    final String VARIABLE_NAME = "[a-z_A-Z]\\w*";

    final String VARIABLE_TYPE = "(final\\s+)?\\s*(int|double|String|boolean|char)";
    final String PARAMETER = VARIABLE_TYPE + "\\s+" + VARIABLE_NAME;
    final String NUMBERS = "-?\\d+(\\.\\d+)?";
    final String VARIABLE_VALUE = "(true|false|\".*\"|'.'|" + NUMBERS + "|" + VARIABLE_NAME + ")";
    final String VARIABLE_NAME_WITH_ASSIGNMENT_OPTION = "(" + VARIABLE_NAME + "(\\s*=\\s*" + VARIABLE_VALUE + "\\s*)?)";


    final String LOOP_AND_CONDITION = "(if|while)";

    final String BOOLEAN_VARIABLE = "(" + NUMBERS + "|true|false|" + VARIABLE_NAME + ")";

    final String BOOLEAN_OPERATOR = "((" + BOOLEAN_VARIABLE + "\\s*(&&|\\|\\|)\\s*)+" + BOOLEAN_VARIABLE + ")";
    final String IF_OR_WHILE_PARAMETER = "(" + BOOLEAN_VARIABLE + "|" + BOOLEAN_OPERATOR + ")";

    final String IF_WHILE_DECLARATION = "\\s*" + LOOP_AND_CONDITION + "\\s*\\(\\s*" + IF_OR_WHILE_PARAMETER +
            "\\s*\\)\\s*\\{\\s*";


    final String METHOD_DECLARATION = "\\s*void\\s+" + METHOD_NAME + "\\s*\\(\\s*(((\\s*" + PARAMETER + "\\s*,\\s*)*(\\s*" + PARAMETER + "\\s*))|)\\s*\\)\\s*\\{\\s*";

    final String VARIABLE_DECLARATION = "\\s*" + VARIABLE_TYPE + "\\s+" + VARIABLE_NAME_WITH_ASSIGNMENT_OPTION + "(\\s*,\\s*" + VARIABLE_NAME_WITH_ASSIGNMENT_OPTION + ")*\\s*;\\s*";

    final String CALL_METHOD = "\\s*" + METHOD_NAME + "\\s*\\(\\s*((" + VARIABLE_VALUE + "(\\s*,\\s*" + VARIABLE_VALUE + "\\s*)*" + ")|)\\)\\s*;\\s*";

    final String ASSIGN_VARIABLE = "\\s*" + VARIABLE_NAME + "\\s*=\\s*" + VARIABLE_VALUE + "\\s*;\\s*";

}
