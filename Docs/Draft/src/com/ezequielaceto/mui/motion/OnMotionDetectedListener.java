/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ezequielaceto.mui.motion;

import com.ezequielaceto.mui.motion.sensor.MotionSensor;

/**
 *
 * @author kimi
 */
public interface OnMotionDetectedListener {
    
    public void onMotionInProgress(MotionSensor sensor, Object movement);
    
}
