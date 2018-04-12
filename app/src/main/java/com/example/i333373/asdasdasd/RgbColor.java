package com.example.i333373.asdasdasd;

/**
 * Created by i333373 on 2018. 04. 05..
 */

public class RgbColor {

    private int red;
    private int green;
    private int blue;

    public RgbColor() {
        red = 0;
        green = 0;
        blue = 0;
    }
    /**
     * the number must be between 0 and 255
     */
    public void setRgbColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }
}
