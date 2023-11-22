package cn.nukkit.block;

import cn.nukkit.item.ItemTool;

public class BlockMangroveRootsMuddy extends BlockRotatedPillar {

    public BlockMangroveRootsMuddy() {
        this(0);
    }

    public BlockMangroveRootsMuddy(final int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return MUDDY_MANGROVE_ROOTS;
    }

    @Override
    public String getName() {
        return "Muddy Mangrove Roots";
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
    public int getToolType() {
        return ItemTool.TYPE_SHOVEL;
    }
}
