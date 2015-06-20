package oop.ex6.expressions;

/**
 * @author Omri Kaplan
 */
public class OmriExpDef {
    final String METHOD_NAME = "[a-zA-Z]\\w*";
    final String VARIABLE_NAME = "[a-z_A-Z]\\w*";
    final String VARIABLE_TYPE = "(int|double|String|boolean|char)";

    final String NUMBERS = "-?\\d+(\\.\\d+)?";

    final String LOOP_AND_CONDITION = "(if|while)";

    final String BOOLEAN_VARIABLE = "(" + NUMBERS + "|true|false|" + VARIABLE_NAME + ")";

    final String BOOLEAN_OPERATOR = "((" + BOOLEAN_VARIABLE + "\\s*(&&|\\|\\|)\\s*)+" + BOOLEAN_VARIABLE + ")";
    final String IF_OR_WHILE_PARAMETER = "(" + BOOLEAN_VARIABLE + "|" + BOOLEAN_OPERATOR + ")";
    final String IF_WHILE_DECLARATION = "\\s*" + LOOP_AND_CONDITION + "\\s*\\(\\s*" + IF_OR_WHILE_PARAMETER +
            "\\s*\\)\\s*\\{\\s*"; //done


    final String VARIABLE_VALUE = "(true|false|\".*\"|'.'|" + NUMBERS + "|" + VARIABLE_NAME + ")";//from Asaf


    final String CALL_METHOD = "\\s*" + METHOD_NAME + "\\s*\\(\\s*((" + VARIABLE_VALUE + "(\\s*,\\s*" + VARIABLE_VALUE + "\\s*)*" + ")|)\\)\\s*;\\s*"; //done

    final String ASSIGN_VARIABLE = "\\s*" + VARIABLE_NAME + "\\s*=\\s*" + VARIABLE_VALUE + "\\s*;\\s*"; //done
}
