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

    /**
     * The default constructor.
     * This constructor gives a name to the created variable.
     * @param name    The name of the new variable.
     */
    public SuperVar(String name) {
        super(name);
    }

    /**
     * A copy constructor.
     * This constructor copies an existing SuperVar.
     * @param superVar    The SuperVar object we want to copy.
     */
    public SuperVar(SuperVar superVar) {
        super(superVar.getName());
        this.isFinal = superVar.isFinal();
        this.wasInitialized = superVar.wasInitialized();
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

    public boolean wasInitialized() {
        return wasInitialized;
    }

    public void setWasInitialized() {
        this.wasInitialized = true;
    }
}
