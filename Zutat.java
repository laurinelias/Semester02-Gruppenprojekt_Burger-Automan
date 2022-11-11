import java.util.Arrays;

/**
 * Wird verwendet, um verschiedene Arten von Zutaten zu erzeugen.
 *
 * @author Christian Supp, Laurin Schubert, Oliver Keune
 * @version 1.0
 */


public abstract class Zutat {
    protected int nummer;
    protected String name;
    protected float preis;
    protected Eigenschaft[] eigenschaft;
    protected String zusatzinfo = "";


    /**
     * Konstruktor für Klasse: Zutat ( bei einer Eigenschaft)
     *
     * @param nummer      Nummer des Zutat
     * @param name        Name des Zutat
     * @param preis       Preis des Zutat
     * @param eigenschaft Klassisch, Vegan, Vegetarisch
     */
    public Zutat ( int nummer, String name, float preis, Eigenschaft... eigenschaft ) {
        this.nummer = nummer;
        this.name = name;
        this.preis = preis;
        this.eigenschaft = eigenschaft;

    }

    public String getName () {
        return name;
    }

    public int getNummer () {
        return nummer;
    }

    public float getPreis () {
        return preis;
    }

    public abstract int zubereiten (); // abstrakte Methode welche in jeder Klasse anders verwendet wird

    /**
     * Wird von den meisten erbenden Klassen überschrieben, jedoch nicht von allen z.B. Salat & Sauce
     *
     * @return Höhe der Zutat
     */
    public float berechneHoehe () {
        return 0f;
    }

    /**
     * @return Zurückgeben der Details der Zutat.
     */
    public String toString () {
        return nummer + " | " + name + " " + Arrays.toString( eigenschaft ) + zusatzinfo + " – " + preis + "€ ";
    }
}
