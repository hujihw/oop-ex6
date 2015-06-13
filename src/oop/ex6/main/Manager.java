package oop.ex6.main;
import oop.ex6.main.Parser.*;

/**
 * Created by Asaf Etzion and Omri Kaplan
 */
class Manager {
    private static Manager ourInstance = new Manager();
    //todo add file member.
    //todo add method hash set and parent=null.

    public static Manager getInstance() {
        return ourInstance;
    }

    private Manager() {
    }

    /**
     * the main method that runs the whole verifying procedure
     * @param sJavaFilePath the path of the sJava file
     */
    void mainProcedure (String sJavaFilePath){
        // todo try on the hole procedure. catch exceptions and print 1, otherwise print 2.
        // calls the parsFile
        // calls the parseBlock

    }



}
