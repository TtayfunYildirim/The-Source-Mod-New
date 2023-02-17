
package net.mcreator.thesource.gui.overlay;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.thesource.procedures.StrongPunchOpenedConditionProcedure;
import net.mcreator.thesource.procedures.PowerSlotsHeatDisplayOverlayIngameProcedure;
import net.mcreator.thesource.procedures.HeatTouchOpenedConditionProcedure;
import net.mcreator.thesource.procedures.HeatThirdPowerSelectedControlProcedure;
import net.mcreator.thesource.procedures.HeatSecondPowerSelectedControlProcedure;
import net.mcreator.thesource.procedures.HeatFourthPowerSelectedControlProcedure;
import net.mcreator.thesource.procedures.HeatFirstPowerSelectedControlProcedure;
import net.mcreator.thesource.procedures.HeatFifthPowerSelectedControlProcedure;
import net.mcreator.thesource.procedures.FlamethrowerOpenedConditionProcedure;
import net.mcreator.thesource.procedures.CloverCanonOpenedConditionProcedure;
import net.mcreator.thesource.procedures.BurningWhirlpoolOpenedConditionProcedure;
import net.mcreator.thesource.TheSourceModVariables;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber
public class PowerSlotsOverlay {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGameOverlayEvent.Post event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int w = event.getWindow().getScaledWidth();
			int h = event.getWindow().getScaledHeight();
			int posX = w / 2;
			int posY = h / 2;
			World _world = null;
			double _x = 0;
			double _y = 0;
			double _z = 0;
			PlayerEntity entity = Minecraft.getInstance().player;
			if (entity != null) {
				_world = entity.world;
				_x = entity.getPosX();
				_y = entity.getPosY();
				_z = entity.getPosZ();
			}
			World world = _world;
			double x = _x;
			double y = _y;
			double z = _z;
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
					GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			RenderSystem.disableAlphaTest();
			if (PowerSlotsHeatDisplayOverlayIngameProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("the_source:textures/screens/slotmc.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -207, posY + 59, 0, 0, 16, 16, 16, 16);

				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("the_source:textures/screens/slotmc.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -184, posY + 59, 0, 0, 16, 16, 16, 16);

				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("the_source:textures/screens/slotmc.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -162, posY + 59, 0, 0, 16, 16, 16, 16);

				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("the_source:textures/screens/slotmc.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -207, posY + 81, 0, 0, 16, 16, 16, 16);

				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("the_source:textures/screens/slotmc.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -184, posY + 81, 0, 0, 16, 16, 16, 16);

				if (HeatTouchOpenedConditionProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("the_source:textures/screens/heatouch.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -207, posY + 59, 0, 0, 16, 16, 16, 16);
				}
				if (HeatFirstPowerSelectedControlProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("the_source:textures/screens/selectionring.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -207, posY + 59, 0, 0, 16, 16, 16, 16);
				}
				if (HeatSecondPowerSelectedControlProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("the_source:textures/screens/selectionring.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -184, posY + 59, 0, 0, 16, 16, 16, 16);
				}
				if (HeatThirdPowerSelectedControlProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("the_source:textures/screens/selectionring.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -162, posY + 59, 0, 0, 16, 16, 16, 16);
				}
				if (HeatFourthPowerSelectedControlProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("the_source:textures/screens/selectionring.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -207, posY + 81, 0, 0, 16, 16, 16, 16);
				}
				if (HeatFifthPowerSelectedControlProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("the_source:textures/screens/selectionring.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -184, posY + 81, 0, 0, 16, 16, 16, 16);
				}
				if (StrongPunchOpenedConditionProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("the_source:textures/screens/strongpunchh.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -184, posY + 59, 0, 0, 16, 16, 16, 16);
				}
				if (FlamethrowerOpenedConditionProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("the_source:textures/screens/flamethrower.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -162, posY + 59, 0, 0, 16, 16, 16, 16);
				}
				if (BurningWhirlpoolOpenedConditionProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("the_source:textures/screens/whirlpool.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -184, posY + 81, 0, 0, 16, 16, 16, 16);
				}
				if (CloverCanonOpenedConditionProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("the_source:textures/screens/clovercannon.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -207, posY + 81, 0, 0, 16, 16, 16, 16);
				}
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"" + ((entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new TheSourceModVariables.PlayerVariables())).selectedskill) + "",
						posX + -211, posY + 37, -65485);
			}
			RenderSystem.depthMask(true);
			RenderSystem.enableDepthTest();
			RenderSystem.enableAlphaTest();
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
	}
}
