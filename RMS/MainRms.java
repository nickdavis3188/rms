package RMS;
import java.util.Scanner;

import RMS.*;

public class MainRms {
    public static void main(String[] args) {
        
        System.out.println("----------------------------------------------------------");
        System.out.println("--------Welcon To My Resturant Menu System-----------------");
        System.out.println("----------------------------------------------------------");
        
        // initiate the RmsAction class
        RmsAction myAction = new RmsAction();
        
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Type \"help\" to get along with the program\n");

            System.out.print(">>>>> ");
            String keyOption = scanner.nextLine();
            // System.out.println(keyOption);
            switch (keyOption) {
                // //help function called
                case "help":
                    myAction.helpDisplay();
                    break;
                    // display menu list
                case "menu":
                    myAction.mealDisplay();
                    break;
                    // insert customer
                case "insert_customer":
                    myAction.createCustomers();
                    break;
                    //display total cost of item orderd
                case "total_cost":
                    myAction.displayTotalPrice();
                    break;
                    //display list of order
                case "list_order":
                    myAction.getOrderList();
                    break;
                    //allw customer to make order
                case "make_order":
                    myAction.createOrder();
                default:
                    System.out.println("Invalid Option sellected😠");
            }
            
            // if(keyOption == "HELP"){
            //     myAction.helpDisplay();
            //     //createCustomer function:to add customer and allocate position to them
            // }
            // else if(keyOption == "INSERT_CUSTOMER"){
            //     myAction.createCustomers();
            //     //to display the total cost of food consume by costomer
            // }
            // else if(keyOption == "TOTAL_COST"){
            //     myAction.displayTotalPrice();
            //     // list out table of oders made by a customer
            // }
            // else if(keyOption == "LIST_ORDER"){
            //     myAction.getOrderList();
            //     //display food menu in tabuler form
            // }
            // else if(keyOption == "MENU"){
            //     myAction.mealDisplay();
            //     // this allow a customer to make an order
            // }
            // else if(keyOption == "MAKE_ORDER"){
            //     myAction.createOrder();
            // }
            // else{
            //     System.out.println("Invalid Option sellected😠");;
            // }
                  
        }
        
    }
}
