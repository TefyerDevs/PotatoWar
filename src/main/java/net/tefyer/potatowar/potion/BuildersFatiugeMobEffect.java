
package net.tefyer.potatowar.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class BuildersFatiugeMobEffect extends MobEffect {
	public BuildersFatiugeMobEffect() {
		super(MobEffectCategory.HARMFUL, -13434880);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
