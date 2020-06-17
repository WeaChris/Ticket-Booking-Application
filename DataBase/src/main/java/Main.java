
import java.io.IOException;

//DATABASE SIDE
public class Main {

    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatabaseUtility start = new DatabaseUtility();
        while(true){
            String s="";
            
            while(s.equals("")){
                s=start.theChecker();
            }
            start.loopHole(s);
        }
        
    }
    
}
