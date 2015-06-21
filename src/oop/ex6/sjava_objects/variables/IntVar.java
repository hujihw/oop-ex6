package oop.ex6.sjava_objects.variables;

/**
 * Represents the type Integer of the S-Java language.
 * @author Omri Kaplan
 */
public class IntVar extends SuperVar {
    public IntVar(String name) {
        super(name);
        setType(Type.INT);
    }
}
