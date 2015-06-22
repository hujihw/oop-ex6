package oop.ex6.sjava_objects;

/**
 * This is the super class of all of the S-Java language objects.
 * @author Omri Kaplan and Asaf Etzion
 */
public class SJavaObject {

    /* data members */
    private String name;


    /* Constructor */

    /**
     * constructs the Sjava object with its name
     * @param name the name of the sjava object
     */
    public SJavaObject(String name) {
        this.name = name;
    }

    /* methods */
    /**
     * a getter for the name member
     * @return the name of the SJavaObject
     */
    public String getName() {
        return name;
    }
}
