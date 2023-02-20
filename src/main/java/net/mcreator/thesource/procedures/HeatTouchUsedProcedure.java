package net.mcreator.thesource.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.thesource.potion.HeatTouchPotionEffect;
import net.mcreator.thesource.TheSourceMod;

import java.util.Map;
import java.util.Collection;

public class HeatTouchUsedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheSourceMod.LOGGER.warn("Failed to load dependency entity for procedure HeatTouchUsed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == HeatTouchPotionEffect.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removePotionEffect(HeatTouchPotionEffect.potion);
			}
		} else {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(HeatTouchPotionEffect.potion, (int) 36000, (int) 0));
		}
	}
}
