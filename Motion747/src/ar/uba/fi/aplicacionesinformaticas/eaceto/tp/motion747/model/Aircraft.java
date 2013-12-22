/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.uba.fi.aplicacionesinformaticas.eaceto.tp.motion747.model;

/**
 *
 * @author kimi
 */
public class Aircraft {
 
    private String waveFrontFile;
    private float pitch,roll,yaw;
    
    
    private Aircraft(String waveFrontFile) {
        this.waveFrontFile = waveFrontFile;
    }
    
    public static Aircraft buildBoing747() {
        String wfile = "/Users/kimi/FIUBA/Materias/7539/7539-Aplicaciones_Informaticas/3DModels/Boeing747/Boeing747.obj";
        
        Aircraft a = new Aircraft(wfile);
        
        a.setPitch(0.0f);
        a.setRoll(0.0f);
        a.setYaw(0.0f);
        
        return a;
    }

    public String getWaveFrontFile() {
        return waveFrontFile;
    }

    public float getPitch() {
        return pitch;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public float getRoll() {
        return roll;
    }

    public void setRoll(float roll) {
        this.roll = roll;
    }

    public float getYaw() {
        return yaw;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

}
