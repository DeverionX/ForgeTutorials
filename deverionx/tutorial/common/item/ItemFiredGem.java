package deverionx.tutorial.common.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.relauncher.*;
import deverionx.tutorial.common.TutorialMain;

public class ItemFiredGem extends Item {

	public ItemFiredGem(int par1) {
		super(par1);
		setTextureFile("/TutorialGFX/Items.png");
		setItemName("DeverionXItemFiredGem");
		setCreativeTab(TutorialMain.tabGems);
		setHasSubtypes(true);
	}
	
	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int i){
		switch(i){
		case 0:return 6;
		case 1:return 7;
		}
		
		return 0;
	}
	
	public String getItemNameIS(ItemStack is){
		switch(is.getItemDamage()){
		case 0:return "DeverionXItemStormStone";
		case 1:return "DeverionXItemLushStone";
		}
		return "itemUnknown";
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubItems(int itemID, CreativeTabs tab, List itemList) //Adds the metadata items to the creative inventory
	{
		for(int i=0;i<2;i++){
			itemList.add(new ItemStack(itemID,1,i)); //Adds all the metadatas
		}
	}
}
