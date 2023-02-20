package net.mcreator.thesource.procedures;

import net.minecraft.world.World;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.Entity;

import net.mcreator.thesource.item.StrongPunchProjectileItem;
import net.mcreator.thesource.TheSourceModVariables;
import net.mcreator.thesource.TheSourceMod;

import java.util.Map;

public class StrongPunchUsedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheSourceMod.LOGGER.warn("Failed to load dependency entity for procedure StrongPunchUsed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheSourceModVariables.PlayerVariables())).flowlevel >= 5) {
			{
				Entity _shootFrom = entity;
				World projectileLevel = _shootFrom.world;
				if (!projectileLevel.isRemote()) {
					ProjectileEntity _entityToSpawn = new Object() {
						public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
							AbstractArrowEntity entityToSpawn = new StrongPunchProjectileItem.ArrowCustomEntity(StrongPunchProjectileItem.arrow,
									world);
							entityToSpawn.setShooter(shooter);
							entityToSpawn.setDamage(damage);
							entityToSpawn.setKnockbackStrength(knockback);
							entityToSpawn.setSilent(true);

							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, 5, 1);
					_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
					_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
					projectileLevel.addEntity(_entityToSpawn);
				}
			}
			{
				double _setval = ((entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TheSourceModVariables.PlayerVariables())).flowlevel - 5);
				entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.flowlevel = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
