/**
 * Wird verwendet, um verschiedene Gemüsesorten zu erzeugen.
 *
 * @author Christian Supp, Laurin Schubert, Oliver Keune
 * @version 1.0
 */

public class Gemuese extends Zutat {

    private int scheibenDicke;
    private int scheibenAnzahl;

    /**
     * Konstruktor für Klasse: Gemüse ( bei zwei Eigenschaften)
     *
     * @param nummer         Nummer des Salats
     * @param name           Name des Salats
     * @param preis          Preis des Salats
     * @param eigenschaft    Klassisch, Vegan, Vegetarisch
     * @param scheibenDicke  Dicke der Scheiben
     * @param scheibenAnzahl Anzahl der Scheiben
     */

    public Gemuese ( int nummer, String name, float preis, Eigenschaft eigenschaft,
                     int scheibenDicke, int scheibenAnzahl ) {
        super( nummer, name, preis, Eigenschaft.VEGAN, eigenschaft );
        this.scheibenDicke = scheibenDicke;
        this.scheibenAnzahl = scheibenAnzahl;

    }

    /**
     * Konstruktor für Klasse: Gemüse ( bei einer Eigenschaft)
     *
     * @param nummer         Nummer des Salats
     * @param name           Name des Salats
     * @param preis          Preis des Salats
     * @param scheibenDicke  Dicke der Scheiben
     * @param scheibenAnzahl Anzahl der Scheieben
     */

    public Gemuese ( int nummer, String name, float preis, int scheibenDicke, int scheibenAnzahl ) {
        super( nummer, name, preis, Eigenschaft.VEGAN );
        this.scheibenDicke = scheibenDicke;
        this.scheibenAnzahl = scheibenAnzahl;

    }

    /**
     * Gibt die Zubereitungsart aus.
     * Gibt die Zeit zurück, die für das Zubereiten benötigt wird.
     *
     * @return Zubereitungszeit in Sekunden
     */

    @Override
    public int zubereiten () {
        System.out.println( name + " wird gewaschen" );

        for ( int i = 1 ; i <= scheibenAnzahl ; i++ ) {
            System.out.println( i + ". Scheibe mit " + scheibenDicke + "mm schneiden" );
        }


        return scheibenAnzahl; // 1 Sekunde pro Scheibe
    }

    /**
     * Gibt die berechnete Höhe zurück.
     *
     * @return berechnete Höhe in mm.
     */

    @Override
    public float berechneHoehe () {
        return scheibenAnzahl * scheibenDicke;
    }

}
