package br.usjt.usjt_ccp3an_bua_weather_forcast;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Weather {
    public final String dayOfWeek;
    public final String minTemp;
    public final String maxTemp;
    public final String humidity;
    public final String description;
    public final String iconURL;

    public Weather (long dt, double minTemp, double maxTemp, double humidity, String description, String iconName){
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(0);
        this.dayOfWeek = convert(dt);
        this.minTemp = numberFormat.format(minTemp) + "\u00B0C";
        this.maxTemp = numberFormat.format(maxTemp) + "\u00B0C";
        this.humidity = NumberFormat.getPercentInstance().format(humidity / 100.0);
        this.description = description;
        this.iconURL = "http://openweathermap.org/img/w/" + iconName + ".png";
    }

    public String convert (long dt){
        Calendar agora = Calendar.getInstance();
        agora.setTimeInMillis(dt * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE HH:mm");
        return sdf.format(agora.getTime());
    }
}


