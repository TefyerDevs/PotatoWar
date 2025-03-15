package net.mcreator.potatowar.procedures;

import org.checkerframework.checker.units.qual.Time;

import net.minecraftforge.server.ServerLifecycleHooks;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.Difficulty;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

public class TownNameProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return "";
		double RandomNum1 = 0;
		double RandomNum2 = 0;
		double RandomNum3 = 0;
		String Height = "";
		String Time = "";
		String Light = "";
		String TownName = "";
		String Part1 = "";
		String Part2 = "";
		String Temp = "";
		String Covered = "";
		String Village = "";
		String Weather = "";
		String Difficulty = "";
		String Part3 = "";
		RandomNum1 = Mth.nextInt(RandomSource.create(), 1, 3);
		RandomNum2 = Mth.nextInt(RandomSource.create(), 1, 3);
		RandomNum3 = Mth.nextInt(RandomSource.create(), 1, 3);
		if (RandomNum1 == 1) {
			if (entity.getY() > world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)) {
				Height = "Sky ";
			} else if (entity.getY() < world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)) {
				Height = "Earth ";
			} else {
				Height = "Ground ";
			}
			Part1 = Height;
		} else if (RandomNum1 == 2) {
			if (world instanceof Level _lvl7 && _lvl7.isDay()) {
				Time = "Sun ";
			} else {
				Time = "Moon ";
			}
			Part1 = Time;
		} else if (RandomNum1 == 3) {
			if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) > 12) {
				Light = "Bright ";
			} else if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) < 5) {
				Light = "Shadow ";
			} else {
				Light = "Dark ";
			}
			Part1 = Light;
		}
		if (RandomNum2 == 1) {
			if (world.getBiome(BlockPos.containing(x, y, z)).value().getBaseTemperature() * 100f < 0) {
				Temp = "Artic ";
			} else if (world.getBiome(BlockPos.containing(x, y, z)).value().getBaseTemperature() * 100f == 0) {
				Temp = "Frozen ";
			} else if (world.getBiome(BlockPos.containing(x, y, z)).value().getBaseTemperature() * 100f <= 45) {
				Temp = "Cold ";
			} else if (world.getBiome(BlockPos.containing(x, y, z)).value().getBaseTemperature() * 100f <= 90) {
				Temp = "warm ";
			} else if (world.getBiome(BlockPos.containing(x, y, z)).value().getBaseTemperature() * 100f <= 180) {
				Temp = "Hot ";
			} else if (world.getBiome(BlockPos.containing(x, y, z)).value().getBaseTemperature() * 100f > 180) {
				Temp = "Scorched ";
			}
			Part2 = Temp;
		} else if (RandomNum2 == 2) {
			if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
				Covered = "Open ";
			} else if (!world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
				Covered = "Closed ";
			}
			Part2 = Covered;
		} else if (RandomNum2 == 3) {
			if (world instanceof ServerLevel _level18 && _level18.isVillage(BlockPos.containing(x, y, z))) {
				Village = "Populated ";
			} else {
				Village = "Empty ";
			}
			Part2 = Village;
		}
		if (RandomNum3 == 1) {
			if (world.getLevelData().isRaining()) {
				Weather = "Storm";
			} else if (world.getLevelData().isThundering()) {
				Weather = "Vicious";
			} else {
				Weather = "Clear";
			}
			Part3 = Weather;
		} else if (RandomNum3 == 2) {
			if (world.dayTime() <= 500) {
				Time = "Sunrise";
			} else if (world.dayTime() <= 5000) {
				Time = "Morning";
			} else if (world.dayTime() <= 7000) {
				Time = "Noon";
			} else if (world.dayTime() <= 5000) {
				Time = "Morning";
			} else if (world.dayTime() <= 7000) {
				Time = "Morning";
			} else if (world.dayTime() <= 13000) {
				Time = "Evening";
			} else if (world.dayTime() <= 17000) {
				Time = "Midnight";
			} else if (world.dayTime() <= 22000) {
				Time = "Early";
			} else if (world.dayTime() <= 500) {
				Time = "Sunrise";
			}
			Part3 = Time;
		} else if (RandomNum3 == 3) {
			if ((world.isClientSide() ? Minecraft.getInstance().getConnection().getOnlinePlayers().size() : ServerLifecycleHooks.getCurrentServer().getPlayerCount()) == 1) {
				Difficulty = "Lonely";
			} else if ((world.isClientSide() ? Minecraft.getInstance().getConnection().getOnlinePlayers().size() : ServerLifecycleHooks.getCurrentServer().getPlayerCount()) <= 3) {
				Difficulty = "Spares";
			} else if ((world.isClientSide() ? Minecraft.getInstance().getConnection().getOnlinePlayers().size() : ServerLifecycleHooks.getCurrentServer().getPlayerCount()) <= 5) {
				Difficulty = "Threatened";
			} else if ((world.isClientSide() ? Minecraft.getInstance().getConnection().getOnlinePlayers().size() : ServerLifecycleHooks.getCurrentServer().getPlayerCount()) <= 7) {
				Difficulty = "Agressive";
			} else if ((world.isClientSide() ? Minecraft.getInstance().getConnection().getOnlinePlayers().size() : ServerLifecycleHooks.getCurrentServer().getPlayerCount()) >= 10) {
				Difficulty = "Manical";
			}
			Part3 = Difficulty;
		}
		TownName = Part1 + "" + (Part2 + "" + Part3);
		return TownName;
	}
}
