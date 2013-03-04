package deverionx.tutorial.common.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import deverionx.tutorial.common.TutorialMain;

public class ItemAxe extends ItemToolTutorial
{
	public static final Block[] blocksEffectiveAgainst = new Block[] {Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.pumpkin, Block.pumpkinLantern};

    public ItemAxe(int ID, EnumToolMaterial m, int tex, String name)
    {
        super(ID, 1, m, blocksEffectiveAgainst);
        this.setCreativeTab(TutorialMain.tabGems);
        setTextureFile("/TutorialGFX/Items.png");
        setIconIndex(tex);
        setItemName(name);
    }
    
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
        return par2Block != null && (par2Block.blockMaterial == Material.wood || par2Block.blockMaterial == Material.plants || par2Block.blockMaterial == Material.vine) ? this.efficiencyOnProperMaterial : super.getStrVsBlock(par1ItemStack, par2Block);
    }
}
