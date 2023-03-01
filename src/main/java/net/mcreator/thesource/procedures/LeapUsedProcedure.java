package net.mcreator.thesource.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.thesource.potion.LeapOnPotionEffect;
import net.mcreator.thesource.TheSourceModVariables;
import net.mcreator.thesource.TheSourceMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class LeapUsedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheSourceMod.LOGGER.warn("Failed to load dependency entity for procedure LeapUsed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheSourceModVariables.PlayerVariables())).level >= 10) {
			for (int index0 = 0; index0 < (int) (10); index0++) {
				FlowLevelDownProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			entity.setMotion((entity.getMotion().getX() + entity.getLookVec().x * 1.2),
					(entity.getMotion().getY()
							+ Math.sqrt(Math.pow(Math.sin(entity.getLookVec().z), 2) + Math.pow(Math.cos(entity.getLookVec().x), 2))),
					(entity.getMotion().getZ() + entity.getLookVec().z * 1.2));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(LeapOnPotionEffect.potion, (int) 40, (int) 0, (false), (false)));
		}
	}
}
