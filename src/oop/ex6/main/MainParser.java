package oop.ex6.main;

import oop.ex6.sjava_objects.SJavaException;
import oop.ex6.sjava_objects.SJavaObject;
import oop.ex6.sjava_objects.blocks.MainBlock;
import oop.ex6.sjava_objects.blocks.MethodBlock;
import oop.ex6.sjava_objects.blocks.SuperBlock;
import oop.ex6.sjava_objects.variables.SuperVar;

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
        // todo skip comments and empty lines

        MainBlock mainBlock = new MainBlock(null);
        Scanner scanner = new Scanner(theFile);

        while (scanner.hasNextLine()){
            String line = scanner.next();
            SJavaObject object = commentsAndEmptyLinesFilter(line);
            if (object != null) {
                if (object instanceof MethodBlock){
                    
                }
                else if (object instanceof SuperVar){
                    mainBlock.addVariable(object.getName(),(SuperVar) object); //todo consider generics
                }
            }
        }

        return null;
    }

    /**
     * Filter the comments and empty lines and sends other lines to ExpressionDefiner.
     * @return return the SJava Object returned from ExpressionDefiner. null otherwise.
     */
    static SJavaObject commentsAndEmptyLinesFilter(String line) { // todo

        return null;
    }
}
