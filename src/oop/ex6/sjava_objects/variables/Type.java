package oop.ex6.sjava_objects.variables;

/**
 * Represents the available variables types.
 * @author Omri Kaplan & Asaf Etzion
 */
public enum Type {
    BOOLEAN ("boolean", "true|false|-?\\d+(\\.\\d+)?"),
    CHAR ("char", "('.')"),
    DOUBLE ("double", "-?\\d+(\\.\\d+)?"),
    INT ("int", "-?\\d+"),
    STRING ("String", "\".*\"");

    private final String type;
    private final String regex;

    /**
     * constructs the enum by the inputted type
     * @param type the type of the enum
     * */
    Type(String type, String regex) {
         this.type = type;
         this.regex = regex;
    }

    /**
     * checks if the type of the value is the same as the type of the enum
     * @param value the value to be checked
     * @return true if they are the same type. false otherwise
     */
    public boolean isValid(String value){
        return value.matches(regex);
    }

    /**
     * a getter for the type field
     * @return the type field
     */
    public String getType() {
        return type;
    }

    /**
     * compares the two enums type.
     * @param varType the second enum to be compared with
     * @return true if the share the same type, false otherwise
     */
    public boolean compareType(Type varType) {
        return this.type.equals(varType.getType());
    }
}
