package personnages;

public class Musee {
	private Trophee[] trophees = new Trophee[100];
	private int nbTrophee;

	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		trophees[nbTrophee] = new Trophee(gaulois, equipement);
		nbTrophee += 1;
	}

	public String extraireInstructionsOCaml() {
		StringBuilder str = new StringBuilder();
		str.append("let musee = [\n");
		int i = 0;
		for (; i < nbTrophee - 1; i++) {
			str.append("\"" + trophees[i].getGaulois().getNom() + "\", \"" + trophees[i].getEquipement() + "\";\n");
		}
		str.append("\"" + trophees[i].getGaulois().getNom() + "\", \"" + trophees[i].getEquipement() + "\"\n]");
		return str.toString();
	}
}
