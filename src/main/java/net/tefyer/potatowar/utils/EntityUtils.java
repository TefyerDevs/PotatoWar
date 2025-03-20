package net.tefyer.potatowar.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.tefyer.potatowar.init.PotatowarModEntities;

public class EntityUtils {

    public static void spawnEntityWithClientString(LevelAccessor world, Entity player, EntityType<?> entity, int x, int y, int z, String printedString){
        spawnEntityWithClientString(world,player,entity,new BlockPos(x,y,z),printedString);
    }
    public static void spawnEntityWithClientString(LevelAccessor world, Entity player, EntityType<?> entity, BlockPos basePos, String printedString){
        if (world instanceof ServerLevel _level) {
            Entity entityToSpawn = entity
                    .spawn(_level, BlockPos.containing(basePos.getX(), basePos.getY() + 1, basePos.getZ()), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null)
                entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
        }
        if (player instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal(printedString), false);
    }
}
