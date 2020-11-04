/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.sop_rmi;

import administrador.vistas.vistaAdmin;
import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import servidorDePedidos.DAO.Ficheros;

/**
 *
 * @author JUAN
 */
public class GestionFacturasImpl extends UnicastRemoteObject implements GestionFacturasInt {
    Ficheros objFichero;
    vistaAdmin GUIA;

    public GestionFacturasImpl(vistaAdmin objNotificacion) throws RemoteException {
        super();
        GUIA = objNotificacion;
        objFichero = new Ficheros();
    }

    @Override
    public void NotificarFactura() throws RemoteException{
        GUIA.notificar();
    }

    @Override
    public ArrayList<String> enviarNombreFacturas() throws RemoteException{
        ArrayList<String> ListaNombres;
        
        ListaNombres = objFichero.getNombreFacturas();
        return ListaNombres;
    }

    @Override
    public String darFactura(String nombre) throws RemoteException {
        String txt;
        txt = objFichero.darFactura(nombre);
        return txt;
    }
}
