package Project;
import java.util.*;

 interface InnerBankManagement {

     void deposit(double amount);
     void withdraw(double amount);
     void check_balance();
  
}

abstract class bankAccount implements InnerBankManagement{
    protected double balance;
    // deposit method
   public void deposit(double amount){
        if(amount==0){
            System.out.println("Please add valid amount");
        }
        else{
            balance +=  amount;
        }
    }

    // withdrow method

   public void withdraw(double amount){
        if(amount==0){
            System.out.println("please enter valid amount");
        }
        else{
            balance -= amount;
        }
    }

    public void check_balance(){
        System.out.println("Balance is : " + balance);
    }

    

    
}

// user class 

 class User extends bankAccount {

    String userName;
    String password;
    
    User(String userName,String password,double balance){
        this.userName=userName;
        this.password=password;
        this.balance=balance;
    }
    
}

public class BankManagement {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      System.out.println("Do you have an account yes/no");

      String choice = sc.nextLine();

      if(choice.equalsIgnoreCase("no")){
        System.out.println("Enter user name : ");
        String userName=sc.nextLine();

        System.out.println("Enter Password :");
        String password1=sc.nextLine();

        System.out.println("Re-Enter Password :");
        String password2=sc.nextLine();

      

        if(!password1.equals(password2)){
            System.out.println("Password not match , Please enter correct password");
        }
        else{

             System.out.println("Add balance :");
            double balance = sc.nextDouble();
              sc.nextLine();
            User u = new User(userName, password2, balance);

              System.out.println("Account created successfully");

               int count=0;

              while(count<3){   
                System.out.println("Enter Password :");
                String password3=sc.nextLine();    
               if(!password3.equals(password2)){
                   count++;
                 System.out.println("Password not match");

                 }
                 else{
                      break;
                 }

                  }
                if(count==3){
                    System.out.println("Try again Later");
                    System.exit(0);
                  }
                else{
                 boolean flag=true;
        
                 while ( flag) {
                
                  System.out.println("enter number 1-Withdrow , 2-deposit , 3-check_balance");

                  int  number = sc.nextInt();
  
                  switch (number) {
                     case 1:
                   System.out.println("Enter amount for Withdrow");
                   double amount=sc.nextDouble();
                   u.withdraw(amount);
                    
                    break;

                 case 2:
                   System.out.println("Enter amount for Diposit");
                   double amount1=sc.nextDouble();
                   u.deposit(amount1);
                    
                    break;

                  case 3:
                   
                   u.check_balance();
                    
                    break;

                default:
                      flag=false;
                    break;
                 }

              }
            } 
        } 

      }
    
        
    }
    
}


