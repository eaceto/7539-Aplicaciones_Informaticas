/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ezequielaceto.mui.motion.sensor;

import com.ezequielaceto.mui.Focuseable;
import com.ezequielaceto.mui.motion.MotionObserver;
import com.ezequielaceto.mui.motion.ObservableMotionSensor;
import com.ezequielaceto.mui.sensor.Sensor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ezequiel Aceto
 */
public abstract class MotionSensor extends Sensor implements ObservableMotionSensor {
    
    private List<MotionObserver> motionObservers;
    private final Object MUTEX= new Object();
    
    private boolean stateChanged;
    private MotionState motionState;
    
    private List<Focuseable> focusSensors;

    public MotionSensor() {
        this.motionObservers = new ArrayList<>();
        this.focusSensors = new ArrayList<>();
        this.stateChanged = false;        
    }
 
    
    /// Focus on Sensor
    public void attachFocusSensor(Focuseable f) {
        if (!this.focusSensors.contains(f)) this.focusSensors.add(f);
    }
    
    public void dettachFocusSensor(Focuseable f) {
        if (this.focusSensors.contains(f)) this.focusSensors.remove(f);
    }
    /// End Focus on Sensor
    
    /// Motion Observer Methods
    @Override
    public void register(MotionObserver obj) {
        if(obj == null) throw new NullPointerException("Null Observer");
        if(!motionObservers.contains(obj)) motionObservers.add(obj);
    }
 
    @Override
    public void unregister(MotionObserver obj) {
        motionObservers.remove(obj);
    }
 
    @Override
    public void notifyObservers() {
        List<MotionObserver> observersLocal;
        // synchronization is used to make sure any observer registered
        // after message is received is not notified
        synchronized (MUTEX) {
            if (!stateChanged)
                return;
            observersLocal = new ArrayList<>(this.motionObservers);
            this.stateChanged=false;
        }
        for (MotionObserver obj : observersLocal) {
            obj.update();
        }
    }
 
    @Override
    public MotionState getUpdate(MotionObserver obj) {
        return motionState;
    }
    /// End on Motion Observer Methods
    
}
