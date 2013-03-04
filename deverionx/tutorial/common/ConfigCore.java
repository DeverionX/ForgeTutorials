package deverionx.tutorial.common;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigCore {
	
	//Items
	public static int itemRubyID;
	public static int itemMetagemID;
	public static int itemRubystaffID;
	public static int itemFirestoneID;
	public static int itemFiredgemID;
	
	//Tools
	public static int toolRubyShovelID;
	public static int toolRubyPickID;
	public static int toolRubyAxeID;
	public static int toolRubySwordID;
	public static int toolRubyHoeID;
	
	//Blocks
	public static int blockRubyID;
	public static int blockMetablockID;
	public static int blockOreID;
	public static int blockRubyGlassID;
	
	//General
	public static boolean isAwesome;
	
	public static void loadConfig(FMLPreInitializationEvent e){
		Configuration config = new Configuration(e.getSuggestedConfigurationFile()); //Gets the file

		config.load();	//Loads it
		
		Property rubyItem; //This is a property, see below
		rubyItem = config.getItem("Ruby", 15000); //This gets the property
		rubyItem.comment = "The base ruby item"; //This adds a comment
		itemRubyID = rubyItem.getInt(); //This gets the value
		
		//Item ID's
		itemMetagemID = config.getItem("Meta Gem", 15001).getInt();
		itemRubystaffID = config.getItem("Ruby Staff", 15002).getInt();
		itemFirestoneID = config.getItem("Firestone", 15003).getInt();
		itemFiredgemID = config.getItem("Firedgem", 15004).getInt();
		
		//Tool ID's
		toolRubyShovelID = config.getItem("Ruby Shovel", 16001).getInt();
		toolRubyPickID = config.getItem("Ruby Pick", 16002).getInt();
		toolRubyAxeID = config.getItem("Ruby Axe", 16003).getInt();
		toolRubySwordID = config.getItem("Ruby Sword", 16004).getInt();
		toolRubyHoeID = config.getItem("Ruby Hoe", 16005).getInt();
		
		//Block ID's
		blockRubyID = config.getBlock("Ruby Block", 300).getInt();
		blockMetablockID = config.getBlock("Meta Block", 301).getInt();
		blockOreID = config.getBlock("Ore Block", 302).getInt();
		blockRubyGlassID = config.getBlock("Ruby Glass Block", 303).getInt();
		
		//General
		isAwesome = config.get(config.CATEGORY_GENERAL, "Is the mod awesome", true).getBoolean(true);
		
		config.save(); //Saves the file
		
	}

}
