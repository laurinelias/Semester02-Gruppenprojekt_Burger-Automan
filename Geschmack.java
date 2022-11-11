/**
 * Wird verwendet, um verschiedene Geschmäcker zu definieren.
 *
 * @author Christian Supp, Laurin Schubert, Oliver Keune
 * @version 1.0
 */

public enum Geschmack {
    SUESS( "Suess" ), SCHARF( "Scharf" ), NORMAL( "Normal" );
    private String name;

    /**
     * Konstruktor für enum: Geschmack
     *
     * @param name Name des Eigenschaft
     */
    private Geschmack ( String name ) {
        this.name = name;
    }

    /**
     * ToString Methode
     *
     * @return Zurückgeben des Namens
     */
    public String toString () {
        return name;
    }
}
