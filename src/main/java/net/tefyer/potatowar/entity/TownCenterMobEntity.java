
package net.tefyer.potatowar.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;

import net.tefyer.potatowar.network.PotatowarModVariables;
import net.tefyer.potatowar.procedures.*;
import net.tefyer.potatowar.init.PotatowarModEntities;

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.List;

public class TownCenterMobEntity extends Monster {
	private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), ServerBossEvent.BossBarColor.WHITE, ServerBossEvent.BossBarOverlay.PROGRESS);

	public TownCenterMobEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(PotatowarModEntities.TOWN_CENTER_MOB.get(), world);
	}

	public TownCenterMobEntity(EntityType<TownCenterMobEntity> type, Level world) {
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
		this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(2, new FloatGoal(this));
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
		finSpawn(world, this.getX(), this.getY(), this.getZ(), this);
		return retval;
	}

	public static void finSpawn(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putString("potatowar:TownName", TownNameProcedure.execute(world, x, y, z, entity));
		entity.getPersistentData().putString("potatowar:CreatorName", PotatowarModVariables.PlayerName);
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal((entity.getPersistentData().getString("potatowar:CreatorName") + "" + ("Founded the town of " + entity.getPersistentData().getString("potatowar:TownName")))),
					false);
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

		mobInteract(entity, sourceentity);
		return retval;
	}

	public static void mobInteract(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal((entity.getPersistentData().getString("potatowar:TownName"))), false);
	}

	@Override
	public void baseTick() {
		super.baseTick();
		tick(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	public static void tick(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double RandomNum = 0;
		double RaidSpawnX = 0;
		double RaidSpawnZ = 0;
		double Cooldown = 0;
		if (entity.getPersistentData().getDouble("potatowar:TownCenterCheckCooldown") <= 0 && entity.getPersistentData().getBoolean("potatowar:RaidActive") == false && entity.getPersistentData().getBoolean("potatowar:RaidCooldown") == false) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:potato"))) && entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("potatowar:civilian")))) {
						entity.getPersistentData().putDouble("potatowar:TownPoints", (entity.getPersistentData().getDouble("potatowar:TownPoints") + Mth.nextInt(RandomSource.create(), 1, 3)));
					} else if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:potato")))
							&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("potatowar:civilian")))) {
						entity.getPersistentData().putDouble("potatowar:TownPoints", (entity.getPersistentData().getDouble("potatowar:TownPoints") + Mth.nextInt(RandomSource.create(), 3, 5)));
					}
				}
			}
			entity.getPersistentData().putDouble("potatowar:TownCenterCheckCooldown", 100);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Raid score is: " + entity.getPersistentData().getDouble("potatowar:TownPoints"))), false);
			if (entity.getPersistentData().getDouble("potatowar:TownPoints") >= 200) {
				entity.getPersistentData().putDouble("potatowar:TownPoints", 0);
				RandomNum = Mth.nextInt(RandomSource.create(), 1, 2);
				if (RandomNum == 1) {
					RaidSpawnX = entity.getX() + 48;
				} else {
					RaidSpawnX = entity.getX() - 48;
				}
				RandomNum = Mth.nextInt(RandomSource.create(), 1, 2);
				if (RandomNum == 1) {
					RaidSpawnZ = entity.getZ() + 48;
				} else {
					RaidSpawnZ = entity.getZ() - 48;
				}
				PotatowarModVariables.MapVariables.get(world).RaidX = entity.getX();
				PotatowarModVariables.MapVariables.get(world).syncData(world);
				PotatowarModVariables.MapVariables.get(world).RaidZ = entity.getZ();
				PotatowarModVariables.MapVariables.get(world).syncData(world);
				SpawnRaidersTeir1Procedure.execute(world, RaidSpawnX, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z), RaidSpawnZ);
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player || entityiterator instanceof ServerPlayer) {
							if (entityiterator instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("A raid is happening!"), false);
							entity.getPersistentData().putBoolean("potatowar:RaidActive", true);
						}
					}
				}
			}
		} else if (entity.getPersistentData().getDouble("potatowar:TownCenterCheckCooldown") > 0) {
			entity.getPersistentData().putDouble("potatowar:TownCenterCheckCooldown", (entity.getPersistentData().getDouble("potatowar:TownCenterCheckCooldown") - 1));
		}
	}

	@Override
	public boolean canCollideWith(Entity entity) {
		return true;
	}

	@Override
	public boolean canBeCollidedWith() {
		return true;
	}

	@Override
	public boolean canChangeDimensions() {
		return false;
	}

	@Override
	public void startSeenByPlayer(ServerPlayer player) {
		super.startSeenByPlayer(player);
		this.bossInfo.addPlayer(player);
	}

	@Override
	public void stopSeenByPlayer(ServerPlayer player) {
		super.stopSeenByPlayer(player);
		this.bossInfo.removePlayer(player);
	}

	@Override
	public void customServerAiStep() {
		super.customServerAiStep();
		this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 500);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 100);
		return builder;
	}
}
