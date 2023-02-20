package net.mcreator.thesource.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.Inventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.thesource.potion.HeatTouchPotionEffect;
import net.mcreator.thesource.TheSourceMod;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

public class HeatTouchBlockSmeltProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onBlockBreak(BlockEvent.BreakEvent event) {
			Entity entity = event.getPlayer();
			IWorld world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("xpAmount", event.getExpToDrop());
			dependencies.put("x", event.getPos().getX());
			dependencies.put("y", event.getPos().getY());
			dependencies.put("z", event.getPos().getZ());
			dependencies.put("px", entity.getPosX());
			dependencies.put("py", entity.getPosY());
			dependencies.put("pz", entity.getPosZ());
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("blockstate", event.getState());
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheSourceMod.LOGGER.warn("Failed to load dependency world for procedure HeatTouchBlockSmelt!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TheSourceMod.LOGGER.warn("Failed to load dependency x for procedure HeatTouchBlockSmelt!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TheSourceMod.LOGGER.warn("Failed to load dependency y for procedure HeatTouchBlockSmelt!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TheSourceMod.LOGGER.warn("Failed to load dependency z for procedure HeatTouchBlockSmelt!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheSourceMod.LOGGER.warn("Failed to load dependency entity for procedure HeatTouchBlockSmelt!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		boolean remove = false;
		if (entity instanceof PlayerEntity && new Object() {
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
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()
					.canHarvestBlock((world.getBlockState(new BlockPos(x, y, z))))) {
				if (!(((world instanceof World && ((World) world).getRecipeManager()
						.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
								((World) world))
						.isPresent())
								? ((World) world).getRecipeManager()
										.getRecipe(IRecipeType.SMELTING,
												new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
												(World) world)
										.get().getRecipeOutput().copy()
								: ItemStack.EMPTY)
						.getItem() == Blocks.AIR.asItem())) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, ((world instanceof World && ((World) world)
								.getRecipeManager()
								.getRecipe(IRecipeType.SMELTING,
										new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), ((World) world))
								.isPresent())
										? ((World) world).getRecipeManager()
												.getRecipe(IRecipeType.SMELTING,
														new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
														(World) world)
												.get().getRecipeOutput().copy()
										: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
					world.setBlockState(new BlockPos(x, y, z), Blocks.AIR.getDefaultState(), 3);
				}
			}
		}
	}
}
