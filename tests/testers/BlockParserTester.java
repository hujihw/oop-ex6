package testers;

import oop.ex6.main.BlockParser;
import oop.ex6.sjava_objects.SJavaObject;
import oop.ex6.sjava_objects.blocks.IfBlock;
import oop.ex6.sjava_objects.blocks.SuperBlock;

/**
 * @author Omri Kaplan
 */
public class BlockParserTester {
    public static void main(String[] args) {
        SJavaObject ifBlock = new IfBlock(null);
        BlockParser.getInstance().parseBlock((SuperBlock) ifBlock);
    }
}
