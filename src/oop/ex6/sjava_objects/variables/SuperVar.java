package oop.ex6.sjava_objects.variables;

/**
 * @author Omri Kaplan
 */
public abstract class SuperVar {

    /* Data Members */
    private boolean isFinal = false;
    private boolean wasInitialized = false;
    private Type type;

    /* Constructors */

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
