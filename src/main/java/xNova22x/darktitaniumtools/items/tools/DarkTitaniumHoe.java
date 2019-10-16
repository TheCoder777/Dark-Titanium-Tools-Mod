package xNova22x.darktitaniumtools.items.tools;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemHoe;
import xNova22x.darktitaniumtools.Main;
import xNova22x.darktitaniumtools.init.ModItems;
import xNova22x.darktitaniumtools.util.IHasModel;

public class DarkTitaniumHoe extends ItemHoe implements IHasModel{
	public DarkTitaniumHoe(String name, ToolMaterial material)  {
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
