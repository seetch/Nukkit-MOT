package cn.nukkit.block;

import cn.nukkit.item.ItemTool;

public class BlockMangroveRoots extends BlockTransparent {
    public BlockMangroveRoots() {
    }

    @Override
    public int getId() {
        return MANGROVE_ROOTS;
    }

    @Override
    public String getName() {
        return "Mangrove Roots";
    }

    @Override
    public double getHardness() {
        return 0.7;
    }

    @Override
    public double getResistance() {
        return 3.5;
    }

    @Override
    public int getBurnChance() {
        return 5;
    }

    @Override
    public int getBurnAbility() {
        return 5;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_AXE;
    }

    @Override
    public int getWaterloggingLevel() {
        return 1;
    }
}
