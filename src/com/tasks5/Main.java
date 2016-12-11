package com.tasks5;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    private static String _api = "http://api.openweathermap.org/data/2.5/forecast?q=";
    private static String _city = "Tampere";
    private static String _country = "fi";
    private static String _mode = "json";
    private static String _api_key = "183fd28e576d65fef33123f6bab81e24";
    private static String _api_url = _api + _city + "," + _country + "&mode=" + _mode + "&units=metric&APPID=" + _api_key;

    public static void main(String[] args) throws Exception {
        fiveDaysWeather();
        System.exit(0);
    }

    private static void fiveDaysWeather(){
        WeatherList weatherList = new WeatherList();
        try {
            URL weatherRequest = new URL(_api_url);
            URLConnection connection = weatherRequest.openConnection();
            connection.setUseCaches(false);
            connection.setDoOutput(true);
            String response;
            try {
                Scanner scanner = new Scanner(weatherRequest.openStream());
                response = scanner.useDelimiter("\\Z").next();
                weatherList.clear();
                System.out.println("5 day weather for " + _city);
                System.out.printf("%-24s %-12s %-14s %-10s %-12s %-16s\n", "Datetime", "Temperature", "Pressure", "Humidity", "Cloudiness", "Wind Speed");
                JSONObject object = new JSONObject(response);
                JSONArray list = object.getJSONArray("list");
                for(int i = 0; i < list.length(); i++){
                    JSONObject obj = list.getJSONObject(i);
                    JSONObject mainObj = obj.getJSONObject("main");
                    JSONObject cloudsObj = obj.getJSONObject("clouds");
                    JSONObject windObj = obj.getJSONObject("wind");
                    String date = obj.getString("dt_txt");
                    Double temperature = mainObj.getDouble("temp");
                    Double pressure = mainObj.getDouble("pressure");
                    int humidity = mainObj.getInt("humidity");
                    int clouds = cloudsObj.getInt("all");
                    Double wind = windObj.getDouble("speed");
                    weatherList.add(new Weather(date, temperature, pressure, humidity, clouds, wind));
                    String temperatureString = (temperature >= 0 ? " " : "") + String.format("%.2f", temperature) + " °C";
                    String pressureString = (pressure < 1000.0 ? " " : "") + String.format("%.2f", pressure) + " hPa";
                    String humidityString = humidity + "%";
                    String cloudsString = clouds + "%";
                    String windString = String.format("%.2f", wind) + " m/s";
                    System.out.printf("%-24s %-12s %-14s %-10s %-12s %-16s\n",
                            date,
                            temperatureString,
                            pressureString,
                            humidityString,
                            cloudsString,
                            windString
                    );
                }
            }catch(IOException e){
                System.err.println("IOException:" + e);
            }
        } catch(MalformedURLException e){
            System.err.println("MalformedURLException:" + e);
        } catch (IOException e) {
            System.err.println("IOException:" + e);
        }
    }

    public static class Weather {
        String _date;
        Double _temperature;
        Double _pressure;
        int _humidity;
        int _clouds;
        Double _wind;

        private Weather(String _date, Double _temperature, Double _pressure, int _humidity, int _clouds, Double _wind) {
            this._date = _date;
            this._temperature = _temperature;
            this._pressure = _pressure;
            this._humidity = _humidity;
            this._clouds = _clouds;
            this._wind = _wind;
        }
    }

    public static class WeatherList {
        Vector<Weather> _weathers;

        private WeatherList() {
            this._weathers = new Vector<>();
        }

        private void add(Weather weather) {
            this._weathers.add(weather);
        }

        private void clear() {
            if (!this._weathers.isEmpty()) {
                this._weathers.clear();
            }
        }
    }
}
