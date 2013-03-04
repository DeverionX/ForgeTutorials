package deverionx.tutorial.common.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.relauncher.*;
import deverionx.tutorial.common.TutorialMain;

public class ItemMetaGem extends Item {

	public ItemMetaGem(int par1) {
		super(par1); //Returns super constructor: par1 is ID
		setTextureFile("/TutorialGFX/Items.png"); //Sets the item texture file
		setItemName("DeverionXItemMetaGem"); //Sets the incode name of the item, make sure it doesn't clash with other items, weird stuff happens
		setCreativeTab(TutorialMain.tabGems); //Tells the game what creative mode tab it goes in
		setHasSubtypes(true); //Marks item as having metadata
	}
	
	@SideOnly(Side.CLIENT) //Marks a method as client side only, typically for graphics and rendering
	public int getIconFromDamage(int i){
		switch(i){ //Checks what the damage is
		case 0:return 1; //If damage equals 0 then return second icon
		case 1:return 2; //^
		case 2:return 3; //^
		}
		
		return 0; //If icon not already returned, just return 0
	}
	
	public String getItemNameIS(ItemStack is){ //Gets the metadata sensitive item name
		switch(is.getItemDamage()){ //Checks what damage is
		case 0:return "DeverionXItemSapphire"; //If damage is one, return name
		case 1:return "DeverionXItemAmethyst"; //^
		case 2:return "DeverionXItemTopaz"; //^
		}
		return "itemUnknown";
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubItems(int itemID, CreativeTabs tab, List itemList) //Adds the metadata items to the creative inventory
	{
		for(int i=0;i<3;i++){
			itemList.add(new ItemStack(itemID,1,i)); //Adds all the metadatas
		}
	}
}
