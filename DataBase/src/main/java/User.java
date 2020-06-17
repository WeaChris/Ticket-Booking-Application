
import java.io.Serializable;


public class User implements Serializable{
    private String fullname;
    private String phone;
    private String email;
    private String username;
    private String password;
    private boolean role;
    
    public User(String fullname, String phone, String email, String username, String password, boolean role){
        this.fullname=fullname;
        this.phone=phone;
        this.email=email;
        this.username=username;
        this.password=password;
        this.role=role;
    }
    
    @Override
    public String toString(){
        return fullname+"   "+phone+"   "+email+"   "+username+"    "+password+"   "+role;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public boolean getRole(){
        return role;
    }
}
