package com.starfield.tests;

import com.starfield.math.trig.Convert;
import com.starfield.math.pseudo.Project;
import com.starfield.math.pseudo.DoublePoint;

public class ProjectionTesting {

    public static void main(String[] args) {
        DoublePoint projectPoint = Project.project(90, 2, 6, 0.1);

        System.out.println(projectPoint.x);
        System.out.println(projectPoint.y);
    }

}
