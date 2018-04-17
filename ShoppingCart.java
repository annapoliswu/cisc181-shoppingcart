/**
 * Created by Anna on 3/7/2018.
 */
import java.util.*;

public class ShoppingCart {
    private String customerName;
    private String currentDate;
    private ArrayList<ItemToPurchase> cartItems = new ArrayList<>();

    ShoppingCart(){
        customerName = "none";
        currentDate = "January 1, 2016";

    }

    ShoppingCart(String name, String date){
        customerName = name;
        currentDate = date;
    }

    public String getCustomerName(){
        return customerName;
    }

    public String getDate(){
        return currentDate;
    }

    public void addItem(ItemToPurchase item){
        cartItems.add(item);
    }

    public void removeItem(String itemName){
        boolean flag = true;

        for(int i = 0; i < cartItems.size(); i++){
            if(cartItems.get(i).getName().equals(itemName)){
                cartItems.remove(i);
                flag = false;
            }
        }
        if(flag){
            System.out.println("Item not found in cart. Nothing removed.");
        }
    }

    //modifies an item of same name to the values of input item
    public void modifyItem(ItemToPurchase item){
        int index = -1;

        for(ItemToPurchase selecteditem : cartItems){
            if(selecteditem.getName().equals(item.getName())){
                index = cartItems.indexOf(selecteditem);
            }
        }

        if(index == -1) {
            System.out.println("Item not found in cart. Nothing modified.");
        } else {
            if(!item.getName().equals("none")) {
                cartItems.get(index).setName(item.getName());
            }
            if(item.getPrice() != 0)
                {cartItems.get(index).setPrice(item.getPrice());
            }
            if (item.getQuantity() != 0){
                cartItems.get(index).setQuantity(item.getQuantity());
            }
            if (!item.getDescription().equals("none")){
                cartItems.get(index).setDescription(item.getDescription());
            }
        }

    }

    //returns total quantity of all items in cart
    public int getNumItemsInCart(){
        int totalQuantity = 0;
        for(ItemToPurchase item : cartItems){
            totalQuantity += item.getQuantity();
        }
        return totalQuantity;
    }

    //returns price of all items in cart
    public int getCostOfCart(){
        int totalCost = 0;
        for (ItemToPurchase item : cartItems){
            totalCost += (item.getPrice() * item.getQuantity());
        }
        return totalCost;
    }

    //prints all item costs and quantities
    public void printTotal(){
        int totalItems = 0;

            for(ItemToPurchase item : cartItems){
                totalItems += item.getQuantity();
            }
            System.out.println(customerName + "'s Shopping Cart - " + currentDate);
            System.out.println("Number of Items: " + totalItems + "\n");
            for (ItemToPurchase item : cartItems){
                item.printItemCost();
            }

        if(cartItems.size() == 0){
            System.out.println("SHOPPING CART IS EMPTY");
        }
        System.out.println("\nTotal: $" + getCostOfCart() );
    }

    //prints all item descriptions
    public void printDescriptions(){
        System.out.println(customerName + "'s Shopping Cart - " + currentDate + "\n\nItem Descriptions");

        for(ItemToPurchase item : cartItems){
            item.printItemDescription();
        }
    }

/*
    public static void main(String[] args) {
        ItemToPurchase coco = new ItemToPurchase("Coco",1, 6, "Really chocolately");
        ItemToPurchase meat = new ItemToPurchase("Beef", 6, 3, "Savory");
        ItemToPurchase oranges = new ItemToPurchase("Oranges", 2, 20, "Citrus serving");
        ShoppingCart myCart = new ShoppingCart("Annapolis", "2/3/17");
        myCart.addItem(coco);
        myCart.addItem(meat);
        myCart.addItem(oranges);

        myCart.printTotal();
        myCart.printDescriptions();
        myCart.removeItem("Beef");
        myCart.printTotal();
}

*/


}
