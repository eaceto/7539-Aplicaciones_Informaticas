/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.uba.fi.aplicacionesinformaticas.eaceto.tp.motion747.model;

import org.lwjgl.opengl.GL11;

/**
 *
 * @author kimi
 */
public class PitchInstrument extends BasicInstrument {

    @Override
    public void drawInstrument(float x, float y, float x2, float y2) {
        super.drawBase(x, y, x2, y2);
        super.drawCircle ((x+x2)/2, (y+y2)/2, x2 - x - 2, y2 - y - 2);        
        
        float h = y2 - y; // de 0 a 180 grados
        float normalizedPitch = (y-(y2+y)/2)/90* super.getValue() + (y2 + y)/2;
        
        GL11.glBegin(GL11.GL_LINES);
        GL11.glColor3f(0.0f, 0.0f, 0.0f);
        GL11.glLineWidth(1.0f);
        GL11.glVertex2f(x, normalizedPitch);
        GL11.glVertex2f(x2, normalizedPitch);    
        GL11.glEnd();
    }
    
}
