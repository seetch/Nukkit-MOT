package cn.nukkit.block;

public class BlockLogMangrove extends BlockWood {

    public BlockLogMangrove() {
        this(0);
    }

    public BlockLogMangrove(final int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return MANGROVE_LOG;
    }

    @Override
    public String getName() {
        return "Mangrove Log";
    }

    @Override
    protected int getStrippedId() {
        return STRIPPED_MANGROVE_LOG;
    }
}
