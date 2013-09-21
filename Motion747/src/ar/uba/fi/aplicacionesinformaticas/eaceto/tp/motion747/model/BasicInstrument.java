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
public abstract class BasicInstrument {
    private float value;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
    
    public abstract void drawInstrument(float x, float y, float x2, float y2);
    
public void drawBase (float x, float y, float x2, float y2) {
        GL11.glBegin(GL11.GL_QUADS);        

        GL11.glColor3f(0.0f, 0.0f, 0.0f);

        GL11.glVertex3f(x, y, 0);
        GL11.glVertex3f(x, y2, 0);
        GL11.glVertex3f(x2, y2, 0);
        GL11.glVertex3f(x2, y, 0);
        GL11.glEnd();            
    }
    
    public void drawCircle (float x, float y, float w, float h) {
       GL11.glPushMatrix();
       GL11.glColor3f(1.0f, 1.0f, 1.0f);
       GL11.glTranslatef(x, y, 0);
       GL11.glScalef(w/2, h/2, 1);
       GL11.glBegin(GL11.GL_TRIANGLE_FAN);
       GL11.glVertex2f(0, 0);
       for(int i = 0; i <= 500; i++){
            double angle = Math.PI * 2 * i / 500;
            GL11.glVertex2f((float)Math.cos(angle), (float)Math.sin(angle));
       }
        GL11.glEnd();
        GL11.glPopMatrix();        
    }
    
    public void drawOval(float x, float y, float width, float height, float red, float green, float blue) {
        float theta;
        float angle_increment;
        float x1;
        float y1;

        angle_increment = (float) Math.PI / 500;

        GL11.glPushMatrix();

        GL11.glTranslatef(x + (width / 2), y + (height / 2), 0);

        GL11.glColor3f(red, green, blue);

        GL11.glBegin(GL11.GL_LINE_LOOP);
        for (theta = 0.0f; theta < 2 * Math.PI; theta += angle_increment) {
            x1 = (float) (width / 2 * Math.cos(theta));
            y1 = (float) (height / 2 * Math.sin(theta));

            GL11.glVertex2f(x1, y1);
        }
        GL11.glEnd();

        GL11.glPopMatrix();
    }    
}
