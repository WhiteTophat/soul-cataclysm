package net.tophat.soulcataclysm.procedures;

import net.tophat.soulcataclysm.init.SoulcataclysmModBlocks;
import net.tophat.soulcataclysm.InfectionHandler;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.core.BlockPos;

public class SoulSpreadProcProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevelAccessor server) {
			BlockPos decidedSpread = InfectionHandler.decideSpread(server.getLevel(), BlockPos.containing(x,y,z), 3);
			if (decidedSpread != null) {
				BlockPos plantPos = BlockPos.containing(decidedSpread.getX(), decidedSpread.getY() + 1, decidedSpread.getZ());
				if (InfectionHandler.isPlantBlock(world.getBlockState(plantPos))) {
					world.setBlock(plantPos, InfectionHandler.infectBlock(world.getBlockState(plantPos)), 3);
				}
				world.setBlock(decidedSpread, InfectionHandler.infectBlock(world.getBlockState(decidedSpread)), 3);
			}
		}
	}
}
