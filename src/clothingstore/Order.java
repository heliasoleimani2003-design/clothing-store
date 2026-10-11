/**
 * 
 */
package clothingstore;

/**
 * Beschreibt eine Bestellung eines Kunden für einen Bestandseintrag. Speichert
 * Stückzahl, Einzelpreis und Rabattsatz zum Zeitpunkt der Erstellung.
 */
public class Order
{
    private int id;
    private Customer customer;
    private StockItem stockItem;
    private int amount;
    private double unitPrice;
    private double discountRate;

    /**
     * Erstellt eine Bestellung und übernimmt den aktuellen Einzelpreis sowie
     * den Rabattsatz des Kunden. Der verfügbare Bestand wird hier nicht
     * verändert.
     *
     * @param id        die ID der Bestellung
     * @param customer  der kaufende Kunde
     * @param stockItem der bestellte Bestandseintrag
     * @param amount    die bestellte Stückzahl
     * @throws IllegalArgumentException wenn amount kleiner oder gleich null ist
     */
    public Order(int id, Customer customer, StockItem stockItem, int amount)
    {
        if (amount <= 0)
        {
            throw new IllegalArgumentException(
                    "Amount must be greater than zero.");
        }
        this.id = id;
        this.customer = customer;
        this.stockItem = stockItem;
        this.amount = amount;
        this.unitPrice = stockItem.getItem().getPrice();
        this.discountRate = customer.getDiscountRate();

    }

    /**
     * Gibt die ID der Bestellung zurück.
     *
     * @return die Bestell-ID
     */
    public int getId()
    {
        return id;
    }

    /**
     * Gibt den kaufenden Kunden zurück.
     *
     * @return der Kunde
     */
    public Customer getCustomer()
    {
        return customer;
    }

    /**
     * Gibt den bestellten Bestandseintrag zurück.
     *
     * @return der Bestandseintrag
     */
    public StockItem getStockItem()
    {
        return stockItem;
    }

    /**
     * Gibt die bestellte Stückzahl zurück.
     *
     * @return die Stückzahl
     */
    public int getAmount()
    {
        return amount;
    }

    /**
     * Gibt den bei der Erstellung gespeicherten Einzelpreis zurück.
     *
     * @return der Preis pro Stück in Euro vor Abzug des Rabatts
     */
    public double getUnitPrice()
    {
        return unitPrice;
    }

    /**
     * Berechnet den Gesamtpreis unter Berücksichtigung des gespeicherten
     * Rabattsatzes.
     *
     * @return der Gesamtpreis in Euro nach Abzug des Rabatts
     */
    public double getTotalPrice()
    {
        return amount * unitPrice * (1 - discountRate);
    }

    /**
     * Gibt Bestell-ID, Kundenname und Gesamtpreis auf der Konsole aus.
     */
    public void printOrderInfo()
    {
        System.out.println("Order ID: " + id);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Total price: " + getTotalPrice());
    }

}
