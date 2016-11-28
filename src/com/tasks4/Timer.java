package com.tasks4;

public class Timer extends Thread {
    private int _interval = 1000;
    private boolean _run = true;
    private int _seconds = 0;
    private int _minutes = 0;
    private boolean _start = true;
    private TimerListener timerListener;

    public void run(){
        while (_start) {
            if (_run) {
                this.printTime();
                this.addSecond();
                if (this._seconds % 10 == 0) {
                    timerListener.tenSecondTrigger();
                }
                try {
                    Thread.sleep(this._interval);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
            else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void setTimerListener (TimerListener timerListener) {
        this.timerListener = timerListener;
    }

    public void setInterval(int interval) {
        this._interval = interval;
    }

    protected void addSecond() {
        this._seconds++;
        if (this._seconds == 60) {
            this._minutes++;
            this._seconds = 0;
        }
    }

    public void printTime() {
        if (this._minutes < 10) {
            System.out.print("0");
        }
        System.out.print(this._minutes + ":");
        if (this._seconds < 10) {
            System.out.print("0");
        }
        System.out.print(this._seconds + "\n");
    }

    public void pause() {
        this._run = false;
    }

    public void unpause() {
        this._run = true;
    }

    public void exit() {
        this._start = false;
    }

}

interface TimerListener {
    void tenSecondTrigger();
}
