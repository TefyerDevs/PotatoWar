package net.mcreator.potatowar.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.potatowar.network.PotatowarModVariables;

import java.util.List;
import java.util.Comparator;

public class AcceptQuestProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("potatowar:AssassinQuest", true);
		{
			boolean _setval = true;
			entity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.HasQuest = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("potatowar:civilian")))) {
					if (entity.getPersistentData().getDouble("potatowar:CivilianID") == entityiterator.getPersistentData().getDouble("potatowar:CivilianID")) {
						entityiterator.getPersistentData().putBoolean("potatowar:QuestTaken", true);
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Thank you, I hope to hear back from you soon."), false);
						AssassinQuest1Procedure.execute(world, (entity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PotatowarModVariables.PlayerVariables())).AssassinX,
								world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (entity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PotatowarModVariables.PlayerVariables())).AssassinX,
										(int) (entity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PotatowarModVariables.PlayerVariables())).AssassinZ),
								(entity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PotatowarModVariables.PlayerVariables())).AssassinZ, entity);
						if (entity instanceof Player _player)
							_player.closeContainer();
					}
				}
			}
		}
	}
}
