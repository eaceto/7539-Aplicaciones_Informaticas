package com.ezequielaceto.mui.sensor;

/**
 *
 * @author Ezequiel Aceto
 */
public abstract class Sensor {
    public abstract String getName();
    public abstract String getIdentifier();
    public abstract SensorType getType();
    
    public enum SensorType {
        HandsDetection,
        BodyDectection
    }
}
