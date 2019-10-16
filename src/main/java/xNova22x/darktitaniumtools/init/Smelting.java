package xNova22x.darktitaniumtools.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Smelting {
	public static void init() {
		GameRegistry.addSmelting(ModItems.Dark_TITANIUM_MASS, new ItemStack(ModItems.DARK_TITANIUM_INGOT, 2), 4.0F);
		GameRegistry.addSmelting(ModItems.IMPURE_DARK_TITANIUM, new ItemStack(ModItems.RAW_DARK_TITANIUM, 1), 2.0F);
		GameRegistry.addSmelting(ModItems.UNFORMED_DARK_TITANIUM_ROD, new ItemStack(ModItems.DARK_TITANIUM_ROD, 2), 2.0F);

	}
}
