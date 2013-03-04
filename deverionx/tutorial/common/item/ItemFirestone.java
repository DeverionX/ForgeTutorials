package deverionx.tutorial.common.item;

import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.*;
import deverionx.tutorial.common.TutorialMain;

public class ItemFirestone extends Item {

	public ItemFirestone(int par1) {
		super(par1);
		setTextureFile("/TutorialGFX/Items.png");
		setItemName("DeverionXItemFireStone");
		setCreativeTab(TutorialMain.tabGems);
		setMaxDamage(30); //Sets the item's max damage
		setMaxStackSize(1); //Sets the maximum size of an itemstack for this item
	}
	
	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int i){
		return 5;
	}
}
