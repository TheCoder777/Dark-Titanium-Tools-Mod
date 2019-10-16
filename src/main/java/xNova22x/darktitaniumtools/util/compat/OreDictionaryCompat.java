package xNova22x.darktitaniumtools.util.compat;

import net.minecraftforge.oredict.OreDictionary;
import xNova22x.darktitaniumtools.init.ModBlocks;
import xNova22x.darktitaniumtools.init.ModItems;

public class OreDictionaryCompat {
	public static void registerOres() {
		OreDictionary.registerOre("oreDarkTitanium", ModBlocks.DARK_TITANIUM_ORE);
		OreDictionary.registerOre("oreMagnesium", ModBlocks.MAGNESIUM_ORE);
		OreDictionary.registerOre("ingotDarkTitanium", ModItems.DARK_TITANIUM_INGOT);
		OreDictionary.registerOre("blockDarkTitanium", ModBlocks.DARK_TITANIUM_BLOCK);
		OreDictionary.registerOre("oreImpureDarkTitanium", ModItems.IMPURE_DARK_TITANIUM); // 'ore' because you have to smelt it
		OreDictionary.registerOre("rodStone", ModItems.STONE_ROD);
		OreDictionary.registerOre("rodDarkTitanium", ModItems.DARK_TITANIUM_ROD);

	}
}
