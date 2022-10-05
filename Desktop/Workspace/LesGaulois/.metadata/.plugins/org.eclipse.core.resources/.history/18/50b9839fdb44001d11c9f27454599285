package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		assert (force >= 0) : "la force d’un Romain est toujours positive";
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert (force >= 0) : "la force d’un Romain est toujours positive";
		int preForce = force;
		force -= forceCoup;
		int postForce = force;
		assert (postForce < preForce) : "la force d’un Romain a diminué";
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}
	
	public void sEquiper(Equipement equipement) {
		// à finir
	}
	
	public static void main(String[] args) {
		Romain minus;
		minus = new Romain("Minus", 6);
		minus.prendreParole();
		minus.parler("Bonjour je mi namae Minus mais je suis pas minus mskn");
		minus.recevoirCoup(2);
		minus.recevoirCoup(4);
		System.out.println(Equipement.BOUCLIER);
	}
}
