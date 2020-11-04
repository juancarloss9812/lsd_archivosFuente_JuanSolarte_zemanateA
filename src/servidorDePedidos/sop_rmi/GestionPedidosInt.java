/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorDePedidos.sop_rmi;

import administrador.sop_rmi.GestionFacturasInt;
import servidorDePedidos.dto.DatosEmpresas;
import servidorDePedidos.dto.Pedido;
import servidorDePedidos.dto.Factura;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author aldair
 */
public interface GestionPedidosInt extends Remote {

    public boolean registrarPedidoSistema(Pedido objPedido) throws RemoteException;

    public DatosEmpresas enviarDatosEmpresa() throws RemoteException;

    public boolean  registrarAdmin(GestionFacturasInt admin) throws RemoteException ;
    
    public boolean registrarFacturaSistema(Factura objFactura) throws RemoteException;

}
