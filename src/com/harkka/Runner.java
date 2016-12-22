package com.harkka;

/**
 * Class Runner.
 *
 * @see Thread
 * @see Weather
 * @see WeatherList
 * @see WeatherFetcher
 */
public class Runner extends Thread {

    private int _interval = 1000 * 60;
    private boolean _run = true;
    private boolean _start = true;
    private WeatherList _weatherList = new WeatherList();
    private WeatherFetcher _weatherFetcher = new WeatherFetcher();

    /**
     * {@inheritDoc}
     */
    public void run(){
        while (_start) {
            if (_run) {
                try {
                    this.fetchNow();
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

    /**
     * Fetch new Weather and store it to WeatherList.
     */
    public void fetchNow() {
        System.out.println("New record added.");
        Weather newWeather = this._weatherFetcher.fetch();
        this._weatherList.add(newWeather);
    }

    /**
     * Pause automated runner.
     */
    public void pause() {
        System.out.println("Paused runner.");
        this._run = false;
    }

    /**
     * Resume automated runner.
     */
    public void unpause() {
        System.out.println("Resumed runner.");
        this._run = true;
    }

    /**
     * Prepare for exit, shutdown thread.
     */
    public void exit() {
        System.out.println("Exiting program.");
        this._start = false;
    }

    /**
     * Clear all data form list.
     *
     * @see WeatherList#clear().
     */
    public void clear() { this._weatherList.clear(); }

    /**
     * Print all data from list.
     *
     * @see WeatherList#print().
     */
    public void print() { this._weatherList.print(); }

}
