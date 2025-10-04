package net.tophat.soulcataclysm.procedures;

import net.minecraft.world.entity.player.Player;
import net.tophat.soulcataclysm.InfectionHandler;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class SoulCommunicatorOnBlockRightClickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide()) {
			_player.displayClientMessage(Component.literal("Reputation: " + InfectionHandler.getReputation(_player.level(), _player)), false);
		}
	}
}
