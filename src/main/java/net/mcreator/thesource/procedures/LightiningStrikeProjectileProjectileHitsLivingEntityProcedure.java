package net.mcreator.thesource.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.thesource.potion.StunedPotionEffect;
import net.mcreator.thesource.TheSourceMod;

import java.util.Map;

public class LightiningStrikeProjectileProjectileHitsLivingEntityProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheSourceMod.LOGGER.warn("Failed to load dependency entity for procedure LightiningStrikeProjectileProjectileHitsLivingEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(StunedPotionEffect.potion, (int) 60, (int) 0, (false), (false)));
	}
}
