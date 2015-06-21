import oop.ex6.main.Sjavac;

import java.io.File;

/**
 * @author Omri Kaplan
 */
public class MainTester {
    public static void main(String[] args) {
        File sourceDir = new File("C:\\Users\\Asaf\\Documents\\GitHub\\ex6\\tests\\tests");
        File[] tests = sourceDir.listFiles();
        String[] argument = new String[1];

        assert tests != null;
        for (File test : tests) {
            argument[0] = String.valueOf(test.toPath());
            System.out.println("-------------------------------------------------------------------------");
            Sjavac.main(argument);
        }
    }
}
