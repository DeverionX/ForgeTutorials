package deverionx.tutorial.common.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.*;
import deverionx.tutorial.common.TutorialMain;

public class TabGems extends CreativeTabs {

	public TabGems(int position, String tabID) {
		super(position, tabID); //The constructor for your tab
	}
	
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack(){
		return new ItemStack(TutorialMain.metaGem,1,2);
	}

	public String getTranslatedTabLabel()
	{
		return "Gems"; //The name of the tab ingame
	}

}
