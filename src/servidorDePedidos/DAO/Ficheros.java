/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorDePedidos.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidorDePedidos.dto.DatosEmpresas;
import servidorDePedidos.dto.Factura;
import servidorDePedidos.sop_rmi.GestionPedidosImpl;

/**
 *
 * @author JUAN
 */
public class Ficheros implements Serializable{

    String ruta="D:\\Ingenieria de Sistemas\\VII SEMESTRE\\Lab Sistemas Distribuidos\\sd_rmi_archivos_fuente_SolarteJ_ZemanateA\\src\\servidorDePedidos\\DAO\\Facturas\\";
    public Ficheros() {
    }
    
    
    public DatosEmpresas darDatosEmpresa(){
        DatosEmpresas objEmpresa = new DatosEmpresas();
        String txt = "";
        try {
            File archivo = new File("D:\\Ingenieria de Sistemas\\VII SEMESTRE\\Lab Sistemas Distribuidos\\sd_rmi_archivos_fuente_SolarteJ_ZemanateA\\src\\servidorDePedidos\\DAO\\DatosEmpresa.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader bf = new BufferedReader(fr);
            String temp = "";
            String bfRead;

            bfRead = bf.readLine();
            objEmpresa.setNombre(bfRead);
            bfRead = bf.readLine();
            objEmpresa.setNit(Integer.parseInt(bfRead));
            bfRead = bf.readLine();
            objEmpresa.setValorIngredienteExtra(Integer.parseInt(bfRead));
            bfRead = bf.readLine();
            objEmpresa.setValorTipoHamburguesaP(Integer.parseInt(bfRead));
            bfRead = bf.readLine();
            objEmpresa.setValorTipoHamburguesaM(Integer.parseInt(bfRead));
            bfRead = bf.readLine();
            objEmpresa.setValorTipoHamburguesaG(Integer.parseInt(bfRead));

            while ((bfRead = bf.readLine()) != null) {
                temp = temp + bfRead; //guardadndo el texto del archivo
            }
            txt = temp;
            System.out.println("texto del txt : " + txt);

            bf.close();

        } catch (Exception e) {
            return null;
        }
        return objEmpresa;
    }
    
    public boolean escrbirFactura(Factura objFactura){
        int numFactura = 0;
        numFactura = darNumFactura(ruta);
        String hambuTipoP = "Hamburguesa de Tipo Pequeño: ";
        String hambuTipoM = "\nHamburguesa de Tipo Mediano: ";
        String hambuTipoG = "\nHamburguesa de Tipo Grande: ";
        String costoS = "\nCosto sin IVA pedido: ";
        String costoI = "\nIVA pedido: ";
        String costoT = "\nCosto con IVA pedido : ";
        ruta = ruta + "Factura" +numFactura + ".txt";
        FileWriter archivo = null;
        try {
            archivo = new FileWriter(ruta);

            archivo.write(hambuTipoP + objFactura.getCantidad_Ham_pequeno()
                    + hambuTipoM + objFactura.getCantidad_Ham_mediana()
                    + hambuTipoG + objFactura.getCantidad_Ham_grande()
                    + costoS + objFactura.getCosto_SIN_IVA()
                    + costoI + objFactura.getValor_IVA_pedido()
                    + costoT + objFactura.getCosto_CON_IVA());
            archivo.close();

        } catch (IOException ex) {
            Logger.getLogger(GestionPedidosImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        ruta="D:\\Ingenieria de Sistemas\\VII SEMESTRE\\Lab Sistemas Distribuidos\\sd_rmi_archivos_fuente_SolarteJ_ZemanateA\\src\\servidorDePedidos\\DAO\\Facturas\\";
        return true;
    }
    
    public int darNumFactura(String ruta) {
        int numFicheros = 0;
        File f = new File(ruta);
        File[] listFiles = f.listFiles();
        for (File file : listFiles) {
            numFicheros++;
        }
        return numFicheros;
    }
    
    public ArrayList<String> getNombreFacturas() {
        ArrayList<String> listaFacturas = new ArrayList<String>();
        int numFicheros = 0;
        String nombres;
        File f = new File(ruta);
        File[] listFiles = f.listFiles();
        for (File file : listFiles) {
            nombres = file.getName();
            System.out.println(nombres);
            listaFacturas.add(nombres);
        }
        
        return listaFacturas;

    }
    
    public String darFactura(String nombreRuta){
            String txt = "";
        try {
            File archivo = new File(ruta+""+nombreRuta);
            FileReader fr = new FileReader(archivo);
            BufferedReader bf = new BufferedReader(fr);
            String temp = "";
            String bfRead;

    
            while ((bfRead = bf.readLine()) != null) {
                temp = temp + bfRead +"\n"; //guardadndo el texto del archivo
            }
            txt = temp;
            
            System.out.println(txt);

            bf.close();

        } catch (Exception e) {
            return null;
        }
      return txt;
    }

    

}
