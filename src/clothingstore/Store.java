/**
 * 
 */
package clothingstore;

import java.util.ArrayList;
import java.util.List;

/**
 * Verwaltet die Bestandseinträge und Bestellungen eines Bekleidungsgeschäfts.
 * Ermöglicht das Hinzufügen, Entfernen, Suchen und Anzeigen von
 * Bestandseinträgen sowie das Erfassen von Käufen.
 */
public class Store
{
    private List<StockItem> stockItems;
    private List<Order> orders;
    private int nextOrderId = 1;

    /**
     * Erstellt einen Store mit einer leeren Bestandsliste und einer leeren
     * Bestellliste. Die Nummerierung der Bestellungen beginnt bei 1.
     */
    public Store()
    {
        stockItems = new ArrayList<>();
        orders = new ArrayList<>();
    }

    /**
     * Fügt einen Bestandseintrag zur Liste hinzu.
     *
     * @param stockItem der hinzuzufügende Bestandseintrag
     */
    public void addStockItems(StockItem stockItem)
    {
        stockItems.add(stockItem);
    }

    /**
     * Entfernt den angegebenen Bestandseintrag aus der Liste. Ist der Eintrag
     * nicht vorhanden, bleibt die Liste unverändert. Bereits erfasste
     * Bestellungen bleiben erhalten.
     *
     * @param stockItem der zu entfernende Bestandseintrag
     */
    public void removeStockItems(StockItem stockItem)
    {
        stockItems.remove(stockItem);
    }

    /**
     * Sucht den ersten passenden Bestandseintrag anhand der Kleidungsmodell-ID
     * und der Größe. Die Größe wird ohne Beachtung der Groß- und
     * Kleinschreibung verglichen.
     *
     * @param itemId die ID des gesuchten Kleidungsmodells
     * @param size   die gesuchte Größe
     * @return der passende Bestandseintrag oder null, wenn kein Eintrag
     *         gefunden wurde
     */
    public StockItem findStockItem(int itemId, String size)
    {
        for (StockItem stockItem : stockItems)
        {
            if (itemId == stockItem.getItem().getId()
                    && stockItem.getSize().equalsIgnoreCase(size))
            {
                return stockItem;
            }
        }
        return null;

    }

    /**
     * Gibt ID, Name, Preis, Größe und Bestand aller Bestandseinträge auf der
     * Konsole aus. Auch Einträge mit einem Bestand von null werden angezeigt.
     * Bei einer leeren Liste wird eine entsprechende Meldung ausgegeben.
     */
    public void printAllStockItems()
    {
        if (stockItems.isEmpty())
        {
            System.out.println("No items available.");
        }
        for (StockItem stockItem : stockItems)
        {
            System.out.print("Id: " + stockItem.getItem().getId() + " | ");
            System.out.print("Name: " + stockItem.getItem().getName() + " | ");
            System.out
                    .print("Price: " + stockItem.getItem().getPrice() + " | ");
            System.out.print("Size: " + stockItem.getSize() + " | ");
            System.out.println("Stock: " + stockItem.getQuantity());
        }

    }

    /**
     * Erstellt eine Bestellung für den angegebenen Kunden und verringert den
     * verfügbaren Bestand. Nach erfolgreicher Bestandsverringerung wird die
     * Bestellung gespeichert und die nächste Bestellnummer erhöht.
     *
     * @param customer der kaufende Kunde
     * @param itemId   die ID des Kleidungsmodells
     * @param size     die gewünschte Größe
     * @param amount   die zu kaufende Stückzahl
     * @return die erstellte Bestellung
     * @throws IllegalArgumentException wenn der Artikel nicht gefunden wird,
     *                                  amount nicht positiv ist oder der
     *                                  Bestand nicht ausreicht
     */
    public Order buyItem(Customer customer, int itemId, String size, int amount)
    {
        StockItem stockItem = findStockItem(itemId, size);
        if (stockItem == null)
        {
            throw new IllegalArgumentException("Item not found.");
        }
        Order order = new Order(nextOrderId, customer, stockItem, amount);

        stockItem.decreaseStock(amount);
        orders.add(order);
        nextOrderId++;
        return order;

    }

    /**
     * Gibt die Informationen aller erfassten Bestellungen in der Reihenfolge
     * ihrer Registrierung auf der Konsole aus. Bei einer leeren Bestellliste
     * wird eine entsprechende Meldung ausgegeben.
     */
    public void printAllOrders()
    {
        if (orders.isEmpty())
        {
            System.out.println("No order is available.");
        }
        for (Order order : orders)
        {
            order.printOrderInfo();

        }
    }

}
