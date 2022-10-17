package es.uva.eii.ds.empresa15;

import com.formdev.flatlaf.FlatLightLaf;

/**
 * @author mariher
 */
public class Launcher {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FlatLightLaf.install();
        //Se inicializa la máquina de estados
        GestorInterfazUsuario sm = GestorInterfazUsuario.getMachine();
        sm.mostrarIdentificarse();
    }
}
