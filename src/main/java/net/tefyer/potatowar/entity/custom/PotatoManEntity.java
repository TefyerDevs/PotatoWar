package net.tefyer.potatowar.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;
import net.tefyer.api.CompoundTagIds;
import net.tefyer.api.entity.utils.EntityUtils;
import net.tefyer.api.item.kit.KitType;
import net.tefyer.potatowar.entity.EntityRegistry;
import net.tefyer.potatowar.items.ChestMalitiaMarker;
import net.tefyer.potatowar.items.custom.KitItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class PotatoManEntity extends PathfinderMob {

    public static KitType kitType;

    public PotatoManEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(EntityRegistry.POTATO_MAN.get(), world);
    }



    @Override
    public @NotNull Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.getNavigation().getNodeEvaluator().setCanOpenDoors(true);
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.2));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(4, new FloatGoal(this));
        this.goalSelector.addGoal(5, new OpenDoorGoal(this, true));
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
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
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty,
                                        MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
        SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
        EntityUtils.potatoManSetItems(world, this.getX(), this.getY(), this.getZ(), this);
        return retval;
    }



    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
        super.mobInteract(player, hand);
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();

        if(kitType != KitType.BLANK){
            performChange(itemstack);
        }

        if(itemstack.getItem() instanceof ChestMalitiaMarker markerItem &&
                    kitType == KitType.MILITA){
            // todo: make malitia work
        }

        EntityUtils.potatoManStartTrade(this.level(), x, y, z, this, player);
        return retval;
    }

    private void performChange(ItemStack stack) {
        if(stack.getItem() instanceof KitItem item){
           setKitType(item.getType());
        }
    }



    @Override
    public void baseTick() {
        super.baseTick();
        if (EntityUtils.checkMinMaxEntityX(this, CompoundTagIds.HomeX,64,64) ||
                EntityUtils.checkMinMaxEntityX(this,CompoundTagIds.HomeZ,64,64))
            this.getPersistentData().putBoolean("potatowar:OutsideTownPosition", true);

        if (this.getPersistentData().getBoolean("potatowar:outsidePosition"))
            this.getNavigation().moveTo((this.getPersistentData().getDouble(CompoundTagIds.HomeX)), getY(),
                        (this.getPersistentData().getDouble(CompoundTagIds.HomeZ)), 1.2);

        if (EntityUtils.checkMinMaxEntityX(this,CompoundTagIds.HomeX,8,8) ||
                EntityUtils.checkMinMaxEntityZ(this,CompoundTagIds.HomeZ,8,8))
            this.getPersistentData().putBoolean("potatowar:OutsideTownPosition", false);

        for (Entity entityiterator : new ArrayList<>(this.level().players())) {
            if ((this.getPersistentData().getString("potatowar:QuestHolder"))
                    .equals(ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString())) {
                if (!(entityiterator.getPersistentData().getDouble(CompoundTagIds.CivilianID) ==
                        this.getPersistentData().getDouble(CompoundTagIds.CivilianID))) {
                    this.getPersistentData().putBoolean("potatowar:QuestTaken", false);
                }
            }
        }
    }

    public static void init() {
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.25);
        builder = builder.add(Attributes.MAX_HEALTH, 10);
        builder = builder.add(Attributes.ARMOR, 0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
        builder = builder.add(Attributes.FOLLOW_RANGE, 16);
        return builder;
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    @Override
    public double getMyRidingOffset() {
        return -0.35D;
    }

    public PotatoManEntity(EntityType<PotatoManEntity> type, Level world) {
        super(type, world);
        setMaxUpStep(0.6f);
        xpReward = 0;
        setNoAi(false);
        setPersistenceRequired();
    }


    public void setKitType(KitType type) {
        kitType = type;
    }
}
