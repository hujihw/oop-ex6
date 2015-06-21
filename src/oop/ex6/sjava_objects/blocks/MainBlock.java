package oop.ex6.sjava_objects.blocks;

import java.util.Collection;
import java.util.Hashtable;

/**
 * represents the main block which is the most outer scope of the Sjava code.
 * @author Omri Kaplan & Asaf Eztion
 */
public class MainBlock extends SuperBlock {

    /* Data Members */
    private Hashtable<String, MethodBlock> methods;

    /* Constructors */
    public MainBlock() {
        super("mainBlock", null);
        methods = new Hashtable<>();
    }

    /* methods */

    /**
     * delegates the putt method to the methods hash table
     * @param key the name of the mathod
     * @param value the method object
     */
    public void addMethod(String key, MethodBlock value) {
        methods.put(key, value);
    }

    /**
     * gets all of the methods, in Sjava all of the methods are declared on the outer scope.
     * @return all of the methods
     */
    public Collection<MethodBlock> getAllMethods(){
        return methods.values();
    }

    /**
     * gets a specific method.
     * @param methodName the name of the method
     * @return the MethodBlock object
     */
    public MethodBlock getMethod(String methodName){
        return methods.get(methodName);
    }

}
