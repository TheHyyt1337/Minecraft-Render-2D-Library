package Render_Lib.impl;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import org.lwjgl.opengl.GL11;
import Render_Lib.RenderMain;

public class R3DUtil extends RenderMain {

    public static R3DUtil r3dUtil;

    public static R3DUtil getUtil(){
        return r3dUtil;
    }

    public void drawOutlinedBox(AxisAlignedBB box2) {
        if (box2 == null) {
            return;
        }
        mc.entityRenderer.setupCameraTransform(mc.timer.renderPartialTicks, 0);
        GL11.glBegin(3);
        GL11.glVertex3d(box2.minX, box2.minY, box2.minZ);
        GL11.glVertex3d(box2.maxX, box2.minY, box2.minZ);
        GL11.glVertex3d(box2.maxX, box2.minY, box2.maxZ);
        GL11.glVertex3d(box2.minX, box2.minY, box2.maxZ);
        GL11.glVertex3d(box2.minX, box2.minY, box2.minZ);
        GL11.glEnd();
        GL11.glBegin(3);
        GL11.glVertex3d(box2.minX, box2.maxY, box2.minZ);
        GL11.glVertex3d(box2.maxX, box2.maxY, box2.minZ);
        GL11.glVertex3d(box2.maxX, box2.maxY, box2.maxZ);
        GL11.glVertex3d(box2.minX, box2.maxY, box2.maxZ);
        GL11.glVertex3d(box2.minX, box2.maxY, box2.minZ);
        GL11.glEnd();
        GL11.glBegin(1);
        GL11.glVertex3d(box2.minX, box2.minY, box2.minZ);
        GL11.glVertex3d(box2.minX, box2.maxY, box2.minZ);
        GL11.glVertex3d(box2.maxX, box2.minY, box2.minZ);
        GL11.glVertex3d(box2.maxX, box2.maxY, box2.minZ);
        GL11.glVertex3d(box2.maxX, box2.minY, box2.maxZ);
        GL11.glVertex3d(box2.maxX, box2.maxY, box2.maxZ);
        GL11.glVertex3d(box2.minX, box2.minY, box2.maxZ);
        GL11.glVertex3d(box2.minX, box2.maxY, box2.maxZ);
        GL11.glEnd();

    }

    public void drawOutlinedBoundingBox(AxisAlignedBB aa) {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        worldRenderer.begin(3, DefaultVertexFormats.POSITION);
        worldRenderer.pos(aa.minX, aa.minY, aa.minZ).endVertex();
        worldRenderer.pos(aa.maxX, aa.minY, aa.minZ).endVertex();
        worldRenderer.pos(aa.maxX, aa.minY, aa.maxZ).endVertex();
        worldRenderer.pos(aa.minX, aa.minY, aa.maxZ).endVertex();
        worldRenderer.pos(aa.minX, aa.minY, aa.minZ).endVertex();
        tessellator.draw();
        worldRenderer.begin(3, DefaultVertexFormats.POSITION);
        worldRenderer.pos(aa.minX, aa.maxY, aa.minZ).endVertex();
        worldRenderer.pos(aa.maxX, aa.maxY, aa.minZ).endVertex();
        worldRenderer.pos(aa.maxX, aa.maxY, aa.maxZ).endVertex();
        worldRenderer.pos(aa.minX, aa.maxY, aa.maxZ).endVertex();
        worldRenderer.pos(aa.minX, aa.maxY, aa.minZ).endVertex();
        tessellator.draw();
        worldRenderer.begin(1, DefaultVertexFormats.POSITION);
        worldRenderer.pos(aa.minX, aa.minY, aa.minZ).endVertex();
        worldRenderer.pos(aa.minX, aa.maxY, aa.minZ).endVertex();
        worldRenderer.pos(aa.maxX, aa.minY, aa.minZ).endVertex();
        worldRenderer.pos(aa.maxX, aa.maxY, aa.minZ).endVertex();
        worldRenderer.pos(aa.maxX, aa.minY, aa.maxZ).endVertex();
        worldRenderer.pos(aa.maxX, aa.maxY, aa.maxZ).endVertex();
        worldRenderer.pos(aa.minX, aa.minY, aa.maxZ).endVertex();
        worldRenderer.pos(aa.minX, aa.maxY, aa.maxZ).endVertex();
        tessellator.draw();
    }


    public void drawBoundingBox(AxisAlignedBB axisalignedbb) {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrender = Tessellator.getInstance().getWorldRenderer();
        worldrender.drawMultiTexture();
        worldrender.pos(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.pos(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.pos(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.pos(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.pos(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.pos(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.pos(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.pos(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.pos(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.pos(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.pos(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.pos(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.pos(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.pos(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.pos(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.pos(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.pos(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.pos(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.pos(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.pos(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.pos(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.pos(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.pos(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.pos(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.pos(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.pos(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.pos(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.pos(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.pos(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.pos(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.pos(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.pos(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.pos(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.pos(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.pos(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.pos(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.pos(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.pos(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.pos(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.pos(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.pos(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.pos(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.pos(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.pos(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.pos(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.pos(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.pos(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.pos(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
        tessellator.draw();
    }

    public void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent) {
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float) posX, (float) posY, 50.0F);
        GlStateManager.scale((float) (-scale), (float) scale, (float) scale);
        GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
        float f = ent.renderYawOffset;
        float f1 = ent.rotationYaw;
        float f2 = ent.rotationPitch;
        float f3 = ent.prevRotationYawHead;
        float f4 = ent.rotationYawHead;
        GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(-((float) Math.atan(mouseY / 40.0F)) * 20.0F, 1.0F, 0.0F, 0.0F);
        ent.renderYawOffset = (float) Math.atan(mouseX / 40.0F) * 20.0F;
        ent.rotationYaw = (float) Math.atan(mouseX / 40.0F) * 40.0F;
        ent.rotationPitch = -((float) Math.atan(mouseY / 40.0F)) * 20.0F;
        ent.rotationYawHead = ent.rotationYaw;
        ent.prevRotationYawHead = ent.rotationYaw;
        GlStateManager.translate(0.0F, 0.0F, 0.0F);
        RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
        rendermanager.setPlayerViewY(180.0F);
        rendermanager.setRenderShadow(false);
        rendermanager.renderEntityWithPosYaw(ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
        rendermanager.setRenderShadow(true);
        ent.renderYawOffset = f;
        ent.rotationYaw = f1;
        ent.rotationPitch = f2;
        ent.prevRotationYawHead = f3;
        ent.rotationYawHead = f4;
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }

    public void drawblock(double a, double a2, double a3, int a4, int a5, float a6) {
        float a7 = (float) (a4 >> 24 & 255) / 255.0f;
        float a8 = (float) (a4 >> 16 & 255) / 255.0f;
        float a9 = (float) (a4 >> 8 & 255) / 255.0f;
        float a10 = (float) (a4 & 255) / 255.0f;
        float a11 = (float) (a5 >> 24 & 255) / 255.0f;
        float a12 = (float) (a5 >> 16 & 255) / 255.0f;
        float a13 = (float) (a5 >> 8 & 255) / 255.0f;
        float a14 = (float) (a5 & 255) / 255.0f;
        GL11.glPushMatrix();
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glDisable((int) 3553);
        GL11.glEnable((int) 2848);
        GL11.glDisable((int) 2929);
        GL11.glDepthMask((boolean) false);
        GL11.glColor4f((float) a8, (float) a9, (float) a10, (float) a7);
        drawOutlinedBoundingBox(new AxisAlignedBB(a, a2, a3, a + 1.0, a2 + 1.0, a3 + 1.0));
        GL11.glLineWidth((float) a6);
        GL11.glColor4f((float) a12, (float) a13, (float) a14, (float) a11);
        drawOutlinedBoundingBox(new AxisAlignedBB(a, a2, a3, a + 1.0, a2 + 1.0, a3 + 1.0));
        GL11.glDisable((int) 2848);
        GL11.glEnable((int) 3553);
        GL11.glEnable((int) 2929);
        GL11.glDepthMask((boolean) true);
        GL11.glDisable((int) 3042);
        GL11.glPopMatrix();
    }

    public void drawEntityESP(double var0, double var2, double var4, double var6, double var8, float var10, float var11, float var12, float var13, float var14, float var15, float var16, float var17, float var18) {
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3553);
        GL11.glEnable(2848);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glColor4f(var10, var11, var12, var13);
        drawBoundingBox(new AxisAlignedBB(var0 - var6, var2, var4 - var6, var0 + var6, var2 + var8, var4 + var6));
        GL11.glLineWidth(var18);
        GL11.glColor4f(var14, var15, var16, var17);
        drawOutlinedBoundingBox(new AxisAlignedBB(var0 - var6, var2, var4 - var6, var0 + var6, var2 + var8, var4 + var6));
        GL11.glDisable(2848);
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }

    public void drawLine3D(float x, float y, float z, float x1, float y1, float z1, int color) {
        new GlUtil().pre3D();
        GL11.glLoadIdentity();
        (Minecraft.getMinecraft()).entityRenderer.orientCamera((Minecraft.getMinecraft()).timer.renderPartialTicks);
        float var11 = (color >> 24 & 0xFF) / 255.0F;
        float var6 = (color >> 16 & 0xFF) / 255.0F;
        float var7 = (color >> 8 & 0xFF) / 255.0F;
        float var8 = (color & 0xFF) / 255.0F;
        GL11.glColor4f(var6, var7, var8, var11);
        GL11.glLineWidth(0.5F);
        GL11.glBegin(3);
        GL11.glVertex3d(x, y, z);
        GL11.glVertex3d(x1, y1, z1);
        GL11.glEnd();
        new GlUtil().post3D();
    }

    public void draw3DLine(float x, float y, float z, int color) {
        new GlUtil().pre3D();
        GL11.glLoadIdentity();
        (Minecraft.getMinecraft()).entityRenderer.orientCamera((Minecraft.getMinecraft()).timer.renderPartialTicks);
        float var11 = (color >> 24 & 0xFF) / 255.0F;
        float var6 = (color >> 16 & 0xFF) / 255.0F;
        float var7 = (color >> 8 & 0xFF) / 255.0F;
        float var8 = (color & 0xFF) / 255.0F;
        GL11.glColor4f(var6, var7, var8, var11);
        GL11.glLineWidth(1.5F);
        GL11.glBegin(3);
        Minecraft.getMinecraft();
        GL11.glVertex3d(0.0D, Minecraft.thePlayer.getEyeHeight(), 0.0D);
        GL11.glVertex3d(x, y, z);
        GL11.glEnd();
        new GlUtil().post3D();
    }

    public int getWidth(){
        return getScaledRes().getScaledWidth();
    }

    public int getHeight(){
        return getScaledRes().getScaledHeight();
    }

}
