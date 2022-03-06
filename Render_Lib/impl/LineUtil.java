package Render_Lib.impl;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;
import Render_Lib.RenderMain;

public class LineUtil extends RenderMain {
    /**
     * author: HYYT - HYYT#9228
     * author: TheSameGema - TheSameGema#9819
     */

    /*     INSTANCES    */
    public static LineUtil lineUtil;

    public static LineUtil getUtil(){
        return lineUtil;
    }

    /**
     *Draws V Line rect.
     */
    public void drawVLine(float x, float y, float x1, int y1) {
        if (x1 < y) {
            float var5 = y;
            y = x1;
            x1 = var5;
        }
        Gui.drawRect(x, y + 1.0f, x + 1.0f, x1, y1);
    }

    /**
     *Draws H Line rect.
     */
    public void drawHLine(float x, float y, float x1, int y1) {
        if (y < x) {
            float var5 = x;
            x = y;
            y = var5;
        }
        Gui.drawRect(x, x1, y + 1.0f, x1 + 1.0f, y1);
    }

    /**
     *Draws H Line rect with GL.
     */
    public void drawHLine(double x, double y, double x1, double y1, float width, int color) {
        float var11 = (color >> 24 & 0xFF) / 255.0F;
        float var6 = (color >> 16 & 0xFF) / 255.0F;
        float var7 = (color >> 8 & 0xFF) / 255.0F;
        float var8 = (color & 0xFF) / 255.0F;
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.color(var6, var7, var8, var11);
        GL11.glPushMatrix();
        GL11.glLineWidth(width);
        GL11.glBegin(3);
        GL11.glVertex2d(x, y);
        GL11.glVertex2d(x1, y1);
        GL11.glEnd();
        GL11.glLineWidth(1.0F);
        GL11.glPopMatrix();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
    }

    /**
     *Draws V Line rect with GL.
     */
    public void drawVLine(float x, float y, float x1, float y1, float width, int color) {
        if (width <= 0.0F)
            return;
        GL11.glPushMatrix();
        new GlUtil().pre3D();
        float var11 = (color >> 24 & 0xFF) / 255.0F;
        float var6 = (color >> 16 & 0xFF) / 255.0F;
        float var7 = (color >> 8 & 0xFF) / 255.0F;
        float var8 = (color & 0xFF) / 255.0F;
        GlStateManager.enableAlpha();
        GlStateManager.enableBlend();
        int shade = GL11.glGetInteger(2900);
        GlStateManager.shadeModel(7425);
        GL11.glColor4f(var6, var7, var8, var11);
        float line = GL11.glGetFloat(2849);
        GL11.glLineWidth(width);
        GL11.glBegin(3);
        GL11.glVertex3d(x, y, 0.0D);
        GL11.glVertex3d(x1, y1, 0.0D);
        GL11.glEnd();
        GlStateManager.shadeModel(shade);
        GL11.glLineWidth(line);
        new GlUtil().post3D();
        GL11.glPopMatrix();
    }
}
