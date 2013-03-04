package deverionx.tutorial.common.item;

import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.*;
import deverionx.tutorial.common.TutorialMain;

public class ItemRuby extends Item {

	public ItemRuby(int par1) {
		super(par1); //Returns super constructor: par1 is ID
		setTextureFile("/TutorialGFX/Items.png"); //Sets the item texture file
		setItemName("DeverionXItemRuby"); //Sets the incode name of the item, make sure it doesn't clash with other items, weird stuff happens
		setCreativeTab(TutorialMain.tabGems); //Tells the game what creative mode tab it goes in
	}
	
	@SideOnly(Side.CLIENT) //Marks a method as client side only, typically for graphics and rendering
	public int getItemIconFromDamage(int i){
		return 0; //The first icon on the spritesheet
	}
}
