package com.starfield.field;

public class FieldObject {

    public double x;
    public double y;
    public double z;
    public double speed;

    public FieldObject() {

    }

    public FieldObject(double x, double y, double z, double speed) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.speed = speed;
    }

    public void step() {
        // Move in the direction of the speed
        this.z += speed;
    }

    public void translate(double transX, double transY) {
        this.x += transX;
        this.y += transY;
    }

    public void scale(double scaleX, double scaleY) {
        this.x *= scaleX;
        this.y *= scaleY;
    }

    public boolean isOutOfBounds(int xBoundStart, int yBoundStart, int xBoundEnd, int yBoundEnd) {
        return ((int) this.x < xBoundStart) || ((int) this.y < yBoundStart) || ((int) this.x > xBoundEnd) || ((int) this.y > yBoundStart);
    }

}
