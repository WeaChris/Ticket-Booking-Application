//SERVER SIDE
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface RmiInterface extends Remote {
     public String test()throws RemoteException;
     public void sign_up(String fu, String ph, String em, String ln, String pa, boolean role)throws RemoteException;
     public boolean[] sign_in(String ln, String pa)throws RemoteException;
     public boolean insertShow(String title, String type, String date, String seatsLeft)throws RemoteException;
     public boolean deleteShow(String title, String type)throws RemoteException;     
     public boolean insertEvents(String date, String time, String price)throws RemoteException;
     public ArrayList<Event> searchEvents(String title, String type)throws RemoteException,ClassNotFoundException;
     public float orderTickets(String title, String type, String date, String time, String price, int seats) throws RemoteException,IOException, ClassNotFoundException;
     public boolean payment(String fullname, String CreditCard)throws RemoteException;
}
