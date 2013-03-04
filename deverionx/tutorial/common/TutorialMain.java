package deverionx.tutorial.common; //The package your mod is in

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import deverionx.tutorial.client.core.handlers.ClientPacketHandler;
import deverionx.tutorial.client.core.handlers.GuiTicker;
import deverionx.tutorial.common.blocks.BlockMetaGem;
import deverionx.tutorial.common.blocks.BlockOre;
import deverionx.tutorial.common.blocks.BlockRuby;
import deverionx.tutorial.common.blocks.BlockRubyGlass;
import deverionx.tutorial.common.core.CommonProxy;
import deverionx.tutorial.common.core.handlers.CraftingHandler;
import deverionx.tutorial.common.core.handlers.FuelHandler;
import deverionx.tutorial.common.core.handlers.ServerPacketHandler;
import deverionx.tutorial.common.core.handlers.WorldGenHandler;
import deverionx.tutorial.common.item.ItemAxe;
import deverionx.tutorial.common.item.ItemFiredGem;
import deverionx.tutorial.common.item.ItemFirestone;
import deverionx.tutorial.common.item.ItemHoe;
import deverionx.tutorial.common.item.ItemMetaGem;
import deverionx.tutorial.common.item.ItemPickaxe;
import deverionx.tutorial.common.item.ItemRuby;
import deverionx.tutorial.common.item.ItemRubyStaff;
import deverionx.tutorial.common.item.ItemShovel;
import deverionx.tutorial.common.item.ItemTutorialSword;
import deverionx.tutorial.common.tabs.TabGems;

@NetworkMod(clientSideRequired=true,serverSideRequired=false, //Weather client side and server side are needed
    clientPacketHandlerSpec = @SidedPacketHandler(channels = {"TutorialGeneral" }, packetHandler = ClientPacketHandler.class), //For clientside packet handling
    serverPacketHandlerSpec = @SidedPacketHandler(channels = {}, packetHandler = ServerPacketHandler.class)) //For serverside packet handling
@Mod(modid="DeverionXTutorial",name="DeverionXTutorial",version="1.0") //Gives Forge extra info about your mod
public class TutorialMain { //The class file
	
	@Instance("DeverionXTutorial") //The instance, this is very important later on
	public static TutorialMain instance = new TutorialMain(); 
	
	@SidedProxy(clientSide = "deverionx.tutorial.client.core.ClientProxy", serverSide = "deverionx.tutorial.common.core.CommonProxy") //Tells Forge the location of your proxies
	public static CommonProxy proxy;
	
	public static CreativeTabs tabGems = new TabGems(CreativeTabs.getNextID(),"DeverionXTabGems"); //Our custom creative tab's object
	
	
	public static Item ruby;
	public static Item metaGem;
	public static Item rubyStaff;
	public static Item firestone;
	public static Item firedGem;
	
	public static EnumToolMaterial rubyMat = EnumHelper.addToolMaterial("Ruby", 3, 64, 100.0F, 3, 15); //The material
	
	public static Item rubySword;
	public static Item rubyShovel;
	public static Item rubyPickaxe;
	public static Item rubyAxe;
	public static Item rubyHoe;
	
	public static Block blockRuby;
	public static Block metaBlock;
	public static Block ore;
	public static Block rubyGlass;
	
	@PreInit()
	public void PreInitTutorial(FMLPreInitializationEvent e){
		ConfigCore cc = new ConfigCore();
		
		cc.loadConfig(e);
		
		ruby = new ItemRuby(cc.itemRubyID);
		metaGem = new ItemMetaGem(cc.itemMetagemID);
		rubyStaff = new ItemRubyStaff(cc.itemRubystaffID);
		firestone = new ItemFirestone(cc.itemFirestoneID);
		firedGem = new ItemFiredGem(cc.itemFiredgemID);
		
		rubySword = new ItemTutorialSword(cc.toolRubySwordID, rubyMat, 8, "DeverionXRubySword");
		rubyShovel = new ItemShovel(cc.toolRubyShovelID, rubyMat, 9, "DeverionXRubyShovel");
		rubyPickaxe = new ItemPickaxe(cc.toolRubyPickID, rubyMat, 10, "DeverionXRubyPickaxe");
		rubyAxe = new ItemAxe(cc.toolRubyAxeID, rubyMat, 11, "DeverionXRubyAxe");
		rubyHoe = new ItemHoe(cc.toolRubyHoeID, rubyMat, 12, "DeverionXRubyHoe");
		
		blockRuby = new BlockRuby(cc.blockRubyID);
		metaBlock = new BlockMetaGem(cc.blockMetablockID);
		ore = new BlockOre(cc.blockOreID);
		rubyGlass = new BlockRubyGlass(cc.blockRubyGlassID);
	}
	
	@Init
	public void InitTutorial(FMLInitializationEvent event){ //Your main initialization method
		
		NetworkRegistry.instance().registerGuiHandler(this, proxy);
		GameRegistry.registerFuelHandler(new FuelHandler());
		GameRegistry.registerWorldGenerator(new WorldGenHandler());
		GameRegistry.registerCraftingHandler(new CraftingHandler());
		TickRegistry.registerTickHandler(new GuiTicker(), Side.CLIENT);
		
		proxy.registerRenderInformation();
		
		proxy.registerBlocks();
		proxy.addNames();
		proxy.addRecipes();
		proxy.registerOre();
		proxy.registerTools();
	}
}
