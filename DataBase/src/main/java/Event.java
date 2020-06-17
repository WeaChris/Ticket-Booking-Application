
import java.io.Serializable;


public class Event extends Show implements Serializable{
    private String date;
    private String time;
    private String price;
    public Event(String title, String type, String date, String seatsLeft, String date2, String time, String price) {
        super(title, type, date, seatsLeft);
        this.date=date2;
        this.time=time;
        this.price=price;
    }
    
    public String getDate2(){
        return date;
    }
    
    public String getTime(){
        return date;
    }
    
    public String getPrice(){
        return date;
    }
    public void setFunctionReference(int i){
        this.functionReference = i;
    }
    public String getSeatsLeft(){
        return super.getSeatsLeft();
    }
    public void setSeatsLeft(String s){
        super.setSeatsLeft(s);
    }
}
