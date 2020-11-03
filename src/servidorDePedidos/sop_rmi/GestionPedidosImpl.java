/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorDePedidos.sop_rmi;

import servidorDePedidos.dto.DatosEmpresas;
import servidorDePedidos.dto.Pedido;
import servidorDePedidos.dto.Factura;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import cliente.utilidades.UtilidadesRegistroC;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidorDeNotificaciones.dto.HamburguesaNotificacionDTO;
import servidorDeNotificaciones.sop_rmi.NotificacionInt;

/**
 *
 * @author juan
 */
public class GestionPedidosImpl extends UnicastRemoteObject implements GestionPedidosInt {

    private NotificacionInt objReferenciaRemotaNotificacion;

    public GestionPedidosImpl() throws RemoteException {
        super();
    }

    @Override
    public boolean registrarPedidoSistema(Pedido objPedido) throws RemoteException {
        System.out.println("Invovando a registrar pedido");
        servidorDeNotificaciones.dto.Pedido objNotificacion = new servidorDeNotificaciones.dto.Pedido();

        objNotificacion.setMesa(objPedido.getMesa());
        for (int i = 0; i < objPedido.getListaHamburguesas().size(); i++) {
            HamburguesaNotificacionDTO objAux = new HamburguesaNotificacionDTO(objPedido.getListaHamburguesas().get(i).getTipo(), objPedido.getListaHamburguesas().get(i).getCantidadIngredientesExtra());
            objNotificacion.agregarHamburguesa(objAux);
        }
        this.objReferenciaRemotaNotificacion.notificarRegistro(objNotificacion);
        return true;
    }

    public void consultarReferenciaRemotaDeNotificacion(String direccionIpRMIRegistry, int numPuertoRMIRegistry) {
        this.objReferenciaRemotaNotificacion = (NotificacionInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry, numPuertoRMIRegistry, "ObjetoRemotoNotificaciones");
    }

    @Override
    public DatosEmpresas enviarDatosEmpresa() throws RemoteException {

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

                System.out.println("" + bfRead);
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

    @Override
    public boolean registrarFacturaSistema(Factura objFactura) throws RemoteException {

        int numFactura = 0;
        String ruta = "D:\\Ingenieria de Sistemas\\VII SEMESTRE\\Lab Sistemas Distribuidos\\sd_rmi_archivos_fuente_SolarteJ_ZemanateA\\src\\servidorDePedidos\\DAO\\Facturas\\factura";
        numFactura = darNumFactura(ruta);
        String hambuTipoP = "Hamburguesa de Tipo Pequeño: ";
        String hambuTipoM = "\nHamburguesa de Tipo Mediano: ";
        String hambuTipoG = "\nHamburguesa de Tipo Grande: ";
        String costoS = "\nCosto sin IVA pedido: ";
        String costoI = "\nIVA pedido: ";
        String costoT = "\nCosto con IVA pedido : ";
        ruta = ruta + numFactura + ".txt";
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

}
