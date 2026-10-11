/**
 * 
 */
package clothingstore;

/**
 * Beschreibt einen Kunden mit Mitgliedschaft, der einen Rabatt von zehn Prozent
 * erhält. Erbt die Kundendaten und die Bestandsbenachrichtigung von Customer.
 */
public class CustomerMember extends Customer
{

    /**
     * Erstellt einen Kunden mit Mitgliedschaft.
     *
     * @param id   die ID des Kunden
     * @param name der Name des Kunden
     */
    public CustomerMember(int id, String name)
    {
        super(id, name);

    }

    /**
     * Gibt den Rabattsatz für Mitglieder zurück.
     *
     * @return 0.10, entsprechend einem Rabatt von zehn Prozent
     */
    @Override
    public double getDiscountRate()
    {
        return 0.10;
    }

}
