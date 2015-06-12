package oop.ex6.sjava_objects.blocks;

import oop.ex6.sjava_objects.SJavaObject;

import java.util.HashSet;

/**
 * @author Omri Kaplan
 */
public class SuperBlock extends SJavaObject {

    /* Data Members */
    private HashSet<SJavaObject> containedObjects;
    private SuperBlock parent;

    /* Constructors */
    public SuperBlock(SuperBlock parent) {
        this.parent = parent;
    }
}
