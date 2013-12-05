/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ezequielaceto.mui.api;

import com.ezequielaceto.mui.LeapMotion.LeapMotionSensor;
import com.ezequielaceto.mui.motion.MotionObserver;
import com.ezequielaceto.mui.motion.ObservableMotionSensor;
import com.ezequielaceto.mui.motion.OnMotionDetectedListener;
import com.ezequielaceto.mui.motion.sensor.MotionSensor;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Ezequiel Aceto
 */
public class UIManager implements MotionObserver {
    HashMap<String, MotionSensor> motionSensors;

    HashMap<String, Object> listeners;
    
    public UIManager() {
        motionSensors = new HashMap<>();
    }

    
    public void addMotionSensor(MotionSensor ms) {
        if (!motionSensors.containsKey(ms.getIdentifier())) {
            motionSensors.put(ms.getIdentifier(), ms);
            
            ms.register(this);            
        }
    }

    public void removeMotionSensor(MotionSensor ms) {
        if (motionSensors.containsKey(ms.getIdentifier())) {
            ms.unregister(this);
        }
    }
    
    public void addOnMotionDetectedListener(OnMotionDetectedListener onMotionDetectedListener) {
        List<OnMotionDetectedListener> list = (List<OnMotionDetectedListener>) listeners.get(OnMotionDetectedListener.class.toString());
        if (!list.contains(onMotionDetectedListener)) list.add(onMotionDetectedListener);        
    }

    /// Motion Observer
    @Override
    public void update(MotionSensor ms) {        
        if (!motionSensors.containsKey(ms.getIdentifier())) return; 
        
        List<OnMotionDetectedListener> list = (List<OnMotionDetectedListener>) listeners.get(OnMotionDetectedListener.class.toString());
        for (OnMotionDetectedListener listener : list) {
            listener.onMotionInProgress(ms, ms.getMovement(this));
        }
    }
    /// End Motion Observer
    
}
