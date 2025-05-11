package net.tefyer.api.entity.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;
import net.tefyer.potatowar.PotatowarMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GlobalVariableRegistry {
    public static String PlayerName = "\"\"";

    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        PotatowarMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
        PotatowarMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
    }

    @SubscribeEvent
    public static void init(RegisterCapabilitiesEvent event) {
        event.register(PlayerVariables.class);
    }

    @Mod.EventBusSubscriber
    public static class EventBusVariableHandlers {
        @SubscribeEvent
        public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
            if (!event.getEntity().level().isClientSide())
                ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
        }

        @SubscribeEvent
        public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
            if (!event.getEntity().level().isClientSide())
                ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
        }

        @SubscribeEvent
        public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
            if (!event.getEntity().level().isClientSide())
                ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
        }

        @SubscribeEvent
        public static void clonePlayer(PlayerEvent.Clone event) {
            event.getOriginal().revive();
            PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
            PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
            clone.PotatoReputation = original.PotatoReputation;
            clone.PlayerX = original.PlayerX;
            clone.PlayerY = original.PlayerY;
            clone.PlayerZ = original.PlayerZ;
            clone.HumanReputation = original.HumanReputation;
            clone.LeaderID = original.LeaderID;
            clone.HasQuest = original.HasQuest;
            if (!event.isWasDeath()) {
                clone.BossFight1 = original.BossFight1;
                clone.BossFight2 = original.BossFight2;
                clone.AssassinName = original.AssassinName;
                clone.AssassinThing = original.AssassinThing;
                clone.AssassinX = original.AssassinX;
                clone.AssassinZ = original.AssassinZ;
            }
        }

        @SubscribeEvent
        public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
            if (!event.getEntity().level().isClientSide()) {
                SavedData mapdata = MapVariables.get(event.getEntity().level());
                SavedData worlddata = WorldVariables.get(event.getEntity().level());
                if (mapdata != null)
                    PotatowarMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
                if (worlddata != null)
                    PotatowarMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
            }
        }

        @SubscribeEvent
        public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
            if (!event.getEntity().level().isClientSide()) {
                SavedData worlddata = WorldVariables.get(event.getEntity().level());
                if (worlddata != null)
                    PotatowarMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
            }
        }
    }

    public static class WorldVariables extends SavedData {
        public static final String DATA_NAME = "potatowar_worldvars";
        public double BossShield = 0;
        public double MigrationX = 0;
        public double MigrationZ = 0;

        public static WorldVariables load(CompoundTag tag) {
            WorldVariables data = new WorldVariables();
            data.read(tag);
            return data;
        }

        public void read(CompoundTag nbt) {
            BossShield = nbt.getDouble("BossShield");
            MigrationX = nbt.getDouble("MigrationX");
            MigrationZ = nbt.getDouble("MigrationZ");
        }

        @Override
        public CompoundTag save(CompoundTag nbt) {
            nbt.putDouble("BossShield", BossShield);
            nbt.putDouble("MigrationX", MigrationX);
            nbt.putDouble("MigrationZ", MigrationZ);
            return nbt;
        }

        public void syncData(LevelAccessor world) {
            this.setDirty();
            if (world instanceof Level level && !level.isClientSide())
                PotatowarMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
        }

        static WorldVariables clientSide = new WorldVariables();

        public static WorldVariables get(LevelAccessor world) {
            if (world instanceof ServerLevel level) {
                return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
            } else {
                return clientSide;
            }
        }
    }

    public static class MapVariables extends SavedData {
        public static final String DATA_NAME = "potatowar_mapvars";
        public boolean DigiArenaSpawned = false;
        public double RaidX = 0;
        public double RaidZ = 0;
        public boolean SpawnPrototypeCooldown = false;

        public static MapVariables load(CompoundTag tag) {
            MapVariables data = new MapVariables();
            data.read(tag);
            return data;
        }

        public void read(CompoundTag nbt) {
            DigiArenaSpawned = nbt.getBoolean("DigiArenaSpawned");
            RaidX = nbt.getDouble("RaidX");
            RaidZ = nbt.getDouble("RaidZ");
            SpawnPrototypeCooldown = nbt.getBoolean("SpawnPrototypeCooldown");
        }

        @Override
        public CompoundTag save(CompoundTag nbt) {
            nbt.putBoolean("DigiArenaSpawned", DigiArenaSpawned);
            nbt.putDouble("RaidX", RaidX);
            nbt.putDouble("RaidZ", RaidZ);
            nbt.putBoolean("SpawnPrototypeCooldown", SpawnPrototypeCooldown);
            return nbt;
        }

        public void syncData(LevelAccessor world) {
            this.setDirty();
            if (world instanceof Level && !world.isClientSide())
                PotatowarMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
        }

        static MapVariables clientSide = new MapVariables();

        public static MapVariables get(LevelAccessor world) {
            if (world instanceof ServerLevelAccessor serverLevelAcc) {
                return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
            } else {
                return clientSide;
            }
        }
    }

    public static class SavedDataSyncMessage {
        private final int type;
        private SavedData data;

        public SavedDataSyncMessage(FriendlyByteBuf buffer) {
            this.type = buffer.readInt();
            CompoundTag nbt = buffer.readNbt();
            if (nbt != null) {
                this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
                if (this.data instanceof MapVariables mapVariables)
                    mapVariables.read(nbt);
                else if (this.data instanceof WorldVariables worldVariables)
                    worldVariables.read(nbt);
            }
        }

        public SavedDataSyncMessage(int type, SavedData data) {
            this.type = type;
            this.data = data;
        }

        public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
            buffer.writeInt(message.type);
            if (message.data != null)
                buffer.writeNbt(message.data.save(new CompoundTag()));
        }

        public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
            NetworkEvent.Context context = contextSupplier.get();
            context.enqueueWork(() -> {
                if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
                    if (message.type == 0)
                        MapVariables.clientSide = (MapVariables) message.data;
                    else
                        WorldVariables.clientSide = (WorldVariables) message.data;
                }
            });
            context.setPacketHandled(true);
        }
    }

    public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
    });

    @Mod.EventBusSubscriber
    private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
        @SubscribeEvent
        public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
            if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
                event.addCapability(new ResourceLocation("potatowar", "player_variables"), new PlayerVariablesProvider());
        }

        private final PlayerVariables playerVariables = new PlayerVariables();
        private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

        @Override
        public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
            return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
        }

        @Override
        public Tag serializeNBT() {
            return playerVariables.writeNBT();
        }

        @Override
        public void deserializeNBT(Tag nbt) {
            playerVariables.readNBT(nbt);
        }
    }

    public static class PlayerVariables {
        public boolean BossFight1 = false;
        public double PotatoReputation = 0;
        public boolean BossFight2 = false;
        public double PlayerX = 0;
        public double PlayerY = 0.0;
        public double PlayerZ = 0;
        public double HumanReputation = 0;
        public double LeaderID = 0;
        public String AssassinName = "\"Name test\"";
        public String AssassinThing = "\"ThingTest\"";
        public double AssassinX = 0;
        public double AssassinZ = 0;
        public boolean HasQuest = false;

        public void syncPlayerVariables(Entity entity) {
            if (entity instanceof ServerPlayer serverPlayer)
                PotatowarMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
        }

        public Tag writeNBT() {
            CompoundTag nbt = new CompoundTag();
            nbt.putBoolean("BossFight1", BossFight1);
            nbt.putDouble("PotatoReputation", PotatoReputation);
            nbt.putBoolean("BossFight2", BossFight2);
            nbt.putDouble("PlayerX", PlayerX);
            nbt.putDouble("PlayerY", PlayerY);
            nbt.putDouble("PlayerZ", PlayerZ);
            nbt.putDouble("HumanReputation", HumanReputation);
            nbt.putDouble("LeaderID", LeaderID);
            nbt.putString("AssassinName", AssassinName);
            nbt.putString("AssassinThing", AssassinThing);
            nbt.putDouble("AssassinX", AssassinX);
            nbt.putDouble("AssassinZ", AssassinZ);
            nbt.putBoolean("HasQuest", HasQuest);
            return nbt;
        }

        public void readNBT(Tag tag) {
            CompoundTag nbt = (CompoundTag) tag;
            BossFight1 = nbt.getBoolean("BossFight1");
            PotatoReputation = nbt.getDouble("PotatoReputation");
            BossFight2 = nbt.getBoolean("BossFight2");
            PlayerX = nbt.getDouble("PlayerX");
            PlayerY = nbt.getDouble("PlayerY");
            PlayerZ = nbt.getDouble("PlayerZ");
            HumanReputation = nbt.getDouble("HumanReputation");
            LeaderID = nbt.getDouble("LeaderID");
            AssassinName = nbt.getString("AssassinName");
            AssassinThing = nbt.getString("AssassinThing");
            AssassinX = nbt.getDouble("AssassinX");
            AssassinZ = nbt.getDouble("AssassinZ");
            HasQuest = nbt.getBoolean("HasQuest");
        }
    }

    public static class PlayerVariablesSyncMessage {
        private final PlayerVariables data;

        public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
            this.data = new PlayerVariables();
            this.data.readNBT(buffer.readNbt());
        }

        public PlayerVariablesSyncMessage(PlayerVariables data) {
            this.data = data;
        }

        public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
            buffer.writeNbt((CompoundTag) message.data.writeNBT());
        }

        public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
            NetworkEvent.Context context = contextSupplier.get();
            context.enqueueWork(() -> {
                if (!context.getDirection().getReceptionSide().isServer()) {
                    PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
                    variables.BossFight1 = message.data.BossFight1;
                    variables.PotatoReputation = message.data.PotatoReputation;
                    variables.BossFight2 = message.data.BossFight2;
                    variables.PlayerX = message.data.PlayerX;
                    variables.PlayerY = message.data.PlayerY;
                    variables.PlayerZ = message.data.PlayerZ;
                    variables.HumanReputation = message.data.HumanReputation;
                    variables.LeaderID = message.data.LeaderID;
                    variables.AssassinName = message.data.AssassinName;
                    variables.AssassinThing = message.data.AssassinThing;
                    variables.AssassinX = message.data.AssassinX;
                    variables.AssassinZ = message.data.AssassinZ;
                    variables.HasQuest = message.data.HasQuest;
                }
            });
            context.setPacketHandled(true);
        }
    }
}
