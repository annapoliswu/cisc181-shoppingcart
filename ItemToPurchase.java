/**
 * Created by Anna on 3/3/2018.
 */

//Class ItemToPurchase with an item name, item price, and quantity of item
public class ItemToPurchase {
    private String itemName;
    private int itemPrice;
    private int itemQuantity;
    private String itemDescription;

    ItemToPurchase(){
        itemName = "none";
        itemPrice = 0;
        itemQuantity = 0;
        itemDescription = "none";
    }

    ItemToPurchase(String name, String description, int price, int quantity){
        itemName = name;
        itemPrice = price;
        itemQuantity = quantity;
        itemDescription = description;
    }


    public void setName(String newName){
        itemName = newName;
    }
    public String getName(){
        return itemName;
    }

    public void setPrice(int newPrice){
        itemPrice = newPrice;
    }
    public int getPrice(){
        return itemPrice;
    }

    public void setQuantity(int newQuantity){
        itemQuantity = newQuantity;
    }
    public int getQuantity(){
        return itemQuantity;
    }

    public void setDescription(String newDescription){
        itemDescription = newDescription;
    }
    public String getDescription(){
        return itemDescription;
    }

    public void printItemCost(){
        System.out.println(itemName + " " + itemQuantity + " @ $" + itemPrice + " = $" + (itemPrice * itemQuantity));
    }

    public void printItemDescription(){
        System.out.println(itemName + ": " + itemDescription);
    }




}
