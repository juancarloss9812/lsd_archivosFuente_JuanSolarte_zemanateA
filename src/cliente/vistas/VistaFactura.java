/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.vistas;

import java.rmi.RemoteException;
import servidorDePedidos.dto.Factura;
import servidorDePedidos.sop_rmi.GestionPedidosInt;
import servidorDePedidos.dto.Pedido;

/**
 *
 * @author JUAN
 */
public class VistaFactura extends javax.swing.JInternalFrame {

    GestionPedidosInt objGestion;
    Pedido objPedido;

    /**
     * Creates new form VistaFactura
     *
     * @param prmVista
     * @throws java.rmi.RemoteException
     */
    public VistaFactura(vistaCliente prmVista) throws RemoteException {
        initComponents();
        objGestion = prmVista.getObjGestion();
        objPedido = prmVista.getObjPedido();
        lblFactura.setText(lblFactura.getText() + "" + objPedido.getMesa());
        if (!objPedido.getListaHamburguesas().isEmpty()) {
            llenarFactura();
            objGestion.registrarPedidoSistema(objPedido);
            prmVista.getObjPedido().getListaHamburguesas().clear();
            prmVista.getObjPedido().setMonto(0);
            prmVista.getObjPedido().setIVA(0);
            this.show();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "NO HAY HAMBURGUESA REGISTRADAS.");
            this.dispose();
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

        lblFactura = new javax.swing.JLabel();
        lblPeque = new javax.swing.JLabel();
        lblMediano = new javax.swing.JLabel();
        lblgrande = new javax.swing.JLabel();
        lblSinIVA = new javax.swing.JLabel();
        lblIVA = new javax.swing.JLabel();
        lblCosto = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setTitle("Factura");

        lblFactura.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblFactura.setText("FACTURA  MESA #");

        lblPeque.setText("Hamburguesas de tipo pequeño : ");

        lblMediano.setText("Hamburguesas de tipo mediano :");

        lblgrande.setText("Hamburguesas de tipo grande :");

        lblSinIVA.setText("Costo sin IVA del pedido: $");

        lblIVA.setText("IVA del pedido: $");

        lblCosto.setText("Costo con IVA del pedido: $");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lblPeque))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCosto)
                                    .addComponent(lblIVA)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblSinIVA)
                                .addComponent(lblMediano)
                                .addComponent(lblgrande))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(lblFactura)))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFactura)
                .addGap(18, 18, 18)
                .addComponent(lblPeque)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMediano)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblgrande)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSinIVA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIVA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCosto)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblFactura;
    private javax.swing.JLabel lblIVA;
    private javax.swing.JLabel lblMediano;
    private javax.swing.JLabel lblPeque;
    private javax.swing.JLabel lblSinIVA;
    private javax.swing.JLabel lblgrande;
    // End of variables declaration//GEN-END:variables

    private void calcularIVA() {
        int cantidad = objPedido.getListaHamburguesas().size();
        float monto = objPedido.getMonto();
        float iva = 0;
        if (cantidad >= 1 && cantidad <= 3) {
            iva = (monto * 5) / 100;

        } else if (cantidad >= 4 && cantidad <= 7) {
            iva = (monto * 8) / 100;

        } else if (cantidad >= 8 && monto == 120000) {
            iva = (monto * 18) / 100;

        } else if (cantidad >= 8) {
            iva = (monto * 15) / 100;
        }

        objPedido.setIVA(iva);

        monto = monto + iva;

    }

    private void llenarFactura() throws RemoteException {
        Pedido objAux = new Pedido();
        Factura objFacatura = new Factura();
        int p = 0;
        int m = 0;
        int g = 0;
        float costo = 0;
        for (int i = 0; i < objPedido.getListaHamburguesas().size(); i++) {

            switch (objPedido.getListaHamburguesas().get(i).getTipo()) {
                case 'P':
                    p++;
                    break;
                case 'M':
                    m++;
                    break;
                case 'G':
                    g++;
                    break;
                default:
                    break;
            }
        }
        objFacatura.setCantidad_Ham_grande(g);
        objFacatura.setCantidad_Ham_mediana(m);
        objFacatura.setCantidad_Ham_pequeno(p);
        calcularIVA();
        objFacatura.setValor_IVA_pedido(objPedido.getIVA());
        costo = objPedido.getMonto() + objPedido.getIVA();
        objFacatura.setCosto_CON_IVA(costo);
        objFacatura.setCosto_SIN_IVA(objPedido.getMonto());

        lblgrande.setText(lblgrande.getText() + "" + objFacatura.getCantidad_Ham_grande());
        lblPeque.setText(lblPeque.getText() + "" + objFacatura.getCantidad_Ham_pequeno());
        lblMediano.setText(lblMediano.getText() + "" + objFacatura.getCantidad_Ham_mediana());
        lblCosto.setText(lblCosto.getText() + "" + objFacatura.getCosto_CON_IVA());
        lblIVA.setText(lblIVA.getText() + "" + objFacatura.getValor_IVA_pedido());
        lblSinIVA.setText(lblSinIVA.getText() + "" + objFacatura.getCosto_SIN_IVA());
        objGestion.registrarFacturaSistema(objFacatura);

    }

}
