package deverionx.tutorial.common.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import deverionx.tutorial.common.TutorialMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRubyGlass extends Block {

	public BlockRubyGlass(int i){
		super(i,Material.glass);
		setStepSound(soundGlassFootstep);
		setTextureFile("/TutorialGFX/Blocks.png");
		setHardness(0.3F);
		setResistance(0.0F);
		setCreativeTab(TutorialMain.tabGems);
		setBlockName("DeverionXBlockRubyGlass");
	}
	
	public int getBlockTextureFromSideAndMetadata(int i,int j){
		return 9;
	}
	
	public int quantityDropped(Random r){ //This will stop the block from dropping
		return 0;
	}
	
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() //Put 0 for fully transparent or opaque blocks, and 1 for semi-transparent
    {
        return 1;
    }
    
    public boolean isOpaqueCube() //Tells the game if the block is transparent
    {
        return false;
    }
    
    public boolean renderAsNormalBlock() //Tells the game how to render the block
    {
        return false;
    }
    
    protected boolean canSilkHarvest() //Tells the game if silk touch can harvest the block
    {
        return true;
    }
    
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) //Renders neighbouring blocks
    {
    	
    	int i = par1IBlockAccess.getBlockId(par2, par3, par4);
    	
        return i == blockID ? false:true;
    }
}
