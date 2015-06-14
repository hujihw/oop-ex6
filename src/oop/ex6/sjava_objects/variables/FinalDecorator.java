package oop.ex6.sjava_objects.variables;

/**
 * @author Omri Kaplan
 */
public class FinalDecorator extends SuperVar {

    /* Data Member */
    SuperVar variable;
    String name;

    /* Constructor */
    FinalDecorator(String[] varDeclaration) {
        variable = VarFactory.produceVariable(varDeclaration);
        setIsFinal(true);
    }

    /* Methods */
    @Override
    public Type getType() {
        return variable.getType();
    }
}
