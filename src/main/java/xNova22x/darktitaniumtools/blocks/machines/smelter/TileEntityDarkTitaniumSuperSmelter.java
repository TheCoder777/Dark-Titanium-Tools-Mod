package xNova22x.darktitaniumtools.blocks.machines.smelter;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.ParticleDrip.LavaFactory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBoat;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.walkers.ItemStackDataLists;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xNova22x.darktitaniumtools.blocks.machines.smelter.slots.SlotDarkTitaniumSuperSmelterFuel;
import xNova22x.darktitaniumtools.init.ModBlocks;
import xNova22x.darktitaniumtools.init.ModItems;

public class TileEntityDarkTitaniumSuperSmelter extends TileEntity implements IInventory, ITickable{
	
	private NonNullList<ItemStack> inv = NonNullList.<ItemStack>withSize(4, ItemStack.EMPTY);
	private String customName;

	private int burnTime;
	private int currentBurnTime;
	private int cookTime;
	private int totalCookTime;
	
	private static int slot0 = 0;
	private static int slot1 = 1;
	private static int fuelSlot = 2;
	private static int outputSlot = 3;
	
	
	@Override
	public String getName() 
	{
		return this.hasCustomName() ? this.customName : "container.dark_titanium_super_smelter";
	}
	
	@Override
	public boolean hasCustomName() 
	{
		return this.customName != null && !this.customName.isEmpty();
	}
	
	public void setCustomInventoryName(String customName)
	{
		this.customName = customName;
	}
	
	@Override
	public ITextComponent getDisplayName() {
		return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
	}
	
	@Override
	public int getSizeInventory() 
	{
		return this.inv.size();
	}
	
	@Override
	public boolean isEmpty() 
	{
		for(ItemStack stack : this.inv)
		{
			if(!stack.isEmpty())
			{
				return false;
			}
		}
		return true;
	}
	
	@Override
	public ItemStack getStackInSlot(int index) 
	{
		return this.inv.get(index);
	}
	
	@Override
	public ItemStack decrStackSize(int index, int count) 
	{
		return ItemStackHelper.getAndSplit(this.inv, index, count);
	}
	
	@Override
	public ItemStack removeStackFromSlot(int index) 
	{
		return ItemStackHelper.getAndRemove(this.inv, index);
	}
	
	@Override
	public void setInventorySlotContents(int index, ItemStack stack) 
	{
		ItemStack itemStack = this.inv.get(index);
		boolean flag = !stack.isEmpty() && stack.isItemEqual(itemStack) && ItemStack.areItemStackTagsEqual(stack, itemStack);
		this.inv.set(index, stack);
		
		if(stack.getCount() > this.getInventoryStackLimit())
		{
			stack.setCount(this.getInventoryStackLimit());
		}
		if (stack.getCount() > this.getInventoryStackLimit()) {
			stack.setCount(this.getInventoryStackLimit());
		}
		if(index == 0 && index + slot1 == 1 && !flag)
			// slot 1 = index 0
			// slot 2 = index 1
			// fuel   = index 2
			// output = index 3
		{
			ItemStack stack1 = (ItemStack)this.inv.get(index + slot1);

			this.totalCookTime = this.getCookTime(stack, stack1);
			this.cookTime = 0;
			this.markDirty();
		}
	}
	
	
	
	/* public static void registerFixesFurnace(DataFixer fixer)
	{
		fixer.registerWalker(FixTypes.BLOCK_ENTITY, new ItemStackDataLists(TileEntityDarkTitaniumTrippleSmelter.class, new String[] {"Items"}));
	} */
	
	public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.inv = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, this.inv);
        this.burnTime = compound.getInteger("BurnTime");
        this.cookTime = compound.getInteger("CookTime");
        this.totalCookTime = compound.getInteger("CookTimeTotal");
        this.currentBurnTime = getItemBurnTime(this.inv.get(fuelSlot));

        if (compound.hasKey("CustomName", 8))
        {
            this.customName = compound.getString("CustomName");
        }
    }

    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setInteger("BurnTime", (short)this.burnTime);
        compound.setInteger("CookTime", (short)this.cookTime);
        compound.setInteger("CookTimeTotal", (short)this.totalCookTime);
        ItemStackHelper.saveAllItems(compound, this.inv);

        if (this.hasCustomName())
        {
            compound.setString("CustomName", this.customName);
        }

        return compound;
    }
    
    @Override
    public int getInventoryStackLimit() 
    {
    	return 64;
    }
    
    public boolean isBurning()
    {
    	return this.burnTime > 0;
    }
    
    @SideOnly(Side.CLIENT)
    public static boolean isBurning(IInventory inventory)
    {
    	return inventory.getField(slot0) > 0;
    }
    
    public void update()
    {
        boolean flag = this.isBurning();
        boolean flag1 = false;

        if (this.isBurning()) --this.burnTime;

        if (!this.world.isRemote)
        {
            ItemStack fuel = this.inv.get(fuelSlot);
            ItemStack Itemslot0 = this.inv.get(slot0);
            ItemStack Itemslot1 = this.inv.get(slot1);


            if (this.isBurning() || !fuel.isEmpty() && !Itemslot0.isEmpty() || Itemslot1.isEmpty())
            {
                if (!this.isBurning() && this.canSmelt())
                {
                    this.burnTime = getItemBurnTime(fuel);
                    this.currentBurnTime = this.burnTime;

                    if (this.isBurning())
                    {
                        flag1 = true;

                        if (!fuel.isEmpty())
                        {
                            Item item = fuel.getItem();
                            fuel.shrink(1);

                            if (fuel.isEmpty())
                            {
                                ItemStack item1 = item.getContainerItem(fuel);
                                this.inv.set(fuelSlot, item1);
                            }
                        }
                    }
                }

                if (this.isBurning() && this.canSmelt())
                {
                    ++this.cookTime;

                    if (this.cookTime == this.totalCookTime)
                    {
                        this.cookTime = 0;
                        this.totalCookTime = this.getCookTime(Itemslot0, Itemslot1);
                        this.smeltItem();
                        flag1 = true;
                    }
                }
                else
                {
                    this.cookTime = 0;
                }
            }
            else if (!this.isBurning() && this.cookTime > 0)
            {
                this.cookTime = MathHelper.clamp(this.cookTime - 2, 0, this.totalCookTime);
            }

            if (flag != this.isBurning())
            {
                flag1 = true;
                DarkTitaniumSuperSmelter.setState(this.isBurning(), this.world, this.pos);
            }
        }

        if (flag1)
        {
            this.markDirty();
        }
    }
    
    public int getCookTime(ItemStack stack0, ItemStack stack1)
    {
    	return 200;
    }
    
    private boolean canSmelt()
    {
        if (((ItemStack)this.inv.get(slot0)).isEmpty() || ((ItemStack)this.inv.get(slot1)).isEmpty()) {
            return false;
        }
        else {
        	ItemStack result = DarkTitaniumSuperSmelterRecipes.getInstance().getSmeltingResult((ItemStack)this.inv.get(slot0), (ItemStack)this.inv.get(slot1));
        	if (result.isEmpty()) return false;
        	else {
        		ItemStack output = (ItemStack)this.inv.get(outputSlot);
        		if (output.isEmpty()) return true;
        		if (!output.isItemEqual(result)) return false;
        		int res = output.getCount() + result.getCount();
        		return res <= getInventoryStackLimit() && res <= output.getMaxStackSize();
        	}
        }
        
    }
    
    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack input0 = this.inv.get(slot0);
            ItemStack input1 = this.inv.get(slot1);

            ItemStack result = DarkTitaniumSuperSmelterRecipes.getInstance().getSmeltingResult(input0, input1);
            ItemStack output = this.inv.get(outputSlot);
            
            if (output.isEmpty()) this.inv.set(outputSlot, result.copy());
            else if (output.getItem() == result.getItem()) output.grow(result.getCount());
            
            if (!input0.isEmpty()) input0.shrink(1);
            if (!input1.isEmpty()) input1.shrink(1);
        }
    }
    
    public static int getItemBurnTime(ItemStack fuel)
    {
        if (fuel.isEmpty()) return 0;
        else {
        	Item item = fuel.getItem();
        	if  (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR) {
        		Block block = Block.getBlockFromItem(item);
        		// if (block == Blocks.WOODEN_SLAB) return 150;
        		// if (block.getDefaultState().getMaterial() == Material.WOOD) return 300;
        		// if (block == Blocks.COAL_BLOCK) return 16000;
        	}
        	
        	/* if (item instanceof ItemTool && "WOOD".equals(((ItemTool)item).getToolMaterialName())) return 200;
        	if (item instanceof ItemSword && "WOOD".equals(((ItemTool)item).getToolMaterialName())) return 200;
        	if (item instanceof ItemHoe && "WOOD".equals(((ItemTool)item).getToolMaterialName())) return 200;
        	if (item == Items.STICK) return 100;
        	if (item == Items.COAL) return 1600;
        	if (item == Items.LAVA_BUCKET) return 20000; */
        	if (item == ModItems.COMPRESSED_MAGNESIUM_CRYSTAL) return 1200;
        	if (item == ModItems.MAGNESIUM_CRYSTAL) return 400;
        	
        	
            
            return ForgeEventFactory.getItemBurnTime(fuel);
        }
    }
    
    public static boolean isItemFuel(ItemStack stack)
    {
    	return getItemBurnTime(stack) > 0;
    }
    
    @Override
    public boolean isUsableByPlayer(EntityPlayer player) 
    {
    	if(this.world.getTileEntity(this.pos) != this)
    	{
    		return false;
    	}
    	else
    	{
    		return player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    	}
    }
    
    public void openInventory(EntityPlayer player) {}

    public void closeInventory(EntityPlayer player) {}
    
    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) 
    {
    	if(index == outputSlot)
    	{
    		return false;
    	}
    	else if(index != fuelSlot)
    	{
    		return true;
    	}
    	else
    	{
    		return isItemFuel(stack);
    	}
    }
    
    public String getGuiID() 
    {
    	return "darktitaniumtools:dark_titanium_super_smelter";
    }
    
    public int getField(int id)
    {
        switch (id)
        {
            case 0:
                return this.burnTime;
            case 1:
                return this.currentBurnTime;
            case 2:
                return this.cookTime;
            case 3:
                return this.totalCookTime;
            default:
                return 0;
        }
    }

    public void setField(int id, int value)
    {
        switch (id)
        {
            case 0:
                this.burnTime = value;
                break;
            case 1:
                this.currentBurnTime = value;
                break;
            case 2:
                this.cookTime = value;
                break;
            case 3:
                this.totalCookTime = value;
        }
    }
    
    @Override
    public int getFieldCount() 
    {
    	return 4;
    }
    
    @Override
    public void clear() 
    {
    	this.inv.clear();
    }
}
