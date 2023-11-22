package cn.nukkit.block;

import cn.nukkit.item.ItemTool;

public class BlockPlanksMangrove extends BlockSolid {

	public BlockPlanksMangrove() {
	}

	@Override
	public int getId() {
		return MANGROVE_PLANKS;
	}

	@Override
	public String getName() {
		return "Mangrove Planks";
	}

	@Override
	public double getHardness() {
		return 2;
	}

	@Override
	public double getResistance() {
		return 3;
	}

	@Override
	public int getToolType() {
		return ItemTool.TYPE_AXE;
	}
}
