//SERVER SIDE
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RmiImplementation extends UnicastRemoteObject implements RmiInterface{
    User us;
    ArrayList<User> users;
    DatabaseConnection dataB;
    Show currentShow;
    public RmiImplementation()throws RemoteException, IOException{
        super();
        dataB= new DatabaseConnection();
        users = new ArrayList<>();
        users.add(new User("1","1","1","1","1",true));
        
    }
    
    @Override
    public String test()throws RemoteException{
        return "Connected";
    }
    

    @Override
    public synchronized  void sign_up(String fu, String ph, String em, String ln, String pa, boolean role) throws RemoteException {
        User us = new User(fu, ph, em, ln, pa, role);
        users.add(us);
        System.out.println(users);
    }
    
    @Override
    public synchronized boolean[] sign_in(String ln, String pa)throws RemoteException {
        //prwti 8esi pinaka gia an einai egegramenos xristis
        //deuteri 8esi pinaka an einai user h admin
        boolean[] login_adminOruser = new boolean[2];//false for user, true for admin
        login_adminOruser[0]=false;
        login_adminOruser[1]=false;
        for(int i=0; i<users.size(); i++){
            if(ln.equals(users.get(i).getUsername())){
                if(pa.equals(users.get(i).getPassword())){
                    login_adminOruser[0]=true;
                    login_adminOruser[1]=users.get(i).getRole();
                    return login_adminOruser;
                }
                
            }
        }
        return login_adminOruser;
    }

    @Override
    public synchronized boolean insertShow(String title, String type, String date, String seatsLeft) throws RemoteException {
        Show newShow = new Show(title, type, date, seatsLeft);
        currentShow = newShow;
        newShow.setFunctionReference(1);
        try {
            dataB.objectOutputStream.writeObject(newShow);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(RmiImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public synchronized  boolean deleteShow(String title, String type) throws RemoteException {
        Show newShow = new Show(title, type, "null", "null");
        newShow.setFunctionReference(2);
        try {
            dataB.objectOutputStream.writeObject(newShow);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(RmiImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;   
    }

    @Override
    public synchronized  boolean insertEvents(String date, String time, String price) throws RemoteException {
        
        Event newEvent = new Event(currentShow.getTitle(), currentShow.getType(), currentShow.getDate(), currentShow.getSeatsLeft(), date, time , price);
        newEvent.setFunctionReference(3);
        try {
            dataB.objectOutputStream.writeObject(newEvent);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(RmiImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
   public synchronized  ArrayList<Event> searchEvents(String title, String type) throws RemoteException,ClassNotFoundException{
       Show newShow = new Show(title, type, "null", "null");
       newShow.setFunctionReference(4);
       ArrayList<Event> list = new ArrayList<Event>();
       try {
           System.out.println("NOT CRASHED2");
            dataB.objectOutputStream.writeObject(newShow);
            System.out.println("NOT CRASHED2");
            
            list=(ArrayList<Event>)dataB.objectInputStream.readObject();
            
            
            System.out.println("NOT CRASHED2");
            return list;
        } catch (IOException ex) {
            Logger.getLogger(RmiImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return list;
   }
   
    @Override
   public synchronized  float orderTickets(String title, String type, String date, String time, String price, int seats) throws RemoteException, IOException, ClassNotFoundException{
       Event event = new Event(title, type, "null", "null", date, time, price);
       event.setFunctionReference(5);
       Order order = new Order(event, seats);
       
       dataB.objectOutputStream.writeObject(order);
       float ticketsPrice = (float)dataB.objectInputStream.readObject();
       return ticketsPrice;
   }
    @Override
   public synchronized  boolean payment(String fullname, String CreditCard)throws RemoteException{
       return true;
   }
   
}
