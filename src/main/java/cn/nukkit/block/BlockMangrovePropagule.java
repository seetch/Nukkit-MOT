package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.level.Level;
import cn.nukkit.level.particle.BoneMealParticle;
import cn.nukkit.math.AxisAlignedBB;

import java.util.concurrent.ThreadLocalRandom;

public class BlockMangrovePropagule extends BlockTransparentMeta {

    public static final int STAGE_MASK = 0b111;
    public static final int HANGING_BIT = 0b1000;

    public static final int STAGE_FULLY_GROWN = 4;

    public BlockMangrovePropagule() {
        this(0);
    }

    public BlockMangrovePropagule(final int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return MANGROVE_PROPAGULE;
    }

    @Override
    public String getName() {
        return "Mangrove Propagule";
    }

    @Override
    public double getHardness() {
        return 0;
    }

    @Override
    public double getResistance() {
        return 0;
    }

    @Override
    public Item[] getDrops(final Item item) {
        if (this.isHanging() && this.getStage() < STAGE_FULLY_GROWN) {
            return Item.EMPTY_ARRAY;
        }

        return new Item[]{
                this.toItem(),
        };
    }

    @Override
    public int getWaterloggingLevel() {
        return 1;
    }

    @Override
    public boolean canBeActivated() {
        return true;
    }

    @Override
    public boolean onActivate(final Item item, final Player player) {
        if (item.getId() == ItemID.DYE && item.getDamage() == 0x0f) { // Bone meal
            if (!this.isHanging()) {
                if (player != null && !player.isCreative()) {
                    item.count--;
                }

                level.addParticle(new BoneMealParticle(this));

                if (ThreadLocalRandom.current().nextFloat() >= 0.45f) {
                    return true;
                }

                this.growTree();
                return true;
            }

            final int stage = this.getStage();
            if (stage >= STAGE_FULLY_GROWN) {
                return false;
            }

            if (player != null && !player.isCreative()) {
                item.count--;
            }

            level.addParticle(new BoneMealParticle(this));

            this.setStage(stage + 1);
            level.setBlock(this, this, true);
            return true;
        }

        return false;
    }

    @Override
    public int onUpdate(final int type) {
        if (type == Level.BLOCK_UPDATE_NORMAL) {
            if (this.canSurvive()) {
                return 0;
            }

            level.useBreakOn(this);
            return Level.BLOCK_UPDATE_NORMAL;
        }

        if (type == Level.BLOCK_UPDATE_RANDOM) {
            if (!this.isHanging()) {
                if (ThreadLocalRandom.current().nextInt(7) != 0) {
                    return 0;
                }

                this.growTree();
                return Level.BLOCK_UPDATE_RANDOM;
            }

            final int stage = this.getStage();
            if (stage >= STAGE_FULLY_GROWN) {
                return 0;
            }

            this.setStage(stage + 1);
            level.setBlock(this, this, true);
            return Level.BLOCK_UPDATE_RANDOM;
        }

        return 0;
    }

    @Override
    public boolean isSolid() {
        return false;
    }

    @Override
    public boolean canPassThrough() {
        return true;
    }

    @Override
    protected AxisAlignedBB recalculateBoundingBox() {
        return null;
    }

    @Override
    public boolean canBeFlowedInto() {
        return true;
    }

    @Override
    public boolean breaksWhenMoved() {
        return true;
    }

    @Override
    public boolean sticksToPiston() {
        return false;
    }

    private void growTree() {
    }

    private boolean canSurvive() {
        if (this.isHanging()) {
            return this.up().getId() == MANGROVE_LEAVES;
        }

        final int id = this.down().getId();
        return id == BIG_DRIPLEAF || id == GRASS || id == DIRT || id == MYCELIUM || id == PODZOL || id == FARMLAND || id == DIRT_WITH_ROOTS || id == MOSS_STONE || id == CLAY_BLOCK;
    }

    public int getStage() {
        return this.getDamage() & STAGE_MASK;
    }

    public void setStage(final int stage) {
        this.setDamage(this.getDamage() & ~STAGE_MASK | stage & STAGE_MASK);
    }

    public boolean isHanging() {
        return (this.getDamage() & HANGING_BIT) == HANGING_BIT;
    }

    public void setHanging(final boolean hanging) {
        this.setDamage(hanging ? this.getDamage() | HANGING_BIT : this.getDamage() & ~HANGING_BIT);
    }
}
