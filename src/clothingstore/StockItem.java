/**
 * 
 */
package clothingstore;

import java.util.ArrayList;
import java.util.List;

/**
 * Verwaltet den Bestand eines Kleidungsmodells in einer bestimmten Größe.
 * Benachrichtigt registrierte Observer, wenn ein zuvor ausverkaufter Artikel
 * wieder verfügbar wird.
 */
public class StockItem
{
    private ClothingItem item;
    private String size;
    private int quantity;
    private List<StockObserver> observers;

    /**
     * Erstellt einen Bestandseintrag mit einer leeren Observer-Liste.
     *
     * @param item     das zugehörige Kleidungsmodell
     * @param size     die Größe des Kleidungsstücks
     * @param quantity die verfügbare Stückzahl
     * @throws IllegalArgumentException wenn quantity negativ ist
     */
    public StockItem(ClothingItem item, String size, int quantity)
    {
        if (quantity < 0)
        {
            throw new IllegalArgumentException(
                    "Quantity must not be negative.");
        }

        this.item = item;
        this.size = size;
        this.quantity = quantity;
        observers = new ArrayList<>();
    }

    /**
     * Gibt das zugehörige Kleidungsmodell zurück.
     *
     * @return das Kleidungsmodell
     */
    public ClothingItem getItem()
    {
        return item;
    }

    /**
     * Gibt die Größe zurück.
     *
     * @return die Größe
     */
    public String getSize()
    {
        return size;
    }

    /**
     * Gibt die aktuell verfügbare Stückzahl zurück.
     *
     * @return die verfügbare Stückzahl
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * Erhöht den Bestand um die angegebene Stückzahl. War der Bestand zuvor
     * null, werden nach der Erhöhung alle registrierten Observer
     * benachrichtigt.
     *
     * @param amount die hinzuzufügende Stückzahl
     * @throws IllegalArgumentException wenn amount kleiner oder gleich null ist
     */
    public void increaseStock(int amount)
    {
        if (amount <= 0)
        {
            throw new IllegalArgumentException(
                    "Amount must be greater than zero.");
        }
        if (quantity == 0)
        {
            quantity += amount;
            notifyObservers();
        } else
        {
            quantity += amount;

        }

    }

    /**
     * Verringert den Bestand um die angegebene Stückzahl.
     *
     * @param amount die zu entnehmende Stückzahl
     * @throws IllegalArgumentException wenn amount kleiner oder gleich null ist
     *                                  oder den verfügbaren Bestand
     *                                  überschreitet
     */
    public void decreaseStock(int amount)
    {
        if (amount <= 0)
        {
            throw new IllegalArgumentException(
                    "Amount must be greater than zero.");
        } else if (amount > quantity)
        {
            throw new IllegalArgumentException("Not enough stock available.");
        }

        quantity -= amount;

    }

    /**
     * Registriert einen Observer für Bestandsbenachrichtigungen. Ein bereits
     * enthaltener Observer wird nicht erneut hinzugefügt.
     *
     * @param observer der zu registrierende Observer
     */
    public void addObserver(StockObserver observer)
    {
        if (!observers.contains(observer))
        {
            observers.add(observer);
        }

    }

    /**
     * Entfernt einen Observer aus der Observer-Liste. Ist er nicht registriert,
     * bleibt die Liste unverändert.
     *
     * @param observer der zu entfernende Observer
     */
    public void removeObserver(StockObserver observer)
    {
        observers.remove(observer);
    }

    /**
     * Benachrichtigt alle registrierten Observer und übergibt ihnen diesen
     * Bestandseintrag. Die Observer bleiben anschließend registriert.
     */
    public void notifyObservers()
    {
        for (StockObserver observer : observers)
        {
            observer.onStockAvailable(this);
        }
    }

}
