package com.starfield.render;


public class FPSCounter {

    public long[] fpsTimes;
    private int historyCount;
    private int lastIndex;

    public FPSCounter(int historyCount) {
        this.historyCount = historyCount;
        this.fpsTimes = new long[historyCount];
    }

    private void shiftFpsArray() {
        for (int i = 1; i < this.historyCount; i++) {
            this.fpsTimes[i] = this.fpsTimes[i - 1];
        }
        this.fpsTimes[0] = 0;
        this.lastIndex = 0;
    }

    private void addFpsTime(long fpsTime) {
        shiftFpsArray();
        this.fpsTimes[0] = fpsTime;
    }

    private double fps(int index) {
        long timeDiff = this.fpsTimes[index] - this.fpsTimes[index + 1];
        if (timeDiff != 0) {
            return 1000/timeDiff;
        } else {
            return 0;
        }
    }

    public double getLastFps() {
        return fps(0);
    }

    public double averageFps() {
        double totalFps = 0;
        for (int i = 0; i < historyCount - 1; i++) {
            totalFps += fps(i);
        }

        return totalFps / historyCount;
    }

    public void countFrame() {
        addFpsTime(System.currentTimeMillis());
    }
}
