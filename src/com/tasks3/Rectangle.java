package com.tasks3;

import javax.swing.*;

/**
 * Created by Dropa on 14.11.2016.
 */
public class Rectangle extends GraphicalObject {
    protected float _h;
    protected float _w;

    public Rectangle(int x, int y, float h, float w) {
        this.setLocation(x,y);
        _h = h;
        _w = w;
    }

    public Rectangle(int x, int y) {
        this.askDimensions();
        this.setLocation(x,y);
    }

    public void setH(float h) {
        _h = h;
    }

    public void setW(float w) {
        _w = w;
    }

    public void askDimensions() {
        String H = JOptionPane.showInputDialog("Insert height of rectangle: ");
        String W = JOptionPane.showInputDialog("Insert width of rectangle: ");
        this.setH(Float.valueOf(H));
        this.setW(Float.valueOf(W));
    }

    public float getH() {
        System.out.print("Height of rectangle is " + Float.toString(_h));
        return _h;
    }

    public float getW() {
        System.out.print("Width of rectangle is " + Float.toString(_w));
        return _w;
    }

    public float getArea() {
        this.getH();
        this.getW();
        float a = _h * _w;
        System.out.print("Area of rectangle is " + Float.toString(a));
        return a;
    }

    public void print() {
        String h = Float.toString(_h);
        String w = Float.toString(_w);
        String x = Integer.toString(_x);
        String y = Integer.toString(_y);
        System.out.printf("I'm Rectangle. My height is %s and my width is %s. My position is %s,%s.\n", h, w, x ,y);
    }

}
