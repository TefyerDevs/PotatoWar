package net.mcreator.potatowar.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.potatowar.network.PotatowarModVariables;
import net.mcreator.potatowar.PotatowarMod;

public class LostHazzyOnInitialEntitySpawn1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("potatowar:boss5")), SoundSource.MUSIC, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("potatowar:boss5")), SoundSource.MUSIC, 1, 1, false);
			}
		}
		{
			boolean _setval = true;
			entity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BossFight1 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		PotatowarMod.queueServerWork(3240, () -> {
			{
				boolean _setval = false;
				entity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BossFight1 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		});
	}
}
