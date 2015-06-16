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

    /* Data Members */
    private static Scanner scanner;


    /* Methods */
    /**
     * reads the code file and creates the outer scope, meaning it creates the methods and the global variables.
     * @param theFile the file we want to parse.
     * @return MainBlock the outer scope block which holds the methods and variables.
     */
    static MainBlock parseFile(File theFile) throws SJavaException, FileNotFoundException {

        MainBlock mainBlock = new MainBlock(null);
        scanner = new Scanner(theFile);

        while (scanner.hasNextLine()){

            String line = scanner.nextLine();
            SJavaObject object = commentsAndEmptyLinesFilter(line);

            if (object != null) {
                if (object instanceof MethodBlock){
                    mainBlock.addMethod(object.getName(), (MethodBlock) object); //todo consider generics
                    advanceToClosingBracket();
                }
                else if (object instanceof SuperVar){
                    mainBlock.addVariable(object.getName(),(SuperVar) object); //todo consider generics
                }
            }
        }

        return null;
    }

    static void advanceToClosingBracket() throws UnclosedBlockException{
        int bracketCounter = 1; // starts with 1 because we already passed one opening bracket
        while (scanner.hasNext()){

            String line = scanner.nextLine();

            if ((line.substring(line.lastIndexOf(" ")+1).equals("{"))){ //todo convert maybe to regex
                //todo set scanner with clone!
                bracketCounter++;
                }
            else if (line.equals("}")){
                bracketCounter--;
            }

            if (bracketCounter==0){
                return;
            }
        }
        throw new UnclosedBlockException("a method declaration block wasn't closed properly, Bracket wise");
    }

    /**
     * Filter the comments and empty lines and sends other lines to ExpressionDefiner.
     * @return return the SJava Object returned from ExpressionDefiner. null otherwise.
     */
    static SJavaObject commentsAndEmptyLinesFilter(String line) { // todo

        return null;
    }
}
