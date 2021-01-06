/*
 ************************************************
 * project:      Level
 * package name: com.kssoftwaresolutionsgbr.level
 * class:        CustomExceptions
 * dev:          Malte Schoenert
 * created on:   2021-01-06
 ************************************************
 */

package com.kssoftwaresolutionsgbr.level;

public class CustomExceptions {
    static class CalculationException extends Exception{
        CalculationException()
        {
            super("Sensor data is invalid. The alignment of the device can't be calculated.");
        }
    }

}
