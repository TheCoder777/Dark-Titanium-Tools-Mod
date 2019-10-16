package xNova22x.darktitaniumtools.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class DarkTitaniumBlock extends BlockBase{

	public DarkTitaniumBlock(String name, Material material) {
		super(name, material);
		
		setSoundType(SoundType.METAL);
		setHardness(5.0F);
		setResistance(50.0F);
		setHarvestLevel("pickaxe", 2);
	}

}
