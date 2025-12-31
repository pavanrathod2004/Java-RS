
import java.util.*;

class Book {
    String bookName;
    int bookQuantity;
    boolean bookAvailability;

    Book(String bookName, int bookQuantity) {
        this.bookName = bookName;
        this.bookQuantity = bookQuantity;
        this.bookAvailability = bookQuantity > 0;
    }

}


class User {
    String userName;
    String password;
   // String borrowedBook;
    HashMap<String, Integer> borrowedBooks;
   


    User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        
         borrowedBooks = new HashMap<>();
    }

    
void viewBorrowbBook(){
    if(borrowedBooks.isEmpty()){
        System.out.println("You have not borrowed any book.");
        return;
    } 
   System.out.println("------------------------------------------------------------------------------------------------");
   System.out.println("Your Borrow Book");
    for(Map.Entry<String,Integer> e : borrowedBooks.entrySet()){
        System.out.println("Book Name : "+ e.getKey()+ " "+"Book Quantity : "+e.getValue());
    }
   System.out.println("------------------------------------------------------------------------------------------------"); 
}

void addBookToUser(String bookname , int quantity ){
    
    borrowedBooks.put(bookname, borrowedBooks.getOrDefault(bookname, 0) + quantity
    );
    System.out.println("Book Borrowed Successfully....!");
    System.out.println("------------------------------------------------------------------------------------------------"); 
    
}

void renewBook(String renewBookName){
      if(borrowedBooks.isEmpty()){
        System.out.println("You Don't Borrow any  Book");
        return;
      }
      System.out.println("---------------------------------------------------------------------------------------------------");
      System.out.println("                 This Book Renew for 14 Days..!                   ");
      System.out.println("---------------------------------------------------------------------------------------------------");
         
}

void  userRBook(String bookName , int quantity){
    for(Map.Entry<String,Integer> e : borrowedBooks.entrySet()){
        if(e.getKey().equalsIgnoreCase(bookName)){
            int qunt = e.getValue();
            if(quantity==qunt){
                borrowedBooks.remove(e.getKey()); 
                System.out.println("Book Return Successfully...!");
            }
            else if(quantity<qunt){
                borrowedBooks.put(e.getKey(),e.getValue()-quantity);
            }
            else{
                System.out.println("You Don't Borrow BOOk : " + bookName + " with Quantity : " +quantity );
            }

            
        }
    }
     
}


}


 class Main_library{
    ArrayList<Book> bookList = new ArrayList<>();
     ArrayList<User> userList = new ArrayList<>();

    void addBook(String bookName ,int bookQuantity){
         bookList.add(new Book(bookName,bookQuantity));

    }

    void addUser(String userName, String password ){
        userList.add(new User(userName, password));
    }

    User chekUser(String userName,String password){
           for(User userObject : userList){
            if(userObject.userName.equals(userName)&& password.equals(userObject.password)){
                return userObject;
           }
    }

   return null;
    
}

 void viewBook(){
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("======Library Book Available======");
        for(Book b : bookList){
            System.out.println(
                "Book: " + b.bookName +" "+
                "  Qty: " + b.bookQuantity +" "+
                "  Available: " + b.bookAvailability
            );
        }
        System.out.println("---------------------------------------------------------------------------------------------------");
    
    }

  int  borrowedBook(String bookname,int quantity){

        for(Book b  : bookList){
            if(bookname.equalsIgnoreCase(b.bookName)&& quantity<=b.bookQuantity){
                b.bookQuantity=b.bookQuantity-quantity;
                b.bookAvailability= b.bookQuantity>0;
                return 1;
            }
            
        }
        return 0;

  }
  
 void returnBook(String ReturnbookName,int quantity){
    for(Book r : bookList){
        if(ReturnbookName.equalsIgnoreCase(r.bookName)){
            r.bookQuantity=r.bookQuantity+quantity;
            r.bookAvailability= r.bookQuantity>=1;
            System.out.println("Book Add in Library  Successfully...!");
        }
    }
 }
  


 }

 

 
class libraryManagment {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        Main_library ml = new Main_library();
        // Add Book
        ml.addBook("Math",5);
        ml.addBook("TOC",10);
        ml.addBook("English",2);
        ml.addBook("Marathi",7);
        ml.addBook("Hindi",6);

        // Add user 
        ml.addUser("Pavan","Pass@123");
        ml.addUser("Ganesh","Pass@124");
        ml.addUser("Akash","Pass@125");
        ml.addUser("Sujit","Pass@126");

        System.out.println("=======Welcome to Book Bhandar=======");
        System.out.println("Enter Your User_Name: ");
        String inputUserName = sc.nextLine();
        System.out.println("Enter Your Password: ");
         String inputPassword = sc.nextLine();

        User u= ml.chekUser(inputUserName,inputPassword);
        if(u !=null){
            boolean whileCond = true;
            System.out.println("======Login Successfully to Book Bhandar======");
            while(whileCond){
            System.out.println("Enter number for your choise");
            System.out.println("1) view Book");
            System.out.println("2) Borrow Book");
            System.out.println("3) Renew Book");
            System.out.println("4) Return Book");
            System.out.println(" for  Log Out  Enter any number Greater than 4");
            
            int num = sc.nextInt();
            sc.nextLine();

            switch (num) {
                case 1:
                       System.out.println("Enter No. following");
                       System.out.println("1) Library Book");
                       System.out.println("2) Yor Borrow Book");
                       int num2=sc.nextInt();
                         sc.nextLine();
                       if(num2==1)
                          ml.viewBook();
                       else if(num2==2)
                             u.viewBorrowbBook();
                    break;
                
                case 2:
                      ml.viewBook();
                      System.out.println("Enter Book Name : ");
                      String bookname= sc.nextLine();
                      System.out.println("Enter Book Quatity : ");
                      int quantity=sc.nextInt();
                      sc.nextLine();
                      int  n= ml.borrowedBook(bookname,quantity);
                       if(n!=0){
                          u.addBookToUser(bookname, quantity);
                       }
                       else if(n==0){
                         System.out.println("---------------------------------------------------------------------------------------------------");
                         System.out.println("                 This Book Not Available..!                   ");
                         System.out.println("---------------------------------------------------------------------------------------------------");
         
                       }
                    break;

                 case 3:
                       System.out.println("Enter book name for Renew");
                       String renewBookName = sc.nextLine();
                       u.renewBook(renewBookName);
                    
                    break;
                 case 4: 
                       System.out.println("Enter Book Name ");
                       String returnBook = sc.nextLine();
                       System.out.println("Enter Book Quantity");
                       int renewBookQuantity = sc.nextInt();
                       ml.returnBook(returnBook,renewBookQuantity);
                       u.userRBook(returnBook, renewBookQuantity);
                    
                    break;
            
            
                default:
                    break;
            }

            }

        }
        else{

        }



   

    
        
    }

    
}