package cn.nukkit.block;

public class BlockLogStrippedMangrove extends BlockWoodStripped {
	public BlockLogStrippedMangrove() {
		this(0);
	}

	public BlockLogStrippedMangrove(final int meta) {
		super(meta);
	}

	@Override
	public int getId() {
		return STRIPPED_MANGROVE_LOG;
	}

	@Override
	public String getName() {
		return "Stripped Mangrove Log";
	}
}
