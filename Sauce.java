import java.util.Arrays;

/**
 * Wird verwendet, um verschiedene Arten von Saucen zu erzeugen.
 *
 * @author Christian Supp, Laurin Schubert, Oliver Keune
 * @version 1.0
 */

public class Sauce extends Zutat {

    private int menge;
    private Geschmack geschmack;

    /**
     * Klassen Konstruktor
     *
     * @param eigenschaft Klassisch, Vegan, Vegetarisch
     * @param nummer      Nummer der Sauce
     * @param name        Name der Sauce
     * @param preis       Preis der Sauce
     * @param menge       Menge der Sauce für 1 Burger
     * @param geschmack   Normal, Scharf, Süß
     */
    public Sauce ( int nummer, String name, float preis, int menge, Geschmack geschmack, Eigenschaft... eigenschaft ) {
        super( nummer, name, preis, eigenschaft );
        this.menge = menge;
        this.geschmack = geschmack;
    }

    /**
     * Gibt die Zubereitungsart aus.
     * Gibt die Zeit zurück, die für das Zubereiten benötigt wird.
     *
     * @return Zubereitungszeit in Sekunden
     */
    @Override
    public int zubereiten () {
        System.out.println( name + " wird geschüttelt." );
        return 0;
    }


    /**
     * @return Details der Sauce
     */
    public String toString () {
        return nummer + " | " + name + " " + geschmack.toString() + " " + Arrays.toString( eigenschaft ) + " – " + preis + "€ ";
    }
}
