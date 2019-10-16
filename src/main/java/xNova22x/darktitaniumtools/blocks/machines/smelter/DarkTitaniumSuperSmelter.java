package xNova22x.darktitaniumtools.blocks.machines.smelter;

import java.util.Random;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xNova22x.darktitaniumtools.Main;
import xNova22x.darktitaniumtools.blocks.BlockBase;
import xNova22x.darktitaniumtools.init.ModBlocks;
import xNova22x.darktitaniumtools.init.ModItems;
import xNova22x.darktitaniumtools.util.IHasModel;
import xNova22x.darktitaniumtools.util.Reference;

public class DarkTitaniumSuperSmelter extends BlockBase implements ITileEntityProvider {
	// slot 1 = index 0
	// slot 2 = index 1
	// fuel   = index 2
	// output = index 3
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	
	private static final PropertyBool BURNING = PropertyBool.create("burning");
	
	public DarkTitaniumSuperSmelter(String name, boolean isBurning) 
	{
		super(name, Material.IRON);
		setHardness(5.0f);
		setHarvestLevel("pickaxe", 3);
		setResistance(20.0f);
		setSoundType(SoundType.METAL);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(BURNING, false));
		
		//ModBlocks.BLOCKS.add(this);
		//ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(ModBlocks.DARK_TITTANIUM_SUPER_SMELTER);
	}
	
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) 
	{
		return new ItemStack(ModBlocks.DARK_TITTANIUM_SUPER_SMELTER);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		if (!worldIn.isRemote) {
			playerIn.openGui(Main.instance, Reference.GUI_DARK_TITTANIUM_SUPER_SMELTER, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) 
	{
		this.setDefaultFacing(worldIn, pos, state);
	}
	
	private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            IBlockState north = worldIn.getBlockState(pos.north());
            IBlockState south = worldIn.getBlockState(pos.south());
            IBlockState west = worldIn.getBlockState(pos.west());
            IBlockState east = worldIn.getBlockState(pos.east());
            EnumFacing face = (EnumFacing)state.getValue(FACING);

            if (face == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock())
            {
                face = EnumFacing.SOUTH;
            }
            else if (face == EnumFacing.SOUTH && south.isFullBlock() && !north.isFullBlock())
            {
                face = EnumFacing.NORTH;
            }
            else if (face == EnumFacing.WEST && west.isFullBlock() && !east.isFullBlock())
            {
                face = EnumFacing.EAST;
            }
            else if (face == EnumFacing.EAST && east.isFullBlock() && !west.isFullBlock())
            {
                face = EnumFacing.WEST;
            }

            worldIn.setBlockState(pos, state.withProperty(FACING, face), 2);
        }
    }
	
	public static void setState(boolean active, World worldIn, BlockPos pos)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        TileEntity tileentity = worldIn.getTileEntity(pos);

        if (active)
        {
            worldIn.setBlockState(pos, ModBlocks.DARK_TITTANIUM_SUPER_SMELTER.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)).withProperty(BURNING, true), 3);
        }
        else
        {
            worldIn.setBlockState(pos, ModBlocks.DARK_TITTANIUM_SUPER_SMELTER.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)).withProperty(BURNING, false), 3);

        }

        if (tileentity != null)
        {
            tileentity.validate();
            worldIn.setTileEntity(pos, tileentity);
        }
    }
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return new TileEntityDarkTitaniumSuperSmelter();
	}
	
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) 
	{
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) 
	{
		worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) 
	{
		TileEntityDarkTitaniumSuperSmelter tileentity = (TileEntityDarkTitaniumSuperSmelter)worldIn.getTileEntity(pos);
		InventoryHelper.dropInventoryItems(worldIn, pos, tileentity);
		super.breakBlock(worldIn, pos, state);
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) 
	{
		return EnumBlockRenderType.MODEL;
	}
	
	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) 
	{
		return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
	}
	
	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) 
	{
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
	}
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] {BURNING, FACING});	
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		EnumFacing facing = EnumFacing.getFront(meta);
		if(facing.getAxis() == EnumFacing.Axis.Y)
		{
			facing = EnumFacing.NORTH;
		}
		return this.getDefaultState().withProperty(FACING, facing);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		return ((EnumFacing)state.getValue(FACING)).getIndex();
	}

}
