package Render_Lib.impl;

import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.opengl.GL11;
import Render_Lib.RenderMain;

public class GradientUtil extends RenderMain {
    /**
     * author: HYYT - HYYT#9228
     * author: TheSameGema - TheSameGema#9819
     */

    /*     INSTANCES    */
    public static GradientUtil gradientUtil;

    public static GradientUtil getUtil(){
        return gradientUtil;
    }

    protected static float zLevel;

    /**
     *Drawing Gradient Rect without triangles.
     */
    public void drawGradientRoundedRect(float x, float y, float x2, float y2, final float round, final int color, final int color2) {
        x += (float)(round / 2.0f + 0.5);
        y += (float)(round / 2.0f + 0.5);
        x2 -= (float)(round / 2.0f + 0.5);
        y2 -= (float)(round / 2.0f + 0.5);
        drawGradientRect((int)x, (int)y, (int)x2, (int)y2, color, color2);
        new CircleUtil().drawCircle(x2 - round / 2.0f, y + round / 2.0f, round, color);
        new CircleUtil().drawCircle(x + round / 2.0f, y2 - round / 2.0f, round, color2);
        new CircleUtil().drawCircle(x + round / 2.0f, y + round / 2.0f, round, color);
        new CircleUtil().drawCircle(x2 - round / 2.0f, y2 - round / 2.0f, round, color2);
        drawGradientRect((int)(x - round / 2.0f - 0.5f), (int)(y + round / 2.0f), (int)x2, (int)(y2 - round / 2.0f), color, color2);
        drawGradientRect((int)x, (int)(y + round / 2.0f), (int)(x2 + round / 2.0f + 0.5f), (int)(y2 - round / 2.0f), color, color2);
        drawGradientRect((int)(x + round / 2.0f), (int)(y - round / 2.0f - 0.5f), (int)(x2 - round / 2.0f), (int)(y2 - round / 2.0f), color, color2);
        drawGradientRect((int)(x + round / 2.0f), (int)y, (int)(x2 - round / 2.0f), (int)(y2 + round / 2.0f + 0.5f), color, color2);
    }
    /**
     *Drawing Gradient Rect.
     */
    public void drawGradientRect(int left, int top, int right, int bottom, int startColor, int endColor)
    {
        float f = (float)(startColor >> 24 & 255) / 255.0F;
        float f1 = (float)(startColor >> 16 & 255) / 255.0F;
        float f2 = (float)(startColor >> 8 & 255) / 255.0F;
        float f3 = (float)(startColor & 255) / 255.0F;
        float f4 = (float)(endColor >> 24 & 255) / 255.0F;
        float f5 = (float)(endColor >> 16 & 255) / 255.0F;
        float f6 = (float)(endColor >> 8 & 255) / 255.0F;
        float f7 = (float)(endColor & 255) / 255.0F;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.shadeModel(7425);
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_COLOR);
        worldrenderer.pos((double)right, (double)top, (double)zLevel).color(f1, f2, f3, f).endVertex();
        worldrenderer.pos((double)left, (double)top, (double)zLevel).color(f1, f2, f3, f).endVertex();
        worldrenderer.pos((double)left, (double)bottom, (double)zLevel).color(f5, f6, f7, f4).endVertex();
        worldrenderer.pos((double)right, (double)bottom, (double)zLevel).color(f5, f6, f7, f4).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel(7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    /**
     *Drawing Gradient Rect with support GL11.
     */
    public void drawGradient(double x, double y, double x2, double y2, int col1, int col2) {
        float f = (col1 >> 24 & 0xFF) / 255.0F;
        float f1 = (col1 >> 16 & 0xFF) / 255.0F;


        float f2 = (col1 >> 8 & 0xFF) / 255.0F;
        float f3 = (col1 & 0xFF) / 255.0F;

        float f4 = (col2 >> 24 & 0xFF) / 255.0F;
        float f5 = (col2 >> 16 & 0xFF) / 255.0F;
        float f6 = (col2 >> 8 & 0xFF) / 255.0F;
        float f7 = (col2 & 0xFF) / 255.0F;

        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glShadeModel(7425);

        GL11.glPushMatrix();
        GL11.glBegin(7);
        GL11.glColor4f(f1, f2, f3, f);
        GL11.glVertex2d(x2, y);
        GL11.glVertex2d(x, y);

        GL11.glColor4f(f5, f6, f7, f4);
        GL11.glVertex2d(x, y2);
        GL11.glVertex2d(x2, y2);
        GL11.glEnd();
        GL11.glPopMatrix();

        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
        GL11.glShadeModel(7424);
    }

    /**
     *Drawing Gradient Rect on center.
     */
    public void drawCenteredGradient(double x, double y, double x2, double y2, int col1, int col2) {
        float width = (float)Math.abs(x - x2);
        float height = (float)Math.abs(y - y2);
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        int bright = 50;
        float var1 = 1.0F;
        double left = Math.max(x, x2);
        double right = Math.min(x, x2);
        for (double i = Math.min(x, x2); i < Math.min(x, x2) + (width / 2.0F); i++)
            drawBorderRect(i, y, x2, y2, new ColorUtil().getColor(255, 255, 255, 255), 2.0D);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.color(0.0F, 0.0F, 0.0F, 0.0F);
    }
    /**
     *Drawing Gradient Rect with borders.
     */
    public void drawBorderRect(double x, double y, double x1, double y1, int color, double lwidth) {
        new LineUtil().drawHLine(x, y, x1, y, (float)lwidth, color);
        new LineUtil().drawHLine(x1, y, x1, y1, (float)lwidth, color);
        new LineUtil().drawHLine(x, y1, x1, y1, (float)lwidth, color);
        new LineUtil().drawHLine(x, y1, x, y, (float)lwidth, color);
    }
    /**
     *Drawing Gradient Rect Sideaways.
     */
    public void drawGradientSideways(double left, double top, double right, double bottom, int col1, int col2) {
        float f = (col1 >> 24 & 0xFF) / 255.0F;
        float f1 = (col1 >> 16 & 0xFF) / 255.0F;
        float f2 = (col1 >> 8 & 0xFF) / 255.0F;
        float f3 = (col1 & 0xFF) / 255.0F;

        float f4 = (col2 >> 24 & 0xFF) / 255.0F;
        float f5 = (col2 >> 16 & 0xFF) / 255.0F;
        float f6 = (col2 >> 8 & 0xFF) / 255.0F;
        float f7 = (col2 & 0xFF) / 255.0F;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glShadeModel(7425);

        GL11.glPushMatrix();
        GL11.glBegin(7);
        GL11.glColor4f(f1, f2, f3, f);
        GL11.glVertex2d(left, top);
        GL11.glVertex2d(left, bottom);

        GL11.glColor4f(f5, f6, f7, f4);
        GL11.glVertex2d(right, bottom);
        GL11.glVertex2d(right, top);
        GL11.glEnd();
        GL11.glPopMatrix();

        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
        GL11.glShadeModel(7424);
        GL11.glColor4d(255, 255, 255, 255);
    }
}
