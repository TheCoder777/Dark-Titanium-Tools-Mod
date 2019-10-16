package xNova22x.darktitaniumtools.blocks.machines.smelter;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import xNova22x.darktitaniumtools.util.Reference;

public class GuiDarkTitaniumTrippleSmelter extends GuiContainer {
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/gui/dark_titanium_super_smelter_gui.png");
	private final InventoryPlayer player;
	private final TileEntityDarkTitaniumSuperSmelter tileentity;
	
	public GuiDarkTitaniumTrippleSmelter(InventoryPlayer player, TileEntityDarkTitaniumSuperSmelter tileentity) {
		super(new ContainerDarkTitaniumSuperSmelter(player, tileentity));
		this.player = player;
		this.tileentity = tileentity;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String s = this.tileentity.getDisplayName().getUnformattedText();
		this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
		this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedText(), 122, this.ySize - 96 + 2, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TEXTURE);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

        if (TileEntityDarkTitaniumSuperSmelter.isBurning(tileentity)) {
        	int k = this.getBurnLeftScaled(13);
        	this.drawTexturedModalRect(this.guiLeft + 45, this.guiTop + 38 + 12 - k, 176, 12 - k, 14, k + 1);
        }
        
        int l = this.getCookProgressScaled(24);
        this.drawTexturedModalRect(this.guiLeft + 80, this.guiTop + 41, 176, 14, l + 1, 16);
    }
	
	private int getCookProgressScaled(int pixels) {
		int i = this.tileentity.getField(2);
		int j = this.tileentity.getField(3);
		return j != 0 && i != 0 ? i * pixels / j : 0;
	}
	
	private int getBurnLeftScaled(int pixels) {
		int i = this.tileentity.getField(1);
		if(i == 0) {
			i = 200;
		}
		return this.tileentity.getField(0) * pixels / i;
	}
}
