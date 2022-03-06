package Render_Lib.impl;

import net.minecraft.client.renderer.GlStateManager;
import Render_Lib.RenderMain;

import java.awt.*;

public class ColorUtil extends RenderMain {
    /**
     * author: HYYT - HYYT#9228
     * author: TheSameGema - TheSameGema#9819
     */

    /*     INSTANCES    */
    public static ColorUtil colorUtil;

    public static ColorUtil getUtil(){
        return colorUtil;
    }

    /**
     *Gets color r g b a.
     */
    public int getColor(Color color) {
        return getColor(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }
    /**
     *Gets color r g b a.
     */
    public int getColor(int brightness) {
        return getColor(brightness, brightness, brightness, 255);
    }

    public int getColor(int brightness, int alpha) {
        return getColor(brightness, brightness, brightness, alpha);
    }

    public int getColor(int red, int green, int blue) {
        return getColor(red, green, blue, 255);
    }

    public int getColor(int red, int green, int blue, int alpha) {
        int color = 0;
        color |= alpha << 24;
        color |= red << 16;
        color |= green << 8;
        color |= blue;
        return color;
    }

    public int reAlpha(int color, float alpha) {
        Color c = new Color(color);
        float r = 0.003921569F * (float) c.getRed();
        float g = 0.003921569F * (float) c.getGreen();
        float b = 0.003921569F * (float) c.getBlue();
        return (new Color(r, g, b, alpha)).getRGB();
    }

    public int withTransparency(int rgb, float alpha) {
        float r2 = (float)(rgb >> 16 & 255) / 255.0f;
        float g2 = (float)(rgb >> 8 & 255) / 255.0f;
        float b2 = (float)(rgb >> 0 & 255) / 255.0f;
        return new Color(r2, g2, b2, alpha).getRGB();
    }

    public int getHexRGB(int hex) {
        return -16777216 | hex;
    }

    public void color(int color) {
        float red = (color & 255) / 255f,
                green = (color >> 8 & 255) / 255f,
                blue = (color >> 16 & 255) / 255f,
                alpha = (color >> 24 & 255) / 255f;

        GlStateManager.color(red, green, blue, alpha);
    }

    public void colorRGBA(int color) {
        float a = (float) (color >> 24 & 255) / 255.0F;
        float r = (float) (color >> 16 & 255) / 255.0F;
        float g = (float) (color >> 8 & 255) / 255.0F;
        float b = (float) (color & 255) / 255.0F;

        GlStateManager.color(r, g, b, a);
    }

    public final Color getColorOfHue(int value) {
        float hue = 1.0F - value / 360.0F;
        int color = Color.HSBtoRGB(hue, 1.0F, 1.0F);
        return new Color(color);
    }

    public final Color getInvertedColor(Color color) {
        int red = 255 - color.getRed();
        int green = 255 - color.getGreen();
        int blue = 255 - color.getBlue();
        return new Color(red, green, blue, color.getAlpha());
    }

    public final int getInvertedColor(int color) {
        return getInvertedColor(new Color(color)).getRGB();
    }

    public int transparency(int color, double alpha) {
        Color c = new Color(color);
        float r = 0.003921569F * c.getRed();
        float g = 0.003921569F * c.getGreen();
        float b = 0.003921569F * c.getBlue();
        return (new Color(r, g, b, (float)alpha)).getRGB();
    }

    public int transparency(Color color, double alpha) {
        return (new Color(color.getRed(), color.getGreen(), color.getBlue(), (float)alpha)).getRGB();
    }

    public Color rainbow(long offset, float fade) {
        float hue = (float)(System.nanoTime() + offset) / 1.0E10F % 1.0F;
        long color = Long.parseLong(Integer.toHexString(Color.HSBtoRGB(hue, 1.0F, 1.0F)), 16);
        Color c = new Color((int)color);
        return new Color(c.getRed() / 255.0F * fade, c.getGreen() / 255.0F * fade, c.getBlue() / 255.0F * fade, c.getAlpha() / 255.0F);
    }



    public float[] getRGBA(int color) {
        float a = (color >> 24 & 0xFF) / 255.0F;
        float r = (color >> 16 & 0xFF) / 255.0F;
        float g = (color >> 8 & 0xFF) / 255.0F;
        float b = (color & 0xFF) / 255.0F;
        return new float[] { r, g, b, a };
    }

    public int intFromHex(String hex) {
        try {
            if (hex.equalsIgnoreCase("rainbow"))
                return rainbow(0L, 1.0F).getRGB();
            return Integer.parseInt(hex, 16);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String hexFromInt(int color) {
        return hexFromInt(new Color(color));
    }

    public String hexFromInt(Color color) {
        return Integer.toHexString(color.getRGB()).substring(2);
    }

    public Color blend(Color color1, Color color2, double ratio) {
        float r = (float)ratio;
        float ir = 1.0F - r;
        float[] rgb1 = new float[3];
        float[] rgb2 = new float[3];
        color1.getColorComponents(rgb1);
        color2.getColorComponents(rgb2);
        Color color3 = new Color(rgb1[0] * r + rgb2[0] * ir, rgb1[1] * r + rgb2[1] * ir, rgb1[2] * r + rgb2[2] * ir);
        return color3;
    }

    public Color blend(Color color1, Color color2) {
        return blend(color1, color2, 0.5D);
    }

    public Color darker(Color color, double fraction) {
        int red = (int)Math.round(color.getRed() * (1.0D - fraction));
        int green = (int)Math.round(color.getGreen() * (1.0D - fraction));
        int blue = (int)Math.round(color.getBlue() * (1.0D - fraction));
        if (red < 0) {
            red = 0;
        } else if (red > 255) {
            red = 255;
        }
        if (green < 0) {
            green = 0;
        } else if (green > 255) {
            green = 255;
        }
        if (blue < 0) {
            blue = 0;
        } else if (blue > 255) {
            blue = 255;
        }
        int alpha = color.getAlpha();
        return new Color(red, green, blue, alpha);
    }

    public Color lighter(Color color, double fraction) {
        int red = (int)Math.round(color.getRed() * (1.0D + fraction));
        int green = (int)Math.round(color.getGreen() * (1.0D + fraction));
        int blue = (int)Math.round(color.getBlue() * (1.0D + fraction));
        if (red < 0) {
            red = 0;
        } else if (red > 255) {
            red = 255;
        }
        if (green < 0) {
            green = 0;
        } else if (green > 255) {
            green = 255;
        }
        if (blue < 0) {
            blue = 0;
        } else if (blue > 255) {
            blue = 255;
        }
        int alpha = color.getAlpha();
        return new Color(red, green, blue, alpha);
    }

    public String getHexName(Color color) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        String rHex = Integer.toString(r, 16);
        String gHex = Integer.toString(g, 16);
        String bHex = Integer.toString(b, 16);
        return String.valueOf(String.valueOf(String.valueOf((rHex.length() == 2) ? rHex : ("0" + rHex)))) + ((gHex.length() == 2) ? gHex : ("0" + gHex)) + ((bHex.length() == 2) ? bHex : ("0" + bHex));
    }

    public double colorDistance(double r1, double g1, double b1, double r2, double g2, double b2) {
        double a = r2 - r1;
        double b3 = g2 - g1;
        double c = b2 - b1;
        return Math.sqrt(a * a + b3 * b3 + c * c);
    }

    public double colorDistance(double[] color1, double[] color2) {
        return colorDistance(color1[0], color1[1], color1[2], color2[0], color2[1], color2[2]);
    }

    public double colorDistance(Color color1, Color color2) {
        float[] rgb1 = new float[3];
        float[] rgb2 = new float[3];
        color1.getColorComponents(rgb1);
        color2.getColorComponents(rgb2);
        return colorDistance(rgb1[0], rgb1[1], rgb1[2], rgb2[0], rgb2[1], rgb2[2]);
    }

    public boolean isDark(double r, double g, double b) {
        double dWhite = colorDistance(r, g, b, 1.0D, 1.0D, 1.0D);
        double dBlack = colorDistance(r, g, b, 0.0D, 0.0D, 0.0D);
        if (dBlack < dWhite)
            return true;
        return false;
    }

    public boolean isDark(Color color) {
        float r = color.getRed() / 255.0F;
        float g = color.getGreen() / 255.0F;
        float b = color.getBlue() / 255.0F;
        return isDark(r, g, b);
    }


    public Color blendColors(float[] fractions, Color[] colors, float progress) {
        if (fractions.length == colors.length) {
            int[] indices = getFractionIndices(fractions, progress);
            float[] range = { fractions[indices[0]], fractions[indices[1]] };
            Color[] colorRange = { colors[indices[0]], colors[indices[1]] };
            float max = range[1] - range[0];
            float value = progress - range[0];
            float weight = value / max;
            Color color = blend(colorRange[0], colorRange[1], (1.0F - weight));
            return color;
        }
        throw new IllegalArgumentException("Fractions and colours must have equal number of elements");
    }

    public int[] getFractionIndices(float[] fractions, float progress) {
        int[] range = new int[2];
        int startPoint;
        for (startPoint = 0; startPoint < fractions.length && fractions[startPoint] <= progress; startPoint++);
        if (startPoint >= fractions.length)
            startPoint = fractions.length - 1;
        range[0] = startPoint - 1;
        range[1] = startPoint;
        return range;
    }

}
