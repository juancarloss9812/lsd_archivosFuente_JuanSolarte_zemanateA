/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorDeNotificaciones.sop_rmi;

import servidorDeNotificaciones.dto.Pedido;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author aldair
 */
public interface NotificacionInt extends Remote {

    public void notificarRegistro(Pedido objNotificacion) throws RemoteException;
}
