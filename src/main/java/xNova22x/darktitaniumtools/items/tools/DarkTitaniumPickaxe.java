package xNova22x.darktitaniumtools.items.tools;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

import org.jline.utils.Log;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import xNova22x.darktitaniumtools.Main;
import xNova22x.darktitaniumtools.init.ModBlocks;
import xNova22x.darktitaniumtools.init.ModItems;
import xNova22x.darktitaniumtools.util.IHasModel;

public class DarkTitaniumPickaxe extends ItemPickaxe implements IHasModel{
	public DarkTitaniumPickaxe(String name, ToolMaterial material)  {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.DarkTitaniumToolsTab);
		
		ModItems.ITEMS.add(this);
		
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
		
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving){
		
		// drops more magnesium
		if(state.getBlock().equals(ModBlocks.MAGNESIUM_ORE)) {
			Random rand = new Random();
			int min_shard = 3;
			int max_shard = 6;
			int max_crystal = 2;
			Block.spawnAsEntity(worldIn, pos, new ItemStack(ModItems.MAGNESIUM_SHARD, rand.nextInt(max_shard) + min_shard));
			if (max_crystal != 0) {Block.spawnAsEntity(worldIn, pos, new ItemStack(ModItems.MAGNESIUM_CRYSTAL, rand.nextInt(max_crystal)));}
			return true;
		}
		
		// CAN drop additional diamonds (sometimes not)
		else if(state.getBlock().equals(Blocks.DIAMOND_ORE)) {
			Random rand = new Random();
			int max = 3;
			if (max != 0) {
				Block.spawnAsEntity(worldIn, pos, new ItemStack(Items.DIAMOND, rand.nextInt(max)));
				return true;
				}
			else {return false;}
		}
		else {return false;}
	}
}
