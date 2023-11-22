package cn.nukkit.block;

public class BlockFenceMangrove extends BlockFence {

    public BlockFenceMangrove() {
    }

    @Override
    public int getId() {
        return MANGROVE_FENCE;
    }

    @Override
    public String getName() {
        return "Mangrove Fence";
    }

    @Override
    public int getFullId() {
        return this.getId() << DATA_BITS;
    }

    @Override
    public void setDamage(final int meta) {
    }
}
