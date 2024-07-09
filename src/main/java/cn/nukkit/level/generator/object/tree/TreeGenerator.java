package cn.nukkit.level.generator.object.tree;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.item.Item;
import cn.nukkit.level.ChunkManager;
import cn.nukkit.level.Level;
import cn.nukkit.math.BlockVector3;
import cn.nukkit.math.Vector3;

import java.util.Random;

public abstract class TreeGenerator extends cn.nukkit.level.generator.object.BasicGenerator {

    /**
     * returns whether or not a tree can grow into a block
     * For example, a tree will not grow into stone
     */
    protected boolean canGrowInto(int id) {
        switch (id) {
            case Item.AIR:
            case Item.LEAVES:
            case Item.GRASS:
            case Item.DIRT:
            case Item.LOG:
            case Item.LOG2:
            case Item.SAPLING:
            case Item.VINE:
            case Item.DIRT_WITH_ROOTS:
            case Item.AZALEA_LEAVES:
            case Item.AZALEA_LEAVES_FLOWERED:
            case Item.CHERRY_LEAVES:
            case Item.CHERRY_LOG:
            case Item.CHERRY_SAPLING:
                return true;
            default:
                return false;
        }
    }

    public void generateSaplings(Level level, Random random, Vector3 pos) {
    }

    protected void setDirtAt(ChunkManager level, BlockVector3 pos) {
        setDirtAt(level, new Vector3(pos.x, pos.y, pos.z));
    }

    /**
     * sets dirt at a specific location if it isn't already dirt
     */
    protected void setDirtAt(ChunkManager level, Vector3 pos) {
        if (level.getBlockIdAt((int) pos.x, (int) pos.y, (int) pos.z) != Item.DIRT) {
            this.setBlockAndNotifyAdequately(level, pos, Block.get(BlockID.DIRT));
        }
    }
}
