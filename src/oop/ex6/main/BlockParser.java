package oop.ex6.main;

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
            SJavaObject expressionObject[] = MainParser.getInstance().commentsAndEmptyLinesFilter(line, methodBlock);
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
            while (line.trim().equals("return;")) {
                line = scanner.nextLine();
            }
            if (line.trim().equals("}")) {
                return;
            }
            // send to Expressions to turn the line into
            SJavaObject[] expressionObject = MainParser.getInstance().commentsAndEmptyLinesFilter(line, block);
            if (expressionObject != null) {
                varOrBlockHandle(block, expressionObject);
            }
        }
    }

    /**
     * Verifying the type of SJava object that was created.
     * @param currentBlock    The block we currently parse.
     * @param theObjects       The given SJava object.
     */
    private void varOrBlockHandle(SuperBlock currentBlock, SJavaObject[] theObjects) throws SJavaException{
        if (theObjects[0] instanceof SuperBlock) {
            ((SuperBlock) theObjects[0]).setParent(currentBlock);
            parseBlock((SuperBlock) theObjects[0]); // todo consider generics, not down casting.
        } else if (theObjects[0] instanceof SuperVar) {
            for (SJavaObject theObject : theObjects) {
                currentBlock.addVariable(theObject.getName(), (SuperVar) theObject);
            }
        }
    }
}
