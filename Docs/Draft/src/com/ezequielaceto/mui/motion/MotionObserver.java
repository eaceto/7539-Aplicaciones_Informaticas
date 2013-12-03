package com.ezequielaceto.mui.motion;

/**
 *
 * @author Ezequiel Aceto
 */
public interface MotionObserver {
 
    //method to update the observer, used by subject
    public void update();
     
    //attach with subject to observe
    public void setSubject(ObservableMotionSensor oms);
    
}
