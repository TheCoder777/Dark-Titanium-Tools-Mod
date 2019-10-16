package xNova22x.darktitaniumtools.items.tools;

import net.minecraft.item.ItemAxe;
import net.minecraft.item.Item.ToolMaterial;
import xNova22x.darktitaniumtools.Main;
import xNova22x.darktitaniumtools.init.ModItems;
import xNova22x.darktitaniumtools.util.IHasModel;

public class DarkTitaniumAxe extends ItemAxe implements IHasModel{
	public DarkTitaniumAxe(String name, ToolMaterial material)  {
		super(material, 10.0F, -2.0F);
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
