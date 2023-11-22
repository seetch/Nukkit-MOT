package cn.nukkit.block;

import cn.nukkit.item.Item;

public class BlockLeavesMangrove extends BlockLeaves {

    public static final int UPDATE_BIT = 0b1;
    public static final int PERSISTENT_BIT = 0b10;

    public BlockLeavesMangrove() {
        this(0);
    }

    public BlockLeavesMangrove(final int meta) {
        super(meta & 0x3);
    }

    @Override
    public int getId() {
        return MANGROVE_LEAVES;
    }

    public String getName() {
        return "Mangrove Leaves";
    }

    @Override
    protected boolean canDropApple() {
        return false;
    }

    @Override
    protected Item getSapling() {
        return Item.get(MANGROVE_PROPAGULE);
    }

    @Override
    public boolean isCheckDecay() {
        return (this.getDamage() & UPDATE_BIT) != 0;
    }

    @Override
    public void setCheckDecay(final boolean checkDecay) {
        this.setDamage(checkDecay ? this.getDamage() | UPDATE_BIT : this.getDamage() & ~UPDATE_BIT);
    }

    @Override
    public boolean isPersistent() {
        return (this.getDamage() & PERSISTENT_BIT) != 0;
    }

    @Override
    public void setPersistent(final boolean persistent) {
        this.setDamage(persistent ? this.getDamage() | PERSISTENT_BIT : this.getDamage() & ~PERSISTENT_BIT);
    }
}
