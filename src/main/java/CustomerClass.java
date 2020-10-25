import java.util.*;
import java.io.*;
/**
 *
 * @author IBM ThinkPad
 */
public class CustomerClass {
    private double balance;
    private String Username;
    private String Password;
    
    void CreateUN(){
        String str;
        Scanner input = new Scanner(System.in);
        
        
        System.out.println("Create username:");
        str = input.nextLine();
        
        try{
            while (username_exist(str)){                            //check to see if username exists if it does, prompt user to create another one
                System.out.println("Username exists. Try again");
                str = input.nextLine();
            }
        } catch (Exception E){
            
        }
        
        //once username retrieved, get password and balance then add all of them into Credintials file
        
    }
    
    public static Boolean username_exist(String UN) throws Exception{
        Boolean exists= false;
        String newUN = UN;
        
        File file = new File("Credentials.txt");                         //CHECKING CREDIANTALS FILE FOR CORRECT USERNAME AND PASSWORD  
        LineNumberReader in = new LineNumberReader (new FileReader(file));
        
        
        String currline = null;
        int counter = 0;
        
         while((currline = in.readLine())!= null && exists==false){
             counter+=2;                                                //jump right before next username
             if (currline.equals(newUN)){
                 exists = true;
             }
         }
        
        return exists;
    }
}
