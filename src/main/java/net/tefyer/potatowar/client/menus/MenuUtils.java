package net.tefyer.potatowar.client.menus;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.tefyer.api.CompoundTagIds;
import net.tefyer.api.entity.utils.EntityUtils;
import net.tefyer.potatowar.entity.custom.PotatoManEntity;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

import static com.ibm.icu.impl.ValidIdentifiers.Datatype.x;

public class MenuUtils {
    public static void itemQuestWhileThisGUIISOpen(Level world, double x, double y, double z, Player player) {
        if(player == null) return;
        if(EntityUtils.getDouble(player, CompoundTagIds.FactionID) == 1){
            comparator(world,x,y,z, PotatoManEntity.class);
        }else if (EntityUtils.getDouble(player, CompoundTagIds.FactionID) == 2){
            //comparator(world,x,y,z, HumanEntity.class);
        }
    }

    private static void comparator(@NotNull Level world, double x, double y, double z, Class c) {
        if (((Entity) world.getEntitiesOfClass(c, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(new Object() {
            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
            }
        }.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity
                _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,
                    10, 100, false, true));
    }
}
