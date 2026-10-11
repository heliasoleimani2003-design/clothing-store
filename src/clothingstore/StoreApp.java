/**
 * 
 */
package clothingstore;

/**
 * 
 */
public class StoreApp
{
    public static void main(String[] args)
    {
        Store store = new Store();

        ClothingItem shirt = new ClothingItem(1, "White Shirt", 20.0);
        ClothingItem shirt2 = new ClothingItem(2, "Black Shirt", 20.0);
        ClothingItem shirt3 = new ClothingItem(3, "Blue Shirt", 20.0);

        StockItem shirtM = new StockItem(shirt, "M", 10);
        StockItem shirt2M = new StockItem(shirt2, "M", 9);
        StockItem shirtL = new StockItem(shirt3, "L", 10);
        StockItem shirtXL = new StockItem(shirt, "XL", 0);

        store.addStockItems(shirtM);
        store.addStockItems(shirt2M);
        store.addStockItems(shirtL);
        store.addStockItems(shirtXL);

        Customer helia = new Customer(2, "Helia");
        Customer sarina = new Customer(3, "Sarina");

        shirtXL.addObserver(helia);
        shirtXL.addObserver(sarina);

        StoreConsole console = new StoreConsole(store);
        console.start();

    }

}
