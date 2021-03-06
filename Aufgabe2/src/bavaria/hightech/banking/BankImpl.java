package bavaria.hightech.banking;

import bavaria.hightech.banking.konto.FestgeldKonto;
import bavaria.hightech.banking.konto.GiroKonto;
import bavaria.hightech.banking.konto.Konto;
import bavaria.hightech.banking.konto.KontoTyp;

public class BankImpl implements BankKundenSicht {

	private static final int KONTO_NUMBER_START = 1000;
	private Konto[] konten = new Konto[42];

	private int newKontonummer() {
		for (int i = 0; i < konten.length; i++) {
			if (konten[i] == null) {
				return i + KONTO_NUMBER_START;
			}
		}
		// unchecked, weil ich oben an die methode nicht dranschreiben das es
		// eine exception ist, wird erst wenn es ausgeführt wurde entdeckt
		// (runtime) wenn methode falsch verwendet wird von programmierer
		throw new IllegalStateException("Zu viele Konten.");

	}

	private void addKonto(Konto konto) {
		int index = konto.getKontonummer() - KONTO_NUMBER_START;
		konten[index] = konto;
	}

	public Konto newKonto(String kontoinhaber, KontoTyp typ) {
		Konto konto;
		switch (typ) {
		case FESTGELDKONTO:
			konto = new FestgeldKonto(3.6f, newKontonummer(), kontoinhaber);
			break;
		case GIROKONTO:
			konto = new GiroKonto(3.6f, 5.0f, newKontonummer(), kontoinhaber);
			break;
		default:
			konto = null; // exception werfen
			break;
		}
		addKonto(konto);
		return konto;
	}

	@Override
	public float getKontostand(int kontonummer) {
		Konto konto = getKonto(kontonummer);
		return konto.getKontostand();
	}

	private Konto getKonto(int kontonummer) {
		return konten[kontonummer - KONTO_NUMBER_START];
	}

	@Override
	public void deposit(int kontonummer, float deposit, String grund) {
		Konto konto = getKonto(kontonummer);
		konto.zugang(deposit, grund);
	}

	/**
	 * @throws Exception
	 *             zu viel Geld wird abgehoben vom FestGeldKonto checked weil am
	 *             anfang der methode aufgeführt muss throws oder try and chatch
	 *             enthalten
	 */
	@Override
	public void drawout(int kontonummer, float drawout, String grund)
			throws Exception {
		Konto konto = getKonto(kontonummer);
		konto.abgang(drawout, grund);
	}

	@Override
	public void transfer(int kontonummer, float transfer, String grund,
			int transferKontoNummer) throws Exception {
		Konto konto = getKonto(kontonummer);
		konto.abgang(transfer, grund);
		Konto transferKonto = getKonto(transferKontoNummer);
		transferKonto.zugang(transfer, grund);
	}

	public void verzinsen() {
		for (int i = 0; i < konten.length; i++) {
			if (konten[i] != null) {
				konten[i].verzinsen();
			}
		}
	}

	public void list() {
		for (int i = 0; i < konten.length; i++) {
			if (konten[i] != null) {
				System.out.println(konten[i]);
			}
		}
	}

	public String getKontoauszug(int kontonummer) {
		Konto konto = getKonto(kontonummer);
		return konto.kontoauszug();
	}
}
