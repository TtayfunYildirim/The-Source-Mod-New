package net.mcreator.thesource.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.thesource.potion.DiedFromHeatPotionEffect;
import net.mcreator.thesource.TheSourceMod;

import java.util.Map;

public class FlamethrowerProjectileProjectileHitsLivingEntityProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheSourceMod.LOGGER.warn("Failed to load dependency entity for procedure FlamethrowerProjectileProjectileHitsLivingEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 10);
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(DiedFromHeatPotionEffect.potion, (int) 100, (int) 1, (false), (false)));
	}
}
