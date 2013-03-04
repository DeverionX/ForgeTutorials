package deverionx.tutorial.common.item;

import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import deverionx.tutorial.common.TutorialMain;

public class ItemShovel extends ItemToolTutorial
{
    public static final Block[] blocksEffectiveAgainst = new Block[] {Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium};

    public ItemShovel(int ID, EnumToolMaterial m, int tex, String name)
    {
        super(ID, 1, m, blocksEffectiveAgainst);
        setTextureFile("/TutorialGFX/Items.png");
        this.setCreativeTab(TutorialMain.tabGems);
        setIconIndex(tex);
        setItemName(name);
    }

    public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block == Block.snow ? true : par1Block == Block.blockSnow;
    }
    
    
}
