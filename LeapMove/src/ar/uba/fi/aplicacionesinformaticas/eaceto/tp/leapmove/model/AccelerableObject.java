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
    
    
}
