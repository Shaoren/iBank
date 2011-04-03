package bavaria.hightech.banking.konto;

public class FestgeldKonto extends Konto {

	/** zus�tzliches atttribut "habenZissatz": */
	private float habenZinssatz;

	/**
	 * methode "abgang" wird �berschrieben: die Buchung wird nicht durchgef�hrt,
	 * wenn das Konto dadurch �berzogen werden w�rde. vom kunden falsch
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
