package xNova22x.darktitaniumtools.blocks.machines.smelter;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import xNova22x.darktitaniumtools.init.ModBlocks;
import xNova22x.darktitaniumtools.init.ModItems;

public class DarkTitaniumSuperSmelterRecipes {
	
	private static final DarkTitaniumSuperSmelterRecipes INSTANCE = new DarkTitaniumSuperSmelterRecipes();
	private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
	private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
	
	public static DarkTitaniumSuperSmelterRecipes getInstance()
    {
        return INSTANCE;
    }
	
	private DarkTitaniumSuperSmelterRecipes()
	{
		addSmeltingRecipe(new ItemStack(ModBlocks.DARK_TITANIUM_ORE), new ItemStack(ModItems.COMPRESSED_MAGNESIUM_CRYSTAL), new ItemStack(ModItems.DARK_TITANIUM_INGOT, 2), 5.0F);
	}
	
	public void addSmeltingRecipe(ItemStack input0, ItemStack input1, ItemStack result, float experience) {
		if(getSmeltingResult(input0, input1) != ItemStack.EMPTY) return;
		this.smeltingList.put(input0, input1, result);
		this.experienceList.put(result, Float.valueOf(experience));
	}
	
	public ItemStack getSmeltingResult(ItemStack input0, ItemStack input1) {
		for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.smeltingList.columnMap().entrySet()) {
			if(this.compareItemStacks(input0, (ItemStack)entry.getKey())) {
				for(Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) {
					if (this.compareItemStacks(input1, (ItemStack)ent.getKey())) {
						return (ItemStack)ent.getValue();
					}
				}
			}
		}
		return ItemStack.EMPTY;
	}
	
	private boolean compareItemStacks(ItemStack in0, ItemStack in1) {
		return in1.getItem() == in0.getItem() && (in1.getMetadata() == 32767 || in1.getMetadata() == in0.getMetadata());
	}
	
	public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList() {
		return this.smeltingList;
	}
	
	public float getSmeltingExperience(ItemStack stack) {
		for (Entry<ItemStack, Float> entry : this.experienceList.entrySet()) {
			if (this.compareItemStacks(stack, (ItemStack)entry.getKey())) {
				return (Float)entry.getValue().floatValue();
			}
		}
		return 0.0F;
	}
	
}
