/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ezequielaceto.mui.Kinect;

import com.ezequielaceto.mui.motion.sensor.MotionSensor;

/**
 *
 * @author Ezequiel Aceto
 */
public class KinectMotionSensor extends MotionSensor {

    @Override
    public String getName() {
        return "Kinect";
    }

    @Override
    public String getIdentifier() {
        return "1";
    }

    @Override
    public SensorType getType() {
        return SensorType.BodyDectection;
    }

    @Override
    public boolean connect() throws SensorConnectionException {
        if ((connected = connectionImpl())) {           
            startPullingSensor();
        }
       
        return true;
    }

    @Override
    public boolean disconnect() {
        connected = false;
        return true;
    }

    @Override
    public boolean isConnected() {
        return connected;
    }

    @Override
    protected Object getDataFromSensor() {
        return null;
    }

    @Override
    protected boolean isNewData(Object newData) {
        return true;
    }

    private boolean connectionImpl() {
        return true;
    }

}
