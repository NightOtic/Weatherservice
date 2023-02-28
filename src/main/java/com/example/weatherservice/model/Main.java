package com.example.weatherservice.model;

public class Main {
    private double temp;
    private double min_temp;
    private double max_temp;
    private double pressure;
    private double sea_level;
    private double grnd_level;
    private double humidity;
    private double temp_kf;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getMin_temp() {
        return min_temp;
    }

    public void setMin_temp(double min_temp) {
        this.min_temp = min_temp;
    }

    public double getMax_temp() {
        return max_temp;
    }

    public void setMax_temp(double max_temp) {
        this.max_temp = max_temp;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getSea_level() {
        return sea_level;
    }

    public void setSea_level(double sea_level) {
        this.sea_level = sea_level;
    }

    public double getGrnd_level() {
        return grnd_level;
    }

    public void setGrnd_level(double grnd_level) {
        this.grnd_level = grnd_level;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getTemp_kf() {
        return temp_kf;
    }

    public void setTemp_kf(double temp_kf) {
        this.temp_kf = temp_kf;
    }
}
