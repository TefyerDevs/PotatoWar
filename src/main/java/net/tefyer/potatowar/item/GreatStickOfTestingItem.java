
package net.tefyer.potatowar.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;

import net.minecraft.world.level.Level;

public class GreatStickOfTestingItem extends Item {
	public GreatStickOfTestingItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
        if (entity.level().isClientSide())
            entity.level().explode(null, entity.getX(), entity.getY(), entity.getZ(), 100, Level.ExplosionInteraction.TNT);
		return retval;
	}
}
