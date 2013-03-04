package deverionx.tutorial.common.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import deverionx.tutorial.common.TutorialMain;

public class BlockOre extends Block {

	public BlockOre(int ID){
		super(ID,Material.rock); //Parameters: Block ID, Block material
		setTextureFile("/TutorialGFX/Blocks.png"); //The texture file used
		setBlockName("DeverionXBlockOre"); //The incode block name
		setHardness(3.0F); //The block hardness
		setResistance(5.0F); //The explosion resistance
		setCreativeTab(TutorialMain.tabGems); //The tab it appears in
	}
	
	public int getBlockTextureFromSideAndMetadata(int i,int j){ //Gets the texture from metadata
		switch(j){
		case 0:return 5;
		case 1:return 6;
		case 2:return 7;
		case 3:return 8;
		default:return 0;
		}
	}
	
	public int damageDropped(int i){ //Makes sure pick block works right
		return i;
	}
	
	public void getSubBlocks(int i, CreativeTabs tab, List l){ //Puts all sub blocks into the creative inventory
		l.add(new ItemStack(i,1,0));
		l.add(new ItemStack(i,1,1));
		l.add(new ItemStack(i,1,2));
		l.add(new ItemStack(i,1,3));
	}
	
	public ArrayList<ItemStack> getBlockDropped(World w, int x, int y, int z, int meta, int fortune){ //Specifies the block drop
		ArrayList<ItemStack> list = new ArrayList<ItemStack>(); //The list of items
		
		list.add(new ItemStack(meta == 0 ? TutorialMain.ruby : TutorialMain.metaGem,1,meta == 0 ? 0 : meta-1)); //One guaranteed
		
		for(int i=0;i<2+fortune;i++){ //A loop for drops, increased by fortune enchant
			if(w.rand.nextInt(101) > 49){ //50% chance
				list.add(new ItemStack(meta == 0 ? TutorialMain.ruby : TutorialMain.metaGem,1,meta == 0 ? 0 : meta-1)); //Adds the gem
			}
		}
		
		return list; //Returns the finished list :)
	}
}
