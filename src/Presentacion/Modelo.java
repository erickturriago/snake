package Presentacion;

import Logica.Sistema;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Modelo implements Runnable {

    private VentanaPrincipal ventanaPrincipal;
    private VentanaJuego ventanaJuego;
    private Sistema miSistema;
    private Thread hiloDibujo;
    private Thread hiloMovimientoSerpiente;
    private BufferedImage dobleBuffer;

    //Se inicia la ventana principal
    public void iniciar() {
        getVentanaPrincipal().setSize(853, 626);
        getVentanaPrincipal().setVisible(true);
        getVentanaPrincipal().setLocationRelativeTo(null);

    }

    //Se inicia el hilo y se convierte una variable a true para la ejecución del while
    public void iniciarJuego() {
        getSistema().setActivo(true);
        if (hiloDibujo == null && hiloMovimientoSerpiente==null) {
            hiloDibujo = new Thread(this);
            hiloMovimientoSerpiente = new Thread(miSistema);
            hiloDibujo.start();
            hiloMovimientoSerpiente.start();
        }

    }

    public void setHiloDibujo() {
        hiloDibujo = null;
    }
    
    public void setHiloMovimientoSerpiente() {
        hiloMovimientoSerpiente = null;
    }

    //Se termina el programa
    public void salir() {
        System.exit(0);
    }

    public Sistema getMiSistema() {
        return miSistema;
    }

    //Se abre la ventana del juego
    public void IniciarVentanaJuego() {
        getVentanaJuego().setSize(853, 626);
        getVentanaJuego().setVisible(true);
        getVentanaJuego().setLocationRelativeTo(null);
    }

    //Se obtienen los valores de sentido y signo que fueron asignados en el controlador al presionar las teclas
    //estos se envían a sistema donde se actualiza el vector de posición de la cabeza de la serpiente
    public Sistema getSistema() {
        if (miSistema == null) {
            miSistema = new Sistema();
        }
        return miSistema;
    }

    public void setSistema() {
        miSistema = null;
    }

    public VentanaPrincipal getVentanaPrincipal() {
        if (ventanaPrincipal == null) {
            ventanaPrincipal = new VentanaPrincipal(this);
        }
        return ventanaPrincipal;
    }

    public VentanaJuego getVentanaJuego() {
        if (ventanaJuego == null) {
            ventanaJuego = new VentanaJuego(this);
        }
        return ventanaJuego;
    }

    public void setVentanaJuego() {
        ventanaJuego = null;
    }

    public void juegoPerdido() {
        getVentanaJuego().getBtnReintentar().setVisible(true);
        getVentanaJuego().getBtnSalir().setVisible(true);

    }

    public void resetJuego() {
        getVentanaJuego().setVisible(false);
        setVentanaJuego();
        setSistema();
        getSistema();
        getSistema().setActivo(false);
        setHiloDibujo();
        setHiloMovimientoSerpiente();
        getSistema().setSentido("f");
        getSistema().setSigno(0);
        IniciarVentanaJuego();
        iniciarJuego();
    }

    @Override
    public void run() {
        Canvas lienzo = getVentanaJuego().getLienzo();
        dobleBuffer = new BufferedImage(853, 626, BufferedImage.TYPE_INT_ARGB);
        Graphics lapizCanvas = getVentanaJuego().getGraphics();
        Graphics lapiz = dobleBuffer.getGraphics();
        lapizCanvas.setColor(Color.black);
        while (getSistema().getActivo()) {
            getVentanaJuego().getContComi().setText(getMiSistema().getContaComida()+"");
            //Se llama el metodo dibujar para dibujar
            dibujar(lapiz);
            //Se dibuja en la ventana en nuevo lienzo con los cambios
            lapizCanvas.drawImage(dobleBuffer, 0, 0, lienzo);
        }
        getVentanaJuego().getErrortxt().setText(getSistema().getMensaje());
        juegoPerdido();

    }

    private void dibujar(Graphics lapiz) {
        //Se obtiene el tablero actualizado con las posiciones donde debe estar la serpiente y se pinta 
        int[][] tablero;
        int[] comida;
        tablero = getSistema().getTablero();
        comida = getSistema().getComida();
        borrar(lapiz);

        for (int i = 0; i < 35; i++) {
            for (int j = 0; j < 35; j++) {
                //dibuja serpiente
                if (tablero[i][j] == 1) {
                    lapiz.setColor(Color.black);
                    lapiz.fillRect(35 + (15 * j), 60 + (15 * i), 15, 15);
                }
            }
        }
        //dibujar comida
        lapiz.setColor(Color.red);
        lapiz.fillRect(35 + (15 * comida[1]), 60 + (15 * comida[0]), 15, 15);

    }

    private void borrar(Graphics lapiz) {
        //Se resetea el tablero donde está la serpiente volviendo a pintar
        int x = 15;
        int y = 15;
        for (int i = 0; i < 35; i++) {
            for (int j = 0; j < 35; j++) {
                if (j == 0 || i == 0 || i == 34 || j == 34) {
                    lapiz.setColor(Color.DARK_GRAY);
                    lapiz.fillRect(35 + (i * x), 60 + (j * y), x, x);
                } else {
                    if ((j % 2 == 0 && i % 2 != 0) || (j % 2 != 0 && i % 2 == 0)) {
                        lapiz.setColor(new Color(165, 219, 130));
                        lapiz.fillRect(35 + (i * x), 60 + (j * y), x, x);
                    } else {
                        lapiz.setColor(new Color(133, 187, 98));
                        lapiz.fillRect(35 + (i * x), 60 + (j * y), x, x);
                    }
                }
            }
        }
    }

}
