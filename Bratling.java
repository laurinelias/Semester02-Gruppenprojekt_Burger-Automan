/**
 * Wird verwendet, um verschiedene Bratlinge zu erzeugen.
 *
 * @author Christian Supp, Laurin Schubert, Oliver Keune
 * @version 1.0
 */

public class Bratling extends Zutat {
    private int bratzeit; // Angabe in Sekunde!!!
    private float hoehe;

    /**
     * Konstruktor für Klasse: Gemüse ( bei einer Eigenschaft)
     *
     * @param nummer      Nummer des Salats
     * @param name        Name des Salats
     * @param preis       Preis des Salats
     * @param eigenschaft Klassisch, Vegan, Vegetarisch
     * @param bratzeit    Bratzeit von beiden Seiten
     * @param hoehe       Höhe des Bratlings
     */
    public Bratling ( int nummer, String name, float preis, Eigenschaft eigenschaft, int bratzeit, int hoehe ) {
        super( nummer, name, preis, eigenschaft );
        this.bratzeit = bratzeit;
        this.hoehe = hoehe;
    }


    /**
     * Gibt die Zubereitungsart aus.
     * Gibt die Zeit zurück, die für das Zubereiten benötigt wird.
     *
     * @return Zubereitungszeit in Sekunden
     */
    @Override
    public int zubereiten () {
        System.out.println( name + " wird von jeder Seite " + bratzeit / 120 + " Minuten und " + bratzeit % 60 / 2
                + " Sekunden gebraten" );
        return bratzeit; // gibt Bratzeit in Sekunden zurück
    }

    /**
     * Gibt die berechnete Höhe zurück.
     *
     * @return berechnete Höhe in mm.
     */
    @Override
    public float berechneHoehe () {
        return 0.965F * bratzeit * hoehe;
    }
}
