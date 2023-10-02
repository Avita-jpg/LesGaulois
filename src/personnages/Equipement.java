package personnages;

public enum Equipement {
	CASQUE("casque"), BOUCLIER("bouclier");

	private String nom;

	private Equipement(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		switch (this) {
		case CASQUE:
			return CASQUE.nom;
		case BOUCLIER:
			return BOUCLIER.nom;
		default:
			return "";
		}
	}
}
