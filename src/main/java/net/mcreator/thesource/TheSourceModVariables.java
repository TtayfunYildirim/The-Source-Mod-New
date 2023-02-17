package net.mcreator.thesource;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

public class TheSourceModVariables {
	public TheSourceModVariables(TheSourceModElements elements) {
		elements.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
	}

	private void init(FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(PlayerVariables.class, new PlayerVariablesStorage(), PlayerVariables::new);
	}

	@CapabilityInject(PlayerVariables.class)
	public static Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = null;

	@SubscribeEvent
	public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity && !(event.getObject() instanceof FakePlayer))
			event.addCapability(new ResourceLocation("the_source", "player_variables"), new PlayerVariablesProvider());
	}

	private static class PlayerVariablesProvider implements ICapabilitySerializable<INBT> {
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(PLAYER_VARIABLES_CAPABILITY::getDefaultInstance);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public INBT serializeNBT() {
			return PLAYER_VARIABLES_CAPABILITY.getStorage().writeNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new),
					null);
		}

		@Override
		public void deserializeNBT(INBT nbt) {
			PLAYER_VARIABLES_CAPABILITY.getStorage().readNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new), null,
					nbt);
		}
	}

	private static class PlayerVariablesStorage implements Capability.IStorage<PlayerVariables> {
		@Override
		public INBT writeNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side) {
			CompoundNBT nbt = new CompoundNBT();
			nbt.putString("power", instance.power);
			nbt.putDouble("level", instance.level);
			nbt.putString("faction", instance.faction);
			nbt.putString("status", instance.status);
			nbt.putString("race", instance.race);
			nbt.putDouble("selectedpower", instance.selectedpower);
			nbt.putDouble("flowlevel", instance.flowlevel);
			nbt.putDouble("lifeforcelevel", instance.lifeforcelevel);
			nbt.putDouble("soulforcelevel", instance.soulforcelevel);
			nbt.putDouble("playerexperience", instance.playerexperience);
			nbt.putDouble("playerexpcap", instance.playerexpcap);
			nbt.putDouble("lastopenedpowernumber", instance.lastopenedpowernumber);
			nbt.putString("selectedskill", instance.selectedskill);
			return nbt;
		}

		@Override
		public void readNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side, INBT inbt) {
			CompoundNBT nbt = (CompoundNBT) inbt;
			instance.power = nbt.getString("power");
			instance.level = nbt.getDouble("level");
			instance.faction = nbt.getString("faction");
			instance.status = nbt.getString("status");
			instance.race = nbt.getString("race");
			instance.selectedpower = nbt.getDouble("selectedpower");
			instance.flowlevel = nbt.getDouble("flowlevel");
			instance.lifeforcelevel = nbt.getDouble("lifeforcelevel");
			instance.soulforcelevel = nbt.getDouble("soulforcelevel");
			instance.playerexperience = nbt.getDouble("playerexperience");
			instance.playerexpcap = nbt.getDouble("playerexpcap");
			instance.lastopenedpowernumber = nbt.getDouble("lastopenedpowernumber");
			instance.selectedskill = nbt.getString("selectedskill");
		}
	}

	public static class PlayerVariables {
		public String power = "NONE";
		public double level = 0.0;
		public String faction = "NONE";
		public String status = "NONE";
		public String race = "NONE";
		public double selectedpower = -1.0;
		public double flowlevel = 50.0;
		public double lifeforcelevel = 0.0;
		public double soulforcelevel = 0;
		public double playerexperience = 0;
		public double playerexpcap = 20.0;
		public double lastopenedpowernumber = 0;
		public String selectedskill = "NONE";

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayerEntity)
				TheSourceMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) entity),
						new PlayerVariablesSyncMessage(this));
		}
	}

	@SubscribeEvent
	public void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void clonePlayer(PlayerEvent.Clone event) {
		PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PlayerVariables()));
		PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
		clone.power = original.power;
		clone.level = original.level;
		clone.faction = original.faction;
		clone.status = original.status;
		clone.race = original.race;
		clone.selectedpower = original.selectedpower;
		clone.flowlevel = original.flowlevel;
		clone.lifeforcelevel = original.lifeforcelevel;
		clone.soulforcelevel = original.soulforcelevel;
		clone.playerexperience = original.playerexperience;
		clone.playerexpcap = original.playerexpcap;
		clone.lastopenedpowernumber = original.lastopenedpowernumber;
		clone.selectedskill = original.selectedskill;
		if (!event.isWasDeath()) {
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(PacketBuffer buffer) {
			this.data = new PlayerVariables();
			new PlayerVariablesStorage().readNBT(null, this.data, null, buffer.readCompoundTag());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, PacketBuffer buffer) {
			buffer.writeCompoundTag((CompoundNBT) new PlayerVariablesStorage().writeNBT(null, message.data, null));
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.power = message.data.power;
					variables.level = message.data.level;
					variables.faction = message.data.faction;
					variables.status = message.data.status;
					variables.race = message.data.race;
					variables.selectedpower = message.data.selectedpower;
					variables.flowlevel = message.data.flowlevel;
					variables.lifeforcelevel = message.data.lifeforcelevel;
					variables.soulforcelevel = message.data.soulforcelevel;
					variables.playerexperience = message.data.playerexperience;
					variables.playerexpcap = message.data.playerexpcap;
					variables.lastopenedpowernumber = message.data.lastopenedpowernumber;
					variables.selectedskill = message.data.selectedskill;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
