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

public class DarkTitaniumTrippleSmelterRecipes {
	
	private static final DarkTitaniumTrippleSmelterRecipes INSTANCE = new DarkTitaniumTrippleSmelterRecipes();
	private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
	private final ArrayList<ItemStack> outputList = new ArrayList();
	private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
	
	//private final Map<Table<ItemStack, ItemStack, ItemStack>, ItemStack> liste;
	public static DarkTitaniumTrippleSmelterRecipes getInstance()
    {
        return INSTANCE;
    }
	
	private DarkTitaniumTrippleSmelterRecipes()
	{
		this.addCookingRecipeForBlock(ModBlocks.DARK_TITANIUM_ORE, new ItemStack(ModItems.DARK_TITANIUM_INGOT, 2), 0.6f);
	}
	
	public void addSmeltingRecipe(ItemStack input0, ItemStack input1, ItemStack input2, ItemStack result, float experience) {
		if(getSmeltingResult(input0, input1, input2) != ItemStack.EMPTY) return;
		this.smeltingList.put(input0, input1, input2);
		outputList.add(result);
		this.experienceList.put(result, Float.valueOf(experience));
	}
	
	public ItemStack getSmeltingResult(ItemStack input0, ItemStack input1, ItemStack input2) {
		for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.smeltingList.columnMap().entrySet()) {
			
		}
		return ItemStack.EMPTY;
	}
	
	
	public void addCookingRecipeForBlock(Block input, ItemStack stack, float experience)
    {
        this.addCooking(Item.getItemFromBlock(input), stack, experience);
    }
	
	public void addCooking(Item input, ItemStack stack, float experience)
    {
        this.addCookingRecipe(new ItemStack(input, 1, 32767), stack, experience);
    }
	
	public void addCookingRecipe(ItemStack input, ItemStack stack, float experience)
    {
        if (getCookingResult(input) != ItemStack.EMPTY) 
        { 
        	net.minecraftforge.fml.common.FMLLog.log.info("Ignored cooking recipe with conflicting input: {} = {}", input, stack); return; 
        }
        this.smeltingList.put(input, stack);
        this.experienceList.put(stack, Float.valueOf(experience));
    }
	
	public ItemStack getCookingResult(ItemStack stack)
    {
        for (Entry<ItemStack, ItemStack> entry : this.smeltingList.entrySet())
        {
            if (this.compareItemStacks(stack, entry.getKey()))
            {
                return entry.getValue();
            }
        }

        return ItemStack.EMPTY;
    }
	
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Map<ItemStack, ItemStack> getCookingList()
    {
        return this.smeltingList;
    }

    public float getCookingExperience(ItemStack stack)
    {
        float ret = stack.getItem().getSmeltingExperience(stack);
        if (ret != -1) return ret;
        for (Entry<ItemStack, Float> entry : this.experienceList.entrySet())
        {
            if (this.compareItemStacks(stack, entry.getKey()))
            {
                return ((Float)entry.getValue()).floatValue();
            }
        }
        return 0.0F;
    }
}
