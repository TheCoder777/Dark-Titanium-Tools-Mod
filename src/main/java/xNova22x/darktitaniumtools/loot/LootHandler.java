package xNova22x.darktitaniumtools.loot;


import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.client.gui.ForgeGuiFactory.ForgeConfigGui.ModIDEntry;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xNova22x.darktitaniumtools.init.ModItems;
import xNova22x.darktitaniumtools.util.Reference;

public class LootHandler {
	
	// Works!
	/* @SubscribeEvent
	public void LoadLoot(LootTableLoadEvent event) {
		
		// Log.info("Loot Table: " + event.getName().toString());
		LootEntry newLootEntry = new LootEntryItem(ModItems.DARK_TITANIUM_NUGGET, 100, 50, new LootFunction[0], new LootCondition[0], "darktitaniumtools:dark_titanium_nugget");

		String dungeon = "minecraft:chests/spawn_bonus_chest";
		if (event.getName().equals(LootTableList.CHESTS_SPAWN_BONUS_CHEST)) {
			event.getTable().getPool("main").addEntry(newLootEntry);
		}
	} */

	public static final LootPool abandoned_mineshaft_chest = LootGenerator.AbandonedMineshaftChest();
	public static final LootPool desert_pyramid_chest = LootGenerator.DesertPyramidChest();
	public static final LootPool end_city_treasure_chest = LootGenerator.EndCityTreasureChest();
	public static final LootPool nether_bridge_chest = LootGenerator.NetherBridgeChest();
	public static final LootPool woodland_mansion_chest = LootGenerator.WoodlandMansionChest();
	public static final LootPool jungle_temple_chest = LootGenerator.JungleTempleChest();
	public static final LootPool jungle_temple_dispenser = LootGenerator.JungleTempleDispenser();


	@SubscribeEvent
	public void lootLoad(LootTableLoadEvent event) {
		if (event.getName().equals(LootTableList.CHESTS_SPAWN_BONUS_CHEST)) {
			event.getTable().addPool(nether_bridge_chest);
		}
		if (event.getName().equals(LootTableList.CHESTS_ABANDONED_MINESHAFT)) {
			event.getTable().addPool(abandoned_mineshaft_chest);
		}
		if (event.getName().equals(LootTableList.CHESTS_DESERT_PYRAMID)) {
			event.getTable().addPool(desert_pyramid_chest);
		}
		if (event.getName().equals(LootTableList.CHESTS_END_CITY_TREASURE)) {
			event.getTable().addPool(end_city_treasure_chest);
		}
		if (event.getName().equals(LootTableList.CHESTS_NETHER_BRIDGE)) {
			event.getTable().addPool(nether_bridge_chest);
		}
		if (event.getName().equals(LootTableList.CHESTS_WOODLAND_MANSION)) {
			event.getTable().addPool(woodland_mansion_chest);
		}
		if (event.getName().equals(LootTableList.CHESTS_JUNGLE_TEMPLE)) {
			event.getTable().addPool(jungle_temple_chest);
		}
		if (event.getName().equals(LootTableList.CHESTS_JUNGLE_TEMPLE_DISPENSER)) { // super hidden items 
			event.getTable().addPool(jungle_temple_dispenser);
		}
	}
}
