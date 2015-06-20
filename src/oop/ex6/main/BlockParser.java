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
class BlockParser {
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
    void parseMethod(MethodBlock methodBlock) throws SJavaException{
        this.scanner = methodBlock.getScanner();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            while (line.trim().equals("return;")){
                line = scanner.nextLine();
                if (line.trim().equals("}")) {
                    return;
                }
            }
            SJavaObject expressionObject = MainParser.commentsAndEmptyLinesFilter(line, methodBlock);
            System.out.println(expressionObject == null);
            if (expressionObject != null) {
                varOrBlockHandle(methodBlock, expressionObject);
            }
        }
    }

    /**
     * Recursively parse SJava code blocks (scopes).
     * @param block    the block to parse.
     */
    void parseBlock(SuperBlock block) throws SJavaException{
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.trim().equals("}")) {
                return;
            }
            // send to Expressions to turn the line into
            SJavaObject expressionObject = MainParser.commentsAndEmptyLinesFilter(line, block);
            if (expressionObject != null) {
                varOrBlockHandle(block, expressionObject);
            }
        }
    }

    /**
     * Verifying the type of SJava object that was created.
     * @param currentBlock    The block we currently parse.
     * @param theObject       The given SJava object.
     */
    private void varOrBlockHandle(SuperBlock currentBlock, SJavaObject theObject) throws SJavaException{
        if (theObject instanceof SuperBlock) {
            ((SuperBlock) theObject).setParent(currentBlock);
            parseBlock((SuperBlock) theObject); // todo consider generics, not down casting.
        } else if (theObject instanceof SuperVar) {
            currentBlock.addVariable(theObject.getName(), (SuperVar) theObject);
        }
    }
}
