package com.harkka;

import org.json.JSONObject;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Class WeatherFetcher.
 *
 * Make sure to import org.json:json:20160810 from Maven.
 *
 * @see "https://mvnrepository.com/artifact/org.json/json"
 * @see Weather
 */
public class WeatherFetcher {

    private String _api = "http://api.openweathermap.org/data/2.5/weather?q=";
    private String _city = "Tampere";
    private String _country = "fi";
    private String _mode = "json";
    private String _api_key = "183fd28e576d65fef33123f6bab81e24";
    private String _api_url = _api + _city + "," + _country + "&mode=" + _mode + "&units=metric&APPID=" + _api_key;

    /**
     * Constructor, nothing to see here.
     */
    public WeatherFetcher() {
    }

    /**
     * Connect to API and generate new Weather.
     *
     * @return Weather
     *   Return new Weather from parsed response.
     */
    public Weather fetch(){
        try {
            URL weatherRequest = new URL(_api_url);
            URLConnection connection = weatherRequest.openConnection();
            connection.setUseCaches(false);
            connection.setDoOutput(true);
            String response;
            try {
                Scanner scanner = new Scanner(weatherRequest.openStream());
                response = scanner.useDelimiter("\\Z").next();
                JSONObject obj = new JSONObject(response);
                JSONObject mainObj = obj.getJSONObject("main");
                JSONObject cloudsObj = obj.getJSONObject("clouds");
                JSONObject windObj = obj.getJSONObject("wind");
                String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                Double temperature = mainObj.getDouble("temp");
                Double pressure = mainObj.getDouble("pressure");
                int humidity = mainObj.getInt("humidity");
                int clouds = cloudsObj.getInt("all");
                Double wind = windObj.getDouble("speed");
                return new Weather(date, temperature, pressure, humidity, clouds, wind);
            }catch(IOException e){
                System.err.println("IOException:" + e);
            }
        } catch(MalformedURLException e){
            System.err.println("MalformedURLException:" + e);
        } catch (IOException e) {
            System.err.println("IOException:" + e);
        }
        // Generate Weather of fails to avoid distortion.
        return new Weather("Fail", 0.0, 0.0, 0, 0, 0.0);
    }
}
