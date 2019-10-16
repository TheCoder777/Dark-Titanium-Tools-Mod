package xNova22x.darktitaniumtools.util.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import xNova22x.darktitaniumtools.blocks.machines.smelter.ContainerDarkTitaniumSuperSmelter;
import xNova22x.darktitaniumtools.blocks.machines.smelter.GuiDarkTitaniumTrippleSmelter;
import xNova22x.darktitaniumtools.blocks.machines.smelter.TileEntityDarkTitaniumSuperSmelter;
import xNova22x.darktitaniumtools.util.Reference;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == Reference.GUI_DARK_TITTANIUM_SUPER_SMELTER) {
			return new ContainerDarkTitaniumSuperSmelter(player.inventory, (TileEntityDarkTitaniumSuperSmelter)world.getTileEntity(new BlockPos(x,y,z)));
		}
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == Reference.GUI_DARK_TITTANIUM_SUPER_SMELTER) {
			return new GuiDarkTitaniumTrippleSmelter(player.inventory, (TileEntityDarkTitaniumSuperSmelter)world.getTileEntity(new BlockPos(x,y,z)));
		}
		return null;
	}
}
