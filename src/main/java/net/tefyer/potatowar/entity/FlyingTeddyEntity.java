
package net.tefyer.potatowar.entity;

import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.util.RandomSource;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;

import net.tefyer.potatowar.procedures.FlyingTeddyProjectileHitsBlockProcedure;
import net.tefyer.potatowar.init.PotatowarModItems;
import net.tefyer.potatowar.init.PotatowarModEntities;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class FlyingTeddyEntity extends AbstractArrow implements ItemSupplier {
	public static final ItemStack PROJECTILE_ITEM = new ItemStack(PotatowarModItems.TEDDY.get());

	public FlyingTeddyEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(PotatowarModEntities.FLYING_TEDDY.get(), world);
	}

	public FlyingTeddyEntity(EntityType<? extends FlyingTeddyEntity> type, Level world) {
		super(type, world);
	}

	public FlyingTeddyEntity(EntityType<? extends FlyingTeddyEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public FlyingTeddyEntity(EntityType<? extends FlyingTeddyEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected ItemStack getPickupItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(entity.getArrowCount() - 1);
	}

	@Override
	public void onHitBlock(BlockHitResult blockHitResult) {
		super.onHitBlock(blockHitResult);
		FlyingTeddyProjectileHitsBlockProcedure.execute(this.level(), blockHitResult.getBlockPos().getX(), blockHitResult.getBlockPos().getY(), blockHitResult.getBlockPos().getZ());
	}

	@Override
	public void tick() {
		super.tick();
		if (this.inGround)
			this.discard();
	}

	public static FlyingTeddyEntity shoot(Level world, LivingEntity entity, RandomSource source) {
		return shoot(world, entity, source, 0.5f, 0, 0);
	}

	public static FlyingTeddyEntity shoot(Level world, LivingEntity entity, RandomSource source, float pullingPower) {
		return shoot(world, entity, source, pullingPower * 0.5f, 0, 0);
	}

	public static FlyingTeddyEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		FlyingTeddyEntity entityarrow = new FlyingTeddyEntity(PotatowarModEntities.FLYING_TEDDY.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);
		return entityarrow;
	}

	public static FlyingTeddyEntity shoot(LivingEntity entity, LivingEntity target) {
		FlyingTeddyEntity entityarrow = new FlyingTeddyEntity(PotatowarModEntities.FLYING_TEDDY.get(), entity, entity.level());
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 0.5f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(0);
		entityarrow.setKnockback(0);
		entityarrow.setCritArrow(false);
		entity.level().addFreshEntity(entityarrow);
		return entityarrow;
	}
}
