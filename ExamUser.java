package Project;
import java.util.*;

import java.util.ArrayList;
//  Exam time class
class ExamTimer extends Thread {
    private UserExamSession exam;
    private int seconds;

    ExamTimer(UserExamSession exam, int seconds) {
        this.exam = exam;
        this.seconds = seconds;
    }

    public void run() {
        try {
            Thread.sleep(seconds * 1000);
            System.out.println("\nTime's Up!");
            System.out.println("Exam Total Marks: " + User_Exam.OutOff);
            System.out.println("Your Obtained Marks: " + exam.total);
            System.exit(0); // auto end exam
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// This class of only Quations
class Exam  {
    static ArrayList<Exam> quationlist = new ArrayList<>();
     String quation ;
     String option1;
     String option2;
     String correctAns;
    
    Exam(){

    }
   
   
    Exam(String quation , String option1 ,String option2 ,String correctAns){
        this.quation=quation;
        this.option1=option1;
        this.option2=option2;
        this.correctAns=correctAns;
    }
    void addQuation(String quation , String option1 ,String option2,String correctAns){
        quationlist.add(new Exam( quation, option1 , option2,correctAns));
    }

    int setTotalMark(){
           return quationlist.size()*10;
    }
}

// this class of Quation Ans Answer for Examinar 
class UserExamSession{
        int total=0;
int StartMainExam(){
         int i=1;
         
        Scanner s = new Scanner(System.in);
        for(Exam g :Exam.quationlist)
        {    
           System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println(i +"Q"+" "+g.quation);
            System.out.println("1 )"+ " " +g.option1);
            System.out.println("2 )"+ " " +g.option2);
            System.out.println("Choose Option :");
            int op = s.nextInt();
            s.nextLine();
            if(op==1){
                  if(g.option1.equals(g.correctAns)){
                        total +=10;
                        
                  }
            }
            else if(op==2) {
                 if(g.option2.equals(g.correctAns)){
                    total+=10;
                 }
                 
            }
            i++;

        }
         if(total<0){
              total=0;
              return total;
         }

         return total;
    }

 
        
 }

// class of Main Exam/
class  User_Exam{
    ArrayList<User_Exam> userList = new ArrayList<>();
    String Username;
   
    String PassWord ;
    int Mark ;
    static  int OutOff;

    User_Exam(){

    }
    User_Exam(String Username,String PassWord){
        this.Username=Username;
        this.PassWord=PassWord;
    
    }

    void  addUser(String Username,String PassWord){
        userList.add(new User_Exam(Username,PassWord));
    }

    User_Exam  checkUser(String Username ,String PassWord){
        Iterator<User_Exam> I = userList.iterator();
        while(I.hasNext()){
            User_Exam u = I.next();
            if(u.Username.equals(Username)&&u.PassWord.equals(PassWord)){
                return u;
            }
        }

        return null;
    }

    void StartExam(){
         Exam e = new Exam();

         OutOff= e.setTotalMark();

         UserExamSession UE = new UserExamSession(); // create object of User Exam Session 
         ExamTimer timer = new ExamTimer(UE,6); // crate object of Exam timer class for set the tiem for exam and pass object of User Exam Session for in case if time up so that time display the how many mark obtain by user

         timer.start(); // start user define thread
       

        Mark=UE.StartMainExam();
   
        System.out.println("Exam Total Mark : " + OutOff);
    
        System.out.println("Your Total Marks Obtain : " + Mark);
        System.exit(0);
         

    }


}

//
public class ExamUser {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Exam E = new Exam();
        E.addQuation("Who is C founder ?","Dennis Ritchie","Vishal Farpat","Dennis Ritchie");
        E.addQuation("Who is Java founder ?","Dennis Ritchie","James Gosling","James Gosling");
         E.addQuation("Who is Python founder ?","Dennis Ritchie","Guido van Rossum","Guido van Rossum");
          

        User_Exam u = new User_Exam();
        u.addUser("Pavan","P@-123");
        u.addUser("Sujit","Pa@-121");
        u.addUser("Vishal","Pas@-125");
        u.addUser("Ganesh","Pass@-124");
        while(true) {
            System.out.println("======Login======");
            System.out.println("Enter you User Name :");
            String username = sc.nextLine();
            System.out.println("Enter your PassWord");
            String password = sc.nextLine();
            User_Exam num = u.checkUser(username, password);
            if (num != null) {
                System.out.println("======Welocome To My Exam======");
                System.out.println("Enter No. for 1) Start Exam");
                 int n = sc.nextInt();
                 sc.nextLine();
                 switch(n){
                     case 1:
                           num.StartExam();

                            break;
                     default:
                            System.exit(0);

                 }
            } else {
                System.out.println("Invalid User Name and Password Please Login agian");
            }
        }


    }
}
