package net.mcreator.thesource.procedures;

import net.minecraft.entity.Entity;
import net.minecraft.command.CommandSource;

import net.mcreator.thesource.TheSourceModVariables;
import net.mcreator.thesource.TheSourceMod;

import java.util.Map;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetMaxFlowToProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("arguments") == null) {
			if (!dependencies.containsKey("arguments"))
				TheSourceMod.LOGGER.warn("Failed to load dependency arguments for procedure SetMaxFlowTo!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheSourceMod.LOGGER.warn("Failed to load dependency entity for procedure SetMaxFlowTo!");
			return;
		}
		CommandContext<CommandSource> arguments = (CommandContext<CommandSource>) dependencies.get("arguments");
		Entity entity = (Entity) dependencies.get("entity");
		{
			double _setval = (DoubleArgumentType.getDouble(arguments, "number"));
			entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.maxflow = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
