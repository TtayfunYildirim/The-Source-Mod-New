package net.mcreator.thesource.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.thesource.TheSourceModVariables;
import net.mcreator.thesource.TheSourceMod;

import java.util.Map;

public class LastOpenedPowerForHeatProcedure {

	public static double executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheSourceMod.LOGGER.warn("Failed to load dependency entity for procedure LastOpenedPowerForHeat!");
			return 0;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheSourceModVariables.PlayerVariables())).level >= 21) {
			return 4;
		} else if ((entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheSourceModVariables.PlayerVariables())).level >= 16) {
			return 3;
		} else if ((entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheSourceModVariables.PlayerVariables())).level >= 12) {
			return 2;
		} else if ((entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheSourceModVariables.PlayerVariables())).level >= 7) {
			return 1;
		} else if ((entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheSourceModVariables.PlayerVariables())).level >= 3) {
			return 0;
		}
		return -1;
	}
}
