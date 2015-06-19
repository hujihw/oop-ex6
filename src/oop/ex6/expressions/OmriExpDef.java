package oop.ex6.expressions;

/**
 * @author Omri Kaplan
 */
public class OmriExpDef {
    final String METHOD_NAME = "[a-zA-Z]\\w*";
    final String VARIABLE_NAME = "[a-z_A-Z]\\w*";
    final String VARIABLE_TYPE = "(int|double|String|boolean|char)";
    final String VARIABLE_VALUE = ".+";

    final String LOOP_AND_CONDITION = "(if|while)";
    final String NUMBERS = "\\d+(\\.\\d+)?";
    final String NUMBERS_OR_NAME = "(" + NUMBERS + "|" + VARIABLE_NAME + ")";

    final String BOOLEAN_OPERATOR = "((" + NUMBERS_OR_NAME + "\\s*(&&|\\|\\|)\\s*)+" + NUMBERS_OR_NAME + ")";
    final String IF_OR_WHILE_PARAMETER = "(" + NUMBERS_OR_NAME + "|" + BOOLEAN_OPERATOR + ")";
    final String IF_WHILE_DECLARATION = "\\s*" + LOOP_AND_CONDITION + "\\s*\\(\\s*" + IF_OR_WHILE_PARAMETER +
            "\\s*\\)\\s*\\{\\s*";

    final String VARIABLE_DECLARATION = "\\s*" + VARIABLE_TYPE + "\\s+" + VARIABLE_NAME + "\\s*=\\s*(" +
            NUMBERS + "|\\S+)\\s*";

    final String METHOD_PARAMETER = "((" + NUMBERS_OR_NAME + "|'.'|\".*\")\\s*)";
    final String COMMA_METHOD_PARAMETER = "(" + METHOD_PARAMETER + "\\s*,\\s*)*";

    final String CALL_METHOD = "\\s*" + METHOD_NAME + "\\s*\\(\\s*((" + COMMA_METHOD_PARAMETER + METHOD_PARAMETER + ")|)\\)\\s*;\\s*";
    final String ASSIGN_VARIABLE = ""; // todo
}
