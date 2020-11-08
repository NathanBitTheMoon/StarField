package com.starfield.math.pseudo;

import java.awt.*;
import com.starfield.math.trig.Convert;

public class Project {

    public static DoublePoint project(double fov, double x, double y, double z) {
        // Project a 3D vector onto a 2D plane
        // Returns a 2D vector based on the FOV

        double trueFov = Math.round((1.0d / Math.tan(Convert.ConvertDegToRad(fov)/2.0d)) * 1000000d) / 1000000d;

        double planeX = x * (trueFov / z);
        double planeY = y * (trueFov / z);

        return new DoublePoint(planeX, planeY);
    }

}
