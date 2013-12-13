/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ezequielaceto.test.mui;

import com.ezequielaceto.mui.sensor.Kinect.KinectMotionSensor;
import com.ezequielaceto.mui.sensor.LeapMotion.LeapMotionSensor;
import com.ezequielaceto.mui.sensor.TheEyeTribe.TheEyeTribeFocusSensor;
import com.ezequielaceto.mui.api.UIManager;
import com.ezequielaceto.mui.motion.OnMotionDetectedListener;
import com.ezequielaceto.mui.sensor.motion.MotionSensor;
import com.ezequielaceto.mui.sensor.Sensor.SensorConnectionException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kimi
 */
public class LeapMotionTest {
    
    public LeapMotionTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testLeapMotionSensor() {
        
        try {
            
            // UIManager handles all the interaction between sensors
            // and user application
            UIManager ui = new UIManager();

            // creates a Leap Motion controller
            // by default Leap Mption is its own Focus sensor
            // close hand means focus OFF - open hand means focus ON            
            LeapMotionSensor leapMotion = new LeapMotionSensor();            
            leapMotion.connect();                        
            ui.addMotionSensor(leapMotion);
            
            // Creates a Kinect controller
            // Kinect focus is controlled by The Eye Tribe
            KinectMotionSensor kinect = new KinectMotionSensor();
            TheEyeTribeFocusSensor eyeTribe = new TheEyeTribeFocusSensor();
            kinect.attachFocusSensor(eyeTribe);

            // add a motion detection listener
            ui.addOnMotionDetectedListener(new OnMotionDetectedListener() {
                @Override
                public void onMotionInProgress(MotionSensor sensor, Object movement) {
                    System.out.println("Motion In Progress in Callback 1: " +  sensor.getName());
                }
            });            
            
            // add another motion detection listener
            ui.addOnMotionDetectedListener(new OnMotionDetectedListener() {
                @Override
                public void onMotionInProgress(MotionSensor sensor, Object movement) {
                    System.out.println("Motion In Progress in Callback 2: " +  sensor.getName());
                }
            });                        
            
            assertTrue(true);            
        } catch (SensorConnectionException sce) {
            assertTrue(false);
        }
               
    }
}
