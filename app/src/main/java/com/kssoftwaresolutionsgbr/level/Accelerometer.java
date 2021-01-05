/*
 ************************************************
 * project:      Level
 * package name: com.kssoftwaresolutionsgbr.level
 * class:        Accelerometer
 * dev:          Malte Schoenert
 * created on:   2021-01-05
 ************************************************
 */

package com.kssoftwaresolutionsgbr.level;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class Accelerometer {

    // interfaces
    public interface Listener{
        void onTranslation(float tx, float ty, float tz);
    }

    // fields
    private SensorManager sensorManager;
    private Sensor sensor;
    private SensorEventListener sensorEventListener;

    private Listener listener;

    // constructors
    Accelerometer(Context context){
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if(listener != null){
                    listener.onTranslation(sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
    }

    // methods
    public void register(){
        sensorManager.registerListener(sensorEventListener, sensor, sensorManager.SENSOR_DELAY_NORMAL);
    }

    public void unregister(){
        sensorManager.unregisterListener(sensorEventListener);
    }

    public void setListener(Listener l){
        listener = l;
    }
}