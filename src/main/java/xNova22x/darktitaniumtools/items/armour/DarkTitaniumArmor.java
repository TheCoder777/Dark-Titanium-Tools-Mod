package xNova22x.darktitaniumtools.items.armour;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class DarkTitaniumArmor extends BaseArmor {
	
    public DarkTitaniumArmor(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(name, materialIn, renderIndexIn, equipmentSlotIn);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		if (player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() instanceof DarkTitaniumArmor &&
			player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() instanceof DarkTitaniumArmor &&
			player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() instanceof DarkTitaniumArmor &&
			player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() instanceof DarkTitaniumArmor) {
				player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 10, 10, false, false));
		}
	}
}
