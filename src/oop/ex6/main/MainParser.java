package oop.ex6.main;

import oop.ex6.expressions.ExpressionsDefiner;
import oop.ex6.sjava_objects.SJavaException;
import oop.ex6.sjava_objects.SJavaObject;
import oop.ex6.sjava_objects.blocks.MainBlock;
import oop.ex6.sjava_objects.blocks.MethodBlock;
import oop.ex6.sjava_objects.blocks.SuperBlock;
import oop.ex6.sjava_objects.variables.SuperVar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * includes the parseFile which is the main method, and the advanceToClosingBracket and commentsAndEmptyLinesFilter
 * which are helper methods
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

        MainBlock mainBlock = new MainBlock(); // todo check maybe change to parent is null
        scanner = new Scanner(theFile);

        while (scanner.hasNextLine()){

            String line = scanner.nextLine();
            SJavaObject[] objectsArray = commentsAndEmptyLinesFilter(line, mainBlock);

            if (objectsArray != null) {
                for (SJavaObject object: objectsArray){
                    if (object instanceof MethodBlock){
                        Scanner methodScanner = new Scanner(theFile);
                        /* everything between \Q and \E is considered as escaped.
                        zero horizon means no bounding to the search */
                        methodScanner.findWithinHorizon("\\Q" + line + "\\E", 0);
                        System.out.println("method scanner: "+methodScanner.match().group()); //todo remove
                        System.out.println("main scanner: "+scanner.match().group()); //todo remove
                        ((MethodBlock) object).setScanner(methodScanner);
                        mainBlock.addMethod(object.getName(), (MethodBlock) object); //todo consider generics
                        advanceToClosingBracket();
                    }
                    else if (object instanceof SuperVar) {
                        mainBlock.addVariable(object.getName(), (SuperVar) object); //todo consider generics
                    }
                }
            }
        }
        return mainBlock;
    }

    /**
     * advances the scanner to the line ending the method declaration.
     * @throws UnclosedBlockException indicates that a method declaration didn't end properly.
     */
    static void advanceToClosingBracket() throws UnclosedBlockException{
        int bracketCounter = 1; // starts with 1 because we already passed one opening bracket
        final String OPENING_BRACKET = ".*(\\{\\s*)", CLOSING_BRACKET = "\\s*\\}\\s*";

        while (scanner.hasNext()){

            String line = scanner.nextLine();

            if (line.matches(OPENING_BRACKET)){
                bracketCounter++;
            } else if (line.matches(CLOSING_BRACKET)){
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
     * @param line the line to parse.
     * @param currentBlock the block that which we are parsing in.
     * @return null if its a white space only or comment line, or what the defineExpression returned (SJavaObject[]).
     * @throws SJavaException throws any SJavaException onwards.
     */
    static SJavaObject[] commentsAndEmptyLinesFilter(String line, SuperBlock currentBlock) throws SJavaException { // todo test

        Pattern p = Pattern.compile("^//.*|\\s*");
        if (!p.matcher(line).matches()){ //negates the pattern to filter empty lines and line comments
            return ExpressionsDefiner.getInstance().defineExpression(line, currentBlock);
        } else return null;
    }
}
