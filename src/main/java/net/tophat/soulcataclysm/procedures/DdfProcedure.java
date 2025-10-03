package net.tophat.soulcataclysm.procedures;

import net.tophat.soulcataclysm.network.SoulcataclysmModVariables;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class DdfProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		SoulcataclysmModVariables.WorldVariables.get(world).points = SoulcataclysmModVariables.WorldVariables.get(world).points;
		SoulcataclysmModVariables.WorldVariables.get(world).syncData(world);
		{
			double _setval = (entity.getCapability(SoulcataclysmModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SoulcataclysmModVariables.PlayerVariables())).reputation;
			entity.getCapability(SoulcataclysmModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.reputation = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
