/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.sop_rmi;

import java.rmi.Remote;

/**
 *
 * @author JUAN
 */
public interface GestionFacturasInt extends Remote{
    public void NotificarFactura(String nombreFactura);
    
}
