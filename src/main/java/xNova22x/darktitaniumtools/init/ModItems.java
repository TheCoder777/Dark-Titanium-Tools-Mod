package xNova22x.darktitaniumtools.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import xNova22x.darktitaniumtools.items.ItemBase;
import xNova22x.darktitaniumtools.items.armour.BaseArmor;
import xNova22x.darktitaniumtools.items.armour.DarkTitaniumArmor;
import xNova22x.darktitaniumtools.items.tools.DarkTitaniumAxe;
import xNova22x.darktitaniumtools.items.tools.DarkTitaniumHoe;
import xNova22x.darktitaniumtools.items.tools.DarkTitaniumPickaxe;
import xNova22x.darktitaniumtools.items.tools.DarkTitaniumSpade;
import xNova22x.darktitaniumtools.items.tools.DarkTitaniumSword;
import xNova22x.darktitaniumtools.util.Reference;

public class ModItems {
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	
	// Materials
	public static final ToolMaterial TOOL_MATERIAL_DARK_TITANIUM = EnumHelper.addToolMaterial("tool_material_dark_titanium", 4, 3122, 10.0F, 10.0F, 20);
	public static final ArmorMaterial ARMOR_MATERIAL_DARK_TITANIUM = EnumHelper.addArmorMaterial("armour_material_dark_titanium", Reference.MODID + ":dark_titanium", 100, new int[]{4, 7, 9, 4}, 20, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F);
	
	
	// Items
	public static final Item DARK_TITANIUM_INGOT = new ItemBase("dark_titanium_ingot");
	public static final Item RAW_DARK_TITANIUM = new ItemBase("raw_dark_titanium");
	public static final Item IMPURE_DARK_TITANIUM = new ItemBase("impure_dark_titanium");
	public static final Item Dark_TITANIUM_MASS = new ItemBase("dark_titanium_mass");
	public static final Item MAGNESIUM_SHARD = new ItemBase("magnesium_shard");
	public static final Item MAGNESIUM_CRYSTAL = new ItemBase("magnesium_crystal");
	public static final Item COMPRESSED_MAGNESIUM_CRYSTAL = new ItemBase("compressed_magnesium_crystal");
	public static final Item DARK_TITANIUM_ROD = new ItemBase("dark_titanium_rod");
	public static final Item UNFORMED_DARK_TITANIUM_ROD = new ItemBase("unformed_dark_titanium_rod");
	public static final Item STONE_ROD = new ItemBase("stone_rod");
	public static final Item DARK_TITANIUM_NUGGET = new ItemBase("dark_titanium_nugget");
	
	
	// Tools
	public static final ItemSword DARK_TITANIUM_SWORD = new DarkTitaniumSword("dark_titanium_sword", TOOL_MATERIAL_DARK_TITANIUM);
	public static final ItemPickaxe DARK_TITANIUM_PICKAXE = new DarkTitaniumPickaxe("dark_titanium_pickaxe", TOOL_MATERIAL_DARK_TITANIUM);
	public static final ItemAxe DARK_TITANIUM_AXE = new DarkTitaniumAxe("dark_titanium_axe", TOOL_MATERIAL_DARK_TITANIUM);
	public static final ItemHoe DARK_TITANIUM_HOE = new DarkTitaniumHoe("dark_titanium_hoe", TOOL_MATERIAL_DARK_TITANIUM);
	public static final ItemSpade DARK_TITANIUM_SPADE = new DarkTitaniumSpade("dark_titanium_shovel", TOOL_MATERIAL_DARK_TITANIUM);
	
	
	// Armour
	public static final Item DARK_TITANIUM_HELMET = new DarkTitaniumArmor("dark_titanium_helmet", ARMOR_MATERIAL_DARK_TITANIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item DARK_TITANIUM_CHESTPLATE = new DarkTitaniumArmor("dark_titanium_chestplate", ARMOR_MATERIAL_DARK_TITANIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item DARK_TITANIUM_LEGGINGS = new DarkTitaniumArmor("dark_titanium_leggings", ARMOR_MATERIAL_DARK_TITANIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item DARK_TITANIUM_BOOTS = new DarkTitaniumArmor("dark_titanium_boots", ARMOR_MATERIAL_DARK_TITANIUM, 1, EntityEquipmentSlot.FEET);

	// add magnesium dust
	// add dark titanium dust
	// add dark titanium sheers
	// add magnesium Torches (underwater)
	
	
	public static void setRepairMaterials() {
		TOOL_MATERIAL_DARK_TITANIUM.setRepairItem(new ItemStack(ModItems.DARK_TITANIUM_INGOT));
		ARMOR_MATERIAL_DARK_TITANIUM.setRepairItem(new ItemStack(ModItems.DARK_TITANIUM_INGOT));
	}
}
