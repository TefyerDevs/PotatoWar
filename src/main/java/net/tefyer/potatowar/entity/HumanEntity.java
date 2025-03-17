
package net.tefyer.potatowar.entity;

import io.netty.buffer.Unpooled;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;

import net.tefyer.potatowar.network.PotatowarModVariables;
import net.tefyer.potatowar.init.PotatowarModEntities;
import net.tefyer.potatowar.world.inventory.ItemquestMenu;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class HumanEntity extends PathfinderMob {
	public HumanEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(PotatowarModEntities.HUMAN.get(), world);
	}

	public HumanEntity(EntityType<HumanEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(0.6f);
		xpReward = 0;
		setNoAi(false);
		setPersistenceRequired();
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
		this.goalSelector.addGoal(2, new OpenDoorGoal(this, false));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(4, new FloatGoal(this));
		this.goalSelector.addGoal(5, new OpenDoorGoal(this, true));
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
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.death"));
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		spawn(this);
		return retval;
	}

	public static void spawn(Entity entity) {
		if (entity == null)
			return;
		double RandomNum = 0;
		ItemStack questItem1 = ItemStack.EMPTY;
		ItemStack QuestItem2 = ItemStack.EMPTY;
		RandomNum = Mth.nextInt(RandomSource.create(), 1, 4);
		entity.getPersistentData().putDouble("potatoWar:FactionID", 2);
		if (RandomNum >= 4) {
			entity.getPersistentData().putDouble("potatoWar:QuestNum", 1);
			entity.getPersistentData().putDouble("potatoWar:ItemType1", (Mth.nextInt(RandomSource.create(), 1, 4)));
			entity.getPersistentData().putDouble("potatoWar:ItemType2", (Mth.nextInt(RandomSource.create(), 1, 4)));
			entity.getPersistentData().putDouble("potatoWar:ItemType3", (Mth.nextInt(RandomSource.create(), 1, 3)));
			entity.getPersistentData().putDouble("potatoWar:itemcount1", (Mth.nextInt(RandomSource.create(), 20, 60)));
			entity.getPersistentData().putDouble("potatoWar:itemcount2", (Mth.nextInt(RandomSource.create(), 2, 5)));
			entity.getPersistentData().putDouble("potatoWar:itemcount3", 1);
			entity.getPersistentData().putDouble("potatoWar:RewardType", (Mth.nextInt(RandomSource.create(), 1, 5)));
			entity.getPersistentData().putDouble("potatoWar:RewardCount1", (Mth.nextInt(RandomSource.create(), 1, 7)));
			entity.getPersistentData().putDouble("potatoWar:RewardCount2", (Mth.nextInt(RandomSource.create(), 1, 3)));
			entity.getPersistentData().putBoolean("potatoWar:HasQuest", true);
		} else if (RandomNum >= 3) {
			entity.getPersistentData().putDouble("potatoWar:QuestNum", 2);
			entity.getPersistentData().putDouble("potatoWar:ItemType1", (Mth.nextInt(RandomSource.create(), 1, 5)));
			entity.getPersistentData().putDouble("potatoWar:ItemType2", (Mth.nextInt(RandomSource.create(), 1, 2)));
			entity.getPersistentData().putDouble("potatoWar:ItemType3", (Mth.nextInt(RandomSource.create(), 1, 3)));
			entity.getPersistentData().putDouble("potatoWar:itemcount1", (Mth.nextInt(RandomSource.create(), 2, 6)));
			entity.getPersistentData().putDouble("potatoWar:itemcount2", (Mth.nextInt(RandomSource.create(), 2, 5)));
			entity.getPersistentData().putDouble("potatoWar:itemcount3", 1);
			entity.getPersistentData().putDouble("potatoWar:RewardType", (Mth.nextInt(RandomSource.create(), 1, 5)));
			entity.getPersistentData().putDouble("potatoWar:RewardCount1", (Mth.nextInt(RandomSource.create(), 2, 9)));
			entity.getPersistentData().putDouble("potatoWar:RewardCount2", (Mth.nextInt(RandomSource.create(), 2, 5)));
			entity.getPersistentData().putBoolean("potatoWar:HasQuest", true);
		} else if (RandomNum >= 2) {
			entity.getPersistentData().putDouble("potatoWar:QuestNum", 3);
			entity.getPersistentData().putDouble("potatoWar:ItemType1", (Mth.nextInt(RandomSource.create(), 1, 4)));
			entity.getPersistentData().putDouble("potatoWar:ItemType2", (Mth.nextInt(RandomSource.create(), 1, 4)));
			entity.getPersistentData().putDouble("potatoWar:ItemType3", (Mth.nextInt(RandomSource.create(), 1, 3)));
			entity.getPersistentData().putDouble("potatoWar:itemcount1", (Mth.nextInt(RandomSource.create(), 10, 20)));
			entity.getPersistentData().putDouble("potatoWar:itemcount2", (Mth.nextInt(RandomSource.create(), 15, 50)));
			entity.getPersistentData().putDouble("potatoWar:itemcount3", 1);
			entity.getPersistentData().putDouble("potatoWar:RewardType", (Mth.nextInt(RandomSource.create(), 1, 5)));
			entity.getPersistentData().putDouble("potatoWar:RewardCount1", (Mth.nextInt(RandomSource.create(), 5, 15)));
			entity.getPersistentData().putDouble("potatoWar:RewardCount2", (Mth.nextInt(RandomSource.create(), 2, 9)));
			entity.getPersistentData().putBoolean("potatoWar:HasQuest", true);
		} else if (RandomNum >= 1) {
			entity.getPersistentData().putDouble("potatoWar:QuestNum", 4);
			entity.getPersistentData().putDouble("potatoWar:ItemType1", (Mth.nextInt(RandomSource.create(), 1, 5)));
			entity.getPersistentData().putDouble("potatoWar:ItemType2", (Mth.nextInt(RandomSource.create(), 1, 2)));
			entity.getPersistentData().putDouble("potatoWar:ItemType3", (Mth.nextInt(RandomSource.create(), 1, 3)));
			entity.getPersistentData().putDouble("potatoWar:itemcount1", (Mth.nextInt(RandomSource.create(), 5, 8)));
			entity.getPersistentData().putDouble("potatoWar:itemcount2", (Mth.nextInt(RandomSource.create(), 25, 50)));
			entity.getPersistentData().putDouble("potatoWar:itemcount3", 1);
			entity.getPersistentData().putDouble("potatoWar:RewardType", (Mth.nextInt(RandomSource.create(), 1, 5)));
			entity.getPersistentData().putDouble("potatoWar:RewardCount1", (Mth.nextInt(RandomSource.create(), 2, 4)));
			entity.getPersistentData().putDouble("potatoWar:RewardCount2", (Mth.nextInt(RandomSource.create(), 3, 12)));
			entity.getPersistentData().putBoolean("potatoWar:HasQuest", true);
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

		interact(world, x, y, z, entity, sourceentity);
		return retval;
	}

	public static void interact(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity.getPersistentData().getBoolean("potatowar:RandomizeQuest")) {
			entity.getPersistentData().putBoolean("potatowar:RandomizeQuest", false);
			spawn(entity);
		}
		if ((entity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PotatowarModVariables.PlayerVariables())).HumanReputation >= 0
				&& !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("forge:kit"))))) {
			sourceentity.getPersistentData().putDouble("potatowar:MilitaryPrice", (entity.getPersistentData().getDouble("potatowar:MilitaryPrice")));
			sourceentity.getPersistentData().putDouble("potatoWar:CurrentQuest", (entity.getPersistentData().getDouble("potatoWar:QuestNum")));
			sourceentity.getPersistentData().putDouble("potatoWar:CurrentQuest", (entity.getPersistentData().getDouble("potatoWar:QuestNum")));
			sourceentity.getPersistentData().putDouble("potatoWar:ItemType1", (entity.getPersistentData().getDouble("potatoWar:ItemType1")));
			sourceentity.getPersistentData().putDouble("potatoWar:ItemType2", (entity.getPersistentData().getDouble("potatoWar:ItemType2")));
			sourceentity.getPersistentData().putDouble("potatoWar:ItemType3", (entity.getPersistentData().getDouble("potatoWar:ItemType3")));
			sourceentity.getPersistentData().putDouble("potatoWar:PlayerItemCount1", (entity.getPersistentData().getDouble("potatoWar:itemcount1")));
			sourceentity.getPersistentData().putDouble("potatoWar:PlayerItemCount2", (entity.getPersistentData().getDouble("potatoWar:itemcount2")));
			sourceentity.getPersistentData().putDouble("potatoWar:PlayerItemCount3", (entity.getPersistentData().getDouble("potatoWar:itemcount3")));
			sourceentity.getPersistentData().putDouble("potatoWar:PlayerRewardCount1", (entity.getPersistentData().getDouble("potatoWar:RewardCount1")));
			sourceentity.getPersistentData().putDouble("potatoWar:PlayerRewardCount2", (entity.getPersistentData().getDouble("potatoWar:RewardCount2")));
			sourceentity.getPersistentData().putDouble("potatoWar:PlayerRewardType", (entity.getPersistentData().getDouble("potatoWar:RewardType")));
			sourceentity.getPersistentData().putDouble("potatoWar:CurrentFactionID", (entity.getPersistentData().getDouble("potatoWar:FactionID")));
			sourceentity.getPersistentData().putDouble("PotatoWar:CivilianID", (entity.getPersistentData().getDouble("PotatoWar:CivilianID")));
			sourceentity.getPersistentData().putBoolean("potatoWar:SlotsLocked", true);
			sourceentity.getPersistentData().putBoolean("potatoWar:HasQuest", true);
			if (sourceentity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public @NotNull Component getDisplayName() {
						return Component.literal("Itemquest");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new ItemquestMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.25);
		builder = builder.add(Attributes.MAX_HEALTH, 20);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}
}
