package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.math.BlockFace;

public abstract class BlockRotatedPillar extends BlockSolidMeta {

    public static final int PILLAR_AXIS_Y = 0b00;
    public static final int PILLAR_AXIS_X = 0b01;
    public static final int PILLAR_AXIS_Z = 0b10;

    private static final int[] PILLAR_AXIS = {PILLAR_AXIS_X, PILLAR_AXIS_Y, PILLAR_AXIS_Z};

    protected BlockRotatedPillar(final int meta) {
        super(meta);
    }

    @Override
    public boolean place(final Item item, final Block block, final Block target, final BlockFace face, final double fx, final double fy, final double fz, final Player player) {
        this.setDamage(PILLAR_AXIS[face.getAxis().ordinal()]);
        return super.place(item, block, target, face, fx, fy, fz, player);
    }

    @Override
    public Item toItem() {
        return Item.get(this.getItemId());
    }
}
