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
    final String NUMBERS = "\\d+\\.*\\d*";
    final String NUMBERS_OR_NAME = "(" + NUMBERS + "|" + VARIABLE_NAME + ")";

    final String BOOLEAN_OPERATOR = "((" + NUMBERS_OR_NAME + "\\s*(&&|\\|\\|)\\s*)+" + NUMBERS_OR_NAME + ")";
    final String BOOLEAN_CONDITION = "(" + NUMBERS_OR_NAME + "|" + BOOLEAN_OPERATOR + ")";
    // todo check if seed to support both boolean parameters in one line.
    final String IF_WHILE_DECLARATION = "\\s*" + LOOP_AND_CONDITION + "\\s*\\(\\s*" + BOOLEAN_CONDITION +
            "\\s*\\)\\s*\\{\\s*";

    final String VARIABLE_DECLARATION = "\\s*" + VARIABLE_TYPE + "\\s+" + VARIABLE_NAME + "\\s*=\\s*(" +
            NUMBERS + "|\\S+)\\s*";

    final String CALL_METHOD = "\\s*" + METHOD_NAME + "\\s*\\(";
}
