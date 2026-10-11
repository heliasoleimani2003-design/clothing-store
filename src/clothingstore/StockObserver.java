/**
 * 
 */
package clothingstore;

/**
 * Definiert die Schnittstelle für Observer, die über wieder verfügbare Artikel
 * informiert werden.
 */
public interface StockObserver
{
    /**
     * Wird aufgerufen, wenn ein Artikel wieder verfügbar ist.
     *
     * @param stockItem der wieder verfügbare Bestandseintrag
     */
    void onStockAvailable(StockItem stockItem);

}
