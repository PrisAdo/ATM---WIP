import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.lang.reflect.Array; 


public class MainClass {
    public static void main(String[] args) throws Exception{
        /*
        1.login
        2.create new user
        3.change password
        */
        int option;
        
        //prompt user to pick option
        
        switch(option){
            case 1: 
                login();
                //option to deposit or withdraw
                break;
            case 2:
                CustomerClass newCustomer = new CustomerClass();
                newCustomer.CreateUN();
                
        }
        
    }
    
    public static void login() throws Exception{
        boolean Access=false;                                           //deny or allow access into bank account
                                                                        //Get username and password from user
        String UN_Input = null, PW_Input = null;
        double UserBalance=0;
        
        JFrame frame= new JFrame();
        MainClass obj = new MainClass();
        String[] logininfo = new String[2];                              //Array that will hold in login in info entered by user   
        logininfo=obj.login(frame); //need to use clown method here      //calling dialouge box
                                                                         //returns username and password
                                                                   
        UN_Input=String.valueOf(Array.get(logininfo, 0));                //convert Object to String
        PW_Input=String.valueOf(Array.get(logininfo, 1));
        
        File file = new File("Credentials.txt");                         //CHECKING CREDIANTALS FILE FOR CORRECT USERNAME AND PASSWORD
        LineNumberReader in = new LineNumberReader (new FileReader(file));
        
        String currline = null;
        int counter = 0;
       
        while((currline = in.readLine())!= null && Access==false){
            counter++;
            if ((in.getLineNumber()-1) % 3 == 0 && currline.equals(UN_Input)) {  //subtractine 1 since, getLine Number starts at 1 and can only dived evenely by 3 in notepad (1,4,7) to (0,3,6)
                
                if ((currline = in.readLine()).equals(PW_Input)){
                    counter++;
                    UserBalance=Double.parseDouble(in.readLine());          //string to double
                    Access=true;
                }
                else{
                    counter+=1;
                    //in.setLineNumber(counter);     //jump to right before next username                   
                }
            }
            else{
                counter+=2;
                //in.setLineNumber(counter+3);        //jump to right before next next username
            }
            
            for(;in.getLineNumber()<counter;){
                in.readLine();                        //read lines until right before user name
            }
        }
        
        System.out.println("Complete.");
    }
   
    
    public String[] login(JFrame frame) {                  //dialouge box
            String[] LoginInfo= new String[]{null,null};

            JPanel panel = new JPanel(new BorderLayout(5, 5));

            JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
            label.add(new JLabel("Username", SwingConstants.RIGHT));
            label.add(new JLabel("Password", SwingConstants.RIGHT));
            panel.add(label, BorderLayout.WEST);

            JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
            JTextField username = new JTextField();
            controls.add(username);
            JPasswordField password = new JPasswordField();
            controls.add(password);
            panel.add(controls, BorderLayout.CENTER);
            
            //JOptionPane.showMessageDialog(frame, panel, "login", JOptionPane.QUESTION_MESSAGE);
            JOptionPane.showConfirmDialog(frame, panel, "login", JOptionPane.OK_CANCEL_OPTION);
            frame.dispose(); //dispose frame after closing window
            
            Array.set(LoginInfo, 0, username.getText());
            Array.set(LoginInfo, 1, String.valueOf(password.getPassword()));
           
            
            return LoginInfo;
    }
    
    
    
    
       
}
