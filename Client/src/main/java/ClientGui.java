
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ClientGui implements ActionListener{
    ClientConnection client;
    //registration
    JFrame frame1;
    JLabel registration, fullname, phone, email, loginName, password, role;
    Choice ro;
    JTextField fu, ph, em, ln, pa;
     
    JButton submit;
    
    //login
    JFrame frame2;
    JLabel login, username, password2;
    JTextField us, pa2;
    
    JButton logIn;
    
    //loginOrsignup
    JFrame frame3;
    JLabel welcome, haveA, createA;
    JButton have, create;
    
    //mainMenu
    JFrame frame4;
    JPanel firstPanel, topPanel, centerPanel, centerPanel2, centerPanel3;
    JButton insertEvent, deactivateEvent, searchEvents, cancelEvent, logoff, deleteUser;
    //insertShow
    JPanel insertShowP, insertShowEventP, eventInfoP1, eventInfoP2, eventInfoP3;
    JTextField title, type, date, numberOfEvents2, time, price, seatsTotal, seatsLeft;
    JButton addShow, addNumberOfEvents, doneWithEvents;
    HashMap<Integer, ArrayList<Component>> eventHolder;
    //deleteShow
    JPanel deleteShowP;
    JTextField title2, type2;
    JButton deleteShow;
    //ticketOrder
    JPanel ticketOrderP;
    JTextField title3, type3;
    JButton searchTickets;
    //panelForEveryEvent
    HashMap<Integer, ArrayList<JLabel>> userChoice;
    JTextField userEvent, seatsWant;
    JButton chosen;
    //paymentFrame
    JPanel paymentP;
    JTextField payersName, payersCreditCard;
    JButton pay;
    float ticketPrice=0;
    
    public ClientGui(){
        client = new ClientConnection();  
        welcomeFrame();
    }
    
    public void welcomeFrame(){
        frame3 = new JFrame();
        frame3.setVisible(true);
        frame3.setSize(600,300);
        frame3.setLayout(null);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setTitle("WELCOME");
        
        welcome = new JLabel("WELCOME AND ENJOY EXPLORING OUR EVENTS");
        haveA = new JLabel("You already have an account:");
        createA = new JLabel("You dont have an accound:");

        have = new JButton("sign in");
        create = new JButton("Create account");
        have.addActionListener(this);
        create.addActionListener(this);
        
        welcome.setBounds(100, 30, 400, 30);
        haveA.setBounds(80, 70, 200, 30);
        have.setBounds(250, 70, 200, 30);
        createA.setBounds(80, 110, 200, 30);
        create.setBounds(250, 110, 200, 30);
        
        frame3.add(welcome);
        frame3.add(haveA);
        frame3.add(have);
        frame3.add(createA);
        frame3.add(create);
        
        
    }
    
    public void signupFrame(){
        frame1= new JFrame();
        frame1.setVisible(true);
        frame1.setSize(700,700);
        frame1.setLayout(null);
        frame1.setTitle("Registration");
        
        registration = new JLabel("REGISTRATION");
        registration.setForeground(Color.blue);
        registration.setFont(new Font("Serif", Font.BOLD, 20));
        fullname = new JLabel("FULL NAME:");
        phone = new JLabel("PHONE NUMBER:");
        email = new JLabel("EMAIL ADDRESS:");
        loginName = new JLabel("LOGIN NAME:");
        password = new JLabel("PASSWORD:");
        role = new JLabel("USER ROLE -user/admin-:");
        
        fu = new JTextField();
        ph = new JTextField();
        em = new JTextField();
        ln = new JTextField();
        ro = new Choice();
        ro.add("user");
        ro.add("admin");
        pa = new JTextField();
        
        submit=  new JButton("Submit");
        submit.addActionListener(this);
        
        registration.setBounds(100, 30, 400, 30);
        fullname.setBounds(80, 70, 200, 30);
        phone.setBounds(80, 110, 200, 30);
        email.setBounds(80, 150, 200, 30);
        loginName.setBounds(80, 190, 200, 30);
        password.setBounds(80, 230, 200, 30);
        role.setBounds(80, 270, 200, 30);
        fu.setBounds(300, 70, 200, 30);
        ph.setBounds(300, 110, 200, 30);
        em.setBounds(300, 150, 200, 30);
        ln.setBounds(300, 190, 200, 30);
        pa.setBounds(300, 230, 200, 30);
        ro.setBounds(300, 270, 200, 30);
        submit.setBounds(50, 350, 100, 30);
        
        
        frame1.add(registration);
        frame1.add(fullname);
        frame1.add(fu);
        frame1.add(phone);
        frame1.add(ph);
        frame1.add(email);
        frame1.add(em);
        frame1.add(loginName);
        frame1.add(ln);
        frame1.add(password);
        frame1.add(pa);
        frame1.add(role);
        frame1.add(ro);
        frame1.add(submit);
    }
    
    public void signinFrame(){
        frame2= new JFrame();
        frame2.setVisible(true);
        frame2.setSize(700,400);
        frame2.setLayout(null);
        frame2.setTitle("LOG IN");
        
        login = new JLabel("LOGIN");
        login.setForeground(Color.blue);
        login.setFont(new Font("Serif", Font.BOLD, 20));
        username = new JLabel("USERNAME:");
        password2 = new JLabel("PASSWORD:");
        
        us = new JTextField();
        pa2= new JTextField();
        logIn = new JButton("Log in");
        logIn.addActionListener(this);
        
        login.setBounds(100, 30, 400, 30);
        username.setBounds(80, 70, 200, 30);
        us.setBounds(300, 70, 200, 30);
        password2.setBounds(80, 110, 200, 30);
        pa2.setBounds(300, 110, 200, 30);
        logIn.setBounds(150, 160, 100, 30);
        
        frame2.add(login);
        frame2.add(username);
        frame2.add(us);
        frame2.add(password2);
        frame2.add(pa2);
        frame2.add(logIn);
    }
    
    public void mainMenuFrameUser(){
        frame4 = new JFrame();
        firstPanel = new JPanel(new BorderLayout());
        topPanel = new JPanel();
        centerPanel = new JPanel(new FlowLayout());
        centerPanel2 = new JPanel();
        centerPanel3 = new JPanel();
        BoxLayout centerPanelLayout = new BoxLayout(centerPanel2, BoxLayout.Y_AXIS);
        centerPanel2.setLayout(centerPanelLayout);
        BoxLayout centerPanelLayout2 = new BoxLayout(centerPanel3, BoxLayout.Y_AXIS);
        centerPanel3.setLayout(centerPanelLayout2);
        
        
        welcome = new JLabel("MAIN MENU");
        welcome.setForeground(Color.blue);
        welcome.setFont(new Font("Serif", Font.BOLD, 30));
        
        
        searchEvents = new JButton("here");
        cancelEvent = new JButton("here");
        logoff = new JButton("here");
        deleteUser = new JButton("here");
        
        
        searchEvents.addActionListener(this);
        cancelEvent.addActionListener(this);
        logoff.addActionListener(this);
        deleteUser.addActionListener(this);
        centerPanel2.add(Box.createRigidArea(new Dimension(0,4)));
        centerPanel2.add(new JLabel("To search a running event press :"));
        centerPanel2.add(Box.createRigidArea(new Dimension(0,15)));
        centerPanel2.add(new JLabel("To cancel an event press :"));
        centerPanel2.add(Box.createRigidArea(new Dimension(0,15)));
        centerPanel2.add(new JLabel("To log off press :"));
        centerPanel2.add(Box.createRigidArea(new Dimension(0,12)));
        centerPanel2.add(new JLabel("To delete your this user and log off press :"));
        
        
        centerPanel3.add(searchEvents);
        centerPanel3.add(cancelEvent);
        centerPanel3.add(logoff);
        centerPanel3.add(deleteUser);
        
        topPanel.add(welcome);
        centerPanel.add(centerPanel2);
        centerPanel.add(centerPanel3);
        firstPanel.add(topPanel, BorderLayout.PAGE_START);
        firstPanel.add(centerPanel, BorderLayout.CENTER);
        
        frame4.add(firstPanel);
        frame4.setVisible(true);
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.setTitle("MAIN MENU");
        frame4.setSize(500, 300);
    }
    
    public void mainMenuFrameAdmin(){
        frame4 = new JFrame();
        firstPanel = new JPanel(new BorderLayout());
        topPanel = new JPanel();
        centerPanel = new JPanel(new FlowLayout());
        centerPanel2 = new JPanel();
        centerPanel3 = new JPanel();
        BoxLayout centerPanelLayout = new BoxLayout(centerPanel2, BoxLayout.Y_AXIS);
        centerPanel2.setLayout(centerPanelLayout);
        BoxLayout centerPanelLayout2 = new BoxLayout(centerPanel3, BoxLayout.Y_AXIS);
        centerPanel3.setLayout(centerPanelLayout2);
        
        welcome = new JLabel("MAIN MENU");
        welcome.setForeground(Color.blue);
        welcome.setFont(new Font("Serif", Font.BOLD, 30));
        insertEvent = new JButton("here");
        deactivateEvent = new JButton("here");
        searchEvents = new JButton("here");
        cancelEvent = new JButton("here");
        logoff = new JButton("here");
        deleteUser = new JButton("here");
        insertEvent.addActionListener(this);
        deactivateEvent.addActionListener(this);
        searchEvents.addActionListener(this);
        cancelEvent.addActionListener(this);
        logoff.addActionListener(this);
        deleteUser.addActionListener(this);
        centerPanel2.add(Box.createRigidArea(new Dimension(0,6)));
        centerPanel2.add(new JLabel("To insert a new event press :"));
        centerPanel2.add(Box.createRigidArea(new Dimension(0,10)));
        centerPanel2.add(new JLabel("To deactivate an event press :"));
        centerPanel2.add(Box.createRigidArea(new Dimension(0,10)));
        centerPanel2.add(new JLabel("To search a running event press :"));
        centerPanel2.add(Box.createRigidArea(new Dimension(0,10)));
        centerPanel2.add(new JLabel("To cancel an event press :"));
        centerPanel2.add(Box.createRigidArea(new Dimension(0,10)));
        centerPanel2.add(new JLabel("To log off press :"));
        centerPanel2.add(Box.createRigidArea(new Dimension(0,10)));
        centerPanel2.add(new JLabel("To delete your this user and log off press :"));
        centerPanel2.add(Box.createRigidArea(new Dimension(0,10)));
        
        centerPanel3.add(insertEvent);
        centerPanel3.add(deactivateEvent);
        centerPanel3.add(searchEvents);
        centerPanel3.add(cancelEvent);
        centerPanel3.add(logoff);
        centerPanel3.add(deleteUser);
        
        topPanel.add(welcome);
        centerPanel.add(centerPanel2);
        centerPanel.add(centerPanel3);
        firstPanel.add(topPanel, BorderLayout.PAGE_START);
        firstPanel.add(centerPanel, BorderLayout.CENTER);
        
        frame4.add(firstPanel);
        frame4.setVisible(true);
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.setTitle("MAIN MENU");
        frame4.pack();
    }
    
    public void insertShowFrame(){
        insertShowP = new JPanel();
        BoxLayout insertShowPLayout = new BoxLayout(insertShowP, BoxLayout.Y_AXIS);
        insertShowP.setLayout(insertShowPLayout);
        title = new JTextField(20);
        type = new JTextField(20);
        date = new JTextField(20);
        
        seatsTotal = new JTextField(20);
        addShow = new JButton("ADD SHOW");
        addShow.addActionListener(this);
        
        insertShowP.add(new JLabel("Fill the following information : "));
        insertShowP.add(new JLabel("Title of the show"));
        insertShowP.add(title);
        insertShowP.add(new JLabel("Type of the show"));
        insertShowP.add(type);
        insertShowP.add(new JLabel("Date of the show"));
        insertShowP.add(date);
        insertShowP.add(new JLabel("Total seats for the show"));
        insertShowP.add(seatsTotal);
        
        insertShowP.add(addShow);
        
        firstPanel.add(insertShowP, BorderLayout.EAST);
        
        firstPanel.repaint();
        firstPanel.validate();
        firstPanel.revalidate();
        
        frame4.validate();
        frame4.revalidate();
        frame4.repaint();
        frame4.pack();
    }
    public void insertShowEventFrame(){
        insertShowEventP = new JPanel();
        BoxLayout insertShowEventPLayout = new BoxLayout(insertShowEventP, BoxLayout.Y_AXIS);
        insertShowEventP.setLayout(insertShowEventPLayout);
        numberOfEvents2 = new JTextField(20);
        addNumberOfEvents = new JButton("OK");
        addNumberOfEvents.addActionListener(this);
        insertShowEventP.add(new JLabel("How many Events will the show you added hosts"));
        insertShowEventP.add(new JLabel("Type the number and press OK"));
        insertShowEventP.add(numberOfEvents2);
        insertShowEventP.add(addNumberOfEvents);
        
        firstPanel.add(insertShowEventP, BorderLayout.EAST);
        
        firstPanel.repaint();
        firstPanel.validate();
        firstPanel.revalidate();
        
        frame4.validate();
        frame4.revalidate();
        frame4.repaint();
        frame4.pack();
        
    }
    
    public void eventsInfoFrame(int numberOfEvents){
        eventHolder = new HashMap<Integer, ArrayList<Component>>();
        ArrayList<Component> listC;
        ArrayList<JPanel> listP = new ArrayList<JPanel>();
        listC = new ArrayList<Component>();
            listC.add(new JLabel("date of the event"));
            listC.add(new JTextField(20));
            listC.add(new JLabel("time of the event"));
            listC.add(new JTextField(20));
            listC.add(new JLabel("price of the event"));
            listC.add(new JTextField(20));
        eventInfoP1 = new JPanel();
        BoxLayout eventInfoP1Layout = new BoxLayout(eventInfoP1, BoxLayout.Y_AXIS);
        eventInfoP1.setLayout(eventInfoP1Layout);
        doneWithEvents = new JButton("DONE");
        doneWithEvents.addActionListener(this);
        
        for(int i=0; i<numberOfEvents; i++){
            eventHolder.put(i, listC);
            listP.add(new JPanel());
        }
        System.out.println(eventHolder.keySet());
        System.out.println(listP);
        for(int i=0; i<numberOfEvents; i++){
            BoxLayout eventInfoP2Layout = new BoxLayout(listP.get(i), BoxLayout.Y_AXIS);
            listP.get(i).setLayout(eventInfoP2Layout);
            listP.get(i).add(new JLabel("Event number :"+(i+1)));
            listP.get(i).add(eventHolder.get(i).get(0));
            listP.get(i).add(eventHolder.get(i).get(1));
            listP.get(i).add(eventHolder.get(i).get(2));
            listP.get(i).add(eventHolder.get(i).get(3));
            listP.get(i).add(eventHolder.get(i).get(4));
            listP.get(i).add(eventHolder.get(i).get(5));
            eventInfoP1.add(listP.get(i));
        }
        eventInfoP1.add(doneWithEvents);
        firstPanel.add(eventInfoP1, BorderLayout.EAST);
        
        firstPanel.repaint();
        firstPanel.validate();
        firstPanel.revalidate();
        
        frame4.validate();
        frame4.revalidate();
        frame4.repaint();
        frame4.pack();
        
    }
    
    public void deleteShowFrame(){
        deleteShowP = new JPanel();
        BoxLayout deleteShowPPLayout = new BoxLayout(deleteShowP, BoxLayout.Y_AXIS);
        deleteShowP.setLayout(deleteShowPPLayout);
        title2 = new JTextField(20);
        type2 = new JTextField(20);
        deleteShow = new JButton("DELETE SHOW");
        deleteShow.addActionListener(this);
        
        deleteShowP.add(new JLabel("Fill the following information : "));
        deleteShowP.add(new JLabel("Title of the show you want to delete"));
        deleteShowP.add(title2);
        deleteShowP.add(new JLabel("Type of the show delete"));
        deleteShowP.add(type2);
        deleteShowP.add(new JLabel("Before you press delete button be aware that if the show exists, will be deleted immediately"));
        deleteShowP.add(deleteShow);
        
        firstPanel.add(deleteShowP, BorderLayout.EAST);
        
        firstPanel.repaint();
        firstPanel.validate();
        firstPanel.revalidate();
        
        frame4.validate();
        frame4.revalidate();
        frame4.repaint();
        frame4.pack();
    }
    
    public void ticketOrderFrame(){
        ticketOrderP = new JPanel();
        BoxLayout ticketOrderPLayout = new BoxLayout(ticketOrderP, BoxLayout.Y_AXIS);
        ticketOrderP.setLayout(ticketOrderPLayout);
        
        title3 = new JTextField(20);
        type3= new JTextField(20);
        searchTickets = new JButton("SEARCH SHOW");
        searchTickets.addActionListener(this);
        
        ticketOrderP.add(new JLabel("Fill the following information : "));
        ticketOrderP.add(new JLabel("Title of the show you want to search"));
        ticketOrderP.add(title3);
        ticketOrderP.add(new JLabel("Type of the show you want to search"));
        ticketOrderP.add(type3);
        ticketOrderP.add(new JLabel("Press the search button and all available shows will show up"));
        ticketOrderP.add(searchTickets);
        
        firstPanel.add(ticketOrderP, BorderLayout.EAST);
        
        firstPanel.repaint();
        firstPanel.validate();
        firstPanel.revalidate();
        
        frame4.validate();
        frame4.revalidate();
        frame4.repaint();
        frame4.pack();
    }
    
    public void panelForEveryEvent(int i, String date, String time, String price, String seatsLeft){
        JPanel mainP = new JPanel(new FlowLayout());
        JPanel panel1 = new JPanel();
        BoxLayout panel1Layout = new BoxLayout(panel1, BoxLayout.Y_AXIS);
        panel1.setLayout(panel1Layout);
        JPanel panel2 = new JPanel();
        BoxLayout panel2Layout = new BoxLayout(panel2, BoxLayout.Y_AXIS);
        panel2.setLayout(panel2Layout);
        ArrayList<JLabel> labellist = new ArrayList<JLabel>();
        panel1.add(new JLabel("Event number :"+(i+1)));
        panel1.add(new JLabel("Date of event :"));
        panel1.add(new JLabel("Time of event :"));
        panel1.add(new JLabel("Price of event :"));
        panel1.add(new JLabel("Seats left for the event :"));
        
         panel2.add(new JLabel("    "));
        panel2.add(new JLabel(date));
        panel2.add(new JLabel(time));
        panel2.add(new JLabel(price));
        panel2.add(new JLabel(seatsLeft));
        
        labellist.add(new JLabel(date));
        labellist.add(new JLabel(time));
        labellist.add(new JLabel(price));
        labellist.add(new JLabel(seatsLeft));
        userChoice.put(i+1, labellist);
        mainP.add(panel1);
        mainP.add(panel2);
        
        ticketOrderP.add(mainP);
        
        ticketOrderP.revalidate();
        ticketOrderP.validate();
        ticketOrderP.repaint();
        
        firstPanel.revalidate();
        firstPanel.validate();
        firstPanel.repaint();
        
        frame4.validate();
        frame4.revalidate();
        frame4.repaint();
        frame4.pack();
    }
    
    public void usersChoiceOfEvent(){
        JPanel mainP = new JPanel();
        BoxLayout mainPLayout = new BoxLayout(mainP, BoxLayout.Y_AXIS);
        mainP.setLayout(mainPLayout);
        
        userEvent = new JTextField(20);
        seatsWant = new JTextField(20);
        chosen = new JButton("OK");
        chosen.addActionListener(this);
        
        mainP.add(new JLabel("When you decide what a event you want"));
        mainP.add(new JLabel("please enter the number of the event you chose"));
        mainP.add(userEvent);
        mainP.add(new JLabel("please enter the number of seats you want"));
        mainP.add(seatsWant);
        mainP.add(chosen);
        
        ticketOrderP.add(mainP);
        
        ticketOrderP.revalidate();
        ticketOrderP.validate();
        ticketOrderP.repaint();
        
        firstPanel.revalidate();
        firstPanel.validate();
        firstPanel.repaint();
        
        frame4.validate();
        frame4.revalidate();
        frame4.repaint();
        frame4.pack();
    }
    
    public void paymentFrame(){
        paymentP = new JPanel();
        BoxLayout paymentPLayout = new BoxLayout(paymentP, BoxLayout.Y_AXIS);
        paymentP.setLayout(paymentPLayout);
        payersName= new JTextField(20);
        payersCreditCard = new JTextField(20);
        pay = new JButton("PAY");
        pay.addActionListener(this);
        
        paymentP.add(new JLabel("Your order's price is: "+ticketPrice));
        paymentP.add(new JLabel("If you want to procceed please fill the following information "));
        paymentP.add(new JLabel("Full name"));
        paymentP.add(payersName);
        paymentP.add(new JLabel("Credit Card"));
        paymentP.add(payersCreditCard);
        paymentP.add(pay);
        
        firstPanel.add(paymentP, BorderLayout.EAST);
        
        firstPanel.revalidate();
        firstPanel.validate();
        firstPanel.repaint();
        
        frame4.validate();
        frame4.revalidate();
        frame4.repaint();
        frame4.pack();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==create){
            signupFrame();
        }else if(e.getSource()==have){
            signinFrame();
        }else if(e.getSource()==submit){
            boolean role= false;
            if(ro.getSelectedItem().equals("user")){
                role= false;
            }else if(ro.getSelectedItem().equals("admin")){
                role=true;
            }
            System.out.println(role);
            try {
                client.rmi.sign_up(fu.getText(), ph.getText(), em.getText(), ln.getText(), pa.getText(), role);
            } catch (RemoteException ex) {
                Logger.getLogger(ClientGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource()==logIn){
            boolean[] b1;
            try {
                b1 =client.rmi.sign_in(us.getText(), pa2.getText());
                System.out.println(b1.toString());
                
                if(b1[0]){
                    if(b1[1]){
                        mainMenuFrameAdmin();
                    }else{
                        mainMenuFrameUser();
                    }
                }else{
                    JLabel fail = new JLabel("NOT REGISTERED");
                    fail.setBounds(150, 190, 100, 30);
                    frame2.add(fail);
                    frame2.validate();
                    frame2.revalidate();
                    frame2.repaint();
                }
            } catch (RemoteException ex) {
                Logger.getLogger(ClientGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource()==insertEvent){
            insertShowFrame();
        }
        else if(e.getSource()==deactivateEvent){
            deleteShowFrame();
        }
        else if(e.getSource()==searchEvents){
            ticketOrderFrame();
        }else if(e.getSource()==cancelEvent){
            
        }else if(e.getSource()==logoff){
            
        }else if(e.getSource()==deleteUser){
            
        }else if(e.getSource()==addShow){
            try {
                boolean succeed=false;
                succeed=client.rmi.insertShow(title.getText(), type.getText(), date.getText(), seatsTotal.getText());
                if(succeed){
                    firstPanel.remove(insertShowP);
                    insertShowEventFrame();
                    firstPanel.repaint();
                    firstPanel.validate();
                    firstPanel.revalidate();

                    frame4.validate();
                    frame4.revalidate();
                    frame4.repaint();
                    frame4.pack();
                }else{
                    insertShowP.add(new JLabel("FAILED"));
                    
                    insertShowP.validate();
                    insertShowP.revalidate();
                    insertShowP.repaint();
                    
                    firstPanel.validate();
                    firstPanel.revalidate();
                    firstPanel.repaint();

                    frame4.validate();
                    frame4.revalidate();
                    frame4.repaint();
                    frame4.pack();
                }
            } catch (RemoteException ex) {
                Logger.getLogger(ClientGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource()==deleteShow){
            
            try {
                boolean succeed=false;
                succeed=client.rmi.deleteShow(title2.getText(), type2.getText());
                if(succeed){
                    firstPanel.remove(deleteShowP);
                    
                    firstPanel.repaint();
                    firstPanel.validate();
                    firstPanel.revalidate();

                    frame4.validate();
                    frame4.revalidate();
                    frame4.repaint();
                    frame4.pack();
                }else{
                    deleteShowP.add(new JLabel("FAILED"));
                    
                    deleteShowP.validate();
                    deleteShowP.revalidate();
                    deleteShowP.repaint();
                    
                    firstPanel.validate();
                    firstPanel.revalidate();
                    firstPanel.repaint();

                    frame4.validate();
                    frame4.revalidate();
                    frame4.repaint();
                    frame4.pack();
                }
            } catch (RemoteException ex) {
                Logger.getLogger(ClientGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource()==searchTickets){
                ArrayList<Event> list;
            try {
                System.out.println("NOT CRASHED");
                list=client.rmi.searchEvents(title3.getText(), type3.getText());
                System.out.println("NOT CRASHED");
                if(!list.isEmpty()){
                    userChoice = new HashMap<Integer, ArrayList<JLabel>>();
                    System.out.println("NOT CRASHED");
                    for(int i=0; i<list.size(); i++){
                        System.out.println("NOT CRASHED");
                        panelForEveryEvent(i,list.get(i).getDate2(), list.get(i).getTime(),list.get(i).getPrice(), list.get(i).getSeatsLeft());
                    }
                    usersChoiceOfEvent();
                    System.out.println("NOT CRASHED");
                }
            } catch (RemoteException ex) {
                Logger.getLogger(ClientGui.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClientGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource()==addNumberOfEvents){
            firstPanel.remove(insertShowEventP);
            System.out.println(Integer.parseInt(numberOfEvents2.getText()));
            eventsInfoFrame(Integer.parseInt(numberOfEvents2.getText()));
        }else if(e.getSource()==doneWithEvents){
            boolean succeed=false;
            JTextField f = (JTextField)eventHolder.get(0).get(1);
            JTextField f2 = (JTextField)eventHolder.get(0).get(3);
            JTextField f3= (JTextField)eventHolder.get(0).get(5);
            try {
                succeed=client.rmi.insertEvents(f.getText(), f2.getText(), f3.getText());
                if(succeed){
                    firstPanel.remove(eventInfoP1);
                    
                    firstPanel.repaint();
                    firstPanel.validate();
                    firstPanel.revalidate();

                    frame4.validate();
                    frame4.revalidate();
                    frame4.repaint();
                    frame4.pack();
                }else{
                    eventInfoP1.add(new JLabel("FAILED"));
                    
                    eventInfoP1.validate();
                    eventInfoP1.revalidate();
                    eventInfoP1.repaint();
                    
                    firstPanel.validate();
                    firstPanel.revalidate();
                    firstPanel.repaint();

                    frame4.validate();
                    frame4.revalidate();
                    frame4.repaint();
                    frame4.pack();
                }
            } catch (RemoteException ex) {
                Logger.getLogger(ClientGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource()==chosen){
            String date2 =userChoice.get(Integer.parseInt(userEvent.getText())).get(0).getText();
            String time2= userChoice.get(Integer.parseInt(userEvent.getText())).get(1).getText();
            String price2= userChoice.get(Integer.parseInt(userEvent.getText())).get(2).getText();
            int seatsLeft2 = Integer.parseInt(userChoice.get(Integer.parseInt(userEvent.getText())).get(3).getText());
            
            try {
                ticketPrice=client.rmi.orderTickets(title3.getText(),type3.getText(), date2, time2, price2, seatsLeft2);
            } catch (IOException ex) {
                Logger.getLogger(ClientGui.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClientGui.class.getName()).log(Level.SEVERE, null, ex);
            }
            firstPanel.remove(ticketOrderP);
            paymentFrame();
            
        }else if(e.getSource()==pay){
            boolean succeed=false;
            try {
                succeed=client.rmi.payment(payersName.getText(), payersCreditCard.getText());
                
                if(succeed){
                    firstPanel.remove(paymentP);
                    firstPanel.validate();
                    firstPanel.revalidate();
                    firstPanel.repaint();

                    frame4.validate();
                    frame4.revalidate();
                    frame4.repaint();
                    frame4.pack();
                }else{
                    
                }
            } catch (RemoteException ex) {
                Logger.getLogger(ClientGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
