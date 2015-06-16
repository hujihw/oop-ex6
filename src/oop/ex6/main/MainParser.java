package oop.ex6.main;

import oop.ex6.sjava_objects.SJavaException;
import oop.ex6.sjava_objects.SJavaObject;
import oop.ex6.sjava_objects.blocks.MainBlock;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * //todo
 * @author Omri Kaplan & Asaf Eztion
 */
class MainParser {

    /**
     * reads the code file and creates the outer scope, meaning it creates the methods and the global variables.
     * @param theFile the file we want to parse.
     * @return MainBlock the outer scope block which holds the methods and variables.
     */
    static MainBlock parseFile(File theFile) throws SJavaException, FileNotFoundException{
        // todo create a MainBlock instance first!
        // todo skip comments and empty lines

        MainBlock mainBlock = new MainBlock(null);
        Scanner scanner = new Scanner(theFile);

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
