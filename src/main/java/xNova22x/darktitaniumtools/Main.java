package xNova22x.darktitaniumtools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import xNova22x.darktitaniumtools.blocks.MagnesiumOre;
import xNova22x.darktitaniumtools.init.ModItems;
import xNova22x.darktitaniumtools.init.Smelting;
import xNova22x.darktitaniumtools.loot.LootHandler;
import xNova22x.darktitaniumtools.proxy.CommonProxy;
import xNova22x.darktitaniumtools.tabs.DarkTitaniumToolsTab;
import xNova22x.darktitaniumtools.util.Reference;
import xNova22x.darktitaniumtools.util.compat.OreDictionaryCompat;
import xNova22x.darktitaniumtools.world.ModWorldGen;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
	
	public static final String MODID = Reference.MODID;
	public static final String MODNAME = Reference.NAME;
	
	@Instance
	public static Main instance;
	
	
	// Initialize Logger
	public static final Logger LOG = LogManager.getLogger(MODID);
	
	// One creativetab for all items
	public static final CreativeTabs DarkTitaniumToolsTab = new DarkTitaniumToolsTab("dark_titanium_tools_main_tab");
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{
		GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
		ModItems.setRepairMaterials();
		LootTableList.register(new ResourceLocation(MODID + ":inject/spawn_bonus_chest"));
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		Smelting.init();
		OreDictionaryCompat.registerOres();
		MinecraftForge.EVENT_BUS.register(new LootHandler());
	}
	
	@EventHandler
	public static void Postinit(FMLPostInitializationEvent event)
	{
		
	}
	
	@EventHandler
	public static void loadComplete(FMLLoadCompleteEvent event) {
		LOG.info("Load Complete.");
	}
	
	@SubscribeEvent
	public static void onHarvestBlocks(BlockEvent.HarvestDropsEvent event)
	{
        int max = 15;
        int min = 5;
        Random rand = new Random();
	    LOG.info("Harvester: " + event.getHarvester());
	    if(event.getHarvester() == null)
	    {
	        if(event.getState().getBlock() instanceof MagnesiumOre)
	        {
	            event.getDrops().clear();

	            event.getDrops().add(new ItemStack(ModItems.MAGNESIUM_SHARD, rand.nextInt(max) + min));
	        }
	    }
	}
}