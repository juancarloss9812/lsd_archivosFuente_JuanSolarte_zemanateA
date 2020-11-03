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
public class DatosEmpresas implements Serializable {

    int nit;
    String nombre;
    float valorIngredienteExtra;
    float valorTipoHamburguesaP;
    float valorTipoHamburguesaM;
    float valorTipoHamburguesaG;

    public DatosEmpresas() {
    }

    public DatosEmpresas(int nit, String nombre, float valorIngredienteExtra, float valorTipoHamburguesaP, float valorTipoHamburguesaM, float valorTipoHamburguesaG) {
        this.nit = nit;
        this.nombre = nombre;
        this.valorIngredienteExtra = valorIngredienteExtra;
        this.valorTipoHamburguesaP = valorTipoHamburguesaP;
        this.valorTipoHamburguesaM = valorTipoHamburguesaM;
        this.valorTipoHamburguesaG = valorTipoHamburguesaG;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getValorIngredienteExtra() {
        return valorIngredienteExtra;
    }

    public void setValorIngredienteExtra(float valorIngredienteExtra) {
        this.valorIngredienteExtra = valorIngredienteExtra;
    }

    public float getValorTipoHamburguesaP() {
        return valorTipoHamburguesaP;
    }

    public void setValorTipoHamburguesaP(float valorTipoHamburguesaP) {
        this.valorTipoHamburguesaP = valorTipoHamburguesaP;
    }

    public float getValorTipoHamburguesaM() {
        return valorTipoHamburguesaM;
    }

    public void setValorTipoHamburguesaM(float valorTipoHamburguesaM) {
        this.valorTipoHamburguesaM = valorTipoHamburguesaM;
    }

    public float getValorTipoHamburguesaG() {
        return valorTipoHamburguesaG;
    }

    public void setValorTipoHamburguesaG(float valorTipoHamburguesaG) {
        this.valorTipoHamburguesaG = valorTipoHamburguesaG;
    }

}
