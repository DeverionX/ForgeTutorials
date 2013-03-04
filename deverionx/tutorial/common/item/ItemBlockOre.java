package deverionx.tutorial.common.item;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import deverionx.tutorial.common.TutorialMain;

public class ItemBlockOre extends ItemBlock {

	public ItemBlockOre(int i){
		super(i);
	}
	
	public int getMetadata(int i){
		return i;
	}
	
	public String getItemNameIS(ItemStack is){
		switch(is.getItemDamage()){
		case 0:return "DeverionXBlockRubyOre";
		case 1:return "DeverionXBlockSapphireOre";
		case 2:return "DeverionXBlockAmethystOre";
		case 3:return "DeverionXBlockTopazOre";
		default:return "";
		}
	}
	
	public int getIconFromDamage(int i){
		return TutorialMain.ore.getBlockTextureFromSideAndMetadata(2,i);
	}
}
