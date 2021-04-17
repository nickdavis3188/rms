package RMS;
import RMS.Order;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RmsAction {
    
    // Fields
    private String[] food = new String[9];
    private String[] priceP = new String[9];
    private int[] priceR = new int[9];
    
    public final int TENPERCENT = 10/100;

// constructor
    public RmsAction(){
        food[0] = "Fried Rice And Chicken";
        priceR[0] = 20;
        priceP[0] = "20";
        
        food[1] = "Jelof Rice And Chicken";
        priceR[1] = 15;
        priceP[1] = "15";
        
        food[2] = "Chicken And Chips";
        priceR[2] = 10;
        priceP[2] = "10";
        
        food[3] = "French Fries";
        priceR[3] = 10;
        priceP[3] = "10";

        food[4] = "VANILA ICE CREAM";
        priceR[4] = 9;
        priceP[4] =" 9";

        food[4] = "AMERICAN PIZZA";
        priceR[4] = 8;
        priceP[4] =" 8";

        food[5] = "BOUGER";
        priceR[5] = 3;
        priceP[5] =" 3";

        food[6] = "DOGNUGT";
        priceR[6] = 7;
        priceP[6] =" 7";
        food[7] = "DOGNUGT";
        priceR[7] = 7;
        priceP[7] = "7";
        food[8] = "DOGNUGT";
        priceR[8] = 4;
        priceP[8] = "4";

     
     
     
    }
    static int totalPrice = 0;
    //static obj for orders
    ArrayList<Order> myOdersList =  new ArrayList<Order>();
    
    //NumberFormat Obj
    NumberFormat currency = NumberFormat.getCurrencyInstance();
    
    //Table Data structure initialization
    private String[] twoBy25 = new String[2]; // 26--2 siters table
    private String[] fourBy15 = new String[4];// 15--4 siters table
    private String[] sixBy10 = new String[6]; // 10--6 siters table

    // initiate scanner
   private Scanner scanner = new Scanner(System.in);


   //customer search
   private String searchCustomer(String name){
     String result="";

       for(int row = 0; row < twoBy25.length;row++){
           if(twoBy25[row] == name){
               result = " At Two siters table, Table:"+(row+1) ;
           }
            
       }

       for(int row2 = 0; row2 < fourBy15.length;row2++){
           if(fourBy15[row2] == name){
               result = "4 siters tabl, Table:"+(row2+1);
           }
       }
       for(int row3 = 0; row3 < fourBy15.length;row3++){
           if(sixBy10[row3] == name){
               result = "6 siters table, Table:"+(row3+1);
           }
       }
    return result;

   }
// an accuring function for assigning customers to thier sutable table and position
   private void insertCustomer(int groupNumber, String table){

       int i = 0;

       do {
             // request for customers name

             System.out.print("ENTER YOUR NAME: ");
             String  customersN = scanner.nextLine().trim();
            
            switch (table) {
                case "twoBy25":
                    this.twoBy25[i] =  customersN;
                    i++;
                    break;
                case "fourBy15":
                    this.fourBy15[i] = customersN;
                    i++;
                    break;
                case "sixBy10":
                    this.sixBy10[i] =  customersN;
                    i++;
                    break;
                default:
                    System.out.println("Table not found!!!");
            }

       } while (i < groupNumber);
    
 
   }

   //createCustomer
   public void createCustomers(){
    //    String mss = "Customer insert is successful";
       try {
           
           //assign user to a table base on thier group
           System.out.print("How many are the custommers in a group ");
           int groupNumber = scanner.nextInt();
   
           //assignment base on group number
          if (groupNumber <= 2) {
            //  this.insertCustomer(groupNumber, "twoBy25");
             int i = 0;
             do {
                System.out.print("ENTER YOUR NAME: ");
                String  customersN = scanner.nextLine().trim();
                this.twoBy25[i] =  customersN;
                i++;
             } while (i < groupNumber);
             System.out.println("insert successful");
             
          }else if(groupNumber > 2 && groupNumber <= 4) {
            //    this.insertCustomer(groupNumber, "fourBy15");
               int v = 0;
               do {
                  System.out.print("ENTER YOUR NAME: ");
                  String  customersN = scanner.nextLine().trim();
                  this.twoBy25[v] =  customersN;
                  v++;
               } while (v < groupNumber);
               System.out.println("insert successful");
               
           }else if(groupNumber > 4 && groupNumber <= 6){
            //   this.insertCustomer(groupNumber, "sixBy10");
              int z = 0;
              do {
                 System.out.print("ENTER YOUR NAME: ");
                 String  customersN = scanner.nextLine().trim();
                 this.twoBy25[z] =  customersN;
                 z++;
              } while (z < groupNumber);

              System.out.println("insert successful");
           }
           

       } catch (Exception e) {
          System.out.println(e.getMessage());
       }
       
   }

    //mealDisplay
    public void mealDisplay(){
        System.out.println("-------------------Welcom to the My Menu feel free to place an order😄-------------------");
         // process calls...
        //   an extension makes a call: callsMade[ext]++
        //   an extension receives a call: callsReceived[ext]++
        
        // summarize call statistics
        
        System.out.printf("%3s%25s%25s\n","FOOD INDEX"," FOOD","PRICE");
        for(int i =0; i<priceR.length;i++){
            // System.out.printf("%3d%25d%25d\n",i,food[i],1);
            System.out.println(i+"\t\t\t"+food[i]+"\t\t\t\t"+" "+currency.format(priceR[i]));
        }
        System.out.println(Arrays.toString(priceR));
        // for (int i = 0; i <this.food.length;i++){
        //     System.out.printf("%3d%25d%25d\n",i,food[i],6);
        //     // System.out.printf("%3d%25d%25d\n",i,7,price[i]);
            

        // }
    }

   //createOrder
   public void createOrder(){
        System.out.println("--NOTE---------To Make An Order Type In The Food Name Ro the Food index ------------------------\n\n");

        try {

            int count = 1;
            System.out.print("Pls Enter Your Name ");
            String customerName = scanner.nextLine().trim();
            String customerPosition =  this.searchCustomer(customerName);
            System.out.println(customerPosition);
            System.out.print("HELLO "+customerName.toUpperCase()+"\n");

            System.out.print("How many order do you want to make :");
            int numberOfOder = scanner.nextInt();
            do {

                System.out.println(count == 0 ? "Order 1":"Order "+count);
            
                System.out.print("Enter The Food Index ");
                int foodIndex = scanner.nextInt();

                totalPrice += this.priceR[foodIndex];

                Order myOder = new Order(customerName, food[foodIndex], currency.format(this.priceR[foodIndex]), customerPosition);
                myOdersList.add(myOder); 
                count++;
            } while (count < numberOfOder);
          
        } catch (Exception e) {  
                System.out.println(e);
        }
         

   }

   //Get order list
   public void getOrderList(){
    System.out.printf("%3s%25s%25s%25s\n","CUSTOMERS NAME"," FOOD ORDERD","PRICE","CUSTOMERS POSITION");
        
        for(Order oders:this.myOdersList){
            System.out.println(oders.name+"\t\t\t"+oders.food+"\t\t\t"+oders.price+"\t\t\t"+oders.table);
        }
        // for (int i = 0; i < this.myOdersList.size(); i++){
        //     System.out.printf("%3d%25d%25d\n",i,this.myOdersList[i].name,currency.format(this.price[i]));
        // }
   }

   //Display total price
   public void displayTotalPrice(){
       int tenPrcentFree = totalPrice * this.TENPERCENT;
       System.out.println("--------------------------------------======");
       System.out.println(">>>>>>>>> 10% free servie <<<<<<<<<<<<<");
       System.out.println("TOTAL PRICE TO BE PAIED BY CUSTOMER IS " +(currency.format(tenPrcentFree - totalPrice)));
       System.out.println("--------------------------------------======");

   }

   //Display HELP MENNU
   public void helpDisplay() {
        String help = "";
        help += "insert_customer : this allows you waiter to ainsert and allocate position to the customer base on thier group\n\n";
        help += "list_order : this helps the waiter to see all the order made by a customer\n\n";
        help += "menu : this display the resturant food menu to the customer\n\n";
        help += "make_order : this allows the customer to make an order\n\n";
        help += "total_cost: this display the total cost of food orderd by customer";
       System.out.println(help);
   }
}
