/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packato;

import com.nilo.plaf.nimrod.NimRODLookAndFeel;
import com.nilo.plaf.nimrod.NimRODTheme;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
/**
 *
 * @author oky
 */
public class Apariencia {
    public String pathLF= "obscura.theme"; //ruta Look and Feel

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new NimRODLookAndFeel());
            NimRODLookAndFeel nf = new NimRODLookAndFeel();
            Apariencia apa = new Apariencia();
            String folder = System.getProperty("user.dir");
            String separator = System.getProperty("file.separator");
            NimRODTheme nt = new NimRODTheme(folder+ separator + apa.pathLF);
            nf.setCurrentTheme(nt);
            UIManager.setLookAndFeel(nf);
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Error de " + ex);
        }

        MainFrame user = new MainFrame();
        user.setVisible(true);


    }
}
