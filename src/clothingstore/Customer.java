/**
 * 
 */
package clothingstore;

/**
 * Beschreibt einen Kunden mit ID und Name. Empfängt als StockObserver
 * Benachrichtigungen, wenn ein Artikel wieder verfügbar ist.
 */
public class Customer implements StockObserver
{
    private int id;
    private String name;

    /**
     * Erstellt einen Kunden.
     *
     * @param id   die ID des Kunden
     * @param name der Name des Kunden
     */
    public Customer(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    /**
     * Gibt die ID des Kunden zurück.
     *
     * @return die Kunden-ID
     */
    public int getId()
    {
        return id;
    }

    /**
     * Gibt den Namen des Kunden zurück.
     *
     * @return der Name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Gibt eine persönliche Benachrichtigung über einen wieder verfügbaren
     * Artikel auf der Konsole aus.
     *
     * @param stockItem der wieder verfügbare Bestandseintrag
     */
    @Override
    public void onStockAvailable(StockItem stockItem)
    {
        System.out.println("Hello " + name + "! "
                + stockItem.getItem().getName() + " in size "
                + stockItem.getSize() + " is available again.");
    }

    /**
     * Gibt den Rabattsatz für einen regulären Kunden zurück. Unterklassen
     * können diese Methode überschreiben.
     *
     * @return 0.0, da reguläre Kunden keinen Rabatt erhalten
     */
    public double getDiscountRate()
    {
        return 0.0;
    }

}
