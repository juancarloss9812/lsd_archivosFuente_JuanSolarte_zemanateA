/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorDePedidos.dto;

import java.io.Serializable;

/**
 *
 * @author JUAN
 */
public class Factura implements Serializable {

    private float costo_SIN_IVA;
    private float valor_IVA_pedido;
    private float costo_CON_IVA;
    private int cantidad_Ham_grande;
    private int cantidad_Ham_mediana;
    private int cantidad_Ham_pequeno;

    public Factura(float costo_SIN_IVA, float valor_IVA_pedido, float costo_CON_IVA, int cantidad_Ham_grande, int cantidad_Ham_mediana, int cantidad_Ham_pequeno) {
        this.costo_SIN_IVA = costo_SIN_IVA;
        this.valor_IVA_pedido = valor_IVA_pedido;
        this.costo_CON_IVA = costo_CON_IVA;
        this.cantidad_Ham_grande = cantidad_Ham_grande;
        this.cantidad_Ham_mediana = cantidad_Ham_mediana;
        this.cantidad_Ham_pequeno = cantidad_Ham_pequeno;
    }

    public Factura() {
    }

    public float getCosto_SIN_IVA() {
        return costo_SIN_IVA;
    }

    public void setCosto_SIN_IVA(float costo_SIN_IVA) {
        this.costo_SIN_IVA = costo_SIN_IVA;
    }

    public float getValor_IVA_pedido() {
        return valor_IVA_pedido;
    }

    public void setValor_IVA_pedido(float valor_IVA_pedido) {
        this.valor_IVA_pedido = valor_IVA_pedido;
    }

    public float getCosto_CON_IVA() {
        return costo_CON_IVA;
    }

    public void setCosto_CON_IVA(float costo_CON_IVA) {
        this.costo_CON_IVA = costo_CON_IVA;
    }

    public int getCantidad_Ham_grande() {
        return cantidad_Ham_grande;
    }

    public void setCantidad_Ham_grande(int cantidad_Ham_grande) {
        this.cantidad_Ham_grande = cantidad_Ham_grande;
    }

    public int getCantidad_Ham_mediana() {
        return cantidad_Ham_mediana;
    }

    public void setCantidad_Ham_mediana(int cantidad_Ham_mediana) {
        this.cantidad_Ham_mediana = cantidad_Ham_mediana;
    }

    public int getCantidad_Ham_pequeno() {
        return cantidad_Ham_pequeno;
    }

    public void setCantidad_Ham_pequeno(int cantidad_Ham_pequeno) {
        this.cantidad_Ham_pequeno = cantidad_Ham_pequeno;
    }

}
