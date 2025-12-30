package Project;
import java.lang.runtime.SwitchBootstraps;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class cart {
    String item_name;
    int item_quantity;
    double amount;

    cart(){

    }
    cart(String item_name, int item_quantity,double amount){
        this.item_name=item_name;
        this.item_quantity= item_quantity;
        this.amount=amount;

    }
    
}
class shoppingCart extends cart{
    public static ArrayList<cart> list = new ArrayList<>();
    public static ArrayList<cart> listHistoryRemove= new ArrayList<>();
    public static ArrayList<cart> listHistoryPurchase =  new ArrayList<>();

    void viewItem(){
         Iterator <cart> I = list.iterator();
         System.out.println("Your Total Selected Item are");
         System.out.println("----------------------------------------------------------------------------------------------");
         while (I.hasNext()) {
            cart itemObject = I.next();
            System.out.println("Item name : " + itemObject.item_name+ " , " + " Item Quantity : " + itemObject.item_quantity+ " , " + " Item Amount " + itemObject.amount);
            
         }
         System.out.println("----------------------------------------------------------------------------------------------");
          
    }
    // add item into arraylist

    void add(String item_name , int item_quantity, double amount){
       
        list.add(new cart(item_name,item_quantity,amount));
    }

    void removeItemname(String name){
         // int i =0;
         Iterator <cart> I = list.iterator();
         while (I.hasNext()) {
            cart selectByName = I.next();
            if(selectByName.item_name.equalsIgnoreCase(name)){
                listHistoryRemove.add(selectByName); // add into list of History
                list.remove(selectByName); // remove from cart list
               
               // list.remove(i);
                System.out.println("Remove from shopping cart");
                return;

            }
           // i++;
            
         }

       
    }

    void removeItemAll(){
        listHistoryRemove.addAll(list);
        list.clear();
        System.out.println("Remove all item from shopping cart");
    }

    void itemPurchaseaLL(){
        System.out.println("Purchase all item success fully");
        listHistoryPurchase.addAll(list); // add into purchase history
        removeItemAll();                 // remove from all item from list cart

    }

    void itemPurchaseName(String name ){
       //  int j =0;
        Iterator <cart> I = list.iterator();
        while (I.hasNext()) {
            cart purchaseObject = I.next();
            if(purchaseObject.item_name.equalsIgnoreCase(name))
            { 
                System.out.println("Purchase by name Successfully");

                listHistoryPurchase.add(purchaseObject);
                removeItemname(name);// remove from list of cart
                
                return;
            }
            
        }
         
    }

    void showHistory(int historyChoise){
        if(historyChoise==1){
            System.out.println("HISTORY OF REMOVE");

            Iterator<cart> I = listHistoryRemove.iterator();
            while(I.hasNext()){
                cart removeITEM = I.next();
                System.out.println("Item name is : " +removeITEM.item_name + " " + "Item Quantity : "+removeITEM.item_quantity +" "+"Item Amount : "+removeITEM.amount);
            }

        }
        else if(historyChoise==2){
             System.out.println("HISTORY OF PURCHASE");
             Iterator<cart> I = listHistoryPurchase.iterator();
            while(I.hasNext()){
                cart purchaseITEM = I.next();
                System.out.println("Item name is : " +purchaseITEM.item_name + " " + "Item Quantity : "+purchaseITEM.item_quantity +" "+"Item Amount : "+purchaseITEM.amount);
            }

        }
        else{
            System.out.println("INVALID NO");
        }
                  
    }



}




public class shop{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
       
          
        // Object create 
        shoppingCart s = new shoppingCart();
 
        boolean whileCondition = true;
        while(whileCondition){
             System.out.println("choose 1) view item  2) add item 3) remove item 4) purchase 5) History");
             int choose = sc.nextInt();
            

        switch(choose){
            case 1:
                s.viewItem();
                break;

            case 2:
                  sc.nextLine();
                  System.out.println("Enter item name , item quantity , price");
                  String name = sc.nextLine();
                  int quantity = sc.nextInt();
                  double  price = sc.nextDouble();
                  s.add(name,quantity,price);

                  break;  
                  
            case 3:
                 System.out.println("if you want remove Item by name type 1 or remove all Item type 2 ");
                   int removeChoise = sc.nextInt();
                   sc.nextLine();
                   if(removeChoise==1){
                     System.out.println("Enter the name of product");
                      String nameforremove=sc.nextLine();
                     s.removeItemname(nameforremove);
                   }
                   else if(removeChoise==2){
                    s.removeItemAll();
                   }
                   else{
                     System.out.println("Invalid  no please enter correct no ");
                   }
                break; 
             
             case 4:
                   System.out.println(" item purchase by name  or all (1 = name , 2 = all) ");
                   int purchaseChoise = sc.nextInt();
                   sc.nextLine();
                   if(purchaseChoise==1){
                        System.out.println("Enter the name of Item for purchase");
                        String purchasename= sc.nextLine();
                       s.itemPurchaseName(purchasename);
                       
                   }
                    else if(purchaseChoise==2){
                         s.itemPurchaseaLL();
                         System.out.println("all item purchase");
                    }
                    else
                        System.out.println("Invalid no"); 
                    
                    break;

            case 5:
                    System.out.println("Which History you want  ");
                    System.out.println("1) REMOVE ITEM");
                    System.out.println("2) PURCHASE ITEM");  
                    int historyChoise = sc.nextInt();    
                    sc.nextLine();
                    s.showHistory(historyChoise);
                    break;  

            default:
                   whileCondition = false;
 
        }     
                        
        }

    }
    
}
