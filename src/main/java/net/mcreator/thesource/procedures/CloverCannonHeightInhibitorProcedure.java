package net.mcreator.thesource.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.thesource.TheSourceMod;

import java.util.Map;

public class CloverCannonHeightInhibitorProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheSourceMod.LOGGER.warn("Failed to load dependency entity for procedure CloverCannonHeightInhibitor!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity.getPosY() < 85) {
			return true;
		}
		return false;
	}
}
