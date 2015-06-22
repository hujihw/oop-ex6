package oop.ex6.sjava_objects.variables;

/**
 * Represents the type Integer of the S-Java language.
 * @author Omri Kaplan and Asaf Etzion
 */
class IntVar extends SuperVar {
    IntVar(String name) {
        super(name);
        setType(Type.INT);
    }
}
