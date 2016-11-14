package com.tasks3;

import javax.swing.*;
import java.nio.channels.Pipe;

/**
 * Created by Dropa on 14.11.2016.
 */
public class Circle extends GraphicalObject {
    protected float _r;

    public Circle(int x, int y, float r) {
        this.setLocation(x,y);
        _r = r;
    }

    public Circle(int x, int y) {
        this.askR();
        this.setLocation(x,y);
    }

    public void setR(float r) {
        _r = r;
    }

    public void askR() {
        String R = JOptionPane.showInputDialog("Insert circle radius: ");
        this.setR(Float.valueOf(R));
    }

    public double getR() {
        System.out.print("Radius of circle is " + Float.toString(_r));
        return _r;
    }

    public double getArea() {
        this.getR();
        double a = ((double) _r * (double) _r) * Math.PI;
        System.out.print("Area of circle is " + Double.toString(a));
        return a;
    }

    public void print() {
        String r = Float.toString(_r);
        String x = Integer.toString(_x);
        String y = Integer.toString(_y);
        System.out.printf("I'm Circle. My radius is %s. My position is %s,%s.\n", r, x ,y);
    }
}
