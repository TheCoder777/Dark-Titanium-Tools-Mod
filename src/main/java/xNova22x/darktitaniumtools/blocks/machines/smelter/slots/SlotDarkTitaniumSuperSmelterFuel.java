package xNova22x.darktitaniumtools.blocks.machines.smelter.slots;

import net.minecraft.inventory.Slot;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import xNova22x.darktitaniumtools.blocks.machines.smelter.TileEntityDarkTitaniumSuperSmelter;

public class SlotDarkTitaniumSuperSmelterFuel extends Slot{
	public SlotDarkTitaniumSuperSmelterFuel(IInventory inventoryIn, int slotIndex, int xPosition, int yPosition) {
		super(inventoryIn, slotIndex, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return TileEntityDarkTitaniumSuperSmelter.isItemFuel(stack);
	}
	
	@Override
	public int getItemStackLimit(ItemStack stack) {
		return super.getItemStackLimit(stack);
	}
}
