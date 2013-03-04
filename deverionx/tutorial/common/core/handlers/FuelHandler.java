package deverionx.tutorial.common.core.handlers;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;
import deverionx.tutorial.common.TutorialMain;

public class FuelHandler implements IFuelHandler{

	@Override
	public int getBurnTime(ItemStack fuel) {
		if(fuel.itemID == TutorialMain.ruby.itemID){
			return 150;
		}
		
		return 0;
	}

}
