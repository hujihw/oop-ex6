package oop.ex6.sjava_objects.variables;

/**
 * Represents the type Double of the S-Java language.
 * @author Omri Kaplan and Asaf Etzion
 */
class BooleanVar extends SuperVar{
    BooleanVar(String name) {
        super(name);
        this.setType(Type.BOOLEAN);
    }
}
