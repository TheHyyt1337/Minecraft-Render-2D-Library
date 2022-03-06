package Render_Lib;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import Render_Lib.impl.*;

public class RenderMain {
    /**
     * author: HYYT - HYYT#9228
     * author: TheSameGema - TheSameGema#9819
     */

    /*     INSTANCES    */
    public Minecraft mc = Minecraft.getMinecraft();
    public static RenderMain instance = new RenderMain();

    public CircleUtil circle;
    public GradientUtil gradient;
    public LineUtil line;
    public ImageUtil image;
    public GlUtil gl;
    public R3DUtil r3d;
    public ScissorUtil scissor;
    public ColorUtil color;
    public RectUtil rect;
    public OutlineUtil outline;
    public TriangleUtil triangle;

    public RenderMain() {
        /* Register Utilities. */
        this.circle =  CircleUtil.getUtil();
        this.gradient = GradientUtil.getUtil();
        this.line = LineUtil.getUtil();
        this.image = ImageUtil.getUtil();
        this.gl = GlUtil.getUtil();
        this.r3d = R3DUtil.getUtil();
        this.scissor = ScissorUtil.getUtil();
        this.color = ColorUtil.getUtil();
        this.rect = RectUtil.getUtil();
        this.outline = OutlineUtil.getUtil();
        this.triangle = TriangleUtil.getUtil();
    }
    //Get ScaledResolution Class.
    public ScaledResolution getScaledRes() {
        return new ScaledResolution(mc);
    }

    public float calculateCompensation(float target, float current, long delta, int speed) {
        float diff = current - target;
         if (delta < 1L)
            delta = 1L;
              if (diff > speed) {
                double xD = ((speed * delta / 16L) < 0.25D) ? 0.5D : (speed * delta / 16L);
                   current = (float)(current - xD);
                    if (current < target)
                      current = target;
                    } else if (diff < -speed) {
                 double xD = ((speed * delta / 16L) < 0.25D) ? 0.5D : (speed * delta / 16L);
                current = (float)(current + xD);
            if (current > target)
                current = target;
        } else {
            current = target;
        }
        return current;
    }

    public double getAnimationState(double animation, double finalState, double speed) {
        float add = (float)(0.01D * speed);
        if (animation < finalState) {
            if (animation + add < finalState) {
                animation += add;
            } else {
                animation = finalState;
            }
        } else if (animation - add > finalState) {
            animation -= add;
        } else {
            animation = finalState;
        }
        return animation;
    }
}