
import java.io.Serializable;


public class Order implements Serializable{
    private Event event;
    private int seatsWanted;
    
    public Order(Event event, int seatsWanted){
        this.event= event;
        this.seatsWanted=seatsWanted;
    }
    
    public Event getEvent(){
        return event;
    }
    
    public int getSeatsWanted(){
        return seatsWanted;
    }
}
