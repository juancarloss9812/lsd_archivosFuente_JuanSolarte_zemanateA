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
import cliente.utilidades.UtilidadesRegistroC;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import servidorDeNotificaciones.dto.HamburguesaNotificacionDTO;
import servidorDeNotificaciones.sop_rmi.NotificacionInt;
import servidorDePedidos.DAO.Ficheros;

/**
 *
 * @author juan
 */
public class GestionPedidosImpl extends UnicastRemoteObject implements GestionPedidosInt {

    private GestionFacturasInt objAdmin;
    private NotificacionInt objReferenciaRemotaNotificacion;
    private final Ficheros objarchivo;

    public GestionPedidosImpl() throws RemoteException {
        super();
        objarchivo = new Ficheros();
    }

    @Override
    public boolean registrarPedidoSistema(Pedido objPedido) throws RemoteException {
        System.out.println("Invovando a registrar pedido");
        servidorDeNotificaciones.dto.Pedido objNotificacion = new servidorDeNotificaciones.dto.Pedido();

        objNotificacion.setMesa(objPedido.getMesa());
        for (int i = 0; i < objPedido.getListaHamburguesas().size(); i++) {
            HamburguesaNotificacionDTO objAux = new HamburguesaNotificacionDTO(objPedido.getListaHamburguesas().get(i).getTipo(), objPedido.getListaHamburguesas().get(i).getCantidadIngredientesExtra());
            objNotificacion.agregarHamburguesa(objAux);
        }
        this.objReferenciaRemotaNotificacion.notificarRegistro(objNotificacion);
        return true;
    }

    public void consultarReferenciaRemotaDeNotificacion(String direccionIpRMIRegistry, int numPuertoRMIRegistry) {
        this.objReferenciaRemotaNotificacion = (NotificacionInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry, numPuertoRMIRegistry, "ObjetoRemotoNotificaciones");
    }

    @Override
    public DatosEmpresas enviarDatosEmpresa() throws RemoteException {

        DatosEmpresas objEmpresa;
        objEmpresa = objarchivo.darDatosEmpresa();
        return objEmpresa;
    }

    @Override
    public boolean registrarFacturaSistema(Factura objFactura) throws RemoteException {
        boolean bandera =false;
        bandera=objarchivo.escrbirFactura(objFactura);
        if(objAdmin != null){
            notificarAdmin();
        }
        return bandera;
    }

    @Override
    public boolean registrarAdmin(GestionFacturasInt admin) throws RemoteException {
        System.out.println("Invocando al método registrar admin desde el servidor");
        objAdmin = admin;
        return true;
    }

    private void notificarAdmin() throws RemoteException {
        System.out.println("Invocando al método notificar admin desde el servidor");
                objAdmin.NotificarFactura();//el servidor hace el callback    
    }

   
}
