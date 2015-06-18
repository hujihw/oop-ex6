package oop.ex6.main;

import oop.ex6.expressions.ExpressionsDefiner;
import oop.ex6.sjava_objects.SJavaException;
import oop.ex6.sjava_objects.SJavaObject;
import oop.ex6.sjava_objects.blocks.MethodBlock;
import oop.ex6.sjava_objects.blocks.SuperBlock;
import oop.ex6.sjava_objects.variables.SuperVar;

import java.util.Scanner;

/**
 * @author Omri Kaplan & Asaf Etzion
 */
public class BlockParser { // tester todo change to package local
    /* Data Members */
    private static BlockParser ourInstance = new BlockParser();
    private Scanner scanner;

    /* Constructor */
    /**
     * Default singleton constructor.
     */
    private BlockParser() {
    }

    /* Methods */

    /**
     * The singleton getter.
     * @return the BlockParser instance.
     */
    public static BlockParser getInstance() {
        return ourInstance;
    }

    /**
     * Parse a method block.
     * @param methodBlock    the method block to parse.
     */
    public void parseMethod(MethodBlock methodBlock) { // tester todo make package local
        this.scanner = methodBlock.getScanner();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            while (line.trim().equals("return;")){
                System.out.println("found 'return;'"); // tester
                line = scanner.nextLine();
                if (line.trim().equals("}")) {
                    System.out.println("found '}'"); // tester
                    return;
                }
            }
            SJavaObject expressionObject = MainParser.commentsAndEmptyLinesFilter(line);
            System.out.println(line); // tester
            System.out.println(expressionObject == null);
            if (expressionObject != null) { // note commentsAndEmptyLinesFilter() not implemented.
                varOrBlockHandle(methodBlock, expressionObject);
            }
        }
    }

    /**
     * Recursively parse SJava code blocks (scopes).
     * @param block    the block to parse.
     */
    public void parseBlock(SuperBlock block) { // tester todo package-local.
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.trim().equals("}")) {
                return;
            }
            // send to Expressions to turn the line into
            SJavaObject expressionObject = MainParser.commentsAndEmptyLinesFilter(line);
            if (expressionObject != null) { // note commentsAndEmptyLinesFilter() not implemented.
                varOrBlockHandle(block, expressionObject);
            }
        }
    }

    private void varOrBlockHandle(SuperBlock theBlock, SJavaObject theObject) {
        if (theObject instanceof SuperBlock) {
            System.out.println("Got a block!"); // tester
            parseBlock((SuperBlock) theObject); // todo consider generics, not down casting.
        } else if (theObject instanceof SuperVar) {
            System.out.println("Got a var!"); // tester
            theBlock.addVariable(theObject.getName(), (SuperVar) theObject);
        }
    }
}
