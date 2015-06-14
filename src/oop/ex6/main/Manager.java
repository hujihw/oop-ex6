package oop.ex6.main;

import oop.ex6.sjava_objects.SJavaException;
import oop.ex6.sjava_objects.blocks.MainBlock;
import oop.ex6.sjava_objects.blocks.MethodBlock;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * The manager of the hole virification process. Calls the Parser an BlockParser, and holds the MainBlock.
 * Created by Asaf Etzion & Omri Kaplan
 */
class Manager {

    /* Data Members */
    //todo add file member. still needed?
    private MainBlock mainBlock; // todo add a method hash table/map. @Asaf remove if done.
    static Manager ourInstance = new Manager();

    /* Constructor */
    private Manager() {
    }

    /**
     * the main method that runs the whole verifying procedure
     * @param sJavaFilePath the path of the sJava file
     */
    void mainProcedure (String sJavaFilePath) throws BadFileException, FileNotFoundException { // todo
        // todo try on the hole procedure. catch exceptions and print 1, otherwise print 2.
        try {
            mainBlock = Parser.parseFile(new File(sJavaFilePath));
            for (MethodBlock method : mainBlock.getAllMethods()) {
                BlockParser.parseBlock(method);
            }

        } catch (SJavaException e) { // todo parseFile throws SJavaException.
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
