package net.mcreator.thesource.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.thesource.TheSourceModVariables;
import net.mcreator.thesource.TheSourceMod;

import java.util.Map;

public class ReturnTrueIfPowerPresentProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheSourceMod.LOGGER.warn("Failed to load dependency entity for procedure ReturnTrueIfPowerPresent!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheSourceModVariables.PlayerVariables())).power).equals("NONE")) {
			return false;
		}
		return true;
	}
}
