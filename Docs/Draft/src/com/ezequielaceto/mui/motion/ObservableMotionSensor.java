package com.ezequielaceto.mui.motion;

/**
 *
 * @author Ezequiel Aceto
 */
public interface ObservableMotionSensor {
    
    //methods to register and unregister observers
    public void register(MotionObserver mo);    
    public void unregister(MotionObserver mo);
        
    //method to notify observers of change
    public void notifyObservers();
     
    //method to get updates from subject
    public Object getUpdate(MotionObserver obj);         
}
