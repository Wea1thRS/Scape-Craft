package net.minecraft.src;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class BlockoreGolds extends Block
{
    public BlockoreGolds(int i, int j)
    {
        super(i, Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
		 MinecraftForge.setBlockHarvestLevel(mod_Flower.oreGolds, 0, "pickaxe", 1);
    }
	int x = 0;
    public int idDropped(int par1, Random par2Random, int par3)
    {
        if (x==0){x++;return Block.oreGold.blockID;}
        if (x==1){x++;return mod_Flower.MXPORB.itemID;}
        if (x==2){x++;return mod_Flower.MXPORB.itemID;}
        if (x==3){x++;return mod_Flower.MXPORB.itemID;}
        else{
        	x=0;
        return mod_Flower.MXPORB.itemID;
       }
    } 
    public int quantityDropped(Random par1Random){return 5;}
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister ir)
    {
           
            {
            this.blockIcon = ir.registerIcon("gold_ore");
            }
    }
}
