package oop.ex6.sjava_objects.variables;

import oop.ex6.sjava_objects.SJavaException;

/**
 * decorates the final function and delegates all of the other variable functions
 * @author Omri Kaplan and Asaf Etzion
 */
class FinalDecorator extends SuperVar {

    /* Data Member */
    SuperVar variable;

    /**
     * constructs a new variable and marks is as final
     * @param varDeclaration holds tha name and type of the var
     * @throws SJavaException throws any SJavaException onwards
     */
    /* Constructor */
    FinalDecorator(String[] varDeclaration) throws SJavaException {
        super(varDeclaration[1]);
        this.variable = VarFactory.produceVariable(varDeclaration);
        setIsFinal(true);
    }

    /* Methods */
    @Override
    public Type getType() {
        return variable.getType();
    }

    @Override
    public void setType(Type type) {
        variable.setType(type);
    }

    @Override
    public boolean wasInitialized() {
        return variable.wasInitialized();
    }

    @Override
    public void setWasInitialized() {
        variable.setWasInitialized();
    }

    @Override
    public String getName() {
        return variable.getName();
    }
}
