package bavaria.hightech.banking.konto;

public class GiroKonto extends Konto {

	/** zus�tzliche Atribue: verschieden Zinss�tze */
	private float habenZinssatz;
	private float sollZinssatz;

	/**
	 * "verzinsen" f�hrt hier, abh�ngig vom Kontostand verschiedene Operationen
	 * aus
	 */
	public void verzinsen() {
		float kontostand = getKontostand();
		if (kontostand >= 0) {
			kontostand = kontostand * (habenZinssatz / 100);
			verbuchen(true, kontostand, "Zinsen");
		} else {
			kontostand -= 2 * kontostand; // durch diese rechnung ver�ndern wir
											// das vorzeichen des kontostands
			kontostand = kontostand * (sollZinssatz / 100);
			verbuchen(false, kontostand, "Zinsen");
		}
	}

	/** GiroKonto Constructor: */
	public GiroKonto(float habenZinssatz, float sollZinssatz, int kontonummer,
			String kontoinhaber) {
		super(kontonummer, kontoinhaber);
		this.habenZinssatz = habenZinssatz;
		this.sollZinssatz = sollZinssatz;

	}

	public String toString() {
		String string = "Kontonummer: " + getKontonummer() + " Inhaber: "
				+ getKontoinhaber() + " Kontostand: " + getKontostand()
				+ " Zinssatz(haben): " + habenZinssatz + " Zinssatz(soll): "
				+ sollZinssatz;
		return string;
	}

}
