package oop.ex6.sjava_objects;

/**
 * todo
 *  @author Omri Kaplan & Asaf Etzion
 */
public class SJavaObject {

    /* data members */
    private String name;

    /* Constructor */
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
