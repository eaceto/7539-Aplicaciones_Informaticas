/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.uba.fi.aplicacionesinformaticas.eaceto.tp.leapmove;

import ar.uba.fi.aplicacionesinformaticas.eaceto.tp.leapmove.model.AccelerableObject;
import ar.uba.fi.aplicacionesinformaticas.eaceto.tp.leapmove.model.ObjectController;
import ar.uba.fi.aplicacionesinformaticas.eaceto.tp.leapmove.model.ObjectControllerView;


/**
 *
 * @author kimi
 */
public class LeapMove {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        AccelerableObject ao = new AccelerableObject();
        ObjectController simulator = new ObjectController(ao);
        
        ObjectControllerView simulatorView = new ObjectControllerView(simulator);

        try {
            simulatorView.init();
            simulatorView.run();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            simulatorView.cleanup();
        }
        System.exit(0);
              
    }
}
