package personnages;

public class Gaulois {
	private String nom;
	int force;
	private int effetPotion = 1;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
		romain.recevoirCoup(force / 3);
	}
	
	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
		this.parler("Merci Druide, je sens que ma force est " + effetPotion + " fois d�cupl�e.");
	}
	
	@Override
	public String toString() {
		
		return "Gaulois [nom=" + nom + ", force=" + force
		+ ", effetPotion=" + effetPotion + "]";
	}
	
	public static void main(String[] args) {
		Gaulois asterix;
		Romain minus;
		asterix = new Gaulois("Ast�rix", 8);
		minus = new Romain("Minus", 10);
		asterix.prendreParole();
		asterix.parler("Pur�e de pomme de terre");
		asterix.frapper(minus);
		asterix.boirePotion(4);
		System.out.println(asterix);
	}
}


