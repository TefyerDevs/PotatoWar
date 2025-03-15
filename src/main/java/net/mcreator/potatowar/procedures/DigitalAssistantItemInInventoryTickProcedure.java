package net.mcreator.potatowar.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.potatowar.PotatowarMod;

public class DigitalAssistantItemInInventoryTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("potatowar:HasDigitalAssistant") == false) {
			entity.getPersistentData().putBoolean("potatowar:HasDigitalAssistant", true);
			entity.getPersistentData().putBoolean("potatowar:IndigiWorld", true);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("I hate you, you know?"), false);
			PotatowarMod.queueServerWork(20, () -> {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Well were both trapped now so I guess ill get us out"), false);
			});
			PotatowarMod.queueServerWork(80, () -> {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Just hold the digital assistant item in your hand and right click."), false);
			});
			PotatowarMod.queueServerWork(160, () -> {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("and I guess I have to help you or your going to get rid of me."), false);
			});
			PotatowarMod.queueServerWork(240, () -> {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Right click a block or hit a entity and ill tell you what I know."), false);
			});
			PotatowarMod.queueServerWork(320, () -> {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("If you are not sure what to do next right click in the air."), false);
			});
		}
	}
}
