package com.harkka;

/**
 * Class Weather.
 */
public class Weather {

    private String _date;
    private Double _temperature;
    private Double _pressure;
    private int _humidity;
    private int _clouds;
    private Double _wind;

    /**
     * Constructor.
     *
     * @param _date String
     * @param _temperature Double
     * @param _pressure Double
     * @param _humidity int
     * @param _clouds int
     * @param _wind Double
     */
    public Weather(String _date, Double _temperature, Double _pressure, int _humidity, int _clouds, Double _wind) {
        this._date = _date;
        this._temperature = _temperature;
        this._pressure = _pressure;
        this._humidity = _humidity;
        this._clouds = _clouds;
        this._wind = _wind;
    }

    /**
     * Prints Weather.
     *
     * Prints timestamp, temperature, pressure, humidity, clouds and wind as a String.
     *
     * @see String
     */
    public void print() {
        String temperatureString = (this._temperature >= 0 ? " " : "") + String.format("%.2f", this._temperature) + " °C";
        String pressureString = (this._pressure < 1000.0 ? " " : "") + String.format("%.2f", this._pressure) + " hPa";
        String humidityString = this._humidity + "%";
        String cloudsString = this._clouds + "%";
        String windString = String.format("%.2f", this._wind) + " m/s";
        System.out.printf("%-24s %-12s %-14s %-10s %-12s %-16s\n",
                this._date,
                temperatureString,
                pressureString,
                humidityString,
                cloudsString,
                windString
        );
    }
}