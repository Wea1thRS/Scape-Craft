package net.minecraft.src;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntitySafeFireball extends EntityFireball {
	public int ExplosionPower = 0;

	public EntitySafeFireball(World par1World) {
		super(par1World);
	}

	@SideOnly(Side.CLIENT)
	public EntitySafeFireball(World par1World, double par2, double par4, double par6, double par8, double par10,
			double par12) {
		super(par1World, par2, par4, par6, par8, par10, par12);
	}

	public EntitySafeFireball(World par1World, EntityLivingBase par2EntityLivingBase, double par3, double par5,
			double par7) {
		super(par1World, par2EntityLivingBase, par3, par5, par7);
	}

	/**
	 * Called when this EntityFireball hits a block or entity.
	 */
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
        if (!this.worldObj.isRemote) {
            if (par1MovingObjectPosition.entityHit != null && !(par1MovingObjectPosition.entityHit instanceof EntityHanging)) {
                par1MovingObjectPosition.entityHit
                        .attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 10.0F);
            }
            this.worldObj.newExplosion((Entity) null, this.posX, this.posY, this.posZ, (float) this.ExplosionPower, true,
                    this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
            this.setDead();
        }
    }

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setInteger("ExplosionPower", this.ExplosionPower);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);

		if (par1NBTTagCompound.hasKey("ExplosionPower")) {
			this.ExplosionPower = par1NBTTagCompound.getInteger("ExplosionPower");
		}
	}
}