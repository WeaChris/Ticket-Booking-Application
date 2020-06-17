
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class ClientConnection {
    RmiInterface rmi;
    public ClientConnection(){
        connectToServer();
    }
    public void connectToServer(){
        try{
            Registry myReg = LocateRegistry.getRegistry("localhost", 1099);
            rmi = (RmiInterface)myReg.lookup("project");
            System.out.println(rmi.test());
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
