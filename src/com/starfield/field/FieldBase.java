package com.starfield.field;

import java.lang.Math;
import com.starfield.math.random.*;

public class FieldBase {

    public int objectCount;
    public FieldObject[] fieldObjects;

    public double speed;

    public int xRangeStart;
    public int yRangeStart;
    public int xRangeEnd;
    public int yRangeEnd;

    public FieldBase(int objectCount, double speed, int xS, int xE, int yS, int yE) {
        this.objectCount = objectCount;
        this.fieldObjects = new FieldObject[objectCount];

        this.xRangeStart = xS;
        this.xRangeEnd = xE;
        this.yRangeStart = yS;
        this.yRangeEnd = yE;

        this.speed = speed;
    }

    public void fillWithRandomPositions() {
        for (int object = 0; object < objectCount; object += 1) {
            this.fieldObjects[object] = new FieldObject(
                    Random.randomRange(xRangeStart, xRangeEnd),
                    Random.randomRange(yRangeStart, yRangeEnd),
                    Random.randomRange(100, 500),
                    this.speed
            );
        }
    }

    public void stepAll() {
        for (FieldObject object : fieldObjects) {
            object.step();
            if (object.z < 0.00) {
                object.x = Random.randomRange(xRangeStart, xRangeEnd);
                object.y = Random.randomRange(yRangeStart, yRangeEnd);
                object.z = Random.randomRange(100, 500);
            }
        }
    }

}
