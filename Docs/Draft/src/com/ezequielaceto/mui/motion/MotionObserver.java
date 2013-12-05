package com.ezequielaceto.mui.motion;

import com.ezequielaceto.mui.motion.sensor.MotionSensor;

/**
 *
 * @author Ezequiel Aceto
 */
public interface MotionObserver {
 
    //method to update the observer, used by subject
    public void update(MotionSensor ms);
    
}
