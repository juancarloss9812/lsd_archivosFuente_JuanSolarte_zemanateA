/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.vistas;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidorDePedidos.dto.DatosEmpresas;
import servidorDePedidos.dto.Factura;
import servidorDePedidos.sop_rmi.GestionPedidosInt;
import servidorDePedidos.dto.Pedido;

/**
 *
 * @author JUAN
 */
public class vistaCliente extends javax.swing.JFrame {

    GestionPedidosInt objGestion;
    Pedido objPedido;
    DatosEmpresas objDatos;
    Factura objFactura;

    /**
     * Creates new form vistaCliente
     *
     * @param prmGestionPedidosInt
     * @param prmDatos
     * @param mesa
     */
    public vistaCliente(GestionPedidosInt prmGestionPedidosInt, DatosEmpresas prmDatos, String mesa) {
        this.objGestion = prmGestionPedidosInt;
        initComponents();
        objFactura = new Factura();
        objPedido = new Pedido();
        objPedido.setMesa(mesa);
        objDatos = prmDatos;
    }

    public Pedido getObjPedido() {
        return objPedido;
    }

    public void setObjPedido(Pedido objPedido) {
        this.objPedido = objPedido;
    }

    public DatosEmpresas getObjDatos() {
        return objDatos;
    }

    public GestionPedidosInt getObjGestion() {
        return objGestion;
    }

    public void setObjGestion(GestionPedidosInt objGestion) {
        this.objGestion = objGestion;
    }

    public Factura getObjFactura() {
        return objFactura;
    }

    public void setObjFactura(Factura objFactura) {
        this.objFactura = objFactura;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jpPrincipal = new javax.swing.JPanel();
        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        opDatosEmpresa = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        opComprar = new javax.swing.JMenuItem();
        opModificar = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        opListar = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(0, 51, 204));
        escritorio.setPreferredSize(new java.awt.Dimension(600, 370));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenu2.setText("Opciones");

        opDatosEmpresa.setText("Informacion Empresas");
        opDatosEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opDatosEmpresaActionPerformed(evt);
            }
        });
        jMenu2.add(opDatosEmpresa);

        jMenu4.setText("Gestion Hamburguesa");

        opComprar.setText("Comprar Hamburguesa");
        opComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opComprarActionPerformed(evt);
            }
        });
        jMenu4.add(opComprar);

        opModificar.setText("Modificar Hamburguesa");
        opModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opModificarActionPerformed(evt);
            }
        });
        jMenu4.add(opModificar);

        jMenuItem3.setText("Eliminar Hamburguesa");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        opListar.setText("Listar Hamburguesas");
        opListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opListarActionPerformed(evt);
            }
        });
        jMenu4.add(opListar);

        jMenu2.add(jMenu4);

        jMenuItem2.setText("Pagar Hamburguesas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Salir");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opDatosEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opDatosEmpresaActionPerformed
        VistaDatos objVDatos;
        try {
            objVDatos = new VistaDatos(objDatos);
            escritorio.add(objVDatos);
            objVDatos.show();
        } catch (RemoteException ex) {
            Logger.getLogger(vistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_opDatosEmpresaActionPerformed

    private void opComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opComprarActionPerformed
        VistaCompraHamburguesa objCompraHamburguesa = new VistaCompraHamburguesa(this, 1);
        escritorio.add(objCompraHamburguesa);
        objCompraHamburguesa.show();
    }//GEN-LAST:event_opComprarActionPerformed

    private void opModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opModificarActionPerformed
        VistaCompraHamburguesa objCompraHamburguesa = new VistaCompraHamburguesa(this, 2);
        escritorio.add(objCompraHamburguesa);
        objCompraHamburguesa.show();
    }//GEN-LAST:event_opModificarActionPerformed

    private void opListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opListarActionPerformed
        vistaListar objListar = new vistaListar(objPedido);
        escritorio.add(objListar);

    }//GEN-LAST:event_opListarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        VistaFactura objVFactura;
        try {
            objVFactura = new VistaFactura(this);
            escritorio.add(objVFactura);
        } catch (RemoteException ex) {
            Logger.getLogger(vistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        VistaEliminar objEliminar = new VistaEliminar(this);
        escritorio.add(objEliminar);
        objEliminar.show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JMenuItem opComprar;
    private javax.swing.JMenuItem opDatosEmpresa;
    private javax.swing.JMenuItem opListar;
    private javax.swing.JMenuItem opModificar;
    // End of variables declaration//GEN-END:variables
}
