package oop.ex6.expressions;

/**
 * @author Omri Kaplan
 */
public class AsafExpDef {

    final String METHOD_NAME = "[a-zA-Z]\\w*";
    final String VARIABLE_NAME = "[a-z_A-Z]\\w*";
    final String VARIABLE_TYPE = "(final\\s+)?\\s*(int|double|String|boolean|char)";
    final String VARIABLE_VALUE = ".+";


    final String PARAMETER = "\\s*"+VARIABLE_TYPE+"\\s+"+VARIABLE_NAME+"\\s*";

    final String METHOD_DECLARAATION = "\\s*void\\s+"+METHOD_NAME+"\\s*\\(\\s*((("+PARAMETER+",\\s*)*("+PARAMETER+"))|)\\s*\\)\\s*\\{\\s*";

    final String VARIABLE_DECLARATION = VARIABLE_TYPE+"\\s+"; //todo add decelare or and init- w/ multiple vars
}
