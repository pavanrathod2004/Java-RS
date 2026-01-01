package Project;

import java.util.Scanner;
class calculation{
     Scanner s = new Scanner(System.in);
      void add(){
        System.out.println("Enter Number .");
        int sum=0;
        boolean whilecondition;
        int a = s.nextInt();
        sum = a;
        do{
           System.out.println("Enter Number");
           int b = s.nextInt();
           s.nextLine();
           sum +=b;
           System.out.println("Add again y/n"); 
           String con = s.nextLine();
            whilecondition = con.equalsIgnoreCase("y");
        }while(whilecondition);
        System.out.println("Total Addition is : "+ sum); 
        
      }

      void sub(){
          System.out.println("Enter Number .");
       
        boolean whilecondition;
        int a = s.nextInt();
        int sub = a;
        do{
           System.out.println("Enter Number");
           int b = s.nextInt();
           s.nextLine();
           sub -=b;
           System.out.println("Substract  again y/n"); 
           String con = s.nextLine();
            whilecondition = con.equalsIgnoreCase("y");
        }while(whilecondition);
        System.out.println("Total Substaction  is : "+ sub); 
      }

      void mul(){
          System.out.println("Enter Number .");
        int mul=1;
         int b;
        boolean whilecondition;
        int a = s.nextInt();
         mul *= a;
        do{
           System.out.println("Enter Number");
           b = s.nextInt();
           s.nextLine();
           mul *=b;
           System.out.println("Multiply again y/n"); 
           String con = s.nextLine();
           whilecondition = con.equalsIgnoreCase("y");
        }while(whilecondition);
        System.out.println("Total Multiplication is : "+ mul); 
      }

      void div(double a , double b){
         boolean whilecondition;
          double division = a/b;
          double c;
          System.out.println(division);
          System.out.println("Divid again y/n"); 
          String whilecon = s.nextLine();
          whilecondition = whilecon.equalsIgnoreCase("y");
          while(whilecondition){
             System.out.println("Enter Second Number ");
              c = s.nextInt();
              s.nextLine();
              if(c == 0){
                 System.out.println("Please Enter another Number Instead 0 ");
                 
              }
              else{
                division /=c;
                System.out.println(division);
                 System.out.println("Divid again y/n"); 
                 whilecon = s.nextLine();
                whilecondition = whilecon.equalsIgnoreCase("y");
              }

          }
          

      }
}

public class calculator extends calculation{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        calculator c = new calculator();
        boolean whilecondition= true;
        while(whilecondition){
        System.out.println("=====Welcome to My Calculator=====");
        System.out.println("Press Button :");
        System.out.println("1) Addition ");
        System.out.println("2) Sustraction ");
        System.out.println("3) Multiplication ");
        System.out.println("4) Division ");

        int num = sc.nextInt();
        sc.nextLine();
        switch (num) {
            case 1:
                  c.add();
               break;
            case 2:
                  c.sub();
               break;
            case 3:
                  c.mul();
              break;
            case 4:
                System.out.println("Enter Number ");
                double a = sc.nextInt();
                double b;
                do{
                  System.out.println("Enter Second Number ");
                    b = sc.nextInt();
                   if(b != 0){
                    break;
                   }
                 System.out.println("Please Enter another Number Instead 0 ");
                }while(whilecondition);                
                c.div(a, b);
               break;
            default:
                 whilecondition =false;
                break;
        }
    }
 }
    
}
