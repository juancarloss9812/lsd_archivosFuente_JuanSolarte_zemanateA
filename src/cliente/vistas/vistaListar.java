/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.vistas;

import servidorDePedidos.dto.HamburguesaPedidoDTO;
import servidorDePedidos.dto.Pedido;

/**
 *
 * @author JUAN
 */
public final class vistaListar extends javax.swing.JInternalFrame {

    Pedido objPedido;

    /**
     * Creates new form vistaListar
     *
     * @param prPedido
     */
    public vistaListar(Pedido prPedido) {
        objPedido = prPedido;
        initComponents();
        listarHamburguesas();
        lblOp.setText("LISTA DE HAMBURGUESAS PEDIDAS");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblOp = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLista = new javax.swing.JTable();
        lblCosto = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setTitle("Listar");

        lblOp.setText("-");

        tblLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Tipo", "Ingredientes Extra", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tblLista);

        lblCosto.setText("Costo: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(lblCosto))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(lblOp, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblOp, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lblCosto)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void listarHamburguesas() {
        int contador = 0;
        String Matrix[][] = new String[objPedido.getListaHamburguesas().size()][4];
        for (int i = 0; i < objPedido.getListaHamburguesas().size(); i++) {
            HamburguesaPedidoDTO objAux = objPedido.getListaHamburguesas().get(i);
            Matrix[i][0] = objAux.getIdentificador();

            if (objAux.getTipo() == 'P') {
                Matrix[i][1] = "PEQUEÑA";

            } else if (objAux.getTipo() == 'M') {
                Matrix[i][1] = "MEDIANA";

            } else if (objAux.getTipo() == 'G') {
                Matrix[i][1] = "GRANDE";
            }

            Matrix[i][2] = "" + objAux.getCantidadIngredientesExtra();
            Matrix[i][3] = "" + objAux.getCosto();
            contador++;
        }
        tblLista.setModel(new javax.swing.table.DefaultTableModel(
                Matrix,
                new String[]{
                    "Nombre", "Tipo", "Ingredientes E", "Precio"
                }
        ));
        if (contador == 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "NO HAY HABURGUESAS REGISTRADAS.");

        } else {
            calcularIVA();
            this.show();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblOp;
    private javax.swing.JTable tblLista;
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

        lblCosto.setText("Costo con IVA del pedido: $ " + monto);

    }
}