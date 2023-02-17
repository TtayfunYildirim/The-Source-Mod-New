package net.mcreator.thesource.procedures;

import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.PacketBuffer;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.thesource.gui.AbilityChooseGuiRavenGui;
import net.mcreator.thesource.gui.AbilityChooseGuiMaterialControlGui;
import net.mcreator.thesource.gui.AbilityChooseGuiLightiningGui;
import net.mcreator.thesource.gui.AbilityChooseGuiHeatGui;
import net.mcreator.thesource.TheSourceModVariables;
import net.mcreator.thesource.TheSourceMod;

import java.util.Map;

import io.netty.buffer.Unpooled;

public class AbilityGuiNextButtonProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheSourceMod.LOGGER.warn("Failed to load dependency world for procedure AbilityGuiNextButton!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TheSourceMod.LOGGER.warn("Failed to load dependency x for procedure AbilityGuiNextButton!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TheSourceMod.LOGGER.warn("Failed to load dependency y for procedure AbilityGuiNextButton!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TheSourceMod.LOGGER.warn("Failed to load dependency z for procedure AbilityGuiNextButton!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheSourceMod.LOGGER.warn("Failed to load dependency entity for procedure AbilityGuiNextButton!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheSourceModVariables.PlayerVariables())).power).equals("Heat")) {
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
						@Override
						public ITextComponent getDisplayName() {
							return new StringTextComponent("AbilityChooseGuiHeat");
						}

						@Override
						public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
							return new AbilityChooseGuiHeatGui.GuiContainerMod(id, inventory,
									new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		} else if (((entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheSourceModVariables.PlayerVariables())).power).equals("Lightining")) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).closeScreen();
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
						@Override
						public ITextComponent getDisplayName() {
							return new StringTextComponent("AbilityChooseGuiLightining");
						}

						@Override
						public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
							return new AbilityChooseGuiLightiningGui.GuiContainerMod(id, inventory,
									new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		} else if (((entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheSourceModVariables.PlayerVariables())).power).equals("Material Control")) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).closeScreen();
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
						@Override
						public ITextComponent getDisplayName() {
							return new StringTextComponent("AbilityChooseGuiRaven");
						}

						@Override
						public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
							return new AbilityChooseGuiRavenGui.GuiContainerMod(id, inventory,
									new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		} else if (((entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheSourceModVariables.PlayerVariables())).power).equals("Raven")) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).closeScreen();
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
						@Override
						public ITextComponent getDisplayName() {
							return new StringTextComponent("AbilityChooseGuiMaterialControl");
						}

						@Override
						public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
							return new AbilityChooseGuiMaterialControlGui.GuiContainerMod(id, inventory,
									new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		}
	}
}
