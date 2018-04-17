import java.lang.*;
import java.util.*;


public class ShoppingCartManager {


    public static Scanner scan = new Scanner(System.in);

    static boolean printMenu(ShoppingCart myCart) {

        String choice = "";

        System.out.println("MENU" +
                "\na - Add item to cart" +
                "\nd - Remove item from cart" +
                "\nc - Change item quantity" +
                "\ni - Output items' descriptions" +
                "\no - Output shopping cart" +
                "\nq - Quit\n");


        while(!(choice.equals("a")||choice.equals("d")||choice.equals("c")||choice.equals("i")||choice.equals("o")||choice.equals("q"))) {
            System.out.println("Choose an option:");
            choice = scan.nextLine();
         }
  /*
        //Works here, creates an infinite loop in zyBooks, always inputting non-existant line before???
        while(!(choice.equals("a")||choice.equals("d")||choice.equals("c")||choice.equals("i")||choice.equals("o")||choice.equals("q"))) {
            System.out.println("Choose an option:");
            if(scan.hasNext()){
                choice = scan.nextLine();
            }
        }
 */

        if (choice.equals("o")) {
            System.out.println("OUTPUT SHOPPING CART");
            myCart.printTotal();

            System.out.println();
            return true;

        } else if (choice.equals("i")) {
            System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
            myCart.printDescriptions();

            System.out.println();
            return true;

        } else if (choice.equals("a")) {
            System.out.println("ADD ITEM TO CART");
            System.out.println("Enter the item name:");
            String name = scan.nextLine();
            System.out.println("Enter the item description:");
            String description = scan.nextLine();
            System.out.println("Enter the item price:");
            int price = scan.nextInt();
            System.out.println("Enter the item quantity:");
            int quantity = scan.nextInt();
            scan.nextLine(); //???

            ItemToPurchase addItem = new ItemToPurchase(name, description, price, quantity);
            myCart.addItem(addItem);

            System.out.println();
            return true;

        } else if (choice.equals("d")) {
            System.out.println("REMOVE ITEM FROM CART");
            System.out.println("Enter name of item to remove:");
            myCart.removeItem(scan.nextLine());

            System.out.println();
            return true;

        } else if (choice.equals("c")) {

            System.out.println("CHANGE ITEM QUANTITY");
            System.out.println("Enter the item name:");
            String searchName = scan.nextLine();
            System.out.println("Enter the new quantity:");
            int newQuantity = scan.nextInt();
            scan.nextLine();

            ItemToPurchase newItem = new ItemToPurchase();
            newItem.setName(searchName);
            newItem.setQuantity(newQuantity);
            myCart.modifyItem(newItem);

            System.out.println();
            return true;

        } else {
            return false;
        }


    }

    public static void main(String[] args) {
        String name = "";
        String date = "";

        System.out.println("Enter Customer's Name:");
        if(scan.hasNextLine())name = scan.nextLine();
        System.out.println("Enter Today's Date:");
        if(scan.hasNextLine()) date = scan.nextLine();

        System.out.println("\nCustomer Name: " + name);
        System.out.println("Today's Date: " + date +"\n");     //check if newline after matters
        ShoppingCart customerCart = new ShoppingCart(name, date);

        Boolean continueMenu = true;
        while (continueMenu) {
            continueMenu = printMenu(customerCart);

        }


    }

}