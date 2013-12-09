package com.ezequielaceto.mui.sensor;

import java.util.Timer;
import java.util.TimerTask;

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

    
    public abstract boolean connect() throws SensorConnectionException;
    protected boolean connected;    
    public boolean disconnect() {
        pullingThread.cancel();
        pullingTimer.cancel();
        return true;
    }
    
    public boolean isConnected() {
        return connected;
    }
    
    // Sensor delay
    private static final long SENSOR_DELAY_NORMAL = 100;
    private static final long SENSOR_DELAY_SLOW = 200;
    private static final long SENSOR_DELAY_FAST = 50;
    private static final long SENSOR_DELAY_VERYFAST = 10;
    private long sensorDelay = SENSOR_DELAY_NORMAL;

    public void setSensorDelay(long sensorDelay) {
        this.sensorDelay = sensorDelay;
    }

    public long getSensorDelay() {
        return sensorDelay;
    }
    
    protected abstract Object getDataFromSensor();
    protected abstract boolean isNewData(Object newData);
    protected abstract void onNewDataAvailable(Object newData);
    
    private TimerTask pullingThread;
    private Timer pullingTimer;
   
    protected void startPullingSensor() {
        pullingThread = new TimerTask() {

            @Override
            public void run() {
                Object newData = getDataFromSensor();
                
                if (isNewData(newData)) {
                    onNewDataAvailable(newData);
                }
            }
        };
        
        pullingTimer = new Timer();
        pullingTimer.schedule(pullingThread, sensorDelay);
    } 
    
    
    public class SensorConnectionException extends Exception {

        private final Sensor s;
        public SensorConnectionException(Sensor s) {
            this.s = s;
        }

        @Override
        public String getMessage() {
            return "Sensor " + s.getName() + " ["+ s.getIdentifier()+"] could not stablished a connection";
        }

    }
}
