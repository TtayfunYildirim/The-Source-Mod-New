package net.mcreator.thesource.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.thesource.TheSourceModVariables;
import net.mcreator.thesource.TheSourceMod;

import java.util.Map;

public class ExpCapAndLevelUpProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				TheSourceMod.LOGGER.warn("Failed to load dependency sourceentity for procedure ExpCapAndLevelUp!");
			return;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		{
			double _setval = ((sourceentity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheSourceModVariables.PlayerVariables())).playerexpcap
					+ Math.pow(1.125,
							(sourceentity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new TheSourceModVariables.PlayerVariables())).level)
							* (sourceentity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new TheSourceModVariables.PlayerVariables())).level);
			sourceentity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.playerexpcap = _setval;
				capability.syncPlayerVariables(sourceentity);
			});
		}
	}
}
