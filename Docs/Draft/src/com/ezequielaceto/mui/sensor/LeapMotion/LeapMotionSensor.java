/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ezequielaceto.mui.sensor.LeapMotion;

import com.ezequielaceto.mui.focus.Focuseable;
import com.ezequielaceto.mui.sensor.motion.MotionSensor;

/**
 *
 * @author Ezequiel Aceto
 */
public class LeapMotionSensor extends MotionSensor implements Focuseable {

    private boolean handIsOpen;

    public LeapMotionSensor() {
        attachFocusSensor(this);
    }
    
    @Override
    public String getName() {
        return "LeapMotion";
    }

    @Override
    public String getIdentifier() {
        return "0";
    }

    @Override
    public SensorType getType() {
        return SensorType.HandsDetection;
    }

    @Override
    public boolean hasFocus() {
        if (handIsOpen) {
            return true;
        }
        return false;
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
