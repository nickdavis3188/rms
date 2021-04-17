package RMS;

public class Order {
    
    // fields
   public String name;
   public String table;
   public String food;
   public String price;

    //constructor
    Order(String name,String food,String price,String table){
        this.name = name;
        this.food = food;
        this.price = price;
        this.table = table;
    }
}
