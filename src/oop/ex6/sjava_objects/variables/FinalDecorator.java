package oop.ex6.sjava_objects.variables;

/**
 * @author Omri Kaplan
 */
public class FinalDecorator extends SuperVar {

    /* Data Member */
    SuperVar variable;

    /* Constructor */
    FinalDecorator(String[] varDeclaration) throws IllegalVarException {
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
