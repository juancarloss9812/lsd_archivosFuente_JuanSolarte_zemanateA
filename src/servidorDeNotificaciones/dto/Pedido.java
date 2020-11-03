/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorDeNotificaciones.dto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author aldair
 */
public class Pedido implements Serializable {

    private ArrayList<HamburguesaNotificacionDTO> listaHamburguesas;
    private String mesa;

    public Pedido() {
        this.listaHamburguesas = new ArrayList();
        this.mesa = "0";
    }

    public void agregarHamburguesa(HamburguesaNotificacionDTO objHamburguesa) {
        this.listaHamburguesas.add(objHamburguesa);
    }

    public ArrayList<HamburguesaNotificacionDTO> getListaHamburguesas() {
        return listaHamburguesas;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

}
