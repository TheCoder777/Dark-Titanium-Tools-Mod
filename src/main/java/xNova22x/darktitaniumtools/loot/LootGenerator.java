package xNova22x.darktitaniumtools.loot;

import java.util.ArrayList;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import scala.util.Random;
import xNova22x.darktitaniumtools.Main;
import xNova22x.darktitaniumtools.init.ModBlocks;
import xNova22x.darktitaniumtools.init.ModItems;
import xNova22x.darktitaniumtools.util.Reference;

public class LootGenerator{
	
	// name for all loot pools
	public static final String LootPoolName = Reference.MODID + ":loot_pool:";
	public static final String TableNamePrefix = LootPoolName + "inject_";
	public static final String ChestPrefix = "inject/chests/";
	public static final String BlockPrefix = "inject/blocks/";
	
	
	public static LootPool AbandonedMineshaftChest() {
		int rollsMin = 1;
		int rollsMax = 4;
		String n = "mineshaft";
		String name = ChestPrefix + n;
		String tableName = TableNamePrefix + n;
		ResourceLocation loc = LootTableList.register(new ResourceLocation(Reference.MODID, name));
		LootEntryTable entry = new LootEntryTable(loc, 100, 100, new LootCondition[0], tableName);
		LootPool pool = new LootPool(new LootEntry[] {entry}, new LootCondition[0], new RandomValueRange(rollsMin, rollsMax), new RandomValueRange(0), LootPoolName);
		return pool;
	}

	public static LootPool DesertPyramidChest() {
		int rollsMin = 1;
		int rollsMax = 3;
		String n = "desertpyramid";
		String name = ChestPrefix + n;
		String tableName = TableNamePrefix + n;
		ResourceLocation loc = LootTableList.register(new ResourceLocation(Reference.MODID, name));
		LootEntryTable entry = new LootEntryTable(loc, 100, 100, new LootCondition[0], tableName);
		LootPool pool = new LootPool(new LootEntry[] {entry}, new LootCondition[0], new RandomValueRange(rollsMin, rollsMax), new RandomValueRange(0), LootPoolName);
		return pool;
	}

	public static LootPool EndCityTreasureChest() {
		int rollsMin = 1;
		int rollsMax = 4;
		String n = "endcitytreasure";
		String name = ChestPrefix + n;
		String tableName = TableNamePrefix + n;
		ResourceLocation loc = LootTableList.register(new ResourceLocation(Reference.MODID, name));
		LootEntryTable entry = new LootEntryTable(loc, 100, 100, new LootCondition[0], tableName);
		LootPool pool = new LootPool(new LootEntry[] {entry}, new LootCondition[0], new RandomValueRange(rollsMin, rollsMax), new RandomValueRange(0), LootPoolName);
		return pool;
	}

	public static LootPool NetherBridgeChest() {
		int rollsMin = 1;
		int rollsMax = 4;
		String n = "netherbridge";
		String name = ChestPrefix + n;
		String tableName = TableNamePrefix + n;
		ResourceLocation loc = LootTableList.register(new ResourceLocation(Reference.MODID, name));
		LootEntryTable entry = new LootEntryTable(loc, 100, 100, new LootCondition[0], tableName);
		LootPool pool = new LootPool(new LootEntry[] {entry}, new LootCondition[0], new RandomValueRange(rollsMin, rollsMax), new RandomValueRange(0), LootPoolName);
		return pool;
	}

	public static LootPool WoodlandMansionChest() {
		int rollsMin = 1;
		int rollsMax = 4;
		String n = "woodlandmansion";
		String name = ChestPrefix + n;
		String tableName = TableNamePrefix + n;
		ResourceLocation loc = LootTableList.register(new ResourceLocation(Reference.MODID, name));
		LootEntryTable entry = new LootEntryTable(loc, 100, 100, new LootCondition[0], tableName);
		LootPool pool = new LootPool(new LootEntry[] {entry}, new LootCondition[0], new RandomValueRange(rollsMin, rollsMax), new RandomValueRange(0), LootPoolName);
		return pool;
	}

	public static LootPool JungleTempleChest() {
		int rollsMin = 1;
		int rollsMax = 3;
		String n = "jungletemple";
		String name = ChestPrefix + n;
		String tableName = TableNamePrefix + n;
		ResourceLocation loc = LootTableList.register(new ResourceLocation(Reference.MODID, name));
		LootEntryTable entry = new LootEntryTable(loc, 100, 100, new LootCondition[0], tableName);
		LootPool pool = new LootPool(new LootEntry[] {entry}, new LootCondition[0], new RandomValueRange(rollsMin, rollsMax), new RandomValueRange(0), LootPoolName);
		return pool;
	}

	public static LootPool JungleTempleDispenser() {
		int rollsMin = 1;
		int rollsMax = 2;
		String n = "jungletempledispenser";
		String name = BlockPrefix + n;
		String tableName = TableNamePrefix + n;
		ResourceLocation loc = LootTableList.register(new ResourceLocation(Reference.MODID, name));
		LootEntryTable entry = new LootEntryTable(loc, 100, 100, new LootCondition[0], tableName);
		LootPool pool = new LootPool(new LootEntry[] {entry}, new LootCondition[0], new RandomValueRange(rollsMin, rollsMax), new RandomValueRange(0), LootPoolName);
		return pool;
	}
	
}
