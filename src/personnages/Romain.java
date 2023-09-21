package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
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
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);

		Romain jules = new Romain("Jules", 10);

		asterix.parler("Je suis " + asterix.getNom() + "! Je voudrais bien frapper un romain.");
		// frapper fait appel à la méthode recevoirCoup
		asterix.frapper(jules);
	}
}
