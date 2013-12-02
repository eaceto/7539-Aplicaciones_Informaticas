/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.uba.fi.aplicacionesinformaticas.eaceto.tp.motion747;

import ar.uba.fi.aplicacionesinformaticas.eaceto.tp.motion747.model.Aircraft;
import ar.uba.fi.aplicacionesinformaticas.eaceto.tp.motion747.model.PitchInstrument;
import ar.uba.fi.aplicacionesinformaticas.eaceto.tp.motion747.model.BasicInstrument;
import ar.uba.fi.aplicacionesinformaticas.eaceto.tp.motion747.model.RollInstrument;
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
public class Simulator extends Listener {

    private final float LEAP_RAD_TO_DEG = 57.295779513f; // Radians to Degrees constant
    private Aircraft aircraft;
    private Controller controller;
    private ArrayList<BasicInstrument> instruments;
    private PitchInstrument pitchInstrument;
    private RollInstrument rollInstrument;
    
    private Simulator() {
    }

    public Simulator(Aircraft aircraft) {
        this.aircraft = aircraft;
        instruments = new ArrayList<BasicInstrument>();

        pitchInstrument = new PitchInstrument();
        rollInstrument = new RollInstrument();
        
        //instruments.add(pitchInstrument);
        //instruments.add(rollInstrument);
        
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

    public ArrayList<BasicInstrument> getInstruments() {
        return instruments;
    }

    @Override
    public void onFrame(Controller cntrlr) {
        if (cntrlr.isConnected()) {
            Frame frame = cntrlr.frame(); //The latest frame

            if (frame.hands().count() == 1) {
                Hand hand = frame.hands().get(0);

                int fingersCount = hand.fingers().count();

                if (fingersCount <= 1) {
                    System.out.println("Hand closed");
                    //aircraft.setPitch(0.0f);
                    //aircraft.setRoll(0.0f);
                    //aircraft.setYaw(0.0f);
                } else {
                    Vector normal = hand.palmNormal();
                    Vector direction = hand.direction();

                    float pitch = direction.pitch() * LEAP_RAD_TO_DEG;
                    float roll = normal.roll() * LEAP_RAD_TO_DEG;
                    float yaw = direction.yaw() * LEAP_RAD_TO_DEG;

                    
                    aircraft.setPitch(pitch);
                    aircraft.setRoll(roll);
                    aircraft.setYaw(yaw);
                    
                    pitchInstrument.setValue(pitch);
                    
                    //aircraft.setYaw(yaw);
                    
                    
                    System.out.println("Frame: " + pitch + " - " + roll + " - " + yaw);

                }
            }
        }
    }

    public String getAircraftWaveFrontFile() {
        return aircraft.getWaveFrontFile();
    }

    public float getAircraftPitch() {
        return aircraft.getPitch();
    }

    public float getAircraftRoll() {
        return aircraft.getRoll();
    }

    public float getAircraftYaw() {
        return aircraft.getYaw();
    }
}
