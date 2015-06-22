package oop.ex6.sjava_objects.variables;

/**
 * Represents the type String of the S-Java language.
 * @author Omri Kaplan and Asaf Etzion
 */
class StringVar extends SuperVar {
    StringVar(String name) {
        super(name);
        setType(Type.STRING);
    }
}
