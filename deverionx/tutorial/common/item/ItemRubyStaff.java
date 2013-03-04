package deverionx.tutorial.common.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import deverionx.tutorial.common.TutorialMain;

public class ItemRubyStaff extends Item {

	public ItemRubyStaff(int par1) {
		super(par1);
		setTextureFile("/TutorialGFX/Items.png"); //Texture File
		setItemName("DeverionXRubyStaff"); //Incode item name
		setCreativeTab(TutorialMain.tabGems); //Tab it appears in
	}
	
	public int getIconFromDamage(int i){ //Gets the icon to display
		return 4;
	}
	
	public boolean onItemUse(ItemStack is, EntityPlayer player, World w, int x, int y, int z, int l, float f, float f1, float f3){ //Called when an item is right clicked on a block
		if(w.getBlockId(x, y, z) == Block.planks.blockID){ //If blockId at x y z is planks:
			w.setBlockMetadataWithNotify(x, y, z, w.getBlockMetadata(x, y, z)+1); //Increase the metadata
			
			if(w.getBlockMetadata(x, y, z) == 4){ //If metadata is 4
				w.setBlockMetadata(x, y, z, 0); //Reset to 0
			}
			
		}else if(w.getBlockId(x, y, z) == Block.plantRed.blockID){ //If block id is red plant
			w.setBlockWithNotify(x, y, z, Block.plantYellow.blockID); //Changing block to yellow plant
			
		}else if(w.getBlockId(x, y, z) == Block.plantYellow.blockID){ //Vice Versa
			w.setBlockWithNotify(x, y, z, Block.plantRed.blockID);
		}else if(w.getBlockId(x, y, z) == Block.cobblestone.blockID){ //If block is cobble
			w.setBlockWithNotify(x, y, z, Block.cobblestoneMossy.blockID); //Set to mossy
		}else if(w.getBlockId(x, y, z) == Block.cobblestoneMossy.blockID){ //Vice versa
			w.setBlockWithNotify(x, y, z, Block.cobblestone.blockID);
		}
		return false;
	}
	
	@Override
	public void addInformation(ItemStack is, EntityPlayer player, List l, boolean b){ //Additional info (eg. the names of music discs)
		l.add("This staff is magical!");
	}
	
	public EnumRarity getRarity(ItemStack is){ //The colour of the item name (eg. with golden apples)
		return EnumRarity.epic;
	}
	
	@Override
	public int getDamageVsEntity(Entity e){ //The amount of damage dealt to an entity when using this item as a weapon
		return 0;
	}
	
	public boolean hasEffect(ItemStack is){ //Adds an effect to the item (eg. golden apples)
		return true;
	}

}
