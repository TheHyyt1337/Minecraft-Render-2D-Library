package Render_Lib.impl;

import org.lwjgl.opengl.GL11;
import Render_Lib.RenderMain;

public class TriangleUtil extends RenderMain {
    /**
     * author: HYYT - HYYT#9228
     * author: TheSameGema - TheSameGema#9819
     */

    /*     INSTANCES    */
    public static TriangleUtil triangleUtil;

    public static TriangleUtil getUtil(){
        return triangleUtil;
    }

    public void drawFilledTriangle(float x, float y, float r, int c, int borderC) {
        new GlUtil().enableGL2D();
        new GlUtil().glColor(c);
        GL11.glEnable(2881);
        GL11.glBegin(4);
        GL11.glVertex2f(x + r / 2.0F, y + r / 2.0F);
        GL11.glVertex2f(x + r / 2.0F, y - r / 2.0F);
        GL11.glVertex2f(x - r / 2.0F, y);
        GL11.glEnd();
        GL11.glLineWidth(1.3F);
        new GlUtil().glColor(borderC);
        GL11.glBegin(3);
        GL11.glVertex2f(x + r / 2.0F, y + r / 2.0F);
        GL11.glVertex2f(x + r / 2.0F, y - r / 2.0F);
        GL11.glEnd();
        GL11.glBegin(3);
        GL11.glVertex2f(x - r / 2.0F, y);
        GL11.glVertex2f(x + r / 2.0F, y - r / 2.0F);
        GL11.glEnd();
        GL11.glBegin(3);
        GL11.glVertex2f(x + r / 2.0F, y + r / 2.0F);
        GL11.glVertex2f(x - r / 2.0F, y);
        GL11.glEnd();
        GL11.glDisable(2881);
        new GlUtil().disableGL2D();
    }
}