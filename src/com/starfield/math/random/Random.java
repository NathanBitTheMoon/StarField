package com.starfield.math.random;

import java.lang.Math;

public class Random {

    public static int randomRange(int start, int end) {
        return (int) (Math.random() * (end - start + 1) + start);
    }

}
