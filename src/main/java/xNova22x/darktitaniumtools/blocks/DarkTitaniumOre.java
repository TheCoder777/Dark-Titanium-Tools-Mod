package xNova22x.darktitaniumtools.blocks;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xNova22x.darktitaniumtools.init.ModItems;

public class DarkTitaniumOre extends BlockBase {

	public DarkTitaniumOre(String name, Material material) {
		super(name, material);
		
		setSoundType(SoundType.STONE);
		setHardness(6.0F);
		setResistance(15.0F);
		setHarvestLevel("pickaxe", 3);
	}
	
	@Override
	public Item getItemDropped (IBlockState state, Random rand, int fortune) {
		return ModItems.IMPURE_DARK_TITANIUM;
	}
	
}
