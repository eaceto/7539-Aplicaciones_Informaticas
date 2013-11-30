/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.uba.fi.aplicacionesinformaticas.eaceto.tp.leapmove.model;


import ar.uba.fi.aplicacionesinformaticas.eaceto.tp.leapmove.LeapMove;
import com.owens.oobjloader.lwjgl.Scene;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

/**
 *
 * @author kimi
 */
public class ObjectControllerView {

    public final String WINDOW_TITLE = "AcelerableObject Simulator - Ezequiel Aceto";
    /**
     * Desired frame time
     */
    private final int FRAMERATE = 60;
    private boolean finished;
    private boolean fullscreen = true;
    private ObjectController simulator;

    public ObjectControllerView(ObjectController simulator) {
        this.simulator = simulator;
    }

    public void init() throws Exception {
        init(false);
    }

    /**
     * @throws Exception if init fails
     */
    private void init(boolean fullscreen) throws Exception {
        // Create a fullscreen window with 1:1 orthographic 2D projection (default)
        Display.setTitle(WINDOW_TITLE);
        Display.setFullscreen(false);
        Display.setDisplayMode(new DisplayMode(480, 320));

        // Enable vsync if we can (due to how OpenGL works, it cannot be guarenteed to always work)
        Display.setVSyncEnabled(true);

        // Create default display of 640x480
        Display.create();

        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        float fAspect = (float) Display.getDisplayMode().getWidth() / (float) Display.getDisplayMode().getHeight();
        GLU.gluPerspective(45.0f, fAspect, 0.5f, 400.0f);

        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        GL11.glViewport(0, 0, Display.getDisplayMode().getWidth() - 100, Display.getDisplayMode().getHeight() - 100);
    }

    public void run() {
        runImpl();
    }

    /**
     * Runs the program (the "main loop")
     */
    private void runImpl() {
        Scene scene = null;

        scene = new Scene();
        

        while (!finished) {
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glLoadIdentity();


            // Always call Window.update(), all the time - it does some behind the
            // scenes work, and also displays the rendered output
            Display.update();

            // Check for close requests
            if (Display.isCloseRequested()) {
                finished = true;
            } // The window is in the foreground, so render!
            else if (Display.isActive()) {
                logic();

                GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_STENCIL_BUFFER_BIT);


                scene.render();


                Display.sync(FRAMERATE);
            } // The window is not in the foreground, so we can allow other stuff to run and infrequently update
            else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                logic();

                // Only bother rendering if the window is visible or dirty
                if (Display.isVisible() || Display.isDirty()) {
                    //System.err.print(".");
                    scene.render();
                }
            }
        }
    }

    /**
     * Do any cleanup
     */
    public void cleanup() {
        // Close the window
        Display.destroy();
    }

    /**
     * Do all calculations, handle input, etc.
     */
    private void logic() {
        // Example input handler: we'll check for the ESC key and exit if it is pressed
        if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
            finished = true;
        }

    }
}
