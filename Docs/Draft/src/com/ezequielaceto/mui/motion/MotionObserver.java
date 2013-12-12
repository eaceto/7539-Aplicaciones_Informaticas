package com.ezequielaceto.mui.motion;

import com.ezequielaceto.mui.sensor.motion.MotionSensor;

/**
 *
 * @author Ezequiel Aceto
 */
public interface MotionObserver {
 
    //method to update the observer, used by subject
    public void update(MotionSensor ms);
    
}
