package xNova22x.darktitaniumtools.blocks.machines.smelter.slots;

import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import xNova22x.darktitaniumtools.blocks.machines.smelter.DarkTitaniumSuperSmelterRecipes;

public class SlotDarkTitaniumSuperSmelterOut extends Slot{
	private final EntityPlayer player;
	private int removeCount;
	
	public SlotDarkTitaniumSuperSmelterOut(EntityPlayer player, IInventory inventoryIn, int slotIndex, int xPosition, int yPosition) 
	{
		super(inventoryIn, slotIndex, xPosition, yPosition);
		this.player = player;
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) 
	{
		return false;
	}
	
	@Override
	public ItemStack decrStackSize(int amount) 
	{
		if(this.getHasStack())
		{
			this.removeCount += Math.min(amount, this.getStack().getCount());
		}
		return super.decrStackSize(amount);
	}
	
	@Override
	public ItemStack onTake(EntityPlayer thePlayer, ItemStack stack) 
	{
		this.onCrafting(stack);
		super.onTake(thePlayer, stack);
		return stack;
	}
}
