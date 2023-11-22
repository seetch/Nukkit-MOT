package cn.nukkit.block;

public class BlockPressurePlateMangrove extends BlockPressurePlateWood {

    public BlockPressurePlateMangrove() {
        this(0);
    }

    public BlockPressurePlateMangrove(final int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return MANGROVE_PRESSURE_PLATE;
    }

    @Override
    public String getName() {
        return "Mangrove Pressure Plate";
    }
}
