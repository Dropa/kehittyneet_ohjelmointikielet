package com.tasks3;

/**
 * Created by Dropa on 14.11.2016.
 */
abstract class GraphicalObject implements Plot{
    protected int _x;
    protected int _y;

    public void setLocation(int x, int y) {
        _x = x;
        _y = y;
    }

    public int getX() {
        System.out.print("Object X coordinate is " + Integer.toString(_x));
        return _x;
    }

    public int getY() {
        System.out.print("Object Y coordinate is " + Integer.toString(_y));
        return _y;
    }

}
