/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorDeNotificaciones.sop_rmi;

import servidorDeNotificaciones.dto.Pedido;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import servidorDeNotificaciones.vistas.vistaNotificacion;

/**
 *
 * @author aldair
 */
public class NotificacionImpl extends UnicastRemoteObject implements NotificacionInt {

    vistaNotificacion GUIN;

    public NotificacionImpl(vistaNotificacion objNotificacion) throws RemoteException {
        super();
        GUIN = objNotificacion;
    }

    @Override
    public void notificarRegistro(Pedido objNotificacion) throws RemoteException {
        GUIN.notificarTabla(objNotificacion);
    }

}
