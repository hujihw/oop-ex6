package oop.ex6.sjava_objects.variables;

import oop.ex6.sjava_objects.SJavaObject;

/**
 * @author Omri Kaplan
 */
public class SuperVar extends SJavaObject{

    /* Data Members */
    private boolean isFinal = false;
    private boolean wasInitialized = false;
    private Type type;

    /* Constructors */
    public SuperVar(SuperVar superVar) {
        this.isFinal = superVar.isFinal();
        this.wasInitialized = superVar.isWasInitialized();
        this.type = superVar.getType();
    }

    /* Methods */

    public Type getType() {
        return type;
    }

    void setType(Type type) {
        this.type = type;
    }

    public boolean isFinal() {
        return isFinal;
    }

    void setIsFinal(boolean isFinal) {
        this.isFinal = isFinal;
    }

    public boolean isWasInitialized() {
        return wasInitialized;
    }

    public void setWasInitialized(boolean wasInitialized) {
        this.wasInitialized = wasInitialized;
    }
}
