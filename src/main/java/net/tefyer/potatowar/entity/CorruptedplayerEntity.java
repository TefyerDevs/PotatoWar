
package net.tefyer.potatowar.entity;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;

import net.tefyer.potatowar.PotatowarMod;
import net.tefyer.potatowar.network.PotatowarModVariables;
import net.tefyer.potatowar.init.PotatowarModEntities;

import javax.annotation.Nullable;
import java.util.Objects;

public class CorruptedplayerEntity extends Monster {
	private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), ServerBossEvent.BossBarColor.WHITE, ServerBossEvent.BossBarOverlay.PROGRESS);

	public CorruptedplayerEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(PotatowarModEntities.CORRUPTEDPLAYER.get(), world);
	}

	public CorruptedplayerEntity(EntityType<CorruptedplayerEntity> type, Level world) {
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
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}
		});
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Player.class, false, false));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, ServerPlayer.class, false, false));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, HazzycloneEntity.class, false, false));
		this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, LostHazzyEntity.class, false, false));
		this.targetSelector.addGoal(7, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(9, new FloatGoal(this));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEAD;
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
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("potatowar:crptplayerambient"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("potatowar:crptplayerhurt"));
	}

	@Override
	public boolean hurt(DamageSource damagesource, float amount) {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		Entity sourceentity = damagesource.getEntity();
		Entity immediatesourceentity = damagesource.getDirectEntity();

		takeDamage(world, y, entity);
		return super.hurt(damagesource, amount);
	}

	public static void takeDamage(LevelAccessor world, double y, Entity entity) {
		if (entity == null)
			return;
		double NewX;
		double NewZ;
		if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
			if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
				NewX = entity.getX() + Mth.nextInt(RandomSource.create(), 1, 3);
			} else {
				NewX = entity.getX() - Mth.nextInt(RandomSource.create(), 1, 3);
			}
			if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
				NewZ = entity.getZ() + Mth.nextInt(RandomSource.create(), 1, 3);
			} else {
				NewZ = entity.getZ() - Mth.nextInt(RandomSource.create(), 1, 3);
			}
			if (!((world.getBlockState(BlockPos.containing(NewX, y, NewZ))).getBlock() == Blocks.AIR)) {
				{
                    entity.teleportTo(NewX, y, NewZ);
					if (entity instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(NewX, y, NewZ, entity.getYRot(), entity.getXRot());
				}
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 80, 1, false, false));
		}
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		if (this.level() instanceof ServerLevel _level)
			_level.getServer().getCommands()
					.performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL,
									new Vec3(this.getX(),this.getY(), this.getX()), Vec2.ZERO,
									_level, 4, "",
									Component.literal(""),
									_level.getServer(), null).withSuppressedOutput(), "stopsound @p");
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		spawn(world, this.getX(), this.getY(), this.getZ(), this);
		return retval;
	}

	public static void spawn(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("potatowar:crtpplayerbossmusic"))), SoundSource.MUSIC, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("potatowar:crtpplayerbossmusic"))), SoundSource.MUSIC, 1, 1, false);
			}
		}
		{
			boolean _setval = true;
			entity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BossFight1 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		PotatowarMod.queueServerWork(5680, () -> {
			{
				boolean _setval = false;
				entity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BossFight1 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		});
	}

	@Override
	public void baseTick() {
		super.baseTick();
		tickEntity(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	public static void tickEntity(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PotatowarModVariables.PlayerVariables())).BossFight1 == true) {
			{
				boolean _setval = false;
				entity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BossFight1 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("potatowar:bossmusic1")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("potatowar:bossmusic1")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			PotatowarMod.queueServerWork(5680, () -> {
				{
					boolean _setval = true;
					entity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.BossFight1 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			});
		}
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
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.32);
		builder = builder.add(Attributes.MAX_HEALTH, 175);
		builder = builder.add(Attributes.ARMOR, 14);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 10);
		builder = builder.add(Attributes.FOLLOW_RANGE, 64);
		return builder;
	}
}
