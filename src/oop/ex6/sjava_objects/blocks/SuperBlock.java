package oop.ex6.sjava_objects.blocks;

import oop.ex6.sjava_objects.SJavaObject;
import oop.ex6.sjava_objects.variables.SuperVar;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * //todo
 * @author Omri Kaplan & Asaf Eztion
 */
public abstract class SuperBlock extends SJavaObject {

    /* Data Members */
    private Hashtable<String, SuperVar> variables;
    private SuperBlock parent;

    /* Constructors */

    /**
     * Initializes the parent of the new block.
     * @param parent    The block parent of the new block.
     */
    public SuperBlock(SuperBlock parent) {
        this.parent = parent;
    }

    /* methods */

    /**
     * delegates the putt method to the variables hash table
     * @param key the name of the variable
     * @param value the variable object
     */
    public void addVariable(String key, SuperVar value) {
9        variables.put(key, value);
    }
}
