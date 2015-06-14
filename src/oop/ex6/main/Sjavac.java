package oop.ex6.main;

/**
 * the Sjavac is the class from which the user runs the Sjava verifier application.
 * @author Omri Kaplan & Asaf Eztion
 */
public class Sjavac {

    /**
     * the main method is called by the user and it initiates the Sjava verification process.
     * int wrong use, it throw a WrongArgumentsNumberException if the user calls it with no arguments or more than one
     * also it caches the WrongArgumentsNumberException and BadFileException and prints 2 to out stream and the
     * exception cause to the error stream
     * @param args should be one in length of 1, args[0] is the path to the sjavac code file.
     */
    public static void main(String[] args) {

        try {
            if (args.length != 1) {
                throw new WrongArgumentsNumberException("the correct use of this application is with one argument");
            Manager.getInstance().mainProcedure(args[0]);}

        }
        catch (WrongArgumentsNumberException | BadFileException exp){
            String IO_ERROR = "2";
            System.out.println(IO_ERROR);
            System.err.println(exp.getMessage());
        }
    }
}

