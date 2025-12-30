import java.util.Scanner;
import java.util.*;

interface interfacestudent {
    public abstract void createAccount();
    public abstract void showMarks();
    public abstract void accountDetail();

    
}

abstract class student  implements interfacestudent{
     String name ;
     int marks;
     Double mobileNumber;
     double account;
     double totalFees = 10000;
     double remeaingFees;
     String password;
     String password1;
     

     Scanner sc = new Scanner(System.in);

    public abstract void createAccount();
    public void showMarks(){
        System.out.println("Your total marks is : " + marks);
    }

   public void accountDetail(){
               System.out.println("Your name is : " + name);
               System.out.println("Your 10 persentage is :  " +  marks);
               System.out.println("Your total fees is : " + totalFees);
               System.out.println("Your submit total fees : " + account);
               remeaingFees  = totalFees - account;
               System.out.println("Your remeaing fees is " + remeaingFees );
         
   }
   
   public void payFees(double fees){
        account += fees;
        System.out.println("Fees paid successfully " + fees);
        System.out.println("Your total fees is " +  account);
        remeaingFees = totalFees - account;
        if(remeaingFees<=0)
            {
                System.out.println("All fees Paid ");
                System.out.println("No remeaning Fees ");
            }
            else{
               System.out.println(" remeaning fees is " + (totalFees-account));
            }

   }

}

class user extends student{
   public void createAccount(){
        System.out.println("Enter your name  : ");
        name= sc.nextLine();
        
        System.out.println("enter you 10 standerd marks in presentage : ");
        marks = sc.nextInt();
        System.out.println("Enter you mobile number : ");
        mobileNumber=sc.nextDouble();
        System.out.println("enter you submited fees ");
        account = sc.nextDouble();
        sc.nextLine();

        int i = 1;
        while(i<=3){
            System.out.println("Enter your passord");
            password = sc.nextLine();
            System.out.println("Re-Enter your password");
            password1= sc.nextLine();

            if(!password.equals(password1)){
                System.out.println("_______________________________________");
                 System.out.println("Your passworld not match");
                 System.out.println("Pelese Re-Enter your password");
                  System.out.println("_______________________________________");
                 i++;
            }
            else if(password.equals(password1)){
                System.out.println("Account created Successfully");
                
                return;
            }
            if(i==3){
                System.out.println("Pelese create Account after some time");
                System.exit(0);
            }

        }

        

    }
   
 
 }

public class studetmanagement {
    public static void main(String s []){
    ArrayList <user> list = new ArrayList<>();
    
    user u = new user();

    Scanner sc = new Scanner(System.in);
       System.out.println("do you have student account yse/no");
            String chooise = sc.nextLine();
            
            if(chooise.equalsIgnoreCase("no")){
             u.createAccount();
             list.add(u);
             System.out.println("Enter your password to login : ");
                 String loginPass= sc.nextLine();
                 if(loginPass.equals(u.password))
                    {
                    System.out.println("Login Successfully");
                           boolean c = true;
                        while(c){
                             System.out.println(" 1 ) showMarks , 2 ) accountDetail , 3 ) payFees ");
                               int chooise1 = sc.nextInt();
                              switch (chooise1) {
                                               case 1:
                                                      u.showMarks();
                    
                                                         break;
                                                case 2:
                                                      u.accountDetail();
                                                           break;         
                                                case 3:
                                                      System.out.println("Enter your fees to pay : ");
                                                      double fees = sc.nextDouble();
                                                     u.payFees(fees);
                                                     break;
                                                default:
                                                       c=false;
                                                          break;
                                             }
                                }

                    }
                    else{
                    System.out.println("Invalid Password ");
                      }
             
     
             }
             else{
                System.out.println("Enter your password to login : " );
                String pass= sc.nextLine();
                if(pass.equals(u.password))
                  { 
                     System.out.println("Login Successfully");
                    boolean c = true;
                    while(c){
                            System.out.println(" 1 ) showMarks , 2 ) accountDetail");
                            int chooise1 = sc.nextInt();
                            switch (chooise1) {
                                     case 1:
                                           u.showMarks();
                    
                                          break;
                                     case 2:
                                           u.accountDetail();
                                        break;         
             
                                    default:
                                          c=false;
                                           break;
                                    }
                         }
                }
             else{
                System.out.println("Invalid password");
                System.exit(0);
             }
             }
             
      
        //   Iterator <Object> i = list.iterator();
        //   while(i.hasNext()){
        //     user us = (user)i.next();
        //     us.accountDetail();

        //   }

    }
    

}