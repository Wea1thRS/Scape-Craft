package net.minecraft.src;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

public class ItemPickaxeGaloreg extends ItemTool {
	/** an array of the blocks this pickaxe is effective against */
	private static Block[] blocksEffectiveAgainst = new Block[] {
			Block.cobblestone, Block.stoneDoubleSlab, Block.stoneSingleSlab,
			Block.stone, Block.sandStone, Block.cobblestoneMossy,
			Block.oreIron, Block.blockIron, Block.oreCoal, Block.blockGold,
			Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice,
			Block.netherrack, Block.oreLapis, Block.blockLapis,
			Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail,
			Block.railDetector, Block.railPowered ,Block.grass, Block.dirt,
			Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay,
			Block.tilledField, Block.slowSand, Block.mycelium
			,Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stoneDoubleSlab,
			Block.stoneSingleSlab, Block.pumpkin, Block.pumpkinLantern};

	protected ItemPickaxeGaloreg(int par1, EnumToolMaterial par2EnumToolGalore) {
		super(par1, 2, par2EnumToolGalore, blocksEffectiveAgainst);
	}

	/**
	 * Returns if the item (tool) can harvest results from the block type.
	 */
	public boolean canHarvestBlock(Block par1Block) {
		return par1Block == Block.obsidian ? this.toolMaterial
				.getHarvestLevel() == 3
				: (par1Block != Block.blockDiamond
						&& par1Block != Block.oreDiamond ? (par1Block == Block.oreEmerald ? this.toolMaterial
						.getHarvestLevel() >= 2
						: (par1Block != Block.blockGold
								&& par1Block != Block.oreGold ? (par1Block != Block.blockIron
								&& par1Block != Block.oreIron ? (par1Block != Block.blockLapis
								&& par1Block != Block.oreLapis ? (par1Block != Block.oreRedstone
								&& par1Block != Block.oreRedstoneGlowing ? (par1Block.blockMaterial == Material.rock ? true
								: par1Block.blockMaterial == Material.iron)
								: this.toolMaterial.getHarvestLevel() >= 2)
								: this.toolMaterial.getHarvestLevel() >= 1)
								: this.toolMaterial.getHarvestLevel() >= 1)
								: this.toolMaterial.getHarvestLevel() >= 2))
						: this.toolMaterial.getHarvestLevel() >= 2);
	}

	/**
	 * Returns the strength of the stack against a given block. 1.0F base,
	 * (Quality+1)*2 if correct blocktype, 1.5F if sword
	 */
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
		return par2Block != null
				&& (par2Block.blockMaterial == Material.iron || par2Block.blockMaterial == Material.rock) ? this.efficiencyOnProperMaterial
				: super.getStrVsBlock(par1ItemStack, par2Block);
	}
	  @SideOnly(Side.CLIENT)
	    public void registerIcons(IconRegister ir)
	    {
	            {
	            this.itemIcon = ir.registerIcon("pickaxegaloreg");
	            }
	    }
}