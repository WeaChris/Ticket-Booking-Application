
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class ClientConnection {
    public ClientConnection(){
        connecting();
    }
    
    public void connecting(){
        try{
            Registry reg = LocateRegistry.createRegistry(1099);
            RmiImplementation rmi= new RmiImplementation();
            reg.rebind("project", rmi);
            
            System.out.println("Server is ready..");
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
