package net.mcreator.thesource.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.thesource.TheSourceModVariables;
import net.mcreator.thesource.TheSourceMod;

import java.util.Map;

public class ExpCapAndLevelUpProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheSourceMod.LOGGER.warn("Failed to load dependency entity for procedure ExpCapAndLevelUp!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			double _setval = ((entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheSourceModVariables.PlayerVariables())).playerexpcap
					+ Math.pow(1.125,
							(entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new TheSourceModVariables.PlayerVariables())).level)
							* (entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new TheSourceModVariables.PlayerVariables())).level);
			entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.playerexpcap = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
