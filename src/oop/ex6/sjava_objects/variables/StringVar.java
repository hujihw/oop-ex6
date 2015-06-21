package oop.ex6.sjava_objects.variables;

/**
 * Represents the type String of the S-Java language.
 * @author Omri Kaplan
 */
public class StringVar extends SuperVar {
    public StringVar(String name) {
        super(name);
        setType(Type.STRING);
    }
}
