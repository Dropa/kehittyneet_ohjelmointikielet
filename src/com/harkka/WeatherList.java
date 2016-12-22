package com.harkka;

import java.util.Vector;

/**
 * Class WeatherList.
 *
 * Stores Vector of Weather
 *
 * @see Vector
 * @see Weather
 */
public class WeatherList {

    private Vector<Weather> _weathers;

    /**
     * Constructor.
     *
     * Initializes Weather Vector.
     */
    public WeatherList() {
        this._weathers = new Vector<>();
    }

    /**
     * Add new Weather to list.
     *
     * @param weather Weather
     */
    public void add(Weather weather) {
        this._weathers.add(weather);
    }

    /**
     * Clear stored data from list.
     */
    public void clear() {
        if (!this._weathers.isEmpty()) {
            this._weathers.clear();
        }
    }

    /**
     * Print stored data from list.
     *
     * @see Weather#print().
     */
    public void print() {
        System.out.println("I have following weather records");
        System.out.printf("%-24s %-12s %-14s %-10s %-12s %-16s\n", "Datetime", "Temperature", "Pressure", "Humidity", "Cloudiness", "Wind Speed");
        this._weathers.forEach(Weather::print);
    }
}