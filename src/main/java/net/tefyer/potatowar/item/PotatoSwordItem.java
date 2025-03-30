package net.tefyer.potatowar.item;

import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;

public class PotatoSwordItem extends SwordItem {
    public PotatoSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Vec3 blockPos = pContext.getClickLocation();

        pContext.getLevel().addParticle(new DustParticleOptions(new Vector3f(1,1,1),10.0f),
                true,blockPos.x,blockPos.y,blockPos.z,5,5,5);

        return super.useOn(pContext);
    }
}
