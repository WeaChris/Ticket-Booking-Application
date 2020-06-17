
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerConnection {
    ServerSocket ss ;
    Socket soc ;
    
    ObjectInputStream objectInputStream;
    ObjectOutputStream objectOutputStream;
    public ServerConnection() throws IOException{
        connecting();
    }
    
    public void connecting() throws IOException{
        System.out.println("Waiting for Server ...");
            ss = new ServerSocket(2225);
            soc = ss.accept();
            System.out.println("Connection Established");
            

            objectInputStream = new ObjectInputStream(soc.getInputStream());
            objectOutputStream = new ObjectOutputStream(soc.getOutputStream());
    }
}
