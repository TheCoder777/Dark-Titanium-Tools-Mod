package xNova22x.darktitaniumtools.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xNova22x.darktitaniumtools.init.ModItems;

public class DarkTitaniumToolsTab extends CreativeTabs{
	public DarkTitaniumToolsTab(String label) {
		super(label);
		this.setNoScrollbar();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.DARK_TITANIUM_INGOT);
	}

}
