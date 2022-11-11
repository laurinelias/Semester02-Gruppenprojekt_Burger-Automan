import java.util.Arrays;


/**
 * Wird verwendet, um verschiedene Burger zu erzeugen.
 *
 * @author Christian Supp, Laurin Schubert, Oliver Keune
 * @version 1.0
 */


public class Burger {
    protected String name;
    protected float preis;
    protected Eigenschaft[] eigenschaft;
    float hoehe;
    Zutat[] zutaten;
    boolean hatBroetchen;

    /**
     * @return Details des Burgers
     */
    @Override
    public String toString () {
        return "Burger{" +
                "name='" + name + '\'' +
                ", preis=" + preis +
                ", zutaten=" + Arrays.toString( zutaten ) +
                ", eigenschaft=" + Arrays.toString( eigenschaft ) +
                ", hoehe=" + hoehe +
                '}';
    }

    final int MAXIMALEZUTATEN = 9;
    int hinzugefuegteZutaten = 0;

    public Burger ( String name ) {
        this.name = name;
    }

    /**
     * In dieser Methode werden die Zubereitungsschritte der zugehörigen Zutaten ausgegeben.
     */
    public void zubereiten () {
        if ( zutaten == null ) {
            return;
        }
        System.out.println( "Burger '" + name + "' wird zubereitet" );
        for ( Zutat zutat : zutaten ) {
            zutat.zubereiten();
        }
    }

    /**
     * In dieser Methode werden die Zutaten zu Burger hinzugefügt.
     * Ebenfalls wird überprüft ob der Burger schon ein Brötchen hat oder ob ihm noch eins fehlt.
     * Ebenfalls wird überprüft ob die max. Zutatenmenge von 9 erreicht wurde.
     * @param zutat	Hinzuzufügende Zutat
     */
    public void addZutat ( Zutat zutat ) {
        if ( hinzugefuegteZutaten >= MAXIMALEZUTATEN && hatBroetchen )
            System.out.println( "Burger hat die maximale Zutatenmenge erreicht." );

        else if ( zutat instanceof Broetchen ) {
            if ( hatBroetchen() ) {
                System.out.println( "Burger hat schon ein Brötchen." );
                return;
            }
            hinzufuegen( zutat );
            System.out.println( "Zutat " + zutat.toString() + " wurde dem Burger hinzugefügt" );
        } else if ( hinzugefuegteZutaten >= (MAXIMALEZUTATEN - 1) && !(zutat instanceof Broetchen) ) {
            System.out.println( "Burger braucht noch ein Brötchen." );
        } else {
            hinzufuegen( zutat );
            System.out.println( "Zutat " + zutat.toString() + " wurde dem Burger hinzugefügt" );
        }
    }

    /*
     *In dieser Methode wird die hinzuzufügende Zutat dem Zutatenarray hinzugefügt.
     */
    private void hinzufuegen ( Zutat zutat ) {
        hinzugefuegteZutaten++;
        //  Damit wirklich kein größerer Burger enstehen kann
        if ( hinzugefuegteZutaten > MAXIMALEZUTATEN ) {
            hinzugefuegteZutaten = MAXIMALEZUTATEN;
        }
        Zutat[] neuesArray = new Zutat[hinzugefuegteZutaten];
        int groesse = zutaten == null ? 0 : zutaten.length;
        for ( int i = 0 ; i < groesse ; i++ ) {
            neuesArray[i] = zutaten[i];
        }
        neuesArray[hinzugefuegteZutaten - 1] = zutat;
        this.zutaten = neuesArray;
    }

    /**
     * Sucht nach Brötchen unter den Zutaten
     *
     * @return true wenn Brötchen vorhanden ist, false wenn nicht
     */
    public boolean hatBroetchen () {
        if ( zutaten == null ) {
            return false;
        }
        for ( Zutat zutat : zutaten ) {
            if ( zutat instanceof Broetchen ) {
                hatBroetchen = true;
                return true;
            }
        }
        return false;
    }

    /**
     * Ruft die restlichen Methoden auf, die die Details setzen
     */
    public void finalisiereBurger () {
        berechneHoehe();
        berechnePreis();
        istKlassisch();
        istVegetarisch();
        istVegan();
    }

    /**
     * Überprüft ob alle Zutaten Vegan sind
     *
     * @return true wenn Vegan
     */
    public boolean istVegan () {
        if ( zutaten == null ) {
            return true;
        }
        for ( Zutat zutat : zutaten ) {
            if ( !Arrays.toString( zutat.eigenschaft ).contains( "Vegan" ) )
                return false;
        }
        int groesse = eigenschaft == null ? 1 : eigenschaft.length + 1;
        if ( groesse > 1 ) {
            for ( Eigenschaft eig : eigenschaft ) {
                if ( eig == Eigenschaft.VEGAN )
                    return true;
            }
            eigenschaft = Arrays.copyOf( eigenschaft, groesse );

        } else {
            eigenschaft = new Eigenschaft[groesse];
        }
        eigenschaft[groesse - 1] = Eigenschaft.VEGAN;
        return true;
    }

    /**
     * Überprüft ob alle Zutaten Vegetarisch sind
     *
     * @return true wenn Vegetarisch
     */
    public boolean istVegetarisch () {
        if ( zutaten == null ) {
            return true;
        }
        for ( Zutat zutat : zutaten ) {
            if ( !Arrays.toString( zutat.eigenschaft ).contains( "Vegan" ) &&
                    !Arrays.toString( zutat.eigenschaft ).contains( "Vegetarisch" ) )
                return false;
        }
        int groesse = eigenschaft == null ? 1 : eigenschaft.length + 1;
        if ( groesse > 1 ) {
            for ( Eigenschaft eig : eigenschaft ) {
                if ( eig == Eigenschaft.VEGETARISCH )
                    return true;
            }
            eigenschaft = Arrays.copyOf( eigenschaft, groesse );

        } else {
            eigenschaft = new Eigenschaft[groesse];
        }
        eigenschaft[groesse - 1] = Eigenschaft.VEGETARISCH;
        return true;
    }

    /**
     * Überprüft ob alle Zutaten Klassisch sind
     *
     * @return true wenn Klassisch
     */
    public boolean istKlassisch () {
        if ( zutaten == null ) {
            return true;
        }
        for ( Zutat zutat : zutaten ) {
            if ( !Arrays.toString( zutat.eigenschaft ).contains( "Klassisch" ) )
                return false;
        }
        int groesse = eigenschaft == null ? 1 : eigenschaft.length + 1;
        if ( groesse > 1 ) {
            for ( Eigenschaft eig : eigenschaft ) {
                if ( eig == Eigenschaft.KLASSISCH )
                    return true;
            }
            eigenschaft = Arrays.copyOf( eigenschaft, groesse );

        } else {
            eigenschaft = new Eigenschaft[groesse];
        }
        eigenschaft[groesse - 1] = Eigenschaft.KLASSISCH;
        return true;
    }

    /**
     * Setzt die Hoehe des Burgers auf die Summe der Hoehe der Zutaten
     *
     * @return Hoehe des gesamten Burges
     */
    public float berechneHoehe () {
        hoehe = 0;
        if ( zutaten != null ) {
            for ( Zutat zutat : zutaten ) hoehe += zutat.berechneHoehe();
        }
        return hoehe;
    }

    /**
     * Setzt den Preis des Burgers auf den Preis aller Zutaten
     *
     * @return Preis des Burgers
     */
    public float berechnePreis () {
        hoehe = 0;
        if ( zutaten != null ) {
            for ( Zutat zutat : zutaten ) preis += zutat.getPreis();
        }
        return preis;
    }
}
