/**
 * Wird verwendet, um verschiedene Bröötchen zu erzeugen.
 *
 * @author Christian Supp, Laurin Schubert, Oliver Keune
 * @version 1.0
 */

public class Broetchen extends Zutat {
	private int backzeit;
	private int hoehe;


	/**
	*  Konstruktor für Klasse: Broetchen ( bei einer Eigenschaft)
	* @param nummer 	 Nummer des Salats
	* @param name		 Name des Salats
	* @param preis 		 Preis des Salats
	* @param backzeit	 Backzeit
	* @param hoehe		 Höhe des Brötchens
	* @param eigenschaft Klassisch, Vegan, Vegetarisch
	*/
	public Broetchen(int nummer, String name, float preis, int backzeit, int hoehe, Eigenschaft... eigenschaft) {
		super(nummer, name, preis, eigenschaft);
		this.backzeit = backzeit;
		this.hoehe = hoehe;
	}

	/**
	*	Gibt die Zubereitungsart aus.
	*	Gibt die Zeit zurück, die für das Zubereiten benötigt wird.
	*	@return Zubereitungszeit in Sekunden
	*/

	@Override
	public int zubereiten() {
		System.out.println(name + " " + backzeit + " Minuten rösten und aufschneiden");
		return backzeit;
	}

	/**
	*	Gibt die berechnete Höhe zurück.
	*	@return berechnete Höhe in mm.
	*/

	@Override
	public float berechneHoehe() {

		return 1.025f * backzeit * hoehe;
	}

}
