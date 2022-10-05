package histoire;

import personnages.Gaulois;
import personnages.Romain;
import personnages.Druide;

public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix, obelix;
		Romain minus;
		Druide panoramix;
		panoramix = new Druide("Panoramix",5,10);
		asterix = new Gaulois("Ast�rix", 8);
		obelix = new Gaulois("Ob�lix", 10);
		minus = new Romain("Minus", 6);
		
		panoramix.parler("Je vais aller pr�parer une petite potion...");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		asterix.parler("Bonjour");
		minus.parler(" UN GAU... UN GAUGAU...");
		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);

	}

}
