
package Presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;

public class ControladorVentanaJuego implements KeyListener, ActionListener{
    
    private VentanaJuego ventana;
    private Modelo modelo;  
    
    public ControladorVentanaJuego(VentanaJuego cThis) {
        ventana = cThis;
        modelo = ventana.getModelo();
        System.out.println("creado");

    }
    
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        modelo.iniciarJuego();
        modelo.getMiSistema().setActivo(true);
        
        if (e.getKeyCode() == 87) {
            if ( modelo.getSistema().getSentido().equals("f") ||  modelo.getSistema().getSentido().equals("x")) {
                modelo.getSistema().setSentido("y");
                modelo.getSistema().setSigno(-1);
//            modelo.moverSerpiente();
                System.out.println("W");
            }

        }
        if (e.getKeyCode() == 65) {
            if ( modelo.getSistema().getSentido().equals("f") ||  modelo.getSistema().getSentido().equals("y")) {
                modelo.getSistema().setSentido("x");
                modelo.getSistema().setSigno(-1);
//            modelo.moverSerpiente();
                System.out.println("A");
            }
        }
        if (e.getKeyCode() == 83) {
            if ( modelo.getSistema().getSentido().equals("f") ||  modelo.getSistema().getSentido().equals("x")) {
                modelo.getSistema().setSentido("y");
                modelo.getSistema().setSigno(1);
//            modelo.moverSerpiente();
                System.out.println("S");
            }
        }
        if (e.getKeyCode() == 68) {
            if ( modelo.getSistema().getSentido().equals("f") ||  modelo.getSistema().getSentido().equals("y")) {
                modelo.getSistema().setSentido("x");
                modelo.getSistema().setSigno(1);
//            modelo.moverSerpiente();
                System.out.println("D");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton;
        if(e.getSource() instanceof JButton){
            boton = (JButton) e.getSource();
            if(boton.getText().equals("Reintentar")){
                
                modelo.resetJuego();
                
            }
            if(boton.getText().equals("Salir")){
                modelo.salir();
            }

        
        }
        return;
    }

    
}
