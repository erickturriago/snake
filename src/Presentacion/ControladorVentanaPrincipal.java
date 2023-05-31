
package Presentacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class ControladorVentanaPrincipal implements ActionListener {

    private VentanaPrincipal ventana;
    private Modelo modelo;
    
    public ControladorVentanaPrincipal(VentanaPrincipal bThis) {
        ventana = bThis;
        modelo = ventana.getModelo();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton;
        if(e.getSource() instanceof JButton){
            boton = (JButton) e.getSource();
            if(boton.getText().equals("SALIR")){
                modelo.salir();
            }
            if(boton.getText().equals("JUGAR")){
                modelo.IniciarVentanaJuego();
            }
        
        }
        return;       
    }
    
   
}
