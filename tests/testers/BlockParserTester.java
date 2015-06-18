package testers;

import oop.ex6.main.BlockParser;
import oop.ex6.sjava_objects.SJavaObject;
import oop.ex6.sjava_objects.blocks.IfBlock;
import oop.ex6.sjava_objects.blocks.MethodBlock;
import oop.ex6.sjava_objects.blocks.SuperBlock;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Omri Kaplan
 */
public class BlockParserTester {
    public static void main(String[] args) {
        MethodBlock theMethod = new MethodBlock(null);
//        File theFile = new File("C:\\Users\\Omri\\OneDrive\\Documents\\huji\\hw\\oop\\ex6\\tests\\testers\\test_files\\empty_method");
        File theFile = new File("C:\\Users\\Omri\\OneDrive\\Documents\\huji\\hw\\oop\\ex6\\tests\\testers\\test_files\\two_blocks_recursion");
        try {
            Scanner scanner = new Scanner(theFile);
            theMethod.setScanner(scanner);
            BlockParser bp = BlockParser.getInstance();
            bp.parseMethod(theMethod);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        SJavaObject ifBlock = new IfBlock(null);
//        BlockParser.getInstance().parseBlock((SuperBlock) ifBlock);
    }
}
