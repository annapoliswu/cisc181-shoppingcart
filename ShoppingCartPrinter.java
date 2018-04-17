/**
 * Created by Anna on 3/3/2018.
 */

import java.io.*;
import java.lang.Math;
import java.util.Scanner;

//Takes in values from user in order to create 2 ItemToPurchase and then
// prints out the total cost of the 2 ItemToPurchase.

public class ShoppingCartPrinter {

    public static void main(String[] args) {
        ItemToPurchase item1 = new ItemToPurchase();
        ItemToPurchase item2 = new ItemToPurchase();

        Scanner scan = new Scanner(System.in);

        System.out.println("Item 1");
        System.out.println("Enter the item name:");
        item1.setName(scan.nextLine());
        System.out.println("Enter the item price:");
        item1.setPrice(scan.nextInt());
        System.out.println("Enter the item quantity:");
        item1.setQuantity(scan.nextInt());

        System.out.println("\nItem 2");
        System.out.println("Enter the item name:");
        scan.nextLine(); //Discard
        item2.setName(scan.nextLine());
        System.out.println("Enter the item price:");
        item2.setPrice(scan.nextInt());
        System.out.println("Enter the item quantity:");
        item2.setQuantity(scan.nextInt());

        System.out.println("\nTOTAL COST");
        System.out.println(item1.getName() + " " + item1.getQuantity() + " @ $" + item1.getPrice() + " = $" + item1.getQuantity()*item1.getPrice());
        System.out.println(item2.getName() + " " + item2.getQuantity() + " @ $" + item2.getPrice() + " = $" + item2.getQuantity()*item2.getPrice());
        System.out.println("\nTotal: $" + (item1.getPrice() * item1.getQuantity() + item2.getPrice() * item2.getQuantity()));
    }
}
