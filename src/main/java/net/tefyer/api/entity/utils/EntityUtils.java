package net.tefyer.api.entity.utils;

import io.netty.buffer.Unpooled;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.network.NetworkHooks;
import net.tefyer.api.CompoundTagIds;
import net.tefyer.potatowar.client.menus.MenuRegistry;
import net.tefyer.potatowar.client.menus.custom.ItemQuestMenu;
import net.tefyer.potatowar.entity.custom.PotatoManEntity;
import net.tefyer.potatowar.tags.ModTags;
import org.jetbrains.annotations.Nullable;

public class EntityUtils {
    public static final <T extends Entity> boolean checkMinMaxEntityX(T entity, String id, int max, int min){
        return entity.getX() >= entity.getPersistentData().getDouble(id) + max || entity.getX()
                <= entity.getPersistentData().getDouble(id) - min;
    }

    public static final <T extends Entity> boolean checkMinMaxEntityY(T entity, String id, int max, int min){
        return entity.getY() >= entity.getPersistentData().getDouble(id) + max || entity.getY()
                <= entity.getPersistentData().getDouble(id) - min;
    }

    public static final <T extends Entity> boolean checkMinMaxEntityZ(T entity, String id, int max, int min){
        return entity.getZ() >= entity.getPersistentData().getDouble(id) + max || entity.getZ()
                <= entity.getPersistentData().getDouble(id) - min;
    }

    public static <T extends Entity> void putValue(T entity,String id, int i){
        entity.getPersistentData().putInt(id, i);
    }
    public static <T extends Entity> void putValue(T entity,String id, double i){
        entity.getPersistentData().putDouble(id, i);
    }
    public static <T extends Entity> void putValue(T entity,String id, boolean i){
        entity.getPersistentData().putBoolean(id, i);
    }
    public static <T extends Entity> void putValue(T entity,String id, String i){
        entity.getPersistentData().putString(id, i);
    }

    public static <T extends Entity> int getInt(T entity,String id){
        return entity.getPersistentData().getInt(id);
    }
    public static <T extends Entity> double getDouble(T entity,String id){
        return entity.getPersistentData().getDouble(id);
    }
    public static <T extends Entity> boolean getBoolean(T entity,String id){
        return entity.getPersistentData().getBoolean(id);
    }
    public static <T extends Entity> String getString(T entity,String id){
        return entity.getPersistentData().getString(id);
    }


    public static double addPotatoReputation(Player player, int i) {
        return (player.getCapability(GlobalVariableRegistry.PLAYER_VARIABLES_CAPABILITY,null)
                .orElse(new GlobalVariableRegistry.PlayerVariables()).PotatoReputation + i);
    }
    public static double subPotatoReputation(Player player, int i) {
        return (player.getCapability(GlobalVariableRegistry.PLAYER_VARIABLES_CAPABILITY,null)
                .orElse(new GlobalVariableRegistry.PlayerVariables()).PotatoReputation - i);
    }

    public static double addHumanReputation(Player player, int i) {
        return (player.getCapability(GlobalVariableRegistry.PLAYER_VARIABLES_CAPABILITY,null)
                .orElse(new GlobalVariableRegistry.PlayerVariables()).HumanReputation + i);
    }
    public static double subHumanReputation(Player player, int i) {
        return (player.getCapability(GlobalVariableRegistry.PLAYER_VARIABLES_CAPABILITY,null)
                .orElse(new GlobalVariableRegistry.PlayerVariables()).HumanReputation - i);
    }

    public static void setPotatoReputation(Player player, double setVal) {
        player.getCapability(GlobalVariableRegistry.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(caps ->{
            caps.PotatoReputation = setVal;
            caps.syncPlayerVariables(player);
        });
    }

    public static void setHumanReputation(Player player, double setVal) {
        player.getCapability(GlobalVariableRegistry.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(caps ->{
            caps.HumanReputation = setVal;
            caps.syncPlayerVariables(player);
        });
    }


    public static String getRandomAssassinName() {
        int randomnumber = Mth.nextInt(RandomSource.create(), 1, 12);;
        String assassinname;
        String lastname;


        switch (randomnumber){
            case 1: assassinname = "Darkbeat";
            case 2: assassinname = "Blacksaw";
            case 3: assassinname = "Hollowshot";
            case 4: assassinname = "Ironkill";
            case 5: assassinname = "Bob";
            case 6: assassinname = "Bulletcrash";
            case 7: assassinname = "Crimsonflash";
            case 8: assassinname = "Deathshroud";
            case 9: assassinname = "Venomcloak";
            case 10: assassinname = "Silentstrike";
            case 11: assassinname = "Nightshade";
            case 12: assassinname = "Phantomblade";
            default: assassinname = "NULL";
        }
        randomnumber = Mth.nextInt(RandomSource.create(), 1, 12);

        switch (randomnumber){
            case 1: lastname = "Whispering Death";
            case 2: lastname = "Cloak of Doom";
            case 3: lastname = "The Enigma";
            case 4: lastname = "Abyssal Executioner";
            case 5: lastname = "The Destroyer";
            case 6: lastname = "Shadeborne";
            case 7: lastname = "Veil of Darkness";
            case 8: lastname = "Obsidian Wraith";
            case 9: lastname = "Netherblade";
            case 10: lastname = "The Lurking Doom";
            case 11: lastname = "Veiled Marauder";
            case 12: lastname = "The Crimson Viper";
            default: lastname = "NULL";
        }
        return assassinname + " " + lastname;
    }
    public static String getRandomAssassinThing() {

        String whatDidTheAssainDo = "NULL_1";
        int RandomNumber = Mth.nextInt(RandomSource.create(), 1, 10);

        switch (RandomNumber){
            case 1:whatDidTheAssainDo = "stole my socks";
            case 2:whatDidTheAssainDo = "robbed me the other day";
            case 3:whatDidTheAssainDo = "attacked another village";
            case 4:whatDidTheAssainDo = "burned someones house";
            case 5:whatDidTheAssainDo = "killed a town guard";
            case 6:whatDidTheAssainDo = "burned a rival's hideout";
            case 7:whatDidTheAssainDo = "betrayed a former ally";
            case 8:whatDidTheAssainDo = "stole a sacred relic";
            case 9:whatDidTheAssainDo = "disrupted a trade route";
            case 10:whatDidTheAssainDo = "released dangerous creatures";
            default:whatDidTheAssainDo = "NULL_2";
        }
        return whatDidTheAssainDo;
    }

    public static void potatoManSetItems(LevelAccessor world, double x, double y, double z, PotatoManEntity entity) {
        if(entity == null)
            return;
        int randomNum = Mth.nextInt(RandomSource.create(),1,5);

        putValue(entity,"potatowar:FactionID", 1D);
        putValue(entity,"potatowar:AssassinQuest", false);
        putValue(entity,"potatowar:CivilianID", (Mth.nextDouble(RandomSource.create(), 1, 1000)));

        switch (randomNum){
            case 1: {
                putValue(entity,"potatowar:AssassinQuest", true);
                putValue(entity,"potatowar:AssassinName", getRandomAssassinName());
                putValue(entity,"potatowar:AssassinThing", getRandomAssassinThing());

                // reroll to decide X
                randomNum =Mth.nextInt(RandomSource.create(),1,2);
                putValue(entity, "potatowar:AssassinX", decideValueBasedOn12Num(entity, randomNum,100,500));
                // reroll to decide Z
                randomNum =Mth.nextInt(RandomSource.create(),1,2);
                putValue(entity, "potatowar:AssassinZ", decideValueBasedOn12Num(entity, randomNum,100,500));

            }
            case 2: {
                addDataToPotatoMan(entity,1,(Mth.nextInt(RandomSource.create(), 1, 5)),
                        (Mth.nextInt(RandomSource.create(), 1, 5)),(Mth.nextInt(RandomSource.create(), 1, 4)),
                        (Mth.nextInt(RandomSource.create(), 10, 60)),(Mth.nextInt(RandomSource.create(), 3, 7)),
                        1, (Mth.nextInt(RandomSource.create(), 1, 5)),(Mth.nextInt(RandomSource.create(), 1, 7))
                        ,(Mth.nextInt(RandomSource.create(), 10, 30)),(Mth.nextDouble(RandomSource.create(), 0, 1000)),
                        true);

            }
            case 3: {
                addDataToPotatoMan(entity,2,(Mth.nextInt(RandomSource.create(), 1, 5)),
                        (Mth.nextInt(RandomSource.create(), 1, 2)),(Mth.nextInt(RandomSource.create(), 1, 3)),
                        (Mth.nextInt(RandomSource.create(), 3, 10)),(Mth.nextInt(RandomSource.create(), 3, 9)),
                        1, (Mth.nextInt(RandomSource.create(), 1, 5)),(Mth.nextInt(RandomSource.create(), 5, 12))
                        ,(Mth.nextInt(RandomSource.create(), 3, 8)),true);
            }
            case 4: {
                addDataToPotatoMan(entity,3,(Mth.nextInt(RandomSource.create(), 1, 5)),
                        (Mth.nextInt(RandomSource.create(), 1, 5)),(Mth.nextInt(RandomSource.create(), 1, 4)),
                        (Mth.nextInt(RandomSource.create(), 10, 60)),(Mth.nextInt(RandomSource.create(), 3, 7)),
                        1, (Mth.nextInt(RandomSource.create(), 1, 5)),(Mth.nextInt(RandomSource.create(), 1, 7))
                        ,(Mth.nextInt(RandomSource.create(), 10, 30)),true);
            }
            case 5: {
                addDataToPotatoMan(entity,4,(Mth.nextInt(RandomSource.create(), 1, 5)),
                        (Mth.nextInt(RandomSource.create(), 1, 5)),(Mth.nextInt(RandomSource.create(), 1, 4)),
                        (Mth.nextInt(RandomSource.create(), 10, 60)),(Mth.nextInt(RandomSource.create(), 3, 7)),
                        (Mth.nextInt(RandomSource.create(), 5, 20)), (Mth.nextInt(RandomSource.create(), 1, 5)),
                        (Mth.nextInt(RandomSource.create(), 1, 7))
                        ,(Mth.nextInt(RandomSource.create(), 10, 30)),true);
            }
        }

    }

    public static <T extends Entity> void addDataToPotatoMan(T entity, double questNum,
                                                             double itemType1, double itemType2, double itemType3,
                                                             double itemCount1, double itemCount2, double itemCount3,
                                                             double rewardType, double rewardCount1, double rewardCount2,
                                                             double civilianID, boolean hasQuest){
        putValue(entity,CompoundTagIds.QuestNum,questNum);
        putValue(entity,CompoundTagIds.ItemType1,itemType1);
        putValue(entity,CompoundTagIds.ItemType2,itemType2);
        putValue(entity,CompoundTagIds.ItemType3,itemType3);
        putValue(entity,CompoundTagIds.ItemCount1,itemCount1);
        putValue(entity,CompoundTagIds.ItemCount2,itemCount2);
        putValue(entity,CompoundTagIds.ItemCount3,itemCount3);
        putValue(entity,CompoundTagIds.RewardType,rewardType);
        putValue(entity,CompoundTagIds.RewardCount1,rewardCount1);
        putValue(entity,CompoundTagIds.RewardCount2,rewardCount2);
        putValue(entity,CompoundTagIds.CivilianID,civilianID);
        putValue(entity,CompoundTagIds.HasQuest,hasQuest);

    }
    public static <T extends Entity> void addDataToPotatoMan(T entity, double questNum,
                                                             double itemType1, double itemType2, double itemType3,
                                                             double itemCount1, double itemCount2, double itemCount3,
                                                             double rewardType, double rewardCount1, double rewardCount2,
                                                             boolean hasQuest){
        putValue(entity,CompoundTagIds.QuestNum,questNum);
        putValue(entity,CompoundTagIds.ItemType1,itemType1);
        putValue(entity,CompoundTagIds.ItemType2,itemType2);
        putValue(entity,CompoundTagIds.ItemType3,itemType3);
        putValue(entity,CompoundTagIds.ItemCount1,itemCount1);
        putValue(entity,CompoundTagIds.ItemCount2,itemCount2);
        putValue(entity,CompoundTagIds.ItemCount3,itemCount3);
        putValue(entity,CompoundTagIds.RewardType,rewardType);
        putValue(entity,CompoundTagIds.RewardCount1,rewardCount1);
        putValue(entity,CompoundTagIds.RewardCount2,rewardCount2);
        putValue(entity,CompoundTagIds.HasQuest,hasQuest);

    }

    public static <T extends Entity>  double decideValueBasedOn12Num(T entity, int randomNum, int min, int max) {
        if (randomNum == 1)
            return (entity.getX() + min + Mth.nextInt(RandomSource.create(), 1, max));
       return (entity.getX() - min - Mth.nextInt(RandomSource.create(), 1, max));
    }

    public static void potatoManStartTrade(LevelAccessor world, double x, double y, double z, PotatoManEntity entity, Player player) {
        if(entity == null || player == null) return;
        if(getBoolean(entity,CompoundTagIds.RandomizeQuest)){
            putValue(entity,CompoundTagIds.RandomizeQuest, false);
            potatoManSetItems(world, x, y, z, entity);
        }
        if(checkIfReputationGreaterThanEquals(player, 0) &&
                player.getMainHandItem().is(ModTags.Items.POTATO_KITS) &&
                getBoolean(player,CompoundTagIds.AssassinQuest)){ // if the trade is done
            preformTrade(player,entity);

        }else{ // help make a new trade
            copyPotatoManValuesToPlayer(player,entity);
            openPotatoManMenu(player, entity);
        }

    }

    public static void copyPotatoManValuesToPlayer(Player player, PotatoManEntity entity) {
        putValue(player, CompoundTagIds.MilitaryPrice, getDouble(entity, CompoundTagIds.MilitaryPrice));
        putValue(player, CompoundTagIds.CurrentQuest, getDouble(entity,CompoundTagIds.CurrentQuest));
        putValue(player, CompoundTagIds.ItemType1, getDouble(entity,CompoundTagIds.ItemType1));
        putValue(player, CompoundTagIds.ItemType2, getDouble(entity,CompoundTagIds.ItemType2));
        putValue(player, CompoundTagIds.ItemType2, getDouble(entity,"potatowar:ItemType3"));
        putValue(player, CompoundTagIds.PlayerItemCount1, getDouble(entity,CompoundTagIds.ItemCount1));
        putValue(player, CompoundTagIds.PlayerItemCount2, getDouble(entity,CompoundTagIds.ItemCount2));
        putValue(player, CompoundTagIds.PlayerItemCount3, getDouble(entity,CompoundTagIds.ItemCount3));
        putValue(player, CompoundTagIds.PlayerRewardCount1, getDouble(entity,CompoundTagIds.PlayerRewardCount1));
        putValue(player, CompoundTagIds.PlayerRewardCount2, getDouble(entity, CompoundTagIds.PlayerRewardCount2));
        putValue(player, CompoundTagIds.PlayerRewardType, getDouble(entity,CompoundTagIds.PlayerRewardType));
        putValue(player, CompoundTagIds.CurrentFactionID, getDouble(entity,CompoundTagIds.CurrentFactionID));
        putValue(player, CompoundTagIds.CivilianID, getDouble(entity,CompoundTagIds.CivilianID));
        putValue(player, CompoundTagIds.SlotsLocked, true);
        putValue(player, CompoundTagIds.HasQuest, true);
    }

    public static void openPotatoManMenu(Player player,Entity entity) {
        if(player instanceof ServerPlayer serverPlayer){
            NetworkHooks.openScreen(serverPlayer, new MenuProvider() {
                @Override
                public Component getDisplayName() {
                    return Component.translatable("menu.potatowar.item_quest");
                }

                @Override
                public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
                    return MenuRegistry.ITEMQUEST.get().create(pContainerId, pPlayerInventory,
                            new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(entity.blockPosition()));
                }
            },entity.blockPosition());
        }
    }

    public static void preformTrade(Player player, PotatoManEntity entity) {
        if(getBoolean(entity,CompoundTagIds.QuestTaken)) { player.displayClientMessage(
                Component.translatable("chat.potato_war.allready_taken_quest"),false); return;}

        if(!hasQuest(player)) {makeQuest(player,entity); return;}

        if(getDouble(entity, CompoundTagIds.CivilianID) == getDouble(player,CompoundTagIds.CivilianID))
            sendMessage(player, Component.translatable("chat.potato_war.quest_not_complete"));
        else sendMessage(player, Component.translatable("chat.potato_war.allready_has_quest"));
    }

    public static void makeQuest(Player player, PotatoManEntity entity) {
        setAssassinName(player,getString(entity,CompoundTagIds.AssassinName));
        setAssasinThing(player,getString(entity,CompoundTagIds.AssassinThing));
        setAssasinX(player,getDouble(entity,CompoundTagIds.AssassinX));
        setAssasinZ(player,getDouble(entity,CompoundTagIds.AssassinZ));
    }

    private static void setAssasinThing(Player player, String string) {
        player.getCapability(GlobalVariableRegistry.PLAYER_VARIABLES_CAPABILITY,null)
                .orElse(new GlobalVariableRegistry.PlayerVariables()).AssassinThing = string;
    }

    private static void setAssassinName(Player player, String string) {
        player.getCapability(GlobalVariableRegistry.PLAYER_VARIABLES_CAPABILITY,null)
                .orElse(new GlobalVariableRegistry.PlayerVariables()).AssassinName = string;
    }

    private static void setAssasinZ(Player player, double aDouble) {
        player.getCapability(GlobalVariableRegistry.PLAYER_VARIABLES_CAPABILITY,null)
                .orElse(new GlobalVariableRegistry.PlayerVariables()).AssassinX = aDouble;

    }

    private static void setAssasinX(Player player, double aDouble) {
        player.getCapability(GlobalVariableRegistry.PLAYER_VARIABLES_CAPABILITY,null)
                .orElse(new GlobalVariableRegistry.PlayerVariables()).AssassinZ = aDouble;
    }



    public static void sendMessage(Player player, Component text) {
        if(!player.level().isClientSide()) player.displayClientMessage(text,false);
    }

    public static boolean hasQuest(Player player) {
        return player.getCapability(GlobalVariableRegistry.PLAYER_VARIABLES_CAPABILITY,null)
                .orElse(new GlobalVariableRegistry.PlayerVariables()).HasQuest;
    }

    public static boolean checkIfReputationGreaterThanEquals(Player player, int i) {
        return player.getCapability(GlobalVariableRegistry.PLAYER_VARIABLES_CAPABILITY,null)
                .orElse(new GlobalVariableRegistry.PlayerVariables()).PotatoReputation >= i;
    }
}
