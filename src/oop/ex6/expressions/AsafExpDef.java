package oop.ex6.expressions;

import java.util.Scanner;

/**
 * @author Asaf Etzion
 */
public class AsafExpDef {

    final String METHOD_NAME = "[a-zA-Z]\\w*";
    final String VARIABLE_NAME = "[a-z_A-Z]\\w*";


    final String VARIABLE_TYPE = "(final\\s+)?\\s*(int|double|String|boolean|char)";
    final String PARAMETER = VARIABLE_TYPE + "\\s+" + VARIABLE_NAME;
    final String NUMBERS = "-?\\d+(\\.\\d+)?";
    final String VARIABLE_VALUE = "(true|false|\".*\"|'.'|" + NUMBERS + "|" + VARIABLE_NAME + ")"; //todo true and false are redundant
    final String VARIABLE_NAME_WITH_ASSINMENT_OPTION = "(" + VARIABLE_NAME + "(\\s*=\\s*" + VARIABLE_VALUE + "\\s*)?)";

    final String METHOD_DECLARATION = "\\s*void\\s+" + METHOD_NAME + "\\s*\\(\\s*(((\\s*" + PARAMETER + "\\s*,\\s*)*(\\s*" + PARAMETER + "\\s*))|)\\s*\\)\\s*\\{\\s*";

    final String VARIABLE_DECLARATION = "\\s*" + VARIABLE_TYPE + "\\s+" + VARIABLE_NAME_WITH_ASSINMENT_OPTION + "(\\s*,\\s*" + VARIABLE_NAME_WITH_ASSINMENT_OPTION + ")*\\s*;\\s*";

}
