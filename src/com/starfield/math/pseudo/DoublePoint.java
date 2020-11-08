package com.starfield.math.pseudo;

public class DoublePoint {

    public double x;
    public double y;

    public DoublePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void tranlate(double translateX, double translateY) {
        this.x += translateX;
        this.y += translateY;
    }

    public void scale(double scaleX, double scaleY) {
        this.x *= scaleX;
        this.y *= scaleY;
    }

}
