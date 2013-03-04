package deverionx.tutorial.common.core;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import deverionx.tutorial.common.TutorialMain;
import deverionx.tutorial.common.item.ItemBlockMetaGem;
import deverionx.tutorial.common.item.ItemBlockOre;

public class CommonProxy implements IGuiHandler{ //THIS IS IMPORTANT, CANNOT BE A PROXY/GUI HANDLER WITHOUT THIS!!

	public void registerRenderInformation() //Client side texture registering
	{
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) { //For GUI's
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) { //For GUI's
		return null;
	}

	public void registerTiles(){ //For registering TileEntities
	}

	public void registerOre(){ //Ore dictionary
		OreDictionary.registerOre("gemRuby", TutorialMain.ruby); //Basic item registration
		
		OreDictionary.registerOre("gemSapphire", new ItemStack(TutorialMain.metaGem,1,0)); //Metadata item registration
		OreDictionary.registerOre("gemAmethyst", new ItemStack(TutorialMain.metaGem,1,1)); //^
		OreDictionary.registerOre("gemTopaz", new ItemStack(TutorialMain.metaGem,1,2)); //^
	}
	
	public void registerBlocks(){ //For registering Blocks
		GameRegistry.registerBlock(TutorialMain.blockRuby, "DevXTutorialRuby");
		GameRegistry.registerBlock(TutorialMain.metaBlock, ItemBlockMetaGem.class, "DevXTutorialMeta");
		GameRegistry.registerBlock(TutorialMain.ore, ItemBlockOre.class, "DevXTutorialOre");
		GameRegistry.registerBlock(TutorialMain.rubyGlass, "DevXTutorialRubyGlass");
		
		MinecraftForge.setBlockHarvestLevel(TutorialMain.ore, 0, "pickaxe", 2); //Sets the required harvest level and tool
		MinecraftForge.setBlockHarvestLevel(TutorialMain.ore, 1, "pickaxe", 2); //0 is wood, 1 is stone
		MinecraftForge.setBlockHarvestLevel(TutorialMain.ore, 2, "pickaxe", 2); //2 is iron
		MinecraftForge.setBlockHarvestLevel(TutorialMain.ore, 3, "pickaxe", 2); //3 is diamond
	}
	
	public void registerTools(){
		MinecraftForge.setToolClass(TutorialMain.rubyShovel, "shovel", 3);
		MinecraftForge.setToolClass(TutorialMain.rubyPickaxe, "pickaxe", 3);
		MinecraftForge.setToolClass(TutorialMain.rubyAxe, "axe", 3);
	}

	public void addNames(){ //For adding Item's ingame names
		LanguageRegistry.addName(TutorialMain.ruby, "Ruby"); //Adds the name for the ruby item
		
		LanguageRegistry.addName(new ItemStack(TutorialMain.metaGem,1,0), "Sapphire"); //Adds the sapphire gem name (metadata sensitive)
		LanguageRegistry.addName(new ItemStack(TutorialMain.metaGem,1,1), "Amethyst"); //Adds the amethyst gem name (metadata sensitive)
		LanguageRegistry.addName(new ItemStack(TutorialMain.metaGem,1,2), "Topaz"); //Adds the topaz gem name (metadata sensitive)
		
		LanguageRegistry.addName(TutorialMain.blockRuby, "Ruby Block");
		LanguageRegistry.addName(new ItemStack(TutorialMain.metaBlock,1,0), "Sapphire Block");
		LanguageRegistry.addName(new ItemStack(TutorialMain.metaBlock,1,1), "Amethyst Block");
		LanguageRegistry.addName(new ItemStack(TutorialMain.metaBlock,1,2), "Topaz Block");
		
		LanguageRegistry.addName(new ItemStack(TutorialMain.ore,1,0), "Ruby Ore");
		LanguageRegistry.addName(new ItemStack(TutorialMain.ore,1,1), "Sapphire Ore");
		LanguageRegistry.addName(new ItemStack(TutorialMain.ore,1,2), "Amethyst Ore");
		LanguageRegistry.addName(new ItemStack(TutorialMain.ore,1,3), "Topaz Ore");
		
		LanguageRegistry.addName(TutorialMain.rubyStaff, "Ruby Staff");
		
		LanguageRegistry.addName(TutorialMain.rubyGlass, "Ruby Glass");
		
		LanguageRegistry.addName(TutorialMain.firestone, "Firestone");
		LanguageRegistry.addName(new ItemStack(TutorialMain.firedGem,1,0), "Stormstone");
		LanguageRegistry.addName(new ItemStack(TutorialMain.firedGem,1,1), "Lushstone");
		
		LanguageRegistry.addName(TutorialMain.rubySword, "Ruby Sword");
		LanguageRegistry.addName(TutorialMain.rubyShovel, "Ruby Shovel");
		LanguageRegistry.addName(TutorialMain.rubyAxe, "Ruby Axe");
		LanguageRegistry.addName(TutorialMain.rubyPickaxe, "Ruby Pickaxe");
		LanguageRegistry.addName(TutorialMain.rubyHoe, "Ruby Hoe");
	}

	public void addRecipes(){ //For adding your Item's recipes
		GameRegistry.addRecipe(new ItemStack(TutorialMain.ruby,1), "XAX", Character.valueOf('X'), new ItemStack(Item.dyePowder,1,1), Character.valueOf('A'),
				Block.glass); //Adds the ruby recipe
		
		GameRegistry.addShapelessRecipe(new ItemStack(TutorialMain.metaGem,1,0), new ItemStack(Item.dyePowder,1,4), Block.glass); //Adds a shapeless recipe for sapphire
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(TutorialMain.metaGem,1,1),"gemRuby",
				"gemAmethyst"));
		
		GameRegistry.addSmelting(TutorialMain.ruby.itemID, new ItemStack(TutorialMain.metaGem,1,2), 5); //A non-metadata sensitive smelting recipe
		FurnaceRecipes.smelting().addSmelting(TutorialMain.metaGem.itemID, 1, new ItemStack(TutorialMain.metaGem,1,2), 5); //Metadata sensitive
		
		GameRegistry.addRecipe(new ItemStack(TutorialMain.blockRuby,1), "XXX","XXX","XXX", Character.valueOf('X'), TutorialMain.ruby);
		
		for(int i = 0;i < 3;i++){
			GameRegistry.addRecipe(new ItemStack(TutorialMain.metaBlock,1,i), "XXX","XXX","XXX", Character.valueOf('X'), new ItemStack(TutorialMain.metaGem,1,i));
		}
		
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(TutorialMain.rubyStaff,1),"  X"," X ","X  ",
				Character.valueOf('X'), "gemRuby")); //A shaped ore dictionary recipe
		
		GameRegistry.addShapelessRecipe(new ItemStack(TutorialMain.rubyGlass,1), TutorialMain.ruby, Block.glass);
		
		GameRegistry.addRecipe(new ItemStack(TutorialMain.firestone,1), "XAX", Character.valueOf('X'), Item.flintAndSteel, Character.valueOf('A'), TutorialMain.ruby);
		
		GameRegistry.addShapelessRecipe(new ItemStack(TutorialMain.firedGem,1,0), new ItemStack(TutorialMain.metaGem,1,1), new ItemStack(TutorialMain.firestone,1,-1));
		GameRegistry.addShapelessRecipe(new ItemStack(TutorialMain.firedGem,1,1), Item.emerald, new ItemStack(TutorialMain.firestone,1,-1));
		
		GameRegistry.addRecipe(new ItemStack(TutorialMain.rubySword, 1), "X","X","A", Character.valueOf('X'), TutorialMain.ruby,
				Character.valueOf('A'), Item.stick);
		
		GameRegistry.addRecipe(new ItemStack(TutorialMain.rubyShovel, 1), "X","A","A", Character.valueOf('X'), TutorialMain.ruby,
				Character.valueOf('A'), Item.stick);
		
		
		/*OreDictionary.getOres("gemRuby"); //Gets an arraylist of valid items
		OreDictionary.getOreNames(); //Returns an arraylist of ore names
		OreDictionary.getOreID("gemRuby"); //Gets a unique int ID for the ore type
		OreDictionary.getOres(0); //Returns an arraylist of valid items from the ore ID
		OreDictionary.getOreID(new ItemStack(xxx,1)); //Gets the unique ore ID from an itemstack, returns -1 if there isn't one*/
	}
}