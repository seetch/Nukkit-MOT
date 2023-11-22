package cn.nukkit.block;

public class BlockFenceGateMangrove extends BlockFenceGate {

    public BlockFenceGateMangrove() {
        super(0);
    }

    public BlockFenceGateMangrove(final int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return MANGROVE_FENCE_GATE;
    }

    @Override
    public String getName() {
        return "Mangrove Fence Gate";
    }
}
