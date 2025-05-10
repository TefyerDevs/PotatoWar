package net.tefyer.api.entity.utils;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.tefyer.potatowar.entity.custom.PotatoManEntity;

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
        putValue(entity,"potatoWar:QuestNum",questNum);
        putValue(entity,"potatoWar:ItemType1",itemType1);
        putValue(entity,"potatoWar:ItemType3",itemType2);
        putValue(entity,"potatoWar:ItemType1",itemType3);
        putValue(entity,"potatoWar:itemcount1",itemCount1);
        putValue(entity,"potatoWar:itemcount2",itemCount2);
        putValue(entity,"potatoWar:itemcount3",itemCount3);
        putValue(entity,"potatoWar:RewardType",rewardType);
        putValue(entity,"potatoWar:RewardCount1",rewardCount1);
        putValue(entity,"potatoWar:RewardCount2",rewardCount2);
        putValue(entity,"potatoWar:CivilianID",civilianID);
        putValue(entity,"potatoWar:HasQuest",hasQuest);

    }
    public static <T extends Entity> void addDataToPotatoMan(T entity, double questNum,
                                                             double itemType1, double itemType2, double itemType3,
                                                             double itemCount1, double itemCount2, double itemCount3,
                                                             double rewardType, double rewardCount1, double rewardCount2,
                                                             boolean hasQuest){
        putValue(entity,"potatoWar:QuestNum",questNum);
        putValue(entity,"potatoWar:ItemType1",itemType1);
        putValue(entity,"potatoWar:ItemType3",itemType2);
        putValue(entity,"potatoWar:ItemType1",itemType3);
        putValue(entity,"potatoWar:itemcount1",itemCount1);
        putValue(entity,"potatoWar:itemcount2",itemCount2);
        putValue(entity,"potatoWar:itemcount3",itemCount3);
        putValue(entity,"potatoWar:RewardType",rewardType);
        putValue(entity,"potatoWar:RewardCount1",rewardCount1);
        putValue(entity,"potatoWar:RewardCount2",rewardCount2);
        putValue(entity,"potatoWar:HasQuest",hasQuest);

    }

    public static <T extends Entity>  double decideValueBasedOn12Num(T entity, int randomNum, int min, int max) {
        if (randomNum == 1)
            return (entity.getX() + min + Mth.nextInt(RandomSource.create(), 1, max));
       return (entity.getX() - min - Mth.nextInt(RandomSource.create(), 1, max));
    }

    public static void potatoManStartTrade(LevelAccessor world, double x, double y, double z, PotatoManEntity entity, Player player) {
        if(entity == null || player == null) return;
        if(getBoolean(entity,"potatowar:RandomizeQuest")){
            putValue(entity,"potatowar:RandomizeQuest", false);
            potatoManSetItems(world, x, y, z, entity);
        }


    }
}
