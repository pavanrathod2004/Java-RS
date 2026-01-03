package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;

class ExamQuation {
    ArrayList<ExamQuation> quationslist = new ArrayList<>();
    String quation;
    String option1;
    String option2;
    String correctAns ;
    ExamQuation(){

    }
    ExamQuation(String quation , String option1, String option2 , String correctAns){
        this.quation = quation;
        this.option1 = option1;
        this.option2 = option2;
        this.correctAns = correctAns;
    }
    void add(String quation , String option1, String option2, String correctAns){
        quationslist.add(new ExamQuation(quation,option1,option2,correctAns));

    }
}

class user{
    ArrayList<user> usersList = new ArrayList<>();
    String userName ;
    String passWord ;
    int mark ;
    user(){

    }
    user(String userName,String passWord,int mark){
        this.userName = userName;
        this.passWord = passWord;
        this.mark= mark;

    }

    void addUser(String userName , String passWord,int mark){
        usersList.add(new user(userName , passWord,mark));

    }

    user checkUser(String userName, String passWord){

        return  null;
    }

    void start(){

    }

}

public class googleExam {
    public static  void main(String args[]){
        //
        try {
            // 1) driver load
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2) create connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Exam", "root", "656542");
            // 3) create tbale Quation and User
            con.setAutoCommit(false);
            // 
            user u = new user();
            Scanner sc = new Scanner(System.in);
            boolean whilecond = true;
            PreparedStatement select = con.prepareStatement("SELECT * FROM EMPLOYEE");
            ResultSet rs = select.executeQuery();
            while(rs.next()){
                    String userName = rs.getString("User_Name");
                    String password = rs.getString("Password");
                    int mark = rs.getInt("Score");
                    u.addUser(userName,password,mark);
                    System.out.println("get user successfully ");

            }
            while(whilecond) {
                System.out.println("======Welcome to My Exam Portal======");
                System.out.println("Enter you userName : ");
                String userName = sc.nextLine();
                System.out.println("Enter your Password :");
                String password = sc.nextLine();

                user checkuser = u.checkUser(userName, password);
                if (checkuser != null) {
                    System.out.println("======Welcome Back to My Exam Portal======");
                    System.out.println("Enter No. for 1) Start Exam");
                    int n = sc.nextInt();
                    sc.nextLine();
                    if(n==1){
                         u.start();
                    }
                    else{
                        System.exit(0);
                    }
                } else {
                    System.out.println("UserName and Password not match...!");
                }
            }

          con.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
