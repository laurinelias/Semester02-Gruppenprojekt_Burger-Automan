
/**
 * Wird verwendet, um verschiedene Arten von Salaten zu erzeugen.
 *
 * @author Christian Supp, Laurin Schubert, Oliver Keune
 * @version 1.0
 */

public class Salat extends Zutat {

	/**
	*  Konstruktor für Klasse: Salat ( bei zwei Eigenschaften)
	* @param nummer 	Nummer des Salats
	* @param name		Name des Salats
	* @param preis 		Preis des Salats
	* @param eigenschaft Klassisch, Vegan, Vegetarisch
	*/
	public Salat(int nummer, String name, float preis, Eigenschaft eigenschaft) {
		super(nummer, name, preis, Eigenschaft.VEGAN, eigenschaft);
	}
	
	 /**
	 *Konstruktor für Klasse: Salat ( bei einer Eigenschaft)
	* @param nummer 	Nummer des Salats
	* @param name		Name des Salats
	* @param preis 		Preis des Salats
	*/
	
	public Salat(int nummer, String name, float preis) {
		super(nummer, name, preis, Eigenschaft.VEGAN);
	}

	
	/**
	*	Gibt die Zubereitungsart aus.
	*	Gibt die Zeit zurück, die für das Zubereiten benötigt wird.
	*	@return Zubereitungszeit in Sekunden
	*/
	
	@Override
	public int zubereiten() {
		System.out.println(name + " wird gewaschen und geschleudert");
		return 0;
	}
}
