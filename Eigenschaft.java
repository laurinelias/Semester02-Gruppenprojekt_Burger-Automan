/**
 * Wird verwendet, um verschiedene Eigenschaften zu definieren.
 *
 * @author Christian Supp, Laurin Schubert, Oliver Keune
 * @version 1.0
 */

public enum Eigenschaft{
    KLASSISCH("Klassisch"), VEGETARISCH("Vegetarisch"), VEGAN("Vegan"), GEGRILLT("Gegrillt");
    private String name;
    
    /**
	*  Konstruktor für enum: Eigenschaft 
	* @param name			Name der Eigenschaft
	*/
    private Eigenschaft(String name){
        this.name=name;
    }
    
    /**
    *ToString Methode 
    * @return Zurückgeben des Namens 
    */ 
    public String toString(){
        return name;
    }
}