package net.tefyer.api.menus.messages;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;
import net.tefyer.api.CompoundTagIds;
import net.tefyer.api.entity.utils.EntityUtils;
import net.tefyer.api.entity.utils.GlobalVariableRegistry;
import net.tefyer.potatowar.PotatowarMod;
import net.tefyer.potatowar.client.menus.custom.ItemQuestMenu;

import java.util.HashMap;
import java.util.function.Supplier;

import static net.tefyer.api.entity.utils.EntityUtils.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemQuestSlotMessage {
    private final int slotID, x, y, z, changeType, meta;

    public ItemQuestSlotMessage(int slotID, int x, int y, int z, int changeType, int meta) {
        this.slotID = slotID;
        this.x = x;
        this.y = y;
        this.z = z;
        this.changeType = changeType;
        this.meta = meta;
    }

    public ItemQuestSlotMessage(FriendlyByteBuf buffer) {
        this.slotID = buffer.readInt();
        this.x = buffer.readInt();
        this.y = buffer.readInt();
        this.z = buffer.readInt();
        this.changeType = buffer.readInt();
        this.meta = buffer.readInt();
    }

    public static void buffer(ItemQuestSlotMessage message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.slotID);
        buffer.writeInt(message.x);
        buffer.writeInt(message.y);
        buffer.writeInt(message.z);
        buffer.writeInt(message.changeType);
        buffer.writeInt(message.meta);
    }

    public static void handler(ItemQuestSlotMessage message,
                               Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            Player entity = context.getSender();
            int slotID = message.slotID;
            int changeType = message.changeType;
            int meta = message.meta;
            int x = message.x;
            int y = message.y;
            int z = message.z;
            handleSlotAction(entity, slotID, changeType, meta, x, y, z);
        });
        context.setPacketHandled(true);
    }

    public static void handleSlotAction(Player player, int slot, int changeType, int meta, int x, int y, int z) {
        Level world = player.level();
        HashMap guistate = ItemQuestMenu.guistate;
        // security measure to prevent arbitrary chunk generation
        if (!world.hasChunkAt(new BlockPos(x, y, z)))
            return;
        if (slot == 6 && changeType == 1) {

            wipeQuestSlots(player);
        }
        if (slot == 6 && changeType == 2) {

            wipeQuestSlots(player);
        }
        if (slot == 7 && changeType == 1) {

            wipeQuestSlots(player);
        }
        if (slot == 7 && changeType == 2) {

            wipeQuestSlots(player);
        }
    }

    public static void wipeQuestSlots(Player player) {
        if(checkSlots(player,0,3) &&
                checkSlots(player,1,4) &&
                checkSlots(player,2,5) && !EntityUtils.getBoolean(player,
                CompoundTagIds.SlotsLocked) && player.containerMenu instanceof ItemQuestMenu){
            wipeQuestSlotsBasedOnHumanOrPotato(player);
        }
    }

    private static void wipeQuestSlotsBasedOnHumanOrPotato(Player player) {
        if(EntityUtils.getDouble(player, CompoundTagIds.FactionID) == 1){
            setPotatoReputation(player, addPotatoReputation(player,10));
            setHumanReputation(player, subHumanReputation(player, 15));
        } else if(EntityUtils.getDouble(player, CompoundTagIds.FactionID) == 2){
            setPotatoReputation(player, subPotatoReputation(player,15));
            setHumanReputation(player, addHumanReputation(player, 10));
        }
    }

    private static boolean checkSlots(Player player, int slot1, int slot2) {
        return player.getSlot(slot1).get().getItem().equals(player.getSlot(slot2).get().getItem());
    }

    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        PotatowarMod.addNetworkMessage(ItemQuestSlotMessage.class, ItemQuestSlotMessage::buffer, ItemQuestSlotMessage::new,
                ItemQuestSlotMessage::handler);
    }
}
