package bavaria.hightech.banking.konto;

public class FestgeldKonto extends Konto {

	/** zusätzliches atttribut "habenZissatz": */
	private float habenZinssatz;

	/**
	 * methode "abgang" wird überschrieben: die Buchung wird nicht durchgeführt,
	 * wenn das Konto dadurch überzogen werden würde. vom kunden falsch
	 * verwendet
	 */
	public void abgang(float betrag, String grund) throws Exception {
		if (betrag <= getKontostand())
			verbuchen(false, betrag, grund);
		else {
			throw new Exception(
					"Du willst mehr Geld abheben als du hast Q_Q!!!!");
		}
	}

	/** methode "verzinsen ist nun definiert: */
	public void verzinsen() {
		float kontostand = getKontostand();
		kontostand = kontostand * (habenZinssatz / 100);
		verbuchen(true, kontostand, "Ertrag durch Zinsen");
	}

	/** FestgeldKonto Constructor: */
	public FestgeldKonto(float habenZinssatz, int kontonummer,
			String kontoinhaber) {
		super(kontonummer, kontoinhaber);
		this.habenZinssatz = habenZinssatz;
	}

	@Override
	public String toString() {
		String string = "Kontonummer: " + getKontonummer() + " Inhaber: "
				+ getKontoinhaber() + " Kontostand: " + getKontostand()
				+ " Zinssatz: " + habenZinssatz;
		return string;
	}

}
