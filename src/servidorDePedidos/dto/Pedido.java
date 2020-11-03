/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorDePedidos.dto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author aldair
 */
public class Pedido implements Serializable {

    private ArrayList<HamburguesaPedidoDTO> listaHamburguesas;
    private String mesa;
    private float IVA;
    private float monto;

    public Pedido() {
        this.mesa = "";
        this.listaHamburguesas = new ArrayList();
    }

    public float getIVA() {
        return IVA;
    }

    public void setIVA(float IVA) {
        this.IVA = IVA;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public void agregarHamburguesa(HamburguesaPedidoDTO objHamburguesa) {
        this.listaHamburguesas.add(objHamburguesa);
    }

    public void editarHamburguesa(HamburguesaPedidoDTO objHamburguesa, String identificador) {
        for (int i = 0; i < listaHamburguesas.size(); i++) {
            if (listaHamburguesas.get(i).getIdentificador().equals(identificador)) {
                listaHamburguesas.get(i).setTipo(objHamburguesa.getTipo());
                listaHamburguesas.get(i).setIdentificador(objHamburguesa.getIdentificador());
                listaHamburguesas.get(i).setCosto(objHamburguesa.getCosto());
                listaHamburguesas.get(i).setCantidadIngredientesExtra(objHamburguesa.getCantidadIngredientesExtra());
            }
        }
    }

    public ArrayList<HamburguesaPedidoDTO> getListaHamburguesas() {
        return listaHamburguesas;
    }

    public void vaciarLista() {
        listaHamburguesas.clear();
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

}
