package personnages;

public class Village {
	private String nom;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
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

	public static void main(String[] args) {
		Village village = new Village("Village des irréductibles", 30);
		// Gaulois gaulois = village.trouverHabitant(30);
		// L'exception se produit parceque on essaye d' accéder au tableau à un indice
		// incorrect car les indices vont de 0 à 29
	}
}
