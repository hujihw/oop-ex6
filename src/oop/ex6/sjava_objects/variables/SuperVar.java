package oop.ex6.sjava_objects.variables;

import oop.ex6.sjava_objects.SJavaObject;

/**
 * the super class of all of the variables
 * @author Omri Kaplan and Asaf Etzion
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

    /**
     * gets the type
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * sets the type
     * @param type the type to be set
     */
    void setType(Type type) {
        this.type = type;
    }

    /**
     * checks if var is final
     * @return true if so
     */
    public boolean isFinal() {
        return isFinal;
    }

    /**
     * sets the final flag
     * @param isFinal the boolean setting value
     */
    void setIsFinal(boolean isFinal) {
        this.isFinal = isFinal;
    }

    /**
     * checks if the var was initialized
     * @return true if so
     */
    public boolean wasInitialized() {
        return wasInitialized;
    }

    /**
     * sets the var to be initialized
     */
    public void setWasInitialized() {
        this.wasInitialized = true;
    }
}
