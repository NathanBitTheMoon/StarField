package com.starfield.render;

import com.starfield.field.FieldBase;
import com.starfield.math.pseudo.Project;
import com.starfield.math.pseudo.DoublePoint;

import java.awt.*;

public class Renderer {

    private FieldBase base;
    private int fov;

    public Renderer(FieldBase base, int fov) {
        this.base = base;
        this.fov = fov;
    }

    public void stepAll() {
        this.base.stepAll();
    }

    public Graphics renderFrame(Graphics drawBase) {
        drawBase.setColor(Color.WHITE);
        for (int drawObject = 0; drawObject < base.objectCount; drawObject += 1) {
            DoublePoint projectPoint = Project.project(fov, base.fieldObjects[drawObject].x, base.fieldObjects[drawObject].y, base.fieldObjects[drawObject].z);
            drawBase.drawRect(
                    (int) projectPoint.x,
                    (int) projectPoint.y,
                    1, 1
            );
        }

        return drawBase;
    }

}
