package cn.nukkit.block;

public class BlockWoodMangrove extends BlockLogMangrove {

    public BlockWoodMangrove() {
        this(0);
    }

    public BlockWoodMangrove(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return MANGROVE_WOOD;
    }

    @Override
    public String getName() {
        return "Mangrove Wood";
    }

    @Override
    protected int getStrippedId() {
        return STRIPPED_MANGROVE_WOOD;
    }
}
