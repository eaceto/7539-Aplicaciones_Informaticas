package ar.uba.fi.aplicacionesinformaticas.eaceto.tp.motion747;

// Written by Sean R. Owens, sean at guild dot net, released to the

import ar.uba.fi.aplicacionesinformaticas.eaceto.tp.motion747.model.Aircraft;

// public domain. Share and enjoy. Since some people argue that it is
// impossible to release software to the public domain, you are also free
// to use this code under any version of the GPL, LPGL, Apache, or BSD
// licenses, or contact me for use of another license.

// Based on tutorial code from http://lwjgl.org/wiki/doku.php/lwjgl/tutorials/opengl/basicopengl
public class Motion747 {
    
    /**
     * Application init
     * @param args Commandline args
     */
    public static void main(String[] args) {

        Aircraft boeing747 = Aircraft.buildBoing747();
        Simulator simulator = new Simulator(boeing747);
        
        SimulatorView simulatorView = new SimulatorView(simulator);

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