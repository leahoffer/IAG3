package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class Server {

    public Server() {
        iniciar();
    }

    public static void main(String[] args) {
        new Server();
    }

    public void iniciar() {
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);

           	//SistemaLogisticaRemote logisticaremote = new SistemaLogisticaRemoteImpl();
            

            //Naming.bind("//localhost:1099/SistemaLogisticaRemote", SistemaLogisticaRemote);
           

            System.out.println("Servicios registrados exitosamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
