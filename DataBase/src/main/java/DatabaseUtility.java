
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


public class DatabaseUtility {
    ServerConnection server;
    ArrayList<Show> showList;
    Object obj;
    HashMap<Show, ArrayList<Event>> data;
    public DatabaseUtility() throws IOException{
        server = new ServerConnection();
        showList = new ArrayList<Show>();
        showList.add(new Show("test", "test", "test", "test"));
        data = new HashMap<Show, ArrayList<Event>>();
    }
    public String theChecker() throws IOException, ClassNotFoundException{
        obj = (Object)server.objectInputStream.readObject();
        return obj.getClass().getSimpleName();
    }
    public void loopHole(String checker) throws IOException, ClassNotFoundException{
            if(checker.equals("Show")){
                showActivities();
            
            }else if(checker.equals("Event")){
                eventActivities();
            }else if(checker.equals("Order")){
                orderActivities();
            }
    }
    public void showActivities() throws IOException, ClassNotFoundException{
        Show currentShowObject=(Show)obj;
        
        if(currentShowObject.getFunctionReference()==1){
            saveNewShow(currentShowObject);
        }else if(currentShowObject.getFunctionReference()==2){
            deleteShow(currentShowObject);
        }
        else if(currentShowObject.getFunctionReference()==4){
            server.objectOutputStream.writeObject(returnEvents(currentShowObject));
        }
    }
    public void eventActivities() throws IOException, ClassNotFoundException{
        Event currentEventObject=(Event)obj;
        
        if(currentEventObject.getFunctionReference()==3){
            saveNewEvents(currentEventObject);
        }else if(currentEventObject.getFunctionReference()==6){
            
        }
    }
    
    public void orderActivities() throws IOException{
        Order currentOrderObject =(Order)obj;
        
        if(currentOrderObject.getEvent().getFunctionReference()==5){
            server.objectOutputStream.writeObject(ticketsPrice(currentOrderObject));
        }
    }
    public Show searchForShow(Show show){
        Set<Show> set = data.keySet();
        
        for(Show temp: set){
            if(temp.getTitle().equals(show.getTitle())){
                if(temp.getType().equals(show.getType())){
                    return temp;
                }
            }
        }
        return null;
    }
    
    public void saveNewShow(Show show) throws IOException, ClassNotFoundException{
        showList.add(show);
        data.put(show, new ArrayList<Event>());
        System.out.println(showList);
    }
    public void saveNewEvents(Event event){
         Show show = new Show(event.getTitle(), event.getType(), "null", "null");
         System.out.println(show);
         show=searchForShow(show);
         System.out.println(show);
         
         data.get(show).add(event);
         System.out.println(data.get(show));
    }
    public void deleteShow(Show show){
        System.out.println(data);
        show=searchForShow(show);
        data.remove(show);
        System.out.println(data);
    }
    
    public ArrayList<Event> returnEvents(Show show){
        System.out.println("NOT CRASHED3");
        show=searchForShow(show);
        System.out.println(show);
        System.out.println(data);
        System.out.println("NOT CRASHED3");
        System.out.println(data.get(show));
        return data.get(show);
    }
    
    public float ticketsPrice(Order order){
        Show show = new Show(order.getEvent().getTitle(), order.getEvent().getType(), "null", "null");
        System.out.println(show);
        show=searchForShow(show);
        float price=0;
        for(int i=0; i<data.get(show).size(); i++){
            if(data.get(show).get(i).getDate2().equals(order.getEvent().getDate2())){
                if(data.get(show).get(i).getTime().equals(order.getEvent().getTime())){
                    if(data.get(show).get(i).getPrice().equals(order.getEvent().getPrice())){
                        price= Integer.parseInt(order.getEvent().getPrice()) *order.getSeatsWanted();
                    }
                }
            }
            
        }
        System.out.println(price);
        return price;
    }

}
