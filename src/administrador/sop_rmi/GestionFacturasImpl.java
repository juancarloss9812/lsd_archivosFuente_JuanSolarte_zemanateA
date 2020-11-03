/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.sop_rmi;

import administrador.vistas.vistaAdmin;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author JUAN
 */
public class GestionFacturasImpl extends UnicastRemoteObject implements GestionFacturasInt {

    vistaAdmin GUIA;

    public GestionFacturasImpl(vistaAdmin objNotificacion) throws RemoteException {
        super();
        GUIA = objNotificacion;
    }

    @Override
    public void NotificarFactura(String nombreFactura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
