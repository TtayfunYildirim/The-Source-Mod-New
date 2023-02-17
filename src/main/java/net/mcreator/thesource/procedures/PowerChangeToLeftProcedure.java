package net.mcreator.thesource.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.thesource.TheSourceModVariables;
import net.mcreator.thesource.TheSourceMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class PowerChangeToLeftProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheSourceMod.LOGGER.warn("Failed to load dependency entity for procedure PowerChangeToLeft!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double lastopened = 0;
		lastopened = LastOpenedPowerForHeatProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		if ((entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheSourceModVariables.PlayerVariables())).selectedpower == 0) {
			{
				double _setval = lastopened;
				entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.selectedpower = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheSourceModVariables.PlayerVariables())).selectedpower > 0) {
			{
				double _setval = ((entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TheSourceModVariables.PlayerVariables())).selectedpower - 1);
				entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.selectedpower = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
