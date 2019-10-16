package xNova22x.darktitaniumtools.items.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;
import xNova22x.darktitaniumtools.Main;
import xNova22x.darktitaniumtools.init.ModItems;
import xNova22x.darktitaniumtools.util.IHasModel;

public class DarkTitaniumSword extends ItemSword implements IHasModel{
	public DarkTitaniumSword(String name, ToolMaterial material)  {
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
}
