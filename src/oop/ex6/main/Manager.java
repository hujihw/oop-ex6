package oop.ex6.main;

import oop.ex6.sjava_objects.SJavaException;
import oop.ex6.sjava_objects.blocks.MainBlock;
import oop.ex6.sjava_objects.blocks.MethodBlock;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * The manager of the whole verification process. Calls the Parser an BlockParser, and holds the MainBlock.
 * @author Asaf Etzion & Omri Kaplan
 */
class Manager {

    /* Data Members */
    private MainBlock mainBlock;
    static Manager ourInstance = new Manager();

    /* Constructor */
    private Manager() {
    }

    /**
     * the main method that runs the whole verifying procedure
     * @param sJavaFilePath the path of the sJava file
     */
    void mainProcedure (String sJavaFilePath) throws BadFileException, FileNotFoundException {
        try {
            mainBlock = Parser.parseFile(new File(sJavaFilePath));
            for (MethodBlock method : mainBlock.getAllMethods()) { // todo verify not returning null.
                BlockParser.parseBlock(method);
            }
            System.out.println("0");
        } catch (SJavaException e) {
            System.out.println("1");
            System.err.println(e.getMessage());
        }
    }

    /**
     * MainBlock getter.
     * @return The main block.
     */
    public MainBlock getMainBlock() {
        return mainBlock;
    }

    /**
     * The Manager instance getter.
     * @return The only manager instance.
     */
    static Manager getInstance() {
        return ourInstance;
    }

}
