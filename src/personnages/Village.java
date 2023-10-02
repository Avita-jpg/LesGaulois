package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}

	public void ajouterHabitant(Gaulois habitant) {
		villageois[nbVillageois] = habitant;
		nbVillageois++;
	}

	public Gaulois trouverHabitant(int numero) {
		return villageois[numero];
	}

	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- " + villageois[i].getNom());
		}
	}

	public static void main(String[] args) {
		Village village = new Village("Village des irréductibles", 30);

		// Gaulois gaulois = village.trouverHabitant(30);
		// L'exception se produit parceque on essaye d' accéder au tableau à un indice
		// incorrect car les indices vont de 0 à 29

		Chef chef = new Chef("Abraracourcix", 6);
		village.setChef(chef);

		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);

//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		Les instructions précedentes affichent "null" puisque setChef n'a pas ajouté 
//		le chef dans le tableau des villageois, donc il y a qu'un villageois à l'indice 0 
//		qui est asterix et à l'indice 1 il n'y a rien (null, valeur par défaut à 
//		l'initialisation du tableau)

		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();

	}
}
