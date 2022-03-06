package Render_Lib.impl;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;
import Render_Lib.RenderMain;

public class RectUtil extends RenderMain {
    /**
     * author: HYYT - HYYT#9228
     * author: TheSameGema - TheSameGema#9819
     */

    /*     INSTANCES    */
    public static RectUtil rectUtil;

    public static RectUtil getUtil(){
        return rectUtil;
    }

    public void drawRoundedRect(double x, double y, double width, double height, float cornerRadius) {
        final int slices = 10;

        drawFillRectangle(x + cornerRadius, y, width - 2 * cornerRadius, height);
        drawFillRectangle(x, y + cornerRadius, cornerRadius, height - 2 * cornerRadius);
        drawFillRectangle(x + width - cornerRadius, y + cornerRadius, cornerRadius, height - 2 * cornerRadius);

        new CircleUtil().drawCirclePart(x + cornerRadius, y + cornerRadius, -MathHelper.PI, -MathHelper.PId2, cornerRadius, slices);
        new CircleUtil().drawCirclePart(x + cornerRadius, y + height - cornerRadius, -MathHelper.PId2, 0.0F, cornerRadius, slices);

        new CircleUtil().drawCirclePart(x + width - cornerRadius, y + cornerRadius, MathHelper.PId2, MathHelper.PI, cornerRadius, slices);
        new CircleUtil().drawCirclePart(x + width - cornerRadius, y + height - cornerRadius, 0, MathHelper.PId2, cornerRadius, slices);

        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_TEXTURE_2D);

        GlStateManager.disableBlend();

    }

    public void drawTestRect(float g2, float h2, float i2, float j2, int col1) {
        float f2 = (float)(col1 >> 24 & 255) / 255.0f;
        float f22 = (float)(col1 >> 16 & 255) / 255.0f;
        float f3 = (float)(col1 >> 8 & 255) / 255.0f;
        float f4 = (float)(col1 & 255) / 255.0f;
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glColor4f(f22, f3, f4, f2);
        GL11.glBegin(7);
        GL11.glVertex2d(i2, h2);
        GL11.glVertex2d(g2, h2);
        GL11.glVertex2d(g2, j2);
        GL11.glVertex2d(i2, j2);
        GL11.glEnd();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
        GL11.glPopMatrix();
    }

    public void drawRoundedRectOld(float x, float y, float x2, float y2, final float round, final int color) {
        x += (float)(round / 2.0f + 0.5);
        y += (float)(round / 2.0f + 0.5);
        x2 -= (float)(round / 2.0f + 0.5);
        y2 -= (float)(round / 2.0f + 0.5);
        Gui.drawRect((int)x, (int)y, (int)x2, (int)y2, color);
        new CircleUtil().drawCircle(x2 - round / 2.0f, y + round / 2.0f, round, color);
        new CircleUtil().drawCircle(x + round / 2.0f, y2 - round / 2.0f, round, color);
        new CircleUtil().drawCircle(x + round / 2.0f, y + round / 2.0f, round, color);
        new CircleUtil().drawCircle(x2 - round / 2.0f, y2 - round / 2.0f, round, color);
        Gui.drawRect((int)(x - round / 2.0f - 0.5f), (int)(y + round / 2.0f), (int)x2, (int)(y2 - round / 2.0f), color);
        Gui.drawRect((int)x, (int)(y + round / 2.0f), (int)(x2 + round / 2.0f + 0.5f), (int)(y2 - round / 2.0f), color);
        Gui.drawRect((int)(x + round / 2.0f), (int)(y - round / 2.0f - 0.5f), (int)(x2 - round / 2.0f), (int)(y2 - round / 2.0f), color);
        Gui.drawRect((int)(x + round / 2.0f), (int)y, (int)(x2 - round / 2.0f), (int)(y2 + round / 2.0f + 0.5f), color);
    }

    public void drawFillRectangle(double x, double y, double width, double height) {
        GlStateManager.enableBlend();
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2d(x, y + height);
        GL11.glVertex2d(x + width, y + height);
        GL11.glVertex2d(x + width, y);
        GL11.glVertex2d(x, y);
        GL11.glEnd();
    }

    public void drawBordered(double x2, double y2, double width, double height, double length, int innerColor, int outerColor) {
        Gui.drawRect(x2, y2, x2 + width, y2 + height, innerColor);
        Gui.drawRect(x2 - length, y2, x2, y2 + height, outerColor);
        Gui.drawRect(x2 - length, y2 - length, x2 + width, y2, outerColor);
        Gui.drawRect(x2 + width, y2 - length, x2 + width + length, y2 + height + length, outerColor);
        Gui.drawRect(x2 - length, y2 + height, x2 + width, y2 + height + length, outerColor);
    }

    public void drawRect(float x, float y, float x1, float y1) {
        GL11.glBegin(7);
        GL11.glVertex2f(x, y1);
        GL11.glVertex2f(x1, y1);
        GL11.glVertex2f(x1, y);
        GL11.glVertex2f(x, y);
        GL11.glEnd();
    }


    public void drawGLRect(float x, float y, float x1, float y1, int color) {
        new GlUtil().enableGL2D();
        new GlUtil().glColor(color);
        drawRect(x, y, x1, y1);
        new GlUtil().disableGL2D();
    }

    public void drawGLRoundedRect(float x, float y, float x1, float y1, int borderC, int insideC) {
        drawGLRect(x + 0.5F, y, x1 - 0.5F, y + 0.5F, insideC);
        drawGLRect(x + 0.5F, y1 - 0.5F, x1 - 0.5F, y1, insideC);
        drawGLRect(x, y + 0.5F, x1, y1 - 0.5F, insideC);
    }

    public void drawGLRoundedRect(int xCoord, int yCoord, int xSize, int ySize, int colour) {
        int width = xCoord + xSize;
        int height = yCoord + ySize;
        drawGLRect((xCoord + 1), yCoord, (width - 1), height, colour);
        drawGLRect(xCoord, (yCoord + 1), width, (height - 1), colour);
    }


    public void drawFancy(double d, double e, double f2, double f3, int paramColor) {
        float alpha = (paramColor >> 24 & 0xFF) / 255.0F;
        float red = (paramColor >> 16 & 0xFF) / 255.0F;
        float green = (paramColor >> 8 & 0xFF) / 255.0F;
        float blue = (paramColor & 0xFF) / 255.0F;
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GL11.glPushMatrix();
        GL11.glEnable(2848);
        GL11.glEnable(2881);
        GL11.glEnable(2832);
        GL11.glEnable(3042);
        GL11.glColor4f(red, green, blue, alpha);
        GL11.glBegin(7);
        GL11.glVertex2d(f2 + 1.300000011920929D, e);
        GL11.glVertex2d(d + 1.0D, e);
        GL11.glVertex2d(d - 1.300000011920929D, f3);
        GL11.glVertex2d(f2 - 1.0D, f3);
        GL11.glEnd();
        GL11.glDisable(2848);
        GL11.glDisable(2881);
        GL11.glDisable(2832);
        GL11.glDisable(3042);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GL11.glPopMatrix();
    }
}