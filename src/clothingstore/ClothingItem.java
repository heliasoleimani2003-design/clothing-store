/**
 * 
 */
package clothingstore;

/**
 * Beschreibt ein Kleidungsmodell mit ID, Name und Preis. Größe und Bestand
 * werden separat in StockItem verwaltet.
 */
public class ClothingItem
{
    private int id;
    private String name;
    private double price;

    /**
     * Erstellt ein Kleidungsmodell.
     *
     * @param id    die ID des Kleidungsmodells
     * @param name  der Name des Kleidungsmodells
     * @param price der Preis pro Stück in Euro
     */
    public ClothingItem(int id, String name, double price)
    {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /**
     * Gibt die ID des Kleidungsmodells zurück.
     *
     * @return die ID
     */
    public int getId()
    {
        return id;
    }

    /**
     * Gibt den Namen des Kleidungsmodells zurück.
     *
     * @return der Name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Gibt den Preis pro Stück zurück.
     *
     * @return der Preis in Euro
     */
    public double getPrice()
    {
        return price;
    }

}
