package oop.ex6.sjava_objects.variables;

/**
 * @author Omri Kaplan
 */
public class FinalDecorator extends SuperVar {

    /* Data Member */
    SuperVar variable;
    String name;

    /* Constructor */
//    FinalDecorator(String[] varDeclaration) { // todo comment out this for compilation
//        variable = VarFactory.produceVariable(varDeclaration); // todo comment out this for compilation
//        setIsFinal(true); // todo comment out for compilation
//    }

    public FinalDecorator(SuperVar superVar) { // todo wrote this for compilation
        super(superVar);
    }

    /* Methods */
    @Override
    public Type getType() {
        return variable.getType();
    }
}
