package deverionx.tutorial.common.item;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemToolTutorial extends Item
{
    private Block[] blocksEffectiveAgainst; //What it's good against
    public float efficiencyOnProperMaterial = 4.0F; //How fast it is

    public int damageVsEntity;

    //The material
    protected EnumToolMaterial toolMaterial;

    protected ItemToolTutorial(int ID, int Damage, EnumToolMaterial m, Block[] ea)
    {
        super(ID);
        this.toolMaterial = m; //The material
        this.blocksEffectiveAgainst = ea; //What it's good against
        this.maxStackSize = 1; //The max stack size
        this.setMaxDamage(m.getMaxUses()); //The max damage
        this.efficiencyOnProperMaterial = m.getEfficiencyOnProperMaterial();
        this.damageVsEntity = Damage + m.getDamageVsEntity();
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    //How well it mines a block
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
        for (int var3 = 0; var3 < this.blocksEffectiveAgainst.length; ++var3)
        {
            if (this.blocksEffectiveAgainst[var3] == par2Block)
            {
                return this.efficiencyOnProperMaterial;
            }
        }

        return 1.0F;
    }

    //What happens when you hit an entity
    public boolean hitEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving)
    {
        par1ItemStack.damageItem(2, par3EntityLiving);
        return true;
    }

    //What happens when you break a block
    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLiving par7EntityLiving)
    {
        if ((double)Block.blocksList[par3].getBlockHardness(par2World, par4, par5, par6) != 0.0D)
        {
            par1ItemStack.damageItem(1, par7EntityLiving);
        }

        return true;
    }

    //How much damage it does
    public int getDamageVsEntity(Entity par1Entity)
    {
        return this.damageVsEntity;
    }

    @SideOnly(Side.CLIENT)
    //Makes it have a slightly different render
    public boolean isFull3D()
    {
        return true;
    }

    //How well it enchants
    public int getItemEnchantability()
    {
        return this.toolMaterial.getEnchantability();
    }

    //Java name of the material
    public String getToolMaterialName()
    {
        return this.toolMaterial.toString();
    }

    //Allows for repair in an anvil
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return this.toolMaterial.getToolCraftingMaterial() == par2ItemStack.itemID ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }

    //How fast it mines a block (Compatibility edition)
    @Override
    public float getStrVsBlock(ItemStack stack, Block block, int meta) 
    {
        if (ForgeHooks.isToolEffective(stack, block, meta))
        {
            return efficiencyOnProperMaterial;
        }
        return getStrVsBlock(stack, block);
    }
}
