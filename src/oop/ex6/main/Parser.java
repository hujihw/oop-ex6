package oop.ex6.main;

import oop.ex6.sjava_objects.SJavaObject;
import oop.ex6.sjava_objects.blocks.MainBlock;

import java.io.File;

/**
 * @author Omri Kaplan
 */
class Parser {

    /**
     * This method read the code file.
     * @param theFile    the file we want to parse.
     * @return MainBlock the outer scope block which holds the methods and variables.
     */
    static MainBlock parseFile(File theFile) { // todo
        // todo create a MainBlock instance first!
        // todo skip comments and empty lines
        return null;
    }

    /**
     * Filter the comments and empty lines and sends other lines to ExpressionDefiner.
     * @return return the SJava Object returned from ExpressionDefiner. null otherwise.
     */
    SJavaObject commentsAndEmptyLinesFilter() { // todo

        return null;
    }
}
