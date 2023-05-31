package Presentacion;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JLabel;

public class VentanaJuego extends javax.swing.JFrame {

    private final Modelo modelo;
    private ControladorVentanaJuego control;

    public VentanaJuego(Modelo cThis) {
        modelo = cThis;
        initComponents();
        transparenciaButton();
        capturarEventos();
    }
    
    public void transparenciaButton() {
        btnReintentar.setVisible(false);
        btnReintentar.setOpaque(false);
        btnReintentar.setContentAreaFilled(false);
//        btnReintentar.setBorderPainted(false);

        btnSalir.setVisible(false);
        btnSalir.setOpaque(false);
        btnSalir.setContentAreaFilled(false);
//        btnSalir.setBorderPainted(false);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int x = 15;
        int y = 15;
        for (int i = 0; i < 35; i++) {
            for (int j = 0; j < 35; j++) {
                if (j == 0 || i == 0 || i == 34 || j == 34) {
                    g.setColor(Color.DARK_GRAY);
                    g.fillRect(35 + (i * x), 60 + (j * y), x, x);
                } else {
                    if ((j % 2 == 0 && i % 2 != 0) || (j % 2 != 0 && i % 2 == 0)) {
                        g.setColor(new Color(165, 219, 130));
                        g.fillRect(35 + (i * x), 60 + (j * y), x, x);
                    } else {
                        g.setColor(new Color(133, 187, 98));
                        g.fillRect(35 + (i * x), 60 + (j * y), x, x);
                    }

                }
            }
        }
//        FondoJuego.setBounds(x, 60, 525, 525);
    }

    public JLabel getContComi() {
        return contComi;
    }
    
    

    public ControladorVentanaJuego getControl() {
        if (control == null) {
            control = new ControladorVentanaJuego(this);
        }
        return control;
    }

    public JButton getBtnReintentar() {
        return btnReintentar;
    }

    public void setBtnReintentar(JButton btnReintentar) {
        this.btnReintentar = btnReintentar;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }

    public void setBtnSalir(JButton btnSalir) {
        this.btnSalir = btnSalir;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public JLabel getErrortxt() {
        return errortxt;
    }

    public void setErrortxt(JLabel errortxt) {
        this.errortxt = errortxt;
    }
    
    public Canvas getLienzo() {
        return lienzo;
    }
    
    private void capturarEventos() {
        this.addKeyListener(getControl());
        btnReintentar.addActionListener(getControl());
        btnSalir.addActionListener(getControl());
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTotal = new javax.swing.JPanel();
        PanelDatos = new javax.swing.JPanel();
        contComi = new javax.swing.JLabel();
        imgCarne = new javax.swing.JLabel();
        TituloPuntaje = new javax.swing.JLabel();
        errortxt = new javax.swing.JLabel();
        btnReintentar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lienzo = new java.awt.Canvas();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(853, 626));
        setSize(new java.awt.Dimension(853, 626));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        PanelTotal.setBackground(new java.awt.Color(0, 0, 0));
        PanelTotal.setPreferredSize(new java.awt.Dimension(853, 626));
        PanelTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PanelTotalKeyPressed(evt);
            }
        });
        PanelTotal.setLayout(null);

        PanelDatos.setBackground(new java.awt.Color(153, 255, 153));
        PanelDatos.setLayout(null);

        contComi.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 48)); // NOI18N
        contComi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contComi.setText("0");
        PanelDatos.add(contComi);
        contComi.setBounds(90, 150, 82, 61);

        imgCarne.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        imgCarne.setForeground(new java.awt.Color(0, 153, 0));
        imgCarne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgCarne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/carne.png"))); // NOI18N
        imgCarne.setMaximumSize(new java.awt.Dimension(100, 50));
        imgCarne.setMinimumSize(new java.awt.Dimension(100, 50));
        PanelDatos.add(imgCarne);
        imgCarne.setBounds(80, 100, 100, 50);

        TituloPuntaje.setBackground(new java.awt.Color(0, 0, 0));
        TituloPuntaje.setFont(new java.awt.Font("Yu Gothic", 1, 40)); // NOI18N
        TituloPuntaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TituloPuntaje.setText("PUNTAJE");
        PanelDatos.add(TituloPuntaje);
        TituloPuntaje.setBounds(0, 0, 250, 100);

        errortxt.setFont(new java.awt.Font("Yu Gothic Medium", 0, 24)); // NOI18N
        errortxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errortxt.setText("SOBREVIVE!");
        PanelDatos.add(errortxt);
        errortxt.setBounds(20, 190, 200, 130);

        btnReintentar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnReintentar.setText("Reintentar");
        PanelDatos.add(btnReintentar);
        btnReintentar.setBounds(50, 330, 160, 50);

        btnSalir.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnSalir.setText("Salir");
        PanelDatos.add(btnSalir);
        btnSalir.setBounds(50, 400, 160, 50);

        PanelTotal.add(PanelDatos);
        PanelDatos.setBounds(570, 20, 250, 530);

        getContentPane().add(PanelTotal);
        PanelTotal.setBounds(0, 0, 853, 600);
        getContentPane().add(lienzo);
        lienzo.setBounds(0, 0, 0, 0);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void PanelTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PanelTotalKeyPressed

    }//GEN-LAST:event_PanelTotalKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelDatos;
    private javax.swing.JPanel PanelTotal;
    private javax.swing.JLabel TituloPuntaje;
    private javax.swing.JButton btnReintentar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel contComi;
    private javax.swing.JLabel errortxt;
    private javax.swing.JLabel imgCarne;
    private java.awt.Canvas lienzo;
    // End of variables declaration//GEN-END:variables
}
