package cn.nukkit.block;

public class BlockSlabMangrove extends BlockSlabWood {

    public static final int TYPE_MASK = 0;
    public static final int TOP_SLOT_BIT = 0b1;

    public BlockSlabMangrove() {
        this(0);
    }

    public BlockSlabMangrove(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return MANGROVE_SLAB;
    }

    @Override
    public String getName() {
        return ((this.getDamage() & 0x08) == 0x08 ? "Upper " : "") + "Mangrove Slab";
    }
}
