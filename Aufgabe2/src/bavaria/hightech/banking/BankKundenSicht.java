package bavaria.hightech.banking;

import bavaria.hightech.banking.konto.Konto;
import bavaria.hightech.banking.konto.KontoTyp;

public interface BankKundenSicht {
	public Konto newKonto(String kontoinhaber, KontoTyp typ);

	public float getKontostand(int kontonummer);

	public void deposit(int kontonummer, float deposit, String grund);

	public void drawout(int kontonummer, float drawout, String grund)
			throws Exception;

	public void transfer(int kontonummer, float transfer, String grund,
			int transferKonto) throws Exception;
}
