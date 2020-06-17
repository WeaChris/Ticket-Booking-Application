
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class DatabaseConnection {
    
    Socket soc ;
    
    ObjectInputStream objectInputStream;
    ObjectOutputStream objectOutputStream;
    
    public DatabaseConnection() throws IOException{
        connecting();
    }
    
    public void connecting() throws IOException{
        System.out.println("Attempting Connection");
        
        soc = new Socket("localhost", 2225);
        
        System.out.println("Connection Succeed");

        objectOutputStream = new ObjectOutputStream(soc.getOutputStream());
        objectInputStream = new ObjectInputStream(soc.getInputStream());
    }
}
