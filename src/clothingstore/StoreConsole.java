/**
 * 
 */
package clothingstore;

/**
 * Stellt die Konsolenoberfläche des Bekleidungsgeschäfts bereit. Ermöglicht das
 * Anzeigen von Artikeln und Bestellungen, das Kaufen von Artikeln und das
 * Registrieren von Bestandsbenachrichtigungen.
 */
public class StoreConsole
{
    private Store store;
    private InputReader inputReader;

    /**
     * Erstellt eine Konsolenoberfläche für den angegebenen Store.
     *
     * @param store der über die Konsole verwendete Store
     */
    public StoreConsole(Store store)
    {
        this.store = store;
        inputReader = new InputReader();
    }

    /**
     * Gibt die verfügbaren Menüoptionen auf der Konsole aus.
     */
    public void printMenu()
    {
        System.out.println("1. Show all items");
        System.out.println("2. Buy an item");
        System.out.println("3. Show all orders");
        System.out.println("4. Notify me when an item is available");
        System.out.println("0. Exit");

    }

    /**
     * Liest Kunden- und Artikeldaten ein und versucht, eine Bestellung zu
     * erstellen. Bei der Antwort "yes" wird ein Mitgliedskunde erstellt, bei
     * jeder anderen Antwort ein regulärer Kunde. Nach erfolgreichem Kauf werden
     * die Bestelldaten ausgegeben. Fehler vom Typ IllegalArgumentException
     * werden abgefangen und als Meldung auf der Konsole angezeigt.
     */
    public void buyItemFromInput()
    {
        int choise = inputReader.readInt("Please inter your id: ");
        String enterName = inputReader.readString("Please enter your name: ");
        String enterAnswer = inputReader
                .readString("Are you a member? yes or no: ");
        Customer customer;
        if (enterAnswer.equalsIgnoreCase("yes"))
        {
            customer = new CustomerMember(choise, enterName);
        } else
        {
            customer = new Customer(choise, enterName);
        }
        int clotheId = inputReader.readInt("Please inter clothe id: ");
        String size = inputReader.readString("Please enter the size: ");
        int enterAmount = inputReader
                .readInt("Please inter how many item do you want to buy?: ");
        try
        {
            Order order = store.buyItem(customer, clotheId, size, enterAmount);
            order.printOrderInfo();
        } catch (IllegalArgumentException e)
        {
            System.out.println("Purchase failed: " + e.getMessage());
        }

    }

    /**
     * Liest Kunden-ID, Kundenname, Kleidungsmodell-ID und Größe ein.
     * Registriert den neu erstellten Kunden als Observer, wenn der passende
     * Artikel einen Bestand von null hat. Bei bereits verfügbarem Bestand wird
     * eine Meldung ausgegeben. Fehler vom Typ IllegalArgumentException werden
     * abgefangen und auf der Konsole angezeigt.
     */
    public void subscribeFromInput()
    {
        int customerId = inputReader.readInt("Please enter your ID: ");
        String name = inputReader.readString("Please enter your name: ");
        Customer customer = new Customer(customerId, name);

        int clothingId = inputReader.readInt("Please enter the clothing ID: ");
        String size = inputReader.readString("Please enter the size: ");

        try
        {
            StockItem stockItem = store.findStockItem(clothingId, size);

            if (stockItem == null)
            {
                throw new IllegalArgumentException("Item not found.");
            }

            if (stockItem.getQuantity() > 0)
            {
                System.out.println("This item is already available.");
            } else
            {
                stockItem.addObserver(customer);
                System.out.println("Stock notification request registered.");
            }
        } catch (IllegalArgumentException e)
        {
            System.out.println("Request failed: " + e.getMessage());
        }
    }

    /**
     * Startet die Menüschleife und führt die gewählte Aktion aus. Ungültige
     * Menüoptionen werden mit einer Meldung beantwortet. Die Schleife endet,
     * wenn die Option 0 gewählt wird.
     */
    public void start()
    {
        boolean running = true;
        while (running)
        {
            printMenu();
            int choice = inputReader.readInt("Choose an option: ");
            switch (choice)
            {
            case 1:
                store.printAllStockItems();
                break;
            case 2:
                buyItemFromInput();
                break;
            case 3:
                store.printAllOrders();
                break;
            case 4:
                subscribeFromInput();
                break;
            case 0:
                running = false;
                System.out.println("Goodbye");
                break;
            default:
                System.out.println("Invalid option");

            }

        }

    }

}