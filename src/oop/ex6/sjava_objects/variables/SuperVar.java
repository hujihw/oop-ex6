package oop.ex6.sjava_objects.variables;

/**
 * @author Omri Kaplan
 */
abstract class SuperVar {

    /* Data Members */
    private boolean isFinal = false;
    private boolean wasInitialized = false;
    private int lineNumber;

    /* Constructors */

    /* Methods */

    // todo decide when variable gets final. factory or expression definer.

    public boolean isWasInitialized() {
        return wasInitialized;
    }

    public void setWasInitialized(boolean wasInitialized) {
        this.wasInitialized = wasInitialized;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }
}
