package xNova22x.darktitaniumtools.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.material.Material;
import xNova22x.darktitaniumtools.blocks.BlockBase;
import xNova22x.darktitaniumtools.blocks.DarkTitaniumBlock;
import xNova22x.darktitaniumtools.blocks.DarkTitaniumOre;
import xNova22x.darktitaniumtools.blocks.MagnesiumOre;
import xNova22x.darktitaniumtools.blocks.MagnesiumTorch;
import xNova22x.darktitaniumtools.blocks.machines.smelter.DarkTitaniumTrippleSmelter;

public class ModBlocks {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block DARK_TITANIUM_BLOCK = new DarkTitaniumBlock("dark_titanium_block", Material.IRON);
	public static final Block DARK_TITANIUM_ORE = new DarkTitaniumOre("dark_titanium_ore", Material.ROCK);
	public static final Block MAGNESIUM_ORE = new MagnesiumOre("magnesium_ore", Material.ROCK);
	public static final BlockTorch MAGNESIUM_TORCH = new MagnesiumTorch();
	
	// Interaction
	public static final Block DARK_TITTANIUM_TRIPPLE_SMELTER = new DarkTitaniumTrippleSmelter("dark_titanium_tripple_smelter", false);
	//public static final Block DARK_TITTANIUM_TRIPPLE_SMELTER_OFF = new DarkTitaniumTrippleSmelter("dark_titanium_tripple_smelter", false);



}
