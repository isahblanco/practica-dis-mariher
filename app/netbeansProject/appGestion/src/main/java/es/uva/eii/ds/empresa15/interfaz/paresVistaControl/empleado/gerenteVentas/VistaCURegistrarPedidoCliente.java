package es.uva.eii.ds.empresa15.interfaz.paresVistaControl.empleado.gerenteVentas;

import javax.swing.JOptionPane;

/**
 *Implementacion de CtrlVistaCURegistrarPedidoCliente
 * 
 * @author mariher
 */
public class VistaCURegistrarPedidoCliente extends javax.swing.JFrame {
    
    private final CtrlVistaCURegistrarPedidoCliente controlador;
    
    /**
     * Creates new form VistaCURegistrarPedidoCliente
     */
    public VistaCURegistrarPedidoCliente() {
        initComponents();
        this.controlador = new CtrlVistaCURegistrarPedidoCliente(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cifClienteLabel = new javax.swing.JLabel();
        cifClienteTextField = new javax.swing.JTextField();
        aceptarCifButton = new javax.swing.JButton();
        confirmarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        configsPCLabel = new javax.swing.JLabel();
        configsPCComboBox = new javax.swing.JComboBox<>();
        cantidadLabel = new javax.swing.JLabel();
        buscarClienteButton = new javax.swing.JButton();
        resumenPedidoLabel = new javax.swing.JLabel();
        cpuLabel = new javax.swing.JLabel();
        tiposCpuComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        aceptarConfigButton = new javax.swing.JButton();
        resumenPedidoScrollPane = new javax.swing.JScrollPane();
        resumenPedidojTextArea = new javax.swing.JTextArea();
        infoConfiguracionjScrollPane = new javax.swing.JScrollPane();
        infoConfiguracionjTextArea = new javax.swing.JTextArea();
        cantidadjTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        cifClienteLabel.setFont(new java.awt.Font("DejaVu Sans", 1, 16)); // NOI18N
        cifClienteLabel.setLabelFor(cifClienteTextField);
        cifClienteLabel.setText("CIF:");

        cifClienteTextField.setFont(new java.awt.Font("DejaVu Sans", 0, 16)); // NOI18N
        cifClienteTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cifClienteTextFieldActionPerformed(evt);
            }
        });

        aceptarCifButton.setFont(new java.awt.Font("DejaVu Sans", 1, 16)); // NOI18N
        aceptarCifButton.setText("Aceptar");
        aceptarCifButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarCifButtonActionPerformed(evt);
            }
        });

        confirmarButton.setFont(new java.awt.Font("DejaVu Sans", 1, 16)); // NOI18N
        confirmarButton.setText("Confirmar");
        confirmarButton.setEnabled(false);
        confirmarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarButtonActionPerformed(evt);
            }
        });

        cancelarButton.setFont(new java.awt.Font("DejaVu Sans", 1, 16)); // NOI18N
        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

        configsPCLabel.setFont(new java.awt.Font("DejaVu Sans", 1, 16)); // NOI18N
        configsPCLabel.setText("Configuraciones de PC:");

        configsPCComboBox.setFont(new java.awt.Font("DejaVu Sans", 0, 16)); // NOI18N
        configsPCComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configsPCComboBoxActionPerformed(evt);
            }
        });

        cantidadLabel.setFont(new java.awt.Font("DejaVu Sans", 1, 16)); // NOI18N
        cantidadLabel.setText("Cantidad:");

        buscarClienteButton.setFont(new java.awt.Font("DejaVu Sans", 1, 16)); // NOI18N
        buscarClienteButton.setText("Buscar");
        buscarClienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarClienteButtonActionPerformed(evt);
            }
        });

        resumenPedidoLabel.setFont(new java.awt.Font("DejaVu Sans", 1, 16)); // NOI18N
        resumenPedidoLabel.setText("Resumen del pedido:");

        cpuLabel.setFont(new java.awt.Font("DejaVu Sans", 1, 16)); // NOI18N
        cpuLabel.setText("CPU:");

        tiposCpuComboBox.setFont(new java.awt.Font("DejaVu Sans", 0, 16)); // NOI18N
        tiposCpuComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiposCpuComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 21)); // NOI18N
        jLabel1.setText("Registrar pedido de cliente");

        aceptarConfigButton.setFont(new java.awt.Font("DejaVu Sans", 1, 16)); // NOI18N
        aceptarConfigButton.setText("Aceptar");
        aceptarConfigButton.setEnabled(false);
        aceptarConfigButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarConfigButtonActionPerformed(evt);
            }
        });

        resumenPedidojTextArea.setColumns(20);
        resumenPedidojTextArea.setRows(5);
        resumenPedidoScrollPane.setViewportView(resumenPedidojTextArea);

        infoConfiguracionjTextArea.setColumns(20);
        infoConfiguracionjTextArea.setRows(5);
        infoConfiguracionjScrollPane.setViewportView(infoConfiguracionjTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(configsPCComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cpuLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tiposCpuComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cantidadLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cantidadjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(configsPCLabel)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cifClienteLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cifClienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(aceptarCifButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(buscarClienteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel1)))
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 7, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(confirmarButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cancelarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(infoConfiguracionjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(aceptarConfigButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(resumenPedidoScrollPane))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(resumenPedidoLabel)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cifClienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aceptarCifButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarClienteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cifClienteLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(configsPCLabel)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(configsPCComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cpuLabel)
                            .addComponent(tiposCpuComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cantidadLabel)
                            .addComponent(cantidadjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(infoConfiguracionjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(aceptarConfigButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(resumenPedidoLabel)
                .addGap(10, 10, 10)
                .addComponent(resumenPedidoScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        cifClienteTextField.getAccessibleContext().setAccessibleName("CIF");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarButtonActionPerformed
        confirmarButton.setEnabled(false);
        procesarConfirmacion();
        clearAllReset();
        JOptionPane.showMessageDialog(this, "El pedido ha sido registrado",
            "Registro de pedido", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_confirmarButtonActionPerformed

    private void buscarClienteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarClienteButtonActionPerformed
         JOptionPane.showMessageDialog(this, "Caso de uso Buscar Cliente no implementado ya que no se ped??a",
            "Funcionalidad no implementada", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_buscarClienteButtonActionPerformed

    private void cifClienteTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cifClienteTextFieldActionPerformed

    }//GEN-LAST:event_cifClienteTextFieldActionPerformed

    private void aceptarCifButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarCifButtonActionPerformed
        procesarCifCliente();
        aceptarConfigButton.setEnabled(true);
    }//GEN-LAST:event_aceptarCifButtonActionPerformed

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        this.controlador.procesarEventoCancelar();
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void configsPCComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configsPCComboBoxActionPerformed
       if(this.configsPCComboBox.getSelectedItem() != null){
        int id = Integer.parseInt(String.valueOf(this.configsPCComboBox.getSelectedItem()));
        mostrarDetallesConfiguracion(this.controlador.obtenerDetallesConfiguracion(id));
       }
       //Si no hay items no se hace nada
    }//GEN-LAST:event_configsPCComboBoxActionPerformed

    private void aceptarConfigButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarConfigButtonActionPerformed
        procesarConficuracionYcantidadSeleccionadas();
        confirmarButton.setEnabled(true);
    }//GEN-LAST:event_aceptarConfigButtonActionPerformed

    private void tiposCpuComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiposCpuComboBoxActionPerformed
      if(this.tiposCpuComboBox.getSelectedItem() != null){
        String tipo = String.valueOf(this.tiposCpuComboBox.getSelectedItem());
        this.controlador.filtrar(tipo);
      }
      //Si no hay items no se hace nada
    }//GEN-LAST:event_tiposCpuComboBoxActionPerformed
    
    private void procesarCifCliente() {
        String cif = cifClienteTextField.getText();
        controlador.procesarEventoCifCliente(cif);
    }
    
    private void procesarConficuracionYcantidadSeleccionadas(){
        int cantidad;
        int idConfig = Integer.parseInt(String.valueOf(this.configsPCComboBox.getSelectedItem()));
        String cantidadStr = cantidadjTextField.getText();
        
        if(cantidadStr.isEmpty()){
            cantidad = -1;
        } else {
            cantidad = Integer.parseInt(cantidadjTextField.getText());
        }
        
        controlador.procesarEventoCrearPedido(idConfig, cantidad);
    }
    
    private void procesarConfirmacion(){
        controlador.procesarEventoRegistrarPedido();
    }
    
    private void clearAllReset(){
        cifClienteTextField.setText("");
        configsPCComboBox.removeAllItems();
        tiposCpuComboBox.removeAllItems();
        cantidadjTextField.setText("");
        infoConfiguracionjTextArea.setText("");
        resumenPedidojTextArea.setText("");
        aceptarConfigButton.setEnabled(false);
    }
    
    /**
     * Muestra un mensaje de error
     * @param mensajeError string con el mensaje de error
     */
    public void mostrarMensajeError(String mensajeError) {
        JOptionPane.showMessageDialog(this, mensajeError,
                "ERROR", JOptionPane.ERROR_MESSAGE);
    }
        
    /**
     * Muestra un mensaje de error y deja vac??o del campo donde introducir
     * la cantidad
     * @param mensajeError string con el mensaje de error
     */
    public void mostrarMensajeErrorCantidad(String mensajeError) {
        JOptionPane.showMessageDialog(this, mensajeError,
                "ERROR", JOptionPane.ERROR_MESSAGE);
        cantidadjTextField.setText("");
    }

    /**
     * A??ade los id de las configuraciones al ComboBox
     * @param idsConfigsPC array de strings con los ids de las configuraciones
     */
    public void mostrarIdConfiguraciones(String[] idsConfigsPC){
        for(var id : idsConfigsPC){
            configsPCComboBox.addItem(id);
        }
    }
    
    /**
     * A??ade los tipos de CPU al ComboBox
     * @param tiposCPU array de strings con los tipos de CPU
     */
    public void mostrarTiposCPU(String[] tiposCPU){
        tiposCpuComboBox.addItem("Todo");
        for(var tipo : tiposCPU){
            tiposCpuComboBox.addItem(tipo);
        }
    }
    
    /**
     * Muestra los detalles correspondientes de la configuracion seleccionada
     * @param detalles string de los detalles de la configuracion
     */
    public void mostrarDetallesConfiguracion(String detalles){
        infoConfiguracionjTextArea.setText("");
        infoConfiguracionjTextArea.setText(detalles);
    }
    
    /**
     * Muestra el resumen correspondiente del pedido
     * @param detalles string del resumen del pedido
     */
    public void mostrarResumenDelPedido(String detalles){
        resumenPedidojTextArea.setText("");
        resumenPedidojTextArea.setText(detalles);
    }
    
    /**
     * Elimina todos los elemento del ComboBox de los ids de las
     * configuraciones y lo deja vac??o
     */
    public void vaciarComboBoxIDconfiguracion(){
        configsPCComboBox.removeAllItems();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarCifButton;
    private javax.swing.JButton aceptarConfigButton;
    private javax.swing.JButton buscarClienteButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JLabel cantidadLabel;
    private javax.swing.JTextField cantidadjTextField;
    private javax.swing.JLabel cifClienteLabel;
    private javax.swing.JTextField cifClienteTextField;
    private javax.swing.JComboBox<String> configsPCComboBox;
    private javax.swing.JLabel configsPCLabel;
    private javax.swing.JButton confirmarButton;
    private javax.swing.JLabel cpuLabel;
    private javax.swing.JScrollPane infoConfiguracionjScrollPane;
    private javax.swing.JTextArea infoConfiguracionjTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel resumenPedidoLabel;
    private javax.swing.JScrollPane resumenPedidoScrollPane;
    private javax.swing.JTextArea resumenPedidojTextArea;
    private javax.swing.JComboBox<String> tiposCpuComboBox;
    // End of variables declaration//GEN-END:variables
}
