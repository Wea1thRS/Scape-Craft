package net.minecraft.src;
 
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
 
public class RenderLesserDemon2 extends RenderLiving
{
    private static final ResourceLocation textureLocation = new ResourceLocation("textures/entity/LesserDemon2.png");
    
    protected ResourceLocation func_110779_a(EntityLesserDemon par1EntityAbbyDemon)
    {
             return textureLocation;
    }
    
    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
    return textureLocation;
    }
	
    protected void preRenderScale(EntityLesserDemon2 par1EntityNameHere , float par2)
    {
                    // These values are x,y,z scale. Where 1.0F = 100% (original size)
		 GL11.glScalef(1.5F, 1.5F, 1.5F);
    }
    
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.preRenderScale((EntityLesserDemon2)par1EntityLivingBase, par2);
    }
    
    public RenderLesserDemon2(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }
 
    public void renderLesserDemon2(EntityLesserDemon2 par1EntityLesserDemon2, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1EntityLesserDemon2, par2, par4, par6, par8, par9);
    }
 
    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderLesserDemon2((EntityLesserDemon2)par1EntityLiving, par2, par4, par6, par8, par9);
    }
   
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderLesserDemon2((EntityLesserDemon2)par1Entity, par2, par4, par6, par8, par9);
    }
}