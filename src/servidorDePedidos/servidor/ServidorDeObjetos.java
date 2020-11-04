/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorDePedidos.servidor;

import administrador.sop_rmi.GestionFacturasImpl;
import servidorDePedidos.utilidades.UtilidadesConsola;
import servidorDePedidos.utilidades.UtilidadesRegistroS;
import java.rmi.RemoteException;
import servidorDePedidos.sop_rmi.GestionPedidosImpl;

/**
 *
 * @author aldair
 */
public class ServidorDeObjetos {

    public static void main(String args[]) throws RemoteException {
        int numPuertoNS;
        String direccionIpNS;

        System.out.println("Cual es la direccion ip donde se encuentra el n_s de alertas");
        direccionIpNS = UtilidadesConsola.leerCadena();
        System.out.println("Cual es el numero de puerto por el cual escucha el n_s de alertas");
        numPuertoNS = UtilidadesConsola.leerEntero();

        GestionPedidosImpl objRemotoPedidos = new GestionPedidosImpl();
        objRemotoPedidos.consultarReferenciaRemotaDeNotificacion(direccionIpNS, numPuertoNS);

        try {
            UtilidadesRegistroS.arrancarNS(numPuertoNS);
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemotoPedidos, direccionIpNS, numPuertoNS, "ObjetoPedidos");
            
        } catch (Exception e) {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" + e.getMessage());
        }
    }
}
