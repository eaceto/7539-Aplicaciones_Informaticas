/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.uba.fi.aplicacionesinformaticas.eaceto.tp.leapmove.model;

import com.leapmotion.leap.Config;
import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.Listener;
import com.leapmotion.leap.Vector;
import java.util.ArrayList;

/**
 *
 * @author kimi
 */
public class ObjectController extends Listener {

    private final float LEAP_RAD_TO_DEG = 57.295779513f; // Radians to Degrees constant
    private AccelerableObject object;
    private Controller controller;

    static int MAX_SAMPLES = 10;
    
    boolean calibrate;
    int numberOfSamples = MAX_SAMPLES;
    float averageX;
    float averageY;
    float averageZ;
    
    
    public ObjectController(AccelerableObject object) {
        this.object = object;
        calibrate = true;
        
        controller = new Controller(this);
    }

    @Override
    public void onInit(Controller cntrlr) {
        super.onInit(cntrlr); //To change body of generated methods, choose Tools | Templates.
        System.out.println("LeapMotion Controller initalized: " + cntrlr);
    }

    @Override
    public void onConnect(Controller cntrlr) {
        super.onConnect(cntrlr); //To change body of generated methods, choose Tools | Templates.
        System.out.println("LeapMotion Controller connected: " + cntrlr);
    }


    @Override
    public void onFrame(Controller cntrlr) {
        if (cntrlr.isConnected()) {
            Frame frame = cntrlr.frame(); //The latest frame

            if (frame.hands().count() == 1) {
                Hand hand = frame.hands().get(0);

                int fingersCount = hand.fingers().count();

                if (fingersCount <= 1) {
                    //System.out.println("Hand closed");
                    
                } else {
                    Vector normal = hand.palmNormal();
                    Vector direction = hand.direction();

                    float pitch = direction.pitch() * LEAP_RAD_TO_DEG;
                    float roll = normal.roll() * LEAP_RAD_TO_DEG;
                    float yaw = direction.yaw() * LEAP_RAD_TO_DEG;

                    //System.out.println("Frame: " + pitch + " - " + roll + " - " + yaw);

                    Vector position = hand.palmPosition();

                    
                    // XZ es el plano de movimiento horizontal
                    // Y es la altura
                    
                    // Transformamos a la regla de la mano derecha con XY en el plano
                    
                    
                    float _x = -1* position.getX();
                    float _y = position.getZ();
                    float _z = position.getY();
                    
                    if (calibrate) {
                        
                        averageX += _x;
                        averageY += _y;
                        averageZ += _z;
                        
                        numberOfSamples--;
                        
                        if (numberOfSamples == 0) {
                            averageX /= 10;
                            averageY /= 10;
                            averageZ /= 10;
                            
                            System.out.println("CENTER");
                            System.out.println(averageX + " " + averageY +  " " + averageZ);
                            
                            calibrate = false;
                        }
                        
                        return;
                    }
                    
                    // L Position: (-157.27783;173.43806;35.746426)
                    // R Position: (151.16275;159.8636;49.463455)
                    // F Position: (4.5742116;177.17041;-90.749954)
                    // B Position: (-15.032832;149.04678;185.4192)
                    
                    //System.out.println("Delta: ("+deltaX+";"+deltaY +";" +deltaZ + ")");
                    
                    object.setPosition(_x - averageX,_y - averageY,_z - averageZ);
                    //object.setPosition(_x,_y,_z);
                    
                    System.out.println(object.getPosition());
                }
            }
        }
    }

}
