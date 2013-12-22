/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.uba.fi.aplicacionesinformaticas.eaceto.tp.leapmove.model;

/**
 *
 * @author kimi
 */
public class AccelerableObject {

    float x,y,z;
    
    void setPosition(float _x, float _y, float _z) {
        x = _x;
        y = _y;
        z = _z;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    String getPosition() {
        return "("+ x + ";" + y + ";" + z + ")";
    }

    String getPositionInPolarCoordinates() {
        double r = getPositionR();
        double theta = getPositionAngle();
        
        return "("+r+","+theta+")";
    }
    
    double getPositionR() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
    
    double getPositionAngle() {
        double angle = Math.atan2(y, x) * 180.0f / 3.14159;
        
        if (angle < 0) {
            angle = 360 + angle;
        }
        
        return angle;
    }

    String getDirection() {
        double angle = getPositionAngle();
        
        if (angle <= 90 + 25 && angle >= 90 - 25) {
            return "FORWARD";
        }
        else if (angle >= 90 + 25 && angle <= 180 - 25) {
            return "LEFT AND FORWARD";
        }
        else if (angle <= 90 - 25 && angle >= 0 + 25) {
            return "RIGHT AND FORWARD";
        }        
        else if (angle <= 0 + 25 && angle <= 360 - 25) {
            return "RIGHT";
        }
        else if (angle >= 180 - 25 && angle <= 180 + 25) {
            return "LEFT";
        }
        else if (angle <= 270 + 25 && angle >= 270 - 25) {
            return "REVERSE";
        }  
        else if (angle <= 270 - 25 && angle >= 180 + 25) {
            return "LEFT AND REVERSE";
        }
        else if (angle <= 360 - 25 && angle >= 270 + 25) {
            return "RIGHT AND REVERSE";
        }          
        
        
        return "";
    }
}
