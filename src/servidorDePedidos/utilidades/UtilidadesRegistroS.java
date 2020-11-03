package servidorDePedidos.utilidades;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class UtilidadesRegistroS {

    public static void arrancarNS(int numPuertoRMI) throws RemoteException {
        try {
            Registry registro = LocateRegistry.getRegistry(numPuertoRMI);
            String[] nombresLigados = registro.list();
            System.out.println("El registro se ha obtenmido y se encentra escuchando en el puerto : " + numPuertoRMI);
            System.out.println("Nombres registrados");
            for (String nombreRegistrado : nombresLigados) {
                System.out.println("nombre : " + nombreRegistrado);
            }
        } catch (RemoteException e) {
            System.out.println("El registro RMI no se localizo en el puerto: " + numPuertoRMI);
            Registry registro = LocateRegistry.createRegistry(numPuertoRMI);
            System.out.println("El registro se ah creado en el puerto: " + numPuertoRMI);
        }
    }

    public static void RegistrarObjetoRemoto(Remote objetoRemoto, String dirIp, int numPuerto, String identificadorObjetoRemoto) {
        String UrlRegistro = "rmi://" + dirIp + ":" + numPuerto + "/" + identificadorObjetoRemoto;
        try {
            Naming.rebind(UrlRegistro, objetoRemoto);
            System.out.println("Se realizo el registro con la direccion  :" + UrlRegistro);
            System.out.println("Esperando Peticiones..");
        } catch (RemoteException e) {
            System.out.println("Error en el registro del objeto remoto");
            e.printStackTrace();
        } catch (MalformedURLException e) {
            System.out.println("Error urlinvalida");
            e.printStackTrace();
        }
    }

}
