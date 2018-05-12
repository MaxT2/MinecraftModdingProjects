package maxts2.tutorialmod.render;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.potion.PotionHelper;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

public class TMSnowballRenderer extends RenderSnowball {
	private Item field_94151_a;
	private int field_94150_f;

	public TMSnowballRenderer(Item p_i1260_1_) {
		super(p_i1260_1_);
		// TODO Auto-generated constructor stub

		
	}

	public TMSnowballRenderer(Item p_i1259_1_, int p_i1259_2_) {
		super(p_i1259_1_,p_i1259_2_);
		this.field_94151_a = p_i1259_1_;
		this.field_94150_f = p_i1259_2_;

		// TODO Auto-generated constructor stub
	}
	@Override
	public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
	{
		IIcon iicon = this.field_94151_a.getIconFromDamage(this.field_94150_f);

		if (iicon != null)
		{
			GL11.glPushMatrix();
			GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		//	GL11.glScalef(2F, 2F, 2F);
			GL11.glScalef(8F, 8F, 8F);
			this.bindEntityTexture(p_76986_1_);
			Tessellator tessellator = Tessellator.instance;

			if (iicon == ItemPotion.func_94589_d("bottle_splash"))
			{
				int i = PotionHelper.func_77915_a(((EntityPotion)p_76986_1_).getPotionDamage(), false);
				float f2 = (float)(i >> 16 & 255) / 255.0F;
				float f3 = (float)(i >> 8 & 255) / 255.0F;
				float f4 = (float)(i & 255) / 255.0F;
				GL11.glColor3f(f2, f3, f4);
				GL11.glPushMatrix();
				this.func_77026_a(tessellator, ItemPotion.func_94589_d("overlay"));
				GL11.glPopMatrix();
				GL11.glColor3f(1.0F, 1.0F, 1.0F);
			}

			this.func_77026_a(tessellator, iicon);
			GL11.glDisable(GL12.GL_RESCALE_NORMAL);
			GL11.glPopMatrix();
		}
	}
	protected ResourceLocation getEntityTexture(Entity p_110775_1_)
	{
		return TextureMap.locationItemsTexture;
	}

	private void func_77026_a(Tessellator p_77026_1_, IIcon p_77026_2_)
	{
		float f = p_77026_2_.getMinU();
		float f1 = p_77026_2_.getMaxU();
		float f2 = p_77026_2_.getMinV();
		float f3 = p_77026_2_.getMaxV();
		float f4 = 1.0F;
		float f5 = 0.5F;
		float f6 = 0.25F;
		GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
		p_77026_1_.startDrawingQuads();
		p_77026_1_.setNormal(0.0F, 1.0F, 0.0F);
		p_77026_1_.addVertexWithUV((double)(0.0F - f5), (double)(0.0F - f6), 0.0D, (double)f, (double)f3);
		p_77026_1_.addVertexWithUV((double)(f4 - f5), (double)(0.0F - f6), 0.0D, (double)f1, (double)f3);
		p_77026_1_.addVertexWithUV((double)(f4 - f5), (double)(f4 - f6), 0.0D, (double)f1, (double)f2);
		p_77026_1_.addVertexWithUV((double)(0.0F - f5), (double)(f4 - f6), 0.0D, (double)f, (double)f2);
		p_77026_1_.draw();
	}

}
