package oop.ex6.main;

import oop.ex6.sjava_objects.SJavaException;
import oop.ex6.sjava_objects.blocks.MainBlock;
import oop.ex6.sjava_objects.blocks.MethodBlock;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * The manager of the whole verification process. Calls the MainParser an BlockParser, and holds the MainBlock.
 * @author Asaf Etzion & Omri Kaplan
 */
class Manager {

    /* Data Members */
    private MainBlock mainBlock;
    private File theFile; // todo maybe needs to be package-local.
    static Manager ourInstance = new Manager();

    /* Constructor */
    private Manager() {
    }

    /* Methods */

    /**
     * The file object getter
     * @return the file.
     */
    public File getTheFile() {
        return theFile;
    }

    /**
     * the main method that runs the whole verifying procedure
     * @param sJavaFilePath the path of the sJava file
     */
    void mainProcedure (String sJavaFilePath) throws BadFileException, FileNotFoundException {
        try {
            theFile = new File(sJavaFilePath);
            mainBlock = MainParser.parseFile(theFile);
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
