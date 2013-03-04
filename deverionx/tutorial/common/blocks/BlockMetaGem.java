package deverionx.tutorial.common.blocks;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.*;
import deverionx.tutorial.common.TutorialMain;

public class BlockMetaGem extends Block{

    public BlockMetaGem(int ID){
        super(ID,Material.rock); //The ID and material
        
        setBlockName("DeverionXOdedBlockOre"); //The incode name
        setHardness(3.0F); //How hard the block is
        setResistance(5.0F); //How well the block resists explosions
        setStepSound(Block.soundStoneFootstep); //The sounds the block makes
        setCreativeTab(TutorialMain.tabGems); //The tab it appears in
        setTextureFile("/TutorialGFX/Blocks.png"); //The texture file
    }
	
	public int getBlockTextureFromSideAndMetadata(int i, int j){ //The different textures fo different metadatas
		switch(j){
		case 0:return 2; //For sapphire
		case 1:return 3; //For amethyst
		case 2:return 4; //For topaz
		default:return 0;
		}
	}
	
	public int damageDropped(int i){ //Tells it what block it drops and also for creative mode pick block
		return i;
	}
	
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) //Adds the metadata blocks to the creative inventory
    {
        for (int var4 = 0; var4 < 3; ++var4)
        {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }
}