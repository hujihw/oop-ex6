package oop.ex6.main;

import oop.ex6.expressions.ExpressionsDefiner;
import oop.ex6.sjava_objects.SJavaException;
import oop.ex6.sjava_objects.SJavaObject;
import oop.ex6.sjava_objects.blocks.MethodBlock;
import oop.ex6.sjava_objects.blocks.SuperBlock;
import oop.ex6.sjava_objects.variables.SuperVar;

import java.util.Scanner;

/**
 * @author Omri Kaplan and Asaf Etzion
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
    void parseMethod(MethodBlock methodBlock) {
        this.scanner = methodBlock.getScanner();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            while (line.trim().equals("return;")){
                line = scanner.nextLine();
                if (line.trim().equals("}")) {
                    return;
                }
            }
            SJavaObject expressionObject = MainParser.commentsAndEmptyLinesFilter(line);
            if (expressionObject != null) {
                if (expressionObject instanceof SuperBlock) {
                    parseBlock((SuperBlock) expressionObject); // todo consider generics, not down casting.
                } else if (expressionObject instanceof SuperVar) {

                }
            }
        }
    }

    /**
     * Recursively parse SJava code blocks (scopes).
     * @param block    the block to parse.
     */
    public void parseBlock(SuperBlock block) { // tester todo package-local.
        System.out.println("got this block: " + block.toString()); // tester
    }


}
