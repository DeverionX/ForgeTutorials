package deverionx.tutorial.common.blocks; //The location of the class

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.relauncher.*;
import deverionx.tutorial.common.TutorialMain;

public class BlockRuby extends Block {

	public BlockRuby(int ID) {
		super(ID, Material.iron); //The ID and material (The material defines what tools are better on it)
		setTextureFile("/TutorialGFX/Blocks.png"); //The texture file
		setBlockName("DeverionXBlockRuby"); //The incode name of the block
		setHardness(5.0F); //How hard the block is to break
		setResistance(10.0F); //How well the block resists explosions
		setStepSound(super.soundMetalFootstep); //The sound the block makes when you walk on it as well as place or break it
		setCreativeTab(TutorialMain.tabGems); //The tab it appears in
	}
	
	@SideOnly(Side.CLIENT)
	public int getBlockTextureFromSide(int i){ //What texture it uses
		return 1;
	}

}
