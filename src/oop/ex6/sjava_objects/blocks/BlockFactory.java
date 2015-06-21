package oop.ex6.sjava_objects.blocks;

import oop.ex6.main.Manager;

/**
 * Produce block Objects.
 * @author Omri Kaplan
 */
public class BlockFactory {
    /**
     * The method that creates new blocks.
     * When a new block needs to be created, this method id invoked with the new block's type and given
     * parameters.
     * @param blockType     The type of the block we want to create.
     * @param parameters    The parameters relevant for this block's creation.
     * @return The new block.
     */
    public static SuperBlock produceBlock(String blockType, SuperBlock parent, String parameters) throws
            IllegalBlockException {
        switch (blockType) {
            case "main":
                return new MainBlock();
            case "ifWhile":
                return new IfWhileBlock(parent, parameters);
            default:
                return new MethodBlock(parameters);
        }
    }
}
