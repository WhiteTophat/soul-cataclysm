
package net.tophat.soulcataclysm.block;

import net.tophat.soulcataclysm.procedures.SoulSpreadProcProcedure;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class SoulStoneBricksWallBlock extends WallBlock {
	public SoulStoneBricksWallBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(1f, 10f).requiresCorrectToolForDrops().randomTicks().forceSolidOn());
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		SoulSpreadProcProcedure.execute(world, x, y, z);
	}
}
