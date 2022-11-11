import java.util.Arrays;

/**
 * Diese Klasse verwaltet die Befehle und Eingabe des Nutzers.
 * Die Main-Methode verrwaltet Zutaten und Burger einer Bestellung.
 *
 * @author Christian Supp, Laurin Schubert, Oliver Keune
 * @version 1.0
 */


public class Controller {
    static Burger[] alleBurger;
    static Zutat[] alleZutaten;
    static Burger aktuellerBurger;

    public static void main ( String[] args ) {

        String[] befehlListe = { "menu", "neuer burger", "zutat", "ok", "meine bestellung", "bestellen", "hilfe" };

        Zutat zutaten[] = new Zutat[18];
        // BRÖTCHEN (int nummer, String name, float preis, Eigenschaft eigenschaft, int
        // backzeit, int höhe)
        zutaten[0] = new Broetchen( 10, "Hamburger", 0.85f, 90, 27, Eigenschaft.KLASSISCH );
        zutaten[1] = new Broetchen( 11, "Hamburger-Sesam", 0.95f, 90, 28, Eigenschaft.KLASSISCH );
        zutaten[2] = new Broetchen( 12, "Vegan-Brötchen", 0.55f, 240, 34, Eigenschaft.VEGAN );
        zutaten[3] = new Broetchen( 13, "Ciabatta", 0.45f, 530, 41, Eigenschaft.VEGETARISCH );

        // BRATLING
        zutaten[4] = new Bratling( 20, "Rindfleisch", 1.85f, Eigenschaft.KLASSISCH, 270, 25 );
        zutaten[5] = new Bratling( 21, "Hänchenfleisch", 1.15f, Eigenschaft.GEGRILLT, 180, 11 );
        zutaten[6] = new Bratling( 22, "Falafelbratling", 1.45f, Eigenschaft.VEGAN, 210, 21 );
        zutaten[7] = new Bratling( 23, "Gemüsebratling", 1.75f, Eigenschaft.VEGETARISCH, 240, 25 );

        // SALAT
        zutaten[8] = new Salat( 30, "Eisbergsalat", 0.18f, Eigenschaft.KLASSISCH );
        zutaten[9] = new Salat( 31, "Rucolasalat", 0.25f );

        // GEMÜSE
        zutaten[10] = new Gemuese( 40, "Tomate", 0.25f, Eigenschaft.KLASSISCH, 3, 3 );
        zutaten[11] = new Gemuese( 41, "Salzgurke", 0.15f, Eigenschaft.KLASSISCH, 2, 4 );
        zutaten[12] = new Gemuese( 42, "Zwiebelringe", 0.08f, 2, 5 );
        zutaten[13] = new Gemuese( 43, "Jalapenoringe", 0.08f, 2, 5 );

        // SOSSE
        zutaten[14] = new Sauce( 50, "Ketchup", 0.10f, 5, Geschmack.NORMAL, Eigenschaft.KLASSISCH, Eigenschaft.VEGAN );
        zutaten[15] = new Sauce( 51, "Sandwichsauce", 0.15f, 10, Geschmack.NORMAL, Eigenschaft.VEGETARISCH );
        zutaten[16] = new Sauce( 52, "Chili-Sauce", 0.25f, 8, Geschmack.SCHARF, Eigenschaft.VEGAN );
        zutaten[17] = new Sauce( 53, "Honig-Senf-Sauce", 0.18f, 8, Geschmack.SUESS, Eigenschaft.VEGETARISCH );

        alleZutaten = zutaten;
        while ( true ) {
            System.out.println( "Geben Sie 'hilfe' ein um alle Befehle zu sehen, Sie können das Vorgang mit 'ende' abbrechen." );
            System.out.print( "Ihre Eingabe: " );
            String befehl = StaticScanner.nextString();
            if ( befehl.equals( "ende" ) || befehl.equals( "quit" ) ) {
                break;
            }
            befehlAusfuehren( befehlListe, getBefehl( befehlListe, befehl ), getParameter( befehlListe, befehl ), zutaten );
        }


    }

    /**
     * Überprüft die Eingabe und gibt den Index des Befehl separat zurück.
     *
     * @param befehlListe Array, das alle Befehle verwaltet.
     * @param befehl      Nutzereingabe
     */
    public static int getBefehl ( String[] befehlListe, String befehl ) {

        for ( int i = 0 ; i < befehlListe.length ; i++ ) {
            if ( befehl.contains( befehlListe[i] ) ) {
                return i;
            }
        }
        return -1;

    }

    /**
     * In dieser Methode wird der Parameter-Teil der Nutzereingabe herausgefiltert.
     *
     * @param befehlListe Array, das alle Befehle verwaltet.
     * @param befehl      Nutzereingabe
     */
    public static String getParameter ( String[] befehlListe, String befehl ) {

        String parameter = null;

        for ( int i = 0 ; i < befehlListe.length ; i++ ) {

            if ( befehl.toLowerCase().contains( befehlListe[i] ) ) {
                parameter = befehl.replace( befehlListe[i] + " ", "" );
                return parameter;
            }
        }
        return parameter;

    }

    /**
     * In dieser Methode wird der Eingabe des Nutzers der entsprechende Befehl zugewiesen und die entsprechende Methode aufgerufen.
     *
     * @param befehlListe Array, das alle Befehle verwaltet
     * @param befehl      Befehl-Teil der Eingabe des Nutzers
     * @param parameter   Parameter-Teil der Eingabe des Nutzers
     * @param zutaten     Array, das alle Zutaten verwaltet
     */

    public static void befehlAusfuehren ( String[] befehlListe, int befehl, String parameter, Zutat[] zutaten ) {

        switch ( befehl ) {
            // Zutat und neue Burger
            case 0:
                befehlMenu( zutaten );
                break;
            case 1:
                befehlNeuerBurger( parameter );
                break;
            case 2:
                befehlZutat( parameter );
                break;
            case 3:
                befehlOk();
                break;
            case 4:
                befehlMeineBestellung();
                break;
            case 5:
                befehlBestellen();
                break;
            case 6:
                System.out.println( Arrays.toString( befehlListe ) );
                break;
            default:
                break;
        }
    }

    /**
     * In dieser Methode werden alle Zutaten eines Arrays ausgegeben.
     *
     * @param zutaten Zutatenarray in dem alle vorhandenen Zutaten gespeichert sind.
     */

    public static void befehlMenu ( Zutat[] zutaten ) {

        for ( Zutat liste : zutaten ) {
            System.out.println( liste.toString() );
        }
    }

    /**
     * In dieser Methode wird ein neuer Burger erstellt, welchre dann zu der Bestellung hinzugefügt werden kann.
     *
     * @param name Name des Burgers
     */
    public static void befehlNeuerBurger ( String name ) {
        if ( aktuellerBurger != null ) {
            System.out.println( "Ihr derzeitiger Burger ist noch nicht fertig" );
            return;
        }
        aktuellerBurger = new Burger( name );
        System.out.println( "Burger '" + name + "' wurde erstellt" );
    }

    /**
     * In dieser Methode wird die Ausgesuchte Zutat zu dem Burger der aktuellen Bestellung hinzugefügt.
     *
     * @param parameter Die Nummer der Zutat
     */
    public static void befehlZutat ( String parameter ) {
        if ( aktuellerBurger == null ) {
            System.out.println( "Es wurde noch kein Burger erstellt" );
            return;
        }
        for ( int i = 0 ; i < alleZutaten.length ; i++ ) {
            if ( alleZutaten[i].getNummer() == Integer.valueOf( parameter ) ) {
                aktuellerBurger.addZutat( alleZutaten[i] );
                return;
            }
        }
        System.out.println( "Zutat konnte nicht gefunden werden" );
    }

    /**
     * In dieser Methode wird die Zusammenstellung eines Burgers beendet.
     * Befindet sich kein Burger in Erstellung, wird eine Fehlermeldung ausgegeben.
     * Das Array alleBurger wird um ein Feld erweitert, in das aktuellerBurger gespeichert wird.
     * Fehlt dem Burger noch ein Brötchen, wird eine Fehlermeldung ausgeworfen.
     */
    public static void befehlOk () {
        if ( aktuellerBurger == null ) {
            System.out.println( "Es ist kein Burger in der Erstellung" );
            return;
        }
        if ( aktuellerBurger.hatBroetchen() ) {
            aktuellerBurger.finalisiereBurger();
            int groesse = 0;
            if ( alleBurger != null )
                groesse = alleBurger.length;
            Burger[] neueBurger = new Burger[groesse + 1];
            for ( int i = 0 ; i < groesse ; i++ ) {
                neueBurger[i] = alleBurger[i];
            }
            neueBurger[groesse] = aktuellerBurger;
            alleBurger = neueBurger;
            aktuellerBurger = null;
            return;
        }
        System.out.println( "Ihr Burger hat noch kein Brötchen" );

    }

    /**
     * In dieser Methode wird die Ausgabe der gesammten Bestellung ausgeführt
     */
    public static void befehlMeineBestellung () {
        if ( alleBurger == null ) {
            System.out.println( "Ihre Bestellung ist leer" );
            return;
        }
        for ( Burger burger : alleBurger ) {
            System.out.println( burger.toString() );
        }
    }

    /**
     * In dieser Methode wird die Methode zubereiten() für jeden Burger aufgerufen, sofern mind. 1 Burger im Array alleBurger liegt.
     */
    public static void befehlBestellen () {
        if ( alleBurger == null ) {
            System.out.println( "Ihre Bestellung ist leer" );
            return;
        }
        for ( Burger burger : alleBurger ) {
            burger.zubereiten();
        }
    }
}
