package oop.ex6.expressions;

import java.util.Scanner;

/**
 * @author Omri Kaplan
 */
public class AsafExpDef {

    final String METHOD_NAME = "[a-zA-Z]\\w*";
    final String VARIABLE_NAME = "[a-z_A-Z]\\w*";


    final String VARIABLE_TYPE = "(final\\s+)?\\s*(int|double|String|boolean|char)";
    final String PARAMETER = VARIABLE_TYPE + "\\s+" + VARIABLE_NAME;
    final String NUMBERS = "-?\\d+(\\.\\d+)?";
    final String VARIABLE_VALUE = "(true|false|\".*\"|'.'|" + NUMBERS + ")";


    final String METHOD_DECLARAATION = "\\s*void\\s+" + METHOD_NAME + "\\s*\\(\\s*(((\\s*" + PARAMETER + "\\s*,\\s*)*(\\s*" + PARAMETER + "\\s*))|)\\s*\\)\\s*\\{\\s*";

    final String VARIABLE_DECLARATION = VARIABLE_TYPE + "\\s+(" + VARIABLE_NAME + "(\\s*=)?)";

    //final String VARIABLE_DECLARATION2 = "\\s*" + VARIABLE_TYPE + "\\s+" + VARIABLE_NAME + "\\s*=\\s*(" +
          //  NUMBERS + "|\\S+)\\s*";
}
