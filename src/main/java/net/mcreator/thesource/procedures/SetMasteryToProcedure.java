package net.mcreator.thesource.procedures;

import net.minecraft.entity.Entity;
import net.minecraft.command.CommandSource;

import net.mcreator.thesource.TheSourceModVariables;
import net.mcreator.thesource.TheSourceMod;

import java.util.Map;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetMasteryToProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("arguments") == null) {
			if (!dependencies.containsKey("arguments"))
				TheSourceMod.LOGGER.warn("Failed to load dependency arguments for procedure SetMasteryTo!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheSourceMod.LOGGER.warn("Failed to load dependency entity for procedure SetMasteryTo!");
			return;
		}
		CommandContext<CommandSource> arguments = (CommandContext<CommandSource>) dependencies.get("arguments");
		Entity entity = (Entity) dependencies.get("entity");
		double Mastery = 0;
		{
			double _setval = (DoubleArgumentType.getDouble(arguments, "Mastery"));
			entity.getCapability(TheSourceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.level = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
