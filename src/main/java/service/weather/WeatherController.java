package service.weather;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.Scanner;

public class WeatherController {
    private static final Properties property;

    static {
        property = new Properties();
        try {
            property.load(new FileInputStream("src/main/resources/properties/weather.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Weather getWeather(String city) throws IOException{
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=metric&appid=" + property.getProperty("openweathermap.token"));
        StringBuilder urlContent = new StringBuilder();
        try (Scanner scanner = new Scanner((InputStream) url.getContent())) {
            while (scanner.hasNext()) {
                urlContent.append(scanner.next());
            }
        }

        Weather weather = new Weather();
        JSONObject topObject = new JSONObject(urlContent.toString());
        weather.setCity(topObject.getString("name"));

        JSONObject mainObject = topObject.getJSONObject("main");
        weather.setTemp(mainObject.getDouble("temp"));

        JSONArray weatherArray = topObject.getJSONArray("weather");
        JSONObject weatherObject = weatherArray.getJSONObject(0);
        weather.setIcon("http://openweathermap.org/img/wn/" + weatherObject.get("icon") + "@4x.png");
        return weather;
    }
}
