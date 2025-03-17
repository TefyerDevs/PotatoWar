
package net.tefyer.potatowar.entity;

import io.netty.buffer.Unpooled;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;

import net.tefyer.potatowar.init.PotatowarModItems;
import net.tefyer.potatowar.init.PotatowarModEntities;
import net.tefyer.potatowar.world.inventory.MilitaryTrainerKitsMenu;

import javax.annotation.Nullable;

public class MilitaryTrainerEntity extends Monster {
	public MilitaryTrainerEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(PotatowarModEntities.MILITARY_TRAINER.get(), world);
	}

	public MilitaryTrainerEntity(EntityType<MilitaryTrainerEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(0.6f);
		xpReward = 0;
		setNoAi(false);
		setPersistenceRequired();
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_AXE));
		this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PotatowarModItems.MILITARY_ARMOR_HELMET.get()));
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.getNavigation().getNodeEvaluator().setCanOpenDoors(true);
		this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}
		});
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(5, new FloatGoal(this));
		this.goalSelector.addGoal(6, new OpenDoorGoal(this, true));
		this.goalSelector.addGoal(7, new OpenDoorGoal(this, false));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public double getMyRidingOffset() {
		return -0.35D;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		finSpawn(this);
		return retval;
	}


	public static void finSpawn(Entity entity) {
		if (entity == null)
			return;
		double RandomNum = 0;
		RandomNum = Mth.nextInt(RandomSource.create(), 1, 5);
		entity.getPersistentData().putDouble("potatowar:KitPrice", (Mth.nextInt(RandomSource.create(), 10, 64)));
		entity.getPersistentData().putDouble("potatoWar:FactionID", 1);
		if (RandomNum >= 5) {
			entity.getPersistentData().putDouble("potatowar:KitID", 5);
			entity.getPersistentData().putDouble("potatowar:KitPrice", (Mth.nextInt(RandomSource.create(), 2, 5)));
		} else if (RandomNum >= 4) {
			entity.getPersistentData().putDouble("potatowar:KitID", 4);
			entity.getPersistentData().putDouble("potatowar:KitPrice", (Mth.nextInt(RandomSource.create(), 5, 10)));
		} else if (RandomNum >= 3) {
			entity.getPersistentData().putDouble("potatowar:KitID", 3);
			entity.getPersistentData().putDouble("potatowar:KitPrice", (Mth.nextInt(RandomSource.create(), 15, 30)));
		} else if (RandomNum >= 2) {
			entity.getPersistentData().putDouble("potatowar:KitID", 2);
			entity.getPersistentData().putDouble("potatowar:KitPrice", (Mth.nextInt(RandomSource.create(), 5, 10)));
		} else if (RandomNum >= 1) {
			entity.getPersistentData().putDouble("potatowar:KitID", 1);
			entity.getPersistentData().putDouble("potatowar:KitPrice", (Mth.nextInt(RandomSource.create(), 30, 45)));
		}
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
		super.mobInteract(sourceentity, hand);
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level();

		mobInteract(x, y, z, entity, sourceentity);
		return retval;
	}

	public static void mobInteract(double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double RandomNum = 0;
		sourceentity.getPersistentData().putDouble("potatoWar:FactionID", (entity.getPersistentData().getDouble("potatoWar:FactionID")));
		sourceentity.getPersistentData().putDouble("potatowar:KitPrice", (entity.getPersistentData().getDouble("potatowar:KitPrice")));
		sourceentity.getPersistentData().putDouble("potatowar:KitID", (entity.getPersistentData().getDouble("potatowar:KitID")));
		if (sourceentity instanceof ServerPlayer _ent) {
			BlockPos _bpos = BlockPos.containing(x, y, z);
			NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("MilitaryTrainerKits");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new MilitaryTrainerKitsMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
				}
			}, _bpos);
		}
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.25);
		builder = builder.add(Attributes.MAX_HEALTH, 25);
		builder = builder.add(Attributes.ARMOR, 8);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 4);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}
}
