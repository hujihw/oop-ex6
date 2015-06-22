import oop.ex6.main.Sjavac;

import java.io.File;

/**
 * @author Omri Kaplan
 */
public class MainTester {
    public static void main(String[] args) {
        File sourceDir = new File("C:\\Users\\Omri\\OneDrive\\Documents\\huji\\hw\\oop\\ex6\\tests\\tests");
        File[] tests = sourceDir.listFiles();
        String[] argument = new String[1];

        assert tests != null;
        for (File test : tests) {
            argument[0] = String.valueOf(test.toPath());
            System.out.println("-------------------------------------------------------------------------");
//            System.out.println(argument[0]);
            System.out.println("test: " + test.getName());
            Sjavac.main(argument);
        }
    }
}
