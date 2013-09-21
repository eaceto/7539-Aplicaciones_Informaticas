/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.uba.fi.aplicacionesinformaticas.eaceto.tp.motion747.model;

/**
 *
 * @author kimi
 */
public class RollInstrument extends BasicInstrument {
    
    @Override
    public void drawInstrument(float x, float y, float x2, float y2) {
        super.drawBase(x, y, x2, y2);
        super.drawCircle ((x+x2)/2, (y+y2)/2, x2 - x - 2, y2 - y - 2);           
    }    
}
