/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.vistas;

import javax.swing.JOptionPane;
import servidorDePedidos.dto.Pedido;

/**
 *
 * @author JUAN
 */
public class VistaEliminar extends javax.swing.JInternalFrame {

    Pedido objPedido;

    vistaCliente objViCliente;

    /**
     * Creates new form VistaEliminar
     *
     * @param prmPedido
     * @param objVista
     */
    public VistaEliminar(vistaCliente objVista) {
        initComponents();
        this.objViCliente = objVista;
        objPedido = objVista.getObjPedido();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        lblIdentificador = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsulta = new javax.swing.JTable();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setClosable(true);
        setMaximizable(true);
        setTitle("Eliminar");

        lblIdentificador.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblIdentificador.setText("Identificador: ");

        btnBuscar.setText("Eliminar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Tipo", "Cantidad Extra", "precio"
            }
        ));
        jScrollPane1.setViewportView(tblConsulta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblIdentificador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdentificador)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        boolean bandera = false;
        int pos = 0;
        String Matrix[][] = new String[objPedido.getListaHamburguesas().size()][4];
        for (int i = 0; i < objPedido.getListaHamburguesas().size(); i++) {
            if (objPedido.getListaHamburguesas().get(i).getIdentificador().equals(txtId.getText())) {
                Matrix[0][0] = objPedido.getListaHamburguesas().get(i).getIdentificador();
                Matrix[0][1] = "" + objPedido.getListaHamburguesas().get(i).getTipo();
                Matrix[0][2] = "" + objPedido.getListaHamburguesas().get(i).getCantidadIngredientesExtra();
                Matrix[0][3] = "" + objPedido.getListaHamburguesas().get(i).getCosto();
                tblConsulta.setModel(new javax.swing.table.DefaultTableModel(
                        Matrix,
                        new String[]{
                            "Nombre", "Tipo", "Ingredientes E", "Precio"
                        }
                ));
                pos = i;
                bandera = true;
                break;
            }
        }
        if (!bandera) {
            javax.swing.JOptionPane.showMessageDialog(this, "HAMBURGUESA NO ESTA REGISTRADA.");
        } else {
            int resultado = javax.swing.JOptionPane.showConfirmDialog(this, "¿ESTA SEGURO DE ELIMNAR LA HAMBURGUESA?", "", JOptionPane.YES_NO_OPTION);

            if (resultado == 0) {
                objPedido.setMonto(objPedido.getMonto() - objPedido.getListaHamburguesas().get(pos).getCosto());
                objPedido.getListaHamburguesas().remove(objPedido.getListaHamburguesas().get(pos));
                objViCliente.setObjPedido(objPedido);
                javax.swing.JOptionPane.showMessageDialog(this, "HAMBURGUESA FUE ELIMINIDA.");
            }

        }
        vaciar();

    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIdentificador;
    private javax.swing.JTable tblConsulta;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables

    private void vaciar() {

        txtId.setText("");
        tblConsulta.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "Nombre", "Tipo", "Cantidad Extra", "precio"
                }
        ));

    }

}
