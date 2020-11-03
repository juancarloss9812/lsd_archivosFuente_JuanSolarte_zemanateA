/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.vistas;

import javax.swing.JOptionPane;
import servidorDePedidos.dto.HamburguesaPedidoDTO;
import servidorDePedidos.dto.Pedido;

/**
 *
 * @author JUAN
 */
public class VistaCompraHamburguesa extends javax.swing.JInternalFrame {

    Pedido objPedido;
    vistaCliente objViCliente;
    int opcion;

    /**
     * Creates new form VistaCompraHamburguesa
     *
     * @param objVista
     * @param prmOpcion
     */
    public VistaCompraHamburguesa(vistaCliente objVista, int prmOpcion) {
        initComponents();
        this.objViCliente = objVista;
        objPedido = objVista.getObjPedido();
        btnPedir.setVisible(false);

        this.opcion = prmOpcion;
        if (prmOpcion == 1) {
            lblId.setVisible(false);
            txtIden.setVisible(false);
            btnConsultar.setVisible(false);
            btnPedir.setVisible(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tipos = new javax.swing.ButtonGroup();
        jToggleButton1 = new javax.swing.JToggleButton();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rbPequenia = new javax.swing.JRadioButton();
        rbMediana = new javax.swing.JRadioButton();
        rbGrande = new javax.swing.JRadioButton();
        txtNombre = new javax.swing.JTextField();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnPedir = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        txtIden = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setClosable(true);
        setMaximizable(true);
        setTitle("Comprar Hamburguesa");

        jLabel1.setText("Nombre Hamburguesa: ");

        jLabel2.setText("tipo: ");

        Tipos.add(rbPequenia);
        rbPequenia.setText("Pequeña");

        Tipos.add(rbMediana);
        rbMediana.setText("Mediana");

        Tipos.add(rbGrande);
        rbGrande.setText("Grande");

        lblCantidad.setText("Cantidad Ingredientes: ");

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        btnPedir.setText("Pedir");
        btnPedir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedirActionPerformed(evt);
            }
        });

        lblId.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblId.setText("Identificador: ");

        btnConsultar.setText("Buscar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPedir)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblCantidad)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCantidad))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rbMediana)
                                        .addComponent(rbPequenia)
                                        .addComponent(rbGrande))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIden, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnConsultar)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtIden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rbPequenia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbMediana)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbGrande)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCantidad)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnPedir)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPedirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedirActionPerformed
        // TODO add your handling code here:
        //guardar los datos
        if (txtNombre.getText().isEmpty() || txtCantidad.getText().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "CAMPOS NULOS.");
        } else if (opcion == 1) {
            comprar();
            int resultado = javax.swing.JOptionPane.showConfirmDialog(this, "¿DESEA AGREGAR OTRA HAMBURGUESA?", "", JOptionPane.YES_NO_OPTION);

            if (resultado == 1) {
                this.setVisible(false);
            }
        } else {
            editar(txtIden.getText());
            int resultado = javax.swing.JOptionPane.showConfirmDialog(this, "¿DESEA EDITAR OTRA HAMBURGUESA?", "", JOptionPane.YES_NO_OPTION);

            if (resultado == 1) {
                this.setVisible(false);
            }
        }


    }//GEN-LAST:event_btnPedirActionPerformed


    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
        boolean bandera = false;
        int pos = 0;
        float costo = 0;
        float extra = 0;
        float totaS = 0;
        if (txtIden.getText().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "CAMPO NULO.");
        } else {

            for (int i = 0; i < objPedido.getListaHamburguesas().size(); i++) {
                if (objPedido.getListaHamburguesas().get(i).getIdentificador().equals(txtIden.getText())) {
                    txtNombre.setText(objPedido.getListaHamburguesas().get(i).getIdentificador());
                    //=""+objPedido.getListaHamburguesas().get(i).getTipo();
                    if (objPedido.getListaHamburguesas().get(i).getTipo() == 'G') {
                        rbGrande.setSelected(true);
                        costo = objViCliente.getObjDatos().getValorTipoHamburguesaG();

                    } else if (objPedido.getListaHamburguesas().get(i).getTipo() == 'M') {
                        rbMediana.setSelected(true);
                        costo = objViCliente.getObjDatos().getValorTipoHamburguesaM();

                    } else if (objPedido.getListaHamburguesas().get(i).getTipo() == 'P') {
                        rbPequenia.setSelected(true);
                        costo = objViCliente.getObjDatos().getValorTipoHamburguesaP();

                    }
                    txtCantidad.setText("" + objPedido.getListaHamburguesas().get(i).getCantidadIngredientesExtra());
                    extra = objViCliente.getObjDatos().getValorIngredienteExtra();
                    extra = extra * Integer.parseInt(txtCantidad.getText());
                    costo = costo + extra;
                    totaS = objPedido.getMonto();
                    totaS = totaS - costo;
                    objPedido.setMonto(totaS);
                    pos = i;
                    bandera = true;
                    break;
                }
            }
            if (!bandera) {
                javax.swing.JOptionPane.showMessageDialog(this, "HAMBURGUESA NO ESTA REGISTRADA.");
            } else {
                btnConsultar.setVisible(false);
                btnPedir.setVisible(true);
            }
        }

    }//GEN-LAST:event_btnConsultarActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped

        char c = evt.getKeyChar();

        if (c < '0' || c > '9') {
            evt.consume();
        }


    }//GEN-LAST:event_txtCantidadKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Tipos;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnPedir;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblId;
    private javax.swing.JRadioButton rbGrande;
    private javax.swing.JRadioButton rbMediana;
    private javax.swing.JRadioButton rbPequenia;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtIden;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private void comprar() {
        float totaS;
        String identificador = txtNombre.getText();
        float extra = objViCliente.getObjDatos().getValorIngredienteExtra();
        float costo = 0;
        char tipo = 'n';

        if (rbGrande.isSelected()) {
            tipo = 'G';
            costo = objViCliente.getObjDatos().getValorTipoHamburguesaG();
        } else if (rbMediana.isSelected()) {
            tipo = 'M';
            costo = objViCliente.getObjDatos().getValorTipoHamburguesaM();
        } else if (rbPequenia.isSelected()) {
            tipo = 'P';
            costo = objViCliente.getObjDatos().getValorTipoHamburguesaP();
        }
        int canIngredientesExtras = Integer.parseInt(txtCantidad.getText());
        extra = canIngredientesExtras * extra;
        costo = costo + extra;
        HamburguesaPedidoDTO objHamburguesa = new HamburguesaPedidoDTO(identificador, tipo, canIngredientesExtras, costo);

        objPedido.agregarHamburguesa(objHamburguesa);
        totaS = objPedido.getMonto();
        totaS = totaS + costo;
        objPedido.setMonto(totaS);

        objViCliente.setObjPedido(objPedido);
        javax.swing.JOptionPane.showMessageDialog(this, "HAMBURGUESA REGISTRADA EN EL PEDIDO.");
        vaciarCampos();

    }

    private void editar(String id) {
        float totaS;
        String identificador = txtNombre.getText();
        float extra = objViCliente.getObjDatos().getValorIngredienteExtra();
        float costo = 0;
        char tipo = 'n';

        if (rbGrande.isSelected()) {
            tipo = 'G';
            costo = objViCliente.getObjDatos().getValorTipoHamburguesaG();
        } else if (rbMediana.isSelected()) {
            tipo = 'M';
            costo = objViCliente.getObjDatos().getValorTipoHamburguesaM();
        } else if (rbPequenia.isSelected()) {
            tipo = 'P';
            costo = objViCliente.getObjDatos().getValorTipoHamburguesaP();
        }
        int canIngredientesExtras = Integer.parseInt(txtCantidad.getText());
        extra = canIngredientesExtras * extra;
        costo = costo + extra;
        HamburguesaPedidoDTO objHamburguesa = new HamburguesaPedidoDTO(identificador, tipo, canIngredientesExtras, costo);
        totaS = objPedido.getMonto();
        totaS = totaS + costo;
        objPedido.setMonto(totaS);
        objPedido.editarHamburguesa(objHamburguesa, txtIden.getText());

        objViCliente.setObjPedido(objPedido);
        javax.swing.JOptionPane.showMessageDialog(this, "HAMBURGUESA REGISTRADA EN EL PEDIDO.");
        vaciarCampos();
    }

    public void vaciarCampos() {
        txtIden.setText("");
        txtCantidad.setText("");
        txtNombre.setText("");
        rbGrande.setSelected(false);
        rbMediana.setSelected(false);
        rbGrande.setSelected(false);

    }
}