/**
 * 
 */
package clothingstore;

import java.util.Scanner;

/**
 * Liest Ganzzahlen und Texte von der Konsole ein. Wiederholt die
 * Eingabeaufforderung bei ungültigen Eingaben.
 */
public class InputReader
{
    private Scanner scanner;

    /**
     * Erstellt einen InputReader, der Eingaben über System.in liest.
     */
    public InputReader()
    {
        scanner = new Scanner(System.in);
    }

    /**
     * Liest eine Ganzzahl ein. Kann die Eingabe nicht als int interpretiert
     * werden, wird eine Fehlermeldung ausgegeben und erneut gefragt. Auch null
     * und negative Zahlen werden akzeptiert.
     *
     * @param message die Meldung vor der Eingabeaufforderung
     * @return die eingegebene Ganzzahl
     */
    public int readInt(String message)
    {

        while (true)
        {
            System.out.println(message);
            String input = scanner.nextLine();
            try
            {
                int number = Integer.parseInt(input);
                return number;
            } catch (NumberFormatException e)
            {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

    }

    /**
     * Liest einen Text ein, der mindestens ein Zeichen enthält, das kein
     * Leerraumzeichen ist. Bei einer leeren Eingabe oder einer Eingabe aus
     * ausschließlich Leerraumzeichen wird erneut gefragt. Der zurückgegebene
     * Text wird nicht gekürzt.
     *
     * @param message die Meldung vor der Eingabeaufforderung
     * @return der eingegebene Text
     */
    public String readString(String message)
    {
        while (true)
        {
            System.out.println(message);
            String input = scanner.nextLine();
            if (input.isBlank())
            {
                System.out.println("Please enter an explanation.");
            } else
            {
                return input;
            }
        }
    }

}
