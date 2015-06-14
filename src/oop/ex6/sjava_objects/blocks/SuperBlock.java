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
    public SuperBlock(SuperBlock parent) {
        this.parent = parent;
    }
}
