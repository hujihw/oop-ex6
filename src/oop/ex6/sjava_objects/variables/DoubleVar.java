package oop.ex6.sjava_objects.variables;

/**
 * Represents the type Double of the S-Java language.
 * @author Omri Kaplan and Asaf Etzion
 */
class DoubleVar extends SuperVar{
    DoubleVar(String name) {
        super(name);
        setType(Type.DOUBLE);
    }
}
