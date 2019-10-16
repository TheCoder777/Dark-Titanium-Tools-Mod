package xNova22x.darktitaniumtools.blocks.machines.smelter.slots;

import net.minecraft.inventory.Slot;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import xNova22x.darktitaniumtools.blocks.machines.smelter.TileEntityDarkTitaniumTrippleSmelter;

public class DarkTitaniumTrippleFurnaceSlotFuel extends Slot{
	public DarkTitaniumTrippleFurnaceSlotFuel(IInventory inventoryIn, int slotIndex, int xPosition, int yPosition) 
	{
		super(inventoryIn, slotIndex, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) 
	{
		return TileEntityDarkTitaniumTrippleSmelter.isItemFuel(stack) || isBucket(stack);
	}
	
	@Override
	public int getItemStackLimit(ItemStack stack) 
	{
		return isBucket(stack) ? 1 : super.getItemStackLimit(stack);
	}
	
	public static boolean isBucket(ItemStack stack)
	{
		return stack.getItem() == Items.BUCKET;
	}
}
