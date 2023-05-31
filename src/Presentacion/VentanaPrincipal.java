
package Presentacion;

public class VentanaPrincipal extends javax.swing.JFrame {

    private final Modelo modelo;
    private ControladorVentanaPrincipal control;
    
    public VentanaPrincipal(Modelo aThis) {
        modelo = aThis;
        initComponents();
        transparenciaButton();
        CapturarEventos();
    }
    
    public void transparenciaButton() {
        btnJugar.setOpaque(false);
        btnJugar.setContentAreaFilled(false);
        btnJugar.setBorderPainted(false);

        btnSalir.setOpaque(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setBorderPainted(false);
    }

    public ControladorVentanaPrincipal getControl() {
        if (control == null) {
            control = new ControladorVentanaPrincipal(this);
        }
        return control;
    }

    public Modelo getModelo() {
        return modelo;
    }
    
    public void CapturarEventos(){
        btnJugar.addActionListener(getControl());
        btnSalir.addActionListener(getControl());
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnJugar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        btnJugar.setFont(new java.awt.Font("Segoe UI Black", 3, 36)); // NOI18N
        btnJugar.setText("JUGAR");
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });
        jPanel1.add(btnJugar);
        btnJugar.setBounds(290, 450, 250, 50);

        btnSalir.setFont(new java.awt.Font("Segoe UI Black", 3, 36)); // NOI18N
        btnSalir.setText("SALIR");
        jPanel1.add(btnSalir);
        btnSalir.setBounds(290, 510, 250, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Snake 1.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 853, 630);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnJugarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJugar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
