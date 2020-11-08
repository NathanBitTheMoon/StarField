package com.starfield.exec;

import com.starfield.math.pseudo.DoublePoint;
import com.starfield.math.pseudo.Project;
import com.starfield.render.Renderer;
import com.starfield.field.FieldBase;
import com.starfield.field.FieldObject;
import com.starfield.window.Frame;

import com.starfield.render.FPSCounter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Run...");

        int sizeX = 1_280;
        int sizeY = 960;
        int fov = 270;

        FPSCounter fpsCounter = new FPSCounter(64);

        FieldBase fieldBase = new FieldBase(256, -5, -200, 200, -200, 200);
        fieldBase.fillWithRandomPositions();

        //BufferedImage bf = new BufferedImage(sizeX, sizeY, BufferedImage.TYPE_INT_ARGB);

        JFrame frame = new JFrame("StarField");
        Frame paintFrame = new Frame(sizeX, sizeY);

        frame.add(paintFrame);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        paintFrame.fillCanvas(Color.BLACK);

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getExtendedKeyCode());
                if (e.getExtendedKeyCode() == 38) {

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        while (true) {

            paintFrame.fillCanvas(Color.BLACK);

            for (FieldObject object : fieldBase.fieldObjects) {
                //if (!object.isOutOfBounds(0, 0, 500, 500)) {

                    DoublePoint drawPoint = Project.project(fov, object.x, object.y, object.z);
                    drawPoint.scale(sizeX / 2, sizeY / 2);
                    drawPoint.tranlate(sizeX / 2, sizeY / 2);
                    try {
                        paintFrame.drawRect(Color.WHITE, (int) drawPoint.x, (int) drawPoint.y, 1, 1);
                        //System.out.println("X: " + Double.toString(drawPoint.x) + " Y: " + Double.toString(drawPoint.y));
                    } catch (Exception e) {

                    }
                //}

                paintFrame.repaint();
            }

            Thread.sleep(0);

            fieldBase.stepAll();
            fpsCounter.countFrame();
            System.out.println("FPS: " + Math.round(fpsCounter.getLastFps()) + ", Average: " + Math.round(fpsCounter.averageFps()));
        }

    }

}
