package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		assert (force >= 0) : "la force d�un Romain est toujours positive";
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
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert (force >= 0) : "la force d�un Romain est toujours positive";
		int preForce = force;
		force -= forceCoup;
		int postForce = force;
		assert (postForce < preForce) : "la force d�un Romain a diminu�";
		if (force > 0) {
			parler("A�e");
		} else {
			parler("J'abandonne...");
		}
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
			case 2: 
				System.out.println("Le soldat " + this.getNom() + " est déjà bien protégé !");
				break;
			case 1:
				if (equipements[0] == equipement) {
					System.out.println("Le soldat " + this.getNom() + " possède déjà un " + equipement.nom);
					break;
				}
			default:
				equipements[nbEquipement] = equipement;
				nbEquipement += 1;
				System.out.println("Le soldat " + this.getNom() + " s'équipe avec un " + equipement.nom + ".");
				break;
				
		}
				
			
	}
	
	public static void main(String[] args) {
		Romain minus;
		minus = new Romain("Minus", 6);
		minus.prendreParole();
		minus.parler("Bonjour je mi namae Minus mais je suis pas minus mskn");
		minus.recevoirCoup(2);
		minus.recevoirCoup(4);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
