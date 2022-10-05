package personnages;
import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " � " + effetPotionMax + ".");
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}
	
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public void preparerPotion() {
		Random random;
		random = new Random();
		this.forcePotion = random.nextInt(effetPotionMax - effetPotionMin);
		this.forcePotion = forcePotion + effetPotionMin;
		if(forcePotion > 7) {
			this.parler("J'ai pr�par� une super potion de force !" + "La potion � une force de " + forcePotion);
		}else {
			this.parler("Je n'ai pas trouv� tous les ingr�dients, ma potion est seulement de force " + forcePotion);
		}
	}
	
	public void booster(Gaulois gaulois) {
		if (gaulois.getNom() == "Obélix") {
			this.parler("Non, Obélix !... Tu n’auras pas de potion magique ! ");
		}else {
			gaulois.boirePotion(forcePotion);
		}
		
	}
	
	public static void main(String[] args) {
		Druide panoramix;
		Gaulois prout;
		prout = new Gaulois("piiuooui", 5);
		panoramix = new Druide("Panoramix",5,10);
		panoramix.preparerPotion();
		panoramix.preparerPotion();
		panoramix.preparerPotion();
		panoramix.booster(prout);
	}
	
}