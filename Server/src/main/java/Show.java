
import java.io.Serializable;


public class Show implements Serializable{
    private String title;
    private String type;
    private String date;
    
    private String seatsLeft;
    public int functionReference;
    public Show(String title, String type, String date, String seatsLeft){
        this.title = title;
        this.type = type;
        this.date = date;
        
        this.seatsLeft = seatsLeft;
    }
    public void setFunctionReference(int i){
        this.functionReference = i;
    }
    
    public int getFunctionReference(){
        return functionReference;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getType(){
        return type;
    }
    
    public String getDate(){
        return date;
    }
    
    public void setSeatsLeft(String s){
        this.seatsLeft = s;
    }
    
    public String getSeatsLeft(){
        return seatsLeft;
    }
    
}
