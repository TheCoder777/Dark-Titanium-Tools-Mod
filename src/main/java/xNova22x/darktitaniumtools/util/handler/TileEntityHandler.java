package xNova22x.darktitaniumtools.util.handler;

import net.minecraftforge.fml.common.registry.GameRegistry;
import xNova22x.darktitaniumtools.blocks.machines.smelter.TileEntityDarkTitaniumSuperSmelter;

public class TileEntityHandler {
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityDarkTitaniumSuperSmelter.class, "darktitaniumtools:dark_titanium_super_smelter");
	}
}
