package net.mcreator.thesource.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import net.mcreator.thesource.TheSourceModVariables;
import net.mcreator.thesource.TheSourceMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class AbilityUseOnKeyPressedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheSourceMod.LOGGER.warn("Failed to load dependency world for procedure AbilityUseOnKeyPressed!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TheSourceMod.LOGGER.warn("Failed to load dependency x for procedure AbilityUseOnKeyPressed!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TheSourceMod.LOGGER.warn("Failed to load dependency y for procedure AbilityUseOnKeyPressed!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TheSourceMod.LOGGER.warn("Failed to load dependency z for procedure AbilityUseOnKeyPressed!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheSourceMod.LOGGER.warn("Failed to load dependency entity for procedure AbilityUseOnKeyPressed!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheSourceModVariables.PlayerVariables())).power).equals("Heat")) {
			if ((entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheSourceModVariables.PlayerVariables())).selectedpower == 0) {
				HeatTouchUsedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			} else if ((entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheSourceModVariables.PlayerVariables())).selectedpower == 1) {
				StrongPunchUsedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			} else if ((entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheSourceModVariables.PlayerVariables())).selectedpower == 2) {
				FlamethrowerUsedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			} else if ((entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheSourceModVariables.PlayerVariables())).selectedpower == 3) {
				CloverCannonUsedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
								new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			} else if ((entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheSourceModVariables.PlayerVariables())).selectedpower == 4) {
				BurningWhirlpoolUsedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
								new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}
}
