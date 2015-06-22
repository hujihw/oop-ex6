package oop.ex6.sjava_objects.variables;

/**
 * Represents the type Char of the S-Java language.
 * @author Omri Kaplan and Asaf Etzion
 */
class CharVar extends SuperVar {
    CharVar(String name) {
        super(name);
        setType(Type.CHAR);
    }
}
