
package net.tefyer.potatowar.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.tefyer.potatowar.procedures.PanicActiveTickConditionProcedure;

public class PanicMobEffect extends MobEffect {
	public PanicMobEffect() {
		super(MobEffectCategory.HARMFUL, -65536);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		PanicActiveTickConditionProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
