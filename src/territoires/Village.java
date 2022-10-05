package territoires;
import personnages.Chef;
import personnages.Gaulois;

public class Village {

	private String nom;
	private Chef chef;
	Gaulois[] villageois;
	int nbVillageois = 0;
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.villageois = new Gaulois[nbVillageoisMaximum];
		this.nom = nom;
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois nvGaulois) {
		this.villageois[this.nbVillageois] = nvGaulois;
		this.nbVillageois +=1 ;
	}
	
	public Gaulois trouverHabitant(int numVillageois) {
		return villageois[numVillageois];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du Chef " + this.chef.getNom() + " vivent les légendaires gaulois : \n");
		for (int i = 0; i < this.nbVillageois; i++) {
			System.out.println("-" + this.villageois[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles",30);
//		Gaulois gaulois = village.trouverHabitant(30);
//		Error : Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 30
//		at territoires.Village.trouverHabitant(Village.java:31)
//		at territoires.Village.main(Village.java:36)
//		Car la taille tu tableau est 30, on peut donc accéder qu'a la valeur 29 du tableau et non la 30 d'où le indexOutOfBound.
		Chef abraracourcix = new Chef("Abraracourcix",6,1,village);
		Gaulois asterix = new Gaulois("Astérix",8);
		village.setChef(abraracourcix);
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		exception cela n'affiche pas les infos du gaulois mais null car il n'existe pas de gaulois à l'index 1 mais il en existe un a l'index 0, c'est astérix.
		Gaulois obelix = new Gaulois("Obélix",25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
		
		

	}
}
