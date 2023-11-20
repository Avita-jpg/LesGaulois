package personnages;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];

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

//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup((force / 3) * effetPotion);
//	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
		Equipement[] tropheesRecuperes = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesRecuperes != null && i < tropheesRecuperes.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = tropheesRecuperes[i];
		}
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + effetPotion + " fois decouplee.");
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public void faireUneDonnation(Musee musee) {
		if (nbTrophees > 0) {
			String texte = "Je donne au musee tous mes trophees:";
			int i = 0;
			while (nbTrophees > 0) {
				texte += "\n- ";
				texte += trophees[i];
				musee.donnerTrophees(this, trophees[i]);
				trophees[i] = null;
				nbTrophees -= 1;
				i += 1;
			}
			parler(texte);
		}
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix);

		Romain jules = new Romain("Jules", 10);
		Druide panoramix = new Druide("Panoramix", 5, 10);

		// parler fait appel a la methode prendreParole
		asterix.parler("Je suis " + asterix.nom + "! Je voudrais bien frapper un romain.");
		panoramix.preparerPotion();
		asterix.boirePotion(panoramix.getForcePotion());
		asterix.frapper(jules);

	}

}